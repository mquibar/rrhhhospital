/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

/**
 *
 * @author leoroot
 */
public abstract class ExpertoAlta <E> extends ExpertoABM <E>
{
    public ExpertoAlta(String tipo)
    {
        super(tipo, "Alta");
    }

    @Override
    protected Boolean persistir(E o)
    {
        System.out.println("Iniciando Alta...\n" + o);
        return getIntermediario().guardar(o);
    }

}
