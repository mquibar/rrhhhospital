/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos.categorizacion;

import Entidades.Agrupamiento;
import Entidades.Categoria;
import Entidades.ClaseVigente;
import Entidades.Tramo;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioAgrupamiento;
import Intermediarios.IntermediarioCategoria;
import Intermediarios.IntermediarioClaseVigente;
import Intermediarios.IntermediarioTramo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import system.exception.GenericException;
import system.exception.PersistenceException;

/**
 *
 * @author Manuel
 */
@Stateless
public class GestorBajaCategoriaBean implements GestorBajaCategoriaRemoto {

    @EJB
    private ExpConsultarCategoria _gestorConsultas;

    public void bajaCategoria(Categoria categoria) throws GenericException, PersistenceException {
        List<ClaseVigente> clases = (new IntermediarioClaseVigente()).findVigenteByCategoria(categoria);
        if (!clases.isEmpty()) {
            throw new GenericException("Existe asignaciones para la categoria seleccionada");
        }
        categoria.setEliminado(true);
        try {
            GestorConeccion.getInstance().beginTransaction();
            if ((new IntermediarioCategoria()).actualizar(categoria)) {
                GestorConeccion.getInstance().commitTransaction();
            } else {
                GestorConeccion.getInstance().rollbackTransaction();
            }
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    public void bajaTramo(Tramo tramo) throws GenericException, PersistenceException {
        List<Categoria> categorias = _gestorConsultas.consultarCategoria(tramo);
        try {
            GestorConeccion.getInstance().beginTransaction();
            for (Categoria c : categorias) {
                bajaCategoria(c);
            }
            tramo.setEliminado(true);


            if ((new IntermediarioTramo()).actualizar(tramo)) {
                GestorConeccion.getInstance().commitTransaction();
            } else {
                GestorConeccion.getInstance().rollbackTransaction();
            }

        } catch (GenericException ge) {
            throw new GenericException("Tramo posee categorías vigentes");
        }catch(PersistenceException pe){
            GestorConeccion.getInstance().rollbackTransaction();
            throw new PersistenceException(pe);
        }catch(Exception e){
            throw new PersistenceException(e);
        }
    }

    public void bajaAgrupamiento(Agrupamiento agrupamiento) throws GenericException, PersistenceException {
        List<Tramo> tramos = _gestorConsultas.consultaTramo(agrupamiento);
        try {
            GestorConeccion.getInstance().beginTransaction();

            for (Tramo t : tramos) {
                bajaTramo(t);
            }

            agrupamiento.setEliminado(true);
            if ((new IntermediarioAgrupamiento()).actualizar(agrupamiento)) {
                GestorConeccion.getInstance().commitTransaction();
            } else {
                GestorConeccion.getInstance().rollbackTransaction();
            }

        } catch (GenericException ge) {
            GestorConeccion.getInstance().rollbackTransaction();
            throw new GenericException("No se puede eliminar un agrupamiento con categorias vigentes");
        }catch(PersistenceException pe){
            GestorConeccion.getInstance().rollbackTransaction();
            throw new PersistenceException(pe);
        }catch(Exception e){
            throw new PersistenceException(e);
        }


    }
}
