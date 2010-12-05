/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos.categorizacion;

import Entidades.Categoria;
import Entidades.Clase;
import Entidades.ClaseContenida;
import Entidades.Requisito;
import Entidades.Tramo;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioCategoria;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpAltaCategoriaBeans implements ExpAltaCategoria {

    private Categoria _categoria;
    @EJB
    ExpConsultarCategoria _expertoConsulta;

    public ExpAltaCategoriaBeans() {
        _categoria = new Categoria();
    }

    public List<Clase> iniciarCU(Tramo tramo) {
        _categoria.setTramo(tramo);
        return _expertoConsulta.listarClases();
    }

    public void setterRequisito(List<Requisito> requisitos) {
        if(_categoria.getRequisitoList()==null)
            _categoria.setRequisitoList(new ArrayList<Requisito>());
        _categoria.getRequisitoList().addAll(requisitos);
    }

    public void setterClase(List<ClaseContenida> clases){
        if(_categoria.getClaseContenida()==null)
            _categoria.setClaseContenidaList(new ArrayList<ClaseContenida>());
        clases.get(0).setInicial(true);
        _categoria.getClaseContenida().addAll(clases);
    }

    public void setterNombre(String nombre, Integer cupo){
        _categoria.setNombre(nombre.toUpperCase());
        _categoria.setCupo(cupo);
    }

    public boolean guardarCategoria() {
        if(_categoria.getNombre().isEmpty()||_categoria.getClaseContenida().isEmpty()||_categoria.getRequisitoList().isEmpty())
            return false;
        for (ClaseContenida claseContenida : _categoria.getClaseContenida()) {
            claseContenida.setCategoria(_categoria);
        }
        for (Requisito requisito : _categoria.getRequisitoList()) {
            requisito.setIdCategoria(_categoria);
        }
        try{
        GestorConeccion.getInstance().beginTransaction();
            if((new IntermediarioCategoria()).guardar(_categoria)){
                GestorConeccion.getInstance().commitTransaction();
                return true;
            }
            else{
                GestorConeccion.getInstance().rollbackTransaction();
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
