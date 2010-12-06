/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.reports;

import Entidades.RegistroPeriodo;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author desarrollo
 */
public class AsistenciaReportDS implements JRDataSource {

    private int indiceActual=-1;
    private List<RegistroPeriodo> lista= new ArrayList<RegistroPeriodo>();

    public AsistenciaReportDS(List<RegistroPeriodo> listado){
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
                return lista.get(indiceActual).getFechaEntrada();
            }
            if ("horaEntrada".equals(arg0.getName())) {
                return lista.get(indiceActual).getHoraEntrada();
            }
            if ("horaSalida".equals(arg0.getName())) {
                return lista.get(indiceActual).getHoraSalida();
            }
        } catch (NullPointerException e) {
            return "-";
        }
        return "-";
    }



    public boolean next() throws JRException {
        return ++indiceActual < lista.size();
    }

    public void addAsignacionHorario(RegistroPeriodo nuevo){
        lista.add(nuevo);
    }

    public void setListaAsignacionHorarioes(List<RegistroPeriodo> listanueva) {
        this.lista = listanueva;
    }



}
