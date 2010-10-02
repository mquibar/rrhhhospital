/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Categoria;
import Entidades.Clase;
import Entidades.Requisito;
import Entidades.Tramo;
import Expertos.ExpAltaCategoria;
import Intermediarios.IntermediarioCategoria;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpAltaCategoriaBeans implements ExpAltaCategoria {

    private Categoria _categoria;
    private boolean _flagSave=false;

    public ExpAltaCategoriaBeans() {
        _categoria = new Categoria();
    }

    public List<Clase> iniciarAlta(Tramo tramo, String nombreCategoria, int cupoMaximo) {
        _categoria.setNombre(nombreCategoria);
        _categoria.setCupo(cupoMaximo);
        ExpConsultarCategoriaBeans experto = new ExpConsultarCategoriaBeans();
        if(experto.consultarCategoriaByNombre(nombreCategoria)== null)
            return null;
        experto = null;
        return experto.listarClases();
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
