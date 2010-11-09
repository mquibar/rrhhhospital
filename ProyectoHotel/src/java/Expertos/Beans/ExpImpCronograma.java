/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos.Beans;

import Entidades.Empleado;
import Entidades.TipoHorario;
import java.util.Date;

/**
 *
 * @author Leo
 */
public class ExpImpCronograma {

    ExpLeerExcel _lector;
    ExpAltaAsignacionHorarioBeans _exp;

    public ExpImpCronograma(String path) {
        _lector = new ExpLeerExcel();
        _lector.openSource(path, 0);

        _exp = new ExpAltaAsignacionHorarioBeans();
    }

    public void close() {
        _lector.quit();
    }

    public void importar() {
        Object[] filas = _lector.getRows();
        for (Object ofila : filas) {
            Object[] fila = (Object[]) ofila;

            Date fecha = (Date) fila[0];
            Empleado idEmpleado =
                    new ExpConsultarPersonalBeans().consultarEmpleadoPorDNI(fila[1].toString());
            TipoHorario idTipoHorario =
                    new ExpConsultarTipoHorarioBeans().consultarTipoHorarioPorNombre(fila[2].toString());
            String descripcion = fila[3].toString();
            boolean vigente = (Boolean) fila[4];

            _exp.iniciarAlta(fecha, fecha, idEmpleado, idTipoHorario, descripcion, vigente);
            _exp.guardar();

        }
    }
}

