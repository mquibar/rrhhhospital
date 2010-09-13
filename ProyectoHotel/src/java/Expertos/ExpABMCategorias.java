/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.Categoria;
import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
public interface ExpABMCategorias {

    /**
     *
     * @param nombreCategoria
     * indica el nombre de la categoria que deseamos crear nuevamente
     * @return
     * El resultado del procedimiento sera TRUE cuando se pueda crear con exito la categoria,
     * haciendolo FALSE en los casos que la categoria exista o se produscan errores de base de datos
     *
     */
    public boolean altaCategoria(String nombreCategoria);

    /**
     *
     * @param categoria
     *
     * @return
     */
    public boolean bajaCategoria(Categoria categoria);
    
    /**
     * 
     * @param categoria
     * 
     * @return
     */
    public boolean modificarCategoria(Categoria categoria);


}
