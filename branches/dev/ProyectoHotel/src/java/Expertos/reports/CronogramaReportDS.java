/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.reports;

import Entidades.AsignacionHorario;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author desarrollo
 */
public class CronogramaReportDS implements JRDataSource {

    private int indiceActual=-1;
    private List<AsignacionHorario> lista= new ArrayList<AsignacionHorario>();

    public CronogramaReportDS(List<AsignacionHorario> listado){
        lista=listado;
    }
    public Object getFieldValue(JRField arg0) throws JRException {
        try {
            if ("Legajo".equals(arg0.getName())) {
                return lista.get(indiceActual).getIdEmpleado().getLegajo();
            }
            if ("EmpleadoTipo".equals(arg0.getName())) {
                return lista.get(indiceActual).getIdEmpleado().getIdTipoEmpleado().getNombre();
            }
            if ("Apellido".equals(arg0.getName())) {
                return lista.get(indiceActual).getIdEmpleado().getApellido();
            }
            if ("Nombre".equals(arg0.getName())) {
                return lista.get(indiceActual).getIdEmpleado().getNombre();
            }


            if ("fecha".equals(arg0.getName())) {
                return lista.get(indiceActual).getFecha();
            }
            if ("tipoHorario".equals(arg0.getName())) {
                return lista.get(indiceActual).getIdTipoHorario().getNombre();
            }
            if ("descripcion".equals(arg0.getName())) {
                return lista.get(indiceActual).getDescripcion();
            }
        } catch (NullPointerException e) {
            return "-";
        }
        return "-";
    }



    public boolean next() throws JRException {
        return ++indiceActual < lista.size();
    }

    public void addAsignacionHorario(AsignacionHorario nuevo){
        lista.add(nuevo);
    }

    public void setListaAsignacionHorarioes(List<AsignacionHorario> listaNueva) {
        this.lista = listaNueva;
    }



}
