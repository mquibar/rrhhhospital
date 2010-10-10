/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.RegistroPeriodo;
import Entidades.Clase;
import Entidades.Requisito;
import Entidades.Tramo;
import Expertos.ExpAltaRegistroPeriodo;
import Intermediarios.IntermediarioRegistroPeriodo;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpAltaRegistroPeriodoBeans implements ExpAltaRegistroPeriodo {

    private RegistroPeriodo _registroPeriodo;
    private boolean _flagSave=false;

    public ExpAltaRegistroPeriodoBeans() {
        _registroPeriodo = new RegistroPeriodo();
    }
    
    public boolean guardarRegistroPeriodo() {
        if(!_flagSave)
            return false;
        return (new IntermediarioRegistroPeriodo()).guardar(_registroPeriodo);
    }

    public void agregarRegistroPeriodo(RegistroPeriodo registroPeriodo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void iniciarAlta(
            Date fechaEntrada,
            Date horaEntrada,
            Date fechaSalida,
            Date horaSalida,
            int idEmpleado) {

        _registroPeriodo.setFechaEntrada(fechaEntrada);
        _registroPeriodo.setHoraEntrada(horaEntrada);
        _registroPeriodo.setFechaSalida(fechaSalida);
        _registroPeriodo.setHoraSalida(horaSalida);
        _registroPeriodo.setIdEmpleado(idEmpleado);
    }

}
