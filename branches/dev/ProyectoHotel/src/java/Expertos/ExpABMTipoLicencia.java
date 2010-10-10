/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.Categoria;
import Entidades.RegistroPeriodo;
import Entidades.TipoLicencia;
import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
public interface ExpABMTipoLicencia {

    /**
     *
     * @param nombreCategoria
     * indica el nombre de la categoria que deseamos crear nuevamente
     * @return
     * El resultado del procedimiento sera TRUE cuando se pueda crear con exito la categoria,
     * haciendolo FALSE en los casos que la categoria exista o se produscan errores de base de datos
     *
     */
    public boolean altaTipoLicencia();

    /**
     *
     * @param categoria
     *
     * @return
     */
    public boolean bajaTipoLicencia(TipoLicencia tipoLicencia);
    
    /**
     * 
     * @param categoria
     * 
     * @return
     */
    public boolean modificarTipoLicencia(TipoLicencia tipoLicencia);


}
