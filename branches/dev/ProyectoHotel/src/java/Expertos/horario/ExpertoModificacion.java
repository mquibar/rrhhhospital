/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.horario;

/**
 *
 * @author leoroot
 */
public abstract class ExpertoModificacion  <E> extends ExpertoABM <E>
{
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
    protected E getEntidad(String idEntidad) {
        E o = null;

       if (idEntidad != null && !idEntidad.isEmpty()) {
            try {
                o = getById(Integer.parseInt(idEntidad));
                System.out.println("Modificando entidad existente '" + getId(o) + "'...");
            } catch (Exception ex) {
                System.out.println(
                        "Error al buscar entidad con ID = '" + idEntidad + "': " +
                        ex.toString());
            }
        }
       else
       {
            System.out.println("No se ha proporcionado un ID de entidad con datos");
       }

        return o;
    }

    protected abstract E getById(int idEntidad);

    protected abstract int getId(E o);

}
