/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos.categorizacion;

import Entidades.Agrupamiento;
import Entidades.Categoria;
import Entidades.Clase;
import Entidades.ClaseContenida;
import Entidades.ClaseVigente;
import Entidades.Empleado;
import Entidades.Tramo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import system.exception.GenericException;
import system.exception.SystemException;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpRecategorizacionBeans implements ExpRecategorizacion {

    @EJB
    private Expertos.categorizacion.ExpConsultarCategoria _consultaCategorias;
    @EJB
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
        long antiguedad = Tools.ManejaFechas.difencia(e.getFechaIngreso())/356;
        int idx = 0;
        //Completa la lista de las categorias que se pueden listar
        for (Categoria c : categorias) {
            if (c.getCupo() < 1) {
                continue;
            }
            contenidas = new ArrayList<ClaseContenida>();
            idx = 0;
            while (c.getClaseContenida().size() > idx && antiguedad >= c.getClaseContenida().get(idx).getAntiguedadMinima()) {
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
        cv.setCategoria(_consultaCategorias.consultarCategoria(categoria));
        cv.setClase(clase);
        cv.setEmpleado(_empleado);
        List<ClaseVigente> lista = (new Intermediarios.IntermediarioClaseVigente()).findByDto(_empleado);
        for (ClaseVigente claseVigente : lista) {
            if (claseVigente.getVigente()) {
                claseVigente.setVigente(false);
            }
        }
        cv.setVigente(true);
        if (categoria.getCupo() > 1) {
            categoria.setCupo(categoria.getCupo() - 1);
        }
        lista.add(cv);

        Intermediarios.GestorConeccion.getInstance().beginTransaction();
        try {
            if ((new Intermediarios.IntermediarioEmpleado()).actualizar(_empleado)) {
                if ((new Intermediarios.IntermediarioCategoria()).actualizar(categoria)) {
                    guardado = true;
                    Intermediarios.Intermediario<ClaseVigente> interm = new Intermediarios.IntermediarioClaseVigente();
                    for (ClaseVigente claseVigente : lista) {
                        if (!interm.actualizar(cv)) {
                            guardado = false;
                        }
                    }

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

    public List<Agrupamiento> listarAgrupamientos() {
        return _consultaCategorias.listarAgrupamientos();
    }

    public List<Tramo> listarTramo(Agrupamiento agrupamiento) {
        return _consultaCategorias.consultaTramo(agrupamiento);
    }

    public List<Categoria> listarCategoria(Empleado e, Tramo t) {
        _empleado = e;
        List<Categoria> posibles, categorias = _consultaCategorias.consultarCategoria(t);
        posibles = new ArrayList<Categoria>();
        List<ClaseContenida> contenidas = null;
        long antiguedad = Tools.ManejaFechas.difencia(e.getFechaIngreso());
        int idx = 0;


        //COMPLETA LA LISTA DE LAS CATEGORIAS QUE SE VAN A MOSTRAR
        for (Categoria cat : categorias) {
            if (cat.getCupo() < 1) {      //SI LA CATEGORIA NO LE QUEDAN CUPOS NO SE PUEDE LISTAR
                continue;
            }
            contenidas = new ArrayList<ClaseContenida>();
            idx = 0;

            //EN ESTA LINEA REVISO CUAL ES LA CLASE MAXIMA QUE SE PUEDE ALCANZAR SEGUN LA ANTIGÜEDAD
            while (cat.getClaseContenida().size() > idx && antiguedad >= cat.getClaseContenida().get(idx).getAntiguedadMinima()) {
                contenidas.add(cat.getClaseContenida().get(idx));
                cat.getClaseContenida().get(idx).getClase();
                idx++;
            }

            cat.setClaseContenidaList(contenidas);

            //SI PARA ESTA CATEGORIA NO PUEDO ALCANZAR CLASES NO LA LISTO
            if (!contenidas.isEmpty()) {
                posibles.add(cat);
            }
            System.out.println("*************** coontenidas =" + contenidas.size());
        }
        System.out.println("******************* posibles = " + posibles.size());


        Tramo tv = null;
        List<ClaseVigente> lista = (new Intermediarios.IntermediarioClaseVigente()).findByDto(e);
        // SI LA EL TRAMO NO ES EL MISMO QUE EL VIGENTE DEVUELVO TODAS LAS CLASES DE ARRIBA
        for (ClaseVigente clasv : lista) {
            tv = _consultaCategorias.consultarTramo(clasv.getCategoria());
            if (clasv.getVigente() && tv != t) {
                System.out.println("*********** perimer salida");
                return posibles;
            }
        }

        // SI ME ENCUENTRO EN EL MISMO TRAMO BORRO LA CATEGORIA Y LISTO LAS CLASES
        // A PARTIR DE LA CLASE VIGENTE DEL EMPLEADO
        Clase clas = null;
        Categoria cat = null;
        for (ClaseVigente cv : lista) { //BUSCO LA CATEGORIA Y CLASE VIGENTE
            if (cv.getVigente()) {
                cat = cv.getCategoria();
                clas = cv.getClase();
                System.out.println("******************** por aca pasa");
                break;
            }
            System.out.println("************* por aca da vueltas");
        }
        if (cat != null) {
            System.out.println("**************************** a este if entra");
            posibles.remove(cat);
            contenidas = new ArrayList<ClaseContenida>();
            idx = cat.getClaseContenida().get(cat.getClaseContenida().indexOf(clas)).getNumeroIndiceOrden();
            for (ClaseContenida cC : cat.getClaseContenida()) {
                if (cC.getNumeroIndiceOrden() == idx + 1) {
                    contenidas.add(cC);
                    break;
                }
            }
            cat.setClaseContenidaList(contenidas);
            posibles.add(0, cat);
        }

        System.out.println("******************** segunda salida posibilidades = " + posibles.size());
        for (Categoria categoria : posibles) {
            System.out.println("****----- " + categoria.getClaseContenida().size());
        }

        return posibles;
    }

    public List<Categoria> listarCategoria(Tramo t) {
        return _consultaCategorias.consultarCategoria(t);
    }

    public void recategorizar(Empleado e, Categoria cat, Clase cl) throws SystemException {

        ClaseVigente cv = new ClaseVigente();

        cv.setFechaVigencia(new Date());
        cv.setCategoria(_consultaCategorias.consultarCategoria(cat));
        cv.setClase(cl);
        cv.setEmpleado(e);

        //REVISA QUE NO TENGA NINGUNA CATEGORIA ASIGNADA Y LA PONE EN FALSE
        List<ClaseVigente> lista = (new Intermediarios.IntermediarioClaseVigente()).findByDto(e);
        for (ClaseVigente claseVigente : lista) {
            if (claseVigente.getVigente()) {
                claseVigente.setVigente(false);
            }
        }
        cv.setVigente(true);
        lista.add(cv);

        if (cat.getCupo() > 1) {
            cat.setCupo(cat.getCupo() - 1);
        }

        e.setClaseVigenteList(lista);

        Intermediarios.GestorConeccion.getInstance().beginTransaction();
        try {
            if ((new Intermediarios.IntermediarioEmpleado()).actualizar(e)) {
                if ((new Intermediarios.IntermediarioCategoria()).actualizar(cat)) {
                    if ((new Intermediarios.IntermediarioClaseVigente()).guardar(cv)) {
                        Intermediarios.GestorConeccion.getInstance().commitTransaction();
                    } else {
                        Intermediarios.GestorConeccion.getInstance().rollbackTransaction();
                        throw new Exception();
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new GenericException("Error al intentar actualizar el empleado");
        }

    }
}
