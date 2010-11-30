/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package seguimiento.gestionCategoria;

import Entidades.Clase;
import Entidades.Requisito;
import Entidades.Tramo;
import Expertos.categorizacion.ExpAltaCategoria;
import java.util.ArrayList;
import managerrrhhhospital.ContextGenerator;
import models.tables.TableClase;
import models.tables.TableRequisitos;

/**
 *
 * @author Manuel
 */
public class ctrlAltaCategoria {

    private AltaCategoria _pantalla;
    private ExpAltaCategoria _gestorCategoria;
    private TableRequisitos _requisitos;
    private TableClase _clases, clasesContenidas;

    public ctrlAltaCategoria(AdminEscalafon pantalla, Tramo tramo) {
        _pantalla = new AltaCategoria(pantalla, this);
        _gestorCategoria = (ExpAltaCategoria) ContextGenerator.getInstance().createGestor(ExpAltaCategoria.class.getName());
        _clases = new TableClase(_gestorCategoria.iniciarCU(tramo));
        clasesContenidas = new TableClase(new ArrayList<Clase>());
        _requisitos = new TableRequisitos(new ArrayList<Requisito>());

    }

    void pressCancelButton(){
        _pantalla.dispose();
    }

    void pressOkButton(){
        
    }
}
