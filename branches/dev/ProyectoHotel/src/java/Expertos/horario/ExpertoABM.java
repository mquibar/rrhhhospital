/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

import Intermediarios.FabricaIntermediario;
import Intermediarios.GestorConeccion;
import Intermediarios.Intermediario;

/**
 *
 * @author leoroot
 */
public abstract class ExpertoABM <E>
{
    protected String _clase;
    protected String _operacion;
    private boolean _flagSave = false;
    E _enProc;

    public ExpertoABM(String clase, String operacion)
    {
        _clase = clase;
        _operacion = operacion;

        System.out.println("Creado nuevo Experto " + _operacion + " : " + _clase);
    }

    public void iniciarAlta(String idEntidad, Object ... data)
    {
       E o = getEntidad(idEntidad);
       o = cargarEntidad(o, data);
       _enProc = o;

        _flagSave = validar(o);
    }

    protected boolean validar(E o) {
        return true;
    }

    public String guardar() {

        String res = "Error: se produjo un error durante la validacion";

        if (_flagSave) {
            try {
                GestorConeccion gc = GestorConeccion.getInstance();
                gc.beginTransaction();
                if (persistir(_enProc)) {
                    res = "La entidad se guardo correctamente. Confirmado.";
                    System.out.println(res);
                    GestorConeccion.getInstance().commitTransaction();
                } else {
                    res = "Error durante el guardado, Rolling Back";
                    System.out.println(res);
                    GestorConeccion.getInstance().rollbackTransaction();
                }
            } catch (Exception ex) {
                res = "Error: se produjo el siguiente error durante el guardado : <br />" + ex.toString();
            }
        }

        return res;
    }

    protected abstract E getEntidad(String idEntidad);
    protected abstract E cargarEntidad(E o, Object ... data);

    protected abstract Boolean persistir(E o) ;
    protected Intermediario getIntermediario()
    {
        return FabricaIntermediario.getInstance().getIntermediario(_clase);
    }

}
