/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Entidades.Empleado;
import Entidades.Licencia;
import Entidades.TipoLicencia;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioLicencia;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpAltaLicenciaBeans implements ExpAltaLicencia {

    private Licencia _licencia;
    private boolean _flagSave=false;
    private boolean _esAlta = true;

    public ExpAltaLicenciaBeans() {
        _licencia = new Licencia();
    }
    
    public String guardar() {
        String res = "Error: se produjo un error durante la validacion";

        if(_flagSave)
        {
            GestorConeccion.getInstance().beginTransaction();
            try
            {
                if( persistir() )
                {
                    GestorConeccion.getInstance().commitTransaction();
                    res = "La Licenia se guardo correctamente";
                }
                else
                {
                    GestorConeccion.getInstance().rollbackTransaction();
                    res = "Error durante el guardado, Rolling Back";
                }
            }
            catch(Exception ex)
            {
                    res = "Error: se produjo el siguiente error durante el guardado : "
                            + ex.toString();
            }
        }

        return res;
    }

     Boolean persistir()
    {
        if(_esAlta)
        {
            return (new IntermediarioLicencia()).guardar(_licencia);
        }
        else
        {
            return (new IntermediarioLicencia()).actualizar(_licencia);
        }
    }

   public void agregarLicencia(Licencia licencia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void iniciarAlta(
            String idEntidad,
            Empleado Empleado,
            TipoLicencia TipoLicencia,
            Date FechaInicio,
            Date FechaFin,
            String motivo
            ) {

        if(idEntidad != null && idEntidad != "")
        {
            try
            {
                _licencia.setId(Integer.parseInt(idEntidad));
                _esAlta = false;
            }
            catch(Exception ex)
            {
                System.out.println(
                        "Error al tratar de modificar, agregando entidad nueva: " +
                        ex.toString());
            }
        }


        _licencia.setIdEmpleado(Empleado);
        _licencia.setIdTipoLicencia(TipoLicencia.getId());
        _licencia.setFechaInicio(FechaInicio);
        _licencia.setFechaFin(FechaFin);
        _licencia.setMotivo(motivo);

        _flagSave = validar();
    }

    private boolean validar()
    {
        return true;
    }

}
