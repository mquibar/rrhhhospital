/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.categorizacion;

import Entidades.Categoria;
import Entidades.Clase;
import Entidades.Requisito;
import Entidades.Tramo;
import Expertos.categorizacion.ExpAltaCategoria;
import Intermediarios.IntermediarioCategoria;
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
    private boolean _flagSave=false;
    @EJB
    Expertos.categorizacion.ExpConsultarCategoria _expertoConsulta;

    public ExpAltaCategoriaBeans() {
        _categoria = new Categoria();
    }

    public List<Clase> iniciarAlta(Tramo tramo, String nombreCategoria, int cupoMaximo) {
        nombreCategoria= nombreCategoria.toUpperCase();
        _categoria.setTramo(tramo);
        _categoria.setNombre(nombreCategoria);
        _categoria.setCupo(cupoMaximo);
        if(_expertoConsulta.consultarCategoriaByNombre(nombreCategoria)!= null)
            return null;
        return _expertoConsulta.listarClases();
    }

    public void agergarClase(Clase clase, int antiguedadMinima, boolean inicial) {
        _categoria.addClase(clase, antiguedadMinima, inicial);
        _flagSave=true;
    }

    public void agergarClase(Clase clase, int antiguedadMinima) {
        _categoria.addClase(clase, antiguedadMinima, false);
    }

    public void agregarRequerimiento(String descripcion){
        Requisito requisito = new Requisito();
        requisito.setIdCategoria(_categoria);
        requisito.setDescripcion(descripcion);
        requisito.setNumero(_categoria.getRequisitoList().size()+1);
        _categoria.getRequisitoList().add(requisito);
        _flagSave=true;
    }
    
    public boolean guardarCategoria() {
        if(!_flagSave)
            return false;
        return (new IntermediarioCategoria()).guardar(_categoria);
    }

}
