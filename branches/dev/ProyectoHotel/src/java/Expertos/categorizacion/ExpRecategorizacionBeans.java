/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos.categorizacion;

import Entidades.Categoria;
import Entidades.Clase;
import Entidades.ClaseContenida;
import Entidades.ClaseVigente;
import Entidades.Empleado;
import Expertos.categorizacion.ExpRecategorizacion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpRecategorizacionBeans implements ExpRecategorizacion {

    @EJB
    private Expertos.categorizacion.ExpConsultarCategoria _consultaCategorias;
    private Expertos.personal.ExpConsultarPersonal _consultaPersonal;
    private Empleado _empleado;

    public List<Empleado> iniciarRecategorizacion() {
        return _consultaPersonal.listarEmpleadoinOrder();
    }

    public List<Categoria> buscarCategoriasPosibles(Empleado e) {
        _empleado = e;
        List<Categoria> posibles, categorias = _consultaCategorias.listarCategorias();
        posibles = new ArrayList<Categoria>();
        List<ClaseContenida> contenidas = null;
        long antiguedad = Tools.ManejaFechas.difencia(e.getFechaIngreso());
        int idx = 0;
        //Completa la lista de las categorias que se pueden listar
        for (Categoria c : categorias) {
            if (c.getCupo() < 1) {
                continue;
            }
            contenidas = new ArrayList<ClaseContenida>();
            idx = 0;
            while (c.getClaseContenida().size() > idx &&
                    antiguedad >= c.getClaseContenida().get(idx).getAntiguedadMinima()) {
                contenidas.add(c.getClaseContenida().get(idx));
                idx++;
            }

            c.setClaseContenidaList(contenidas);
            if (!contenidas.isEmpty()) {
                posibles.add(c);
            }
        }

        Clase cl = null;
        Categoria c = null;
        for (ClaseVigente cv : e.getClaseVigenteList()) {
            if (cv.getVigente()) {
                c = cv.getCategoria();
                cl = cv.getClase();
                break;
            }
        }
        if (c != null) {
            posibles.remove(c);
            contenidas = new ArrayList<ClaseContenida>();
            idx = c.getClaseContenida().get(c.getClaseContenida().indexOf(cl)).getNumeroIndiceOrden();
            for (ClaseContenida cC : c.getClaseContenida()) {
                if (cC.getNumeroIndiceOrden() == idx + 1) {
                    contenidas.add(cC);
                    break;
                }
            }
            c.setClaseContenidaList(contenidas);
            posibles.add(0, c);
        }

        return posibles;
    }

    public List<Categoria> listarTodas() {
        return _consultaCategorias.listarCategorias();
    }

    public boolean recategorizar(Categoria categoria, Clase clase, boolean cumpleRequerimientos) {

        boolean guardado = false;
        if (!cumpleRequerimientos) {
            return guardado;
        }

        ClaseVigente cv = new ClaseVigente();

        cv.setFechaVigencia(new Date());
        cv.setCategoria(categoria);
        cv.setClase(clase);
        cv.setEmpleado(_empleado);

        for (ClaseVigente claseVigente : _empleado.getClaseVigenteList()) {
            if (claseVigente.getVigente()) {
                claseVigente.setVigente(false);
            }
        }
        cv.setVigente(true);
        if(categoria.getCupo()>1)
            categoria.setCupo(categoria.getCupo() - 1);
        _empleado.getClaseVigenteList().add(cv);

        Intermediarios.GestorConeccion.getInstance().beginTransaction();
        try {
            if ((new Intermediarios.IntermediarioEmpleado()).actualizar(_empleado)) {
                if ((new Intermediarios.IntermediarioCategoria()).actualizar(categoria)) {
                    guardado = true;
                }
            }
            if (guardado) {
                Intermediarios.GestorConeccion.getInstance().commitTransaction();
            } else {
                Intermediarios.GestorConeccion.getInstance().rollbackTransaction();
            }
        } catch (Exception ex) {
            guardado = false;
            System.out.println(ex.getMessage());
        }

        return guardado;
    }
}
