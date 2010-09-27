/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Agrupamiento;
import Entidades.Categoria;
import Entidades.Clase;
import Entidades.Tramo;
import Expertos.ExpAltaCategoria;
import Intermediarios.IntermediarioCategoria;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author Manuel
 */
@Stateless
public class ExpAltaCategoriaBeans implements ExpAltaCategoria {

    private Categoria _categoria;

    public ExpAltaCategoriaBeans() {
        _categoria = new Categoria();
    }

    public List<Clase> iniciarAlta(Tramo tramo, String nombreCategoria) {
        _categoria.setNombre(nombreCategoria);
        ExpConsultarCategoriaBeans experto = new ExpConsultarCategoriaBeans();
        if(experto.consultarCategoriaByNombre(nombreCategoria)== null)
            return null;
        experto = null;
        return experto.listarClases();
    }

    public void agergarClase(Clase clase, int antiguedadMinima, boolean inicial) {
        _categoria.addClase(clase, antiguedadMinima, inicial);
    }

    public void agergarClase(Clase clase, int antiguedadMinima) {
        _categoria.addClase(clase, antiguedadMinima, false);
    }

    public boolean guardarCategoria() {
        return (new IntermediarioCategoria()).guardar(_categoria);
    }

}
