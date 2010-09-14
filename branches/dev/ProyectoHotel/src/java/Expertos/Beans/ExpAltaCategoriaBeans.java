/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Categoria;
import Entidades.Clase;
import Expertos.ExpAltaCategoria;
import java.util.List;
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

    public List<Clase> iniciarAlta(String nombreCategoria) {
        _categoria.setNombre(nombreCategoria);
        return (new ExpConsultarCategoriaBeans()).listarClases();
    }

    public void agergarClase(Clase clase, int antiguedadMinima, boolean inicial) {
        _categoria.addClase(clase, antiguedadMinima, inicial);
    }

    public void agergarClase(Clase clase, int antiguedadMinima) {
        _categoria.addClase(clase, antiguedadMinima, false);
    }

    public boolean guardarCategoria() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
