/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.reports;

import Entidades.Licencia;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author desarrollo
 */
public class LicenciaReportDS implements JRDataSource {

    private int indiceActual=-1;
    private List<Licencia> lista= new ArrayList<Licencia>();

    public LicenciaReportDS(List<Licencia> listado){
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



            if ("fechaInicio".equals(arg0.getName())) {
                return lista.get(indiceActual).getFechaInicio();
            }
            if ("fechaFin".equals(arg0.getName())) {
                return lista.get(indiceActual).getFechaFin();
            }
            if ("tipoLicencia".equals(arg0.getName())) {
                return lista.get(indiceActual).getIdTipoLicencia();
            }
            if ("motivo".equals(arg0.getName())) {
                return lista.get(indiceActual).getMotivo();
            }
        } catch (NullPointerException e) {
            return "-";
        }
        return "-";
    }



    public boolean next() throws JRException {
        return ++indiceActual < lista.size();
    }

    public void addAsignacionHorario(Licencia nuevo){
        lista.add(nuevo);
    }

    public void setListaAsignacionHorarioes(List<Licencia> listanueva) {
        this.lista = listanueva;
    }



}
