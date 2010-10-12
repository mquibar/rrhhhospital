/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos;

import Entidades.AsignacionHorario;
import Entidades.Licencia;
import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
public interface ExpABMAsignacionHorario {

    /**
     *
     * @param nombreCategoria
     * indica el nombre de la categoria que deseamos crear nuevamente
     * @return
     * El resultado del procedimiento sera TRUE cuando se pueda crear con exito la categoria,
     * haciendolo FALSE en los casos que la categoria exista o se produscan errores de base de datos
     *
     */
    public boolean altaAsignacionHorario();

    /**
     *
     * @param categoria
     *
     * @return
     */
    public boolean bajaAsignacionHorario(AsignacionHorario asignacionHorario);
    
    /**
     * 
     * @param categoria
     * 
     * @return
     */
    public boolean modificarAsignacionHorario(AsignacionHorario asignacionHorario);


}
