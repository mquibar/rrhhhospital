/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Agrupamiento;
import Entidades.Categoria;
import Entidades.Clase;
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

    public Map<String, List> iniciarAlta(String nombreCategoria) {
        _categoria.setNombre(nombreCategoria);
        ExpConsultarCategoriaBeans experto = new ExpConsultarCategoriaBeans();
        Map<String, List> mapa = new HashMap<String, List>();
        if(experto.consultarCategoriaByNombre(nombreCategoria)== null)
            return null;
        mapa.put(Clase.class.getName(), experto.listarClases());
        mapa.put(Agrupamiento.class.getName(), experto.listarAgrupamientos());
        experto = null;
        return mapa;
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
