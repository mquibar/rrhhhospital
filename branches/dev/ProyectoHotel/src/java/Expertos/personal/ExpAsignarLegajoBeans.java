/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos.personal;

import Entidades.Agrupamiento;
import Entidades.Categoria;
import Entidades.Clase;
import Entidades.ClaseContenida;
import Entidades.ClaseVigente;
import Entidades.Empleado;
import Entidades.Tramo;
import Expertos.categorizacion.ExpRecategorizacion;
import Intermediarios.IntermediarioEmpleado;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import system.exception.SystemException;

/**
 *
 * @author Juan
 */
@Stateless
public class ExpAsignarLegajoBeans implements ExpAsignarLegajo {

    @EJB
    ExpRecategorizacion _expRecategoria;

    public List<Empleado> beginCU() {
        return (new IntermediarioEmpleado()).findNotLegajo(0);
    }

    public List<Agrupamiento> listarAgrupamiento() {
        return _expRecategoria.listarAgrupamientos();
    }

    public List<Tramo> listarTramo(Agrupamiento a) {
        return _expRecategoria.listarTramo(a);
    }

    public List<Categoria> listarCategoria(Tramo t) {
        return _expRecategoria.listarCategoria(t);
    }

    public List<Clase> listarClase(Categoria c) {
        try {
            List<Clase> list = new ArrayList<Clase>();

            for (ClaseContenida claseContenida : c.getClaseContenida()) {
                list.add(claseContenida.getClase());
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public void saveEmployee(Empleado e, Categoria cat, Clase cl, Integer legajo)throws SystemException{
        e.setClaseVigenteList(new ArrayList<ClaseVigente>());
        e.setLegajo(legajo);
        _expRecategoria.recategorizar(e, cat, cl);
    }
}
