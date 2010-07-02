/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios.Beans;

import Configuraciones.LogAdmin;
import Entidades.Agrupamiento;
import Intermediarios.IntermediarioAgrupamiento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author desarrollo
 */
@Stateless
public class IntermediarioAgrupamientoBeans extends IntermediarioBeans implements IntermediarioAgrupamiento{

    public IntermediarioAgrupamientoBeans(){
        _log = LogAdmin.getInstance().getLog(this.getClass().getName());
    }
    
    public void actualizar(Agrupamiento agrupamiento) {
        try{
            _manager.merge(agrupamiento);
        }
        catch(Exception ex){
            _log.error(ex.getMessage());
            ex.printStackTrace();
        }
        
    }

    public Agrupamiento findByName(String nombre) {
        Query q = _manager.createNamedQuery("Agrupamiento.findByNombre");
        q.setParameter(":nombre", nombre);
        return (Agrupamiento) q.getSingleResult();
    }

    public List<Agrupamiento> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Agrupamiento> findAllOrder() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
