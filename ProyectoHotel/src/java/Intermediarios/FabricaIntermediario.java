/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

/**
 *
 * @author leoroot
 */
public class FabricaIntermediario
{
    static FabricaIntermediario _uniqueInstance = null;
    public static FabricaIntermediario getInstance()
    {
        if(_uniqueInstance == null)
        {
            _uniqueInstance = new FabricaIntermediario();
        }
        return _uniqueInstance;
    }

    public Intermediario getIntermediario(String tipo)
    {
        Intermediario i = null;

        if(tipo.equalsIgnoreCase("tipohorario"))
        {
            i = new IntermediarioTipoHorario();
        }

        return i;
    }

}
