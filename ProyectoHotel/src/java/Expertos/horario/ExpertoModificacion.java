/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos.horario;

/**
 *
 * @author leoroot
 */
public abstract class ExpertoModificacion<E> extends ExpertoABM<E> {

    public ExpertoModificacion(String tipo)
    {
        super(tipo, "Modificacion");
    }

    @Override
    protected Boolean persistir(E o)
    {
        System.out.println("Iniciando Modificacion...\n" + o);
        return getIntermediario().actualizar(o);
    }

    @Override
    protected E getEntidad(String idEntidad)
    {
        E o = null;

        o = getById(Integer.parseInt(idEntidad));
        System.out.println("Modificando entidad existente '" + getId(o) + "'...");

        return o;
    }

    protected abstract E getById(int idEntidad);

    protected abstract int getId(E o);
}
