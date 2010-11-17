/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Entidades.Empleado;
import Expertos.personal.ExpAsignarLegajo;
import java.util.List;
import models.combos.AbstractModelOptionList;
import models.combos.ModelOptionAgrupamiento;
import models.combos.ModelOptionCategoria;
import models.combos.ModelOptionClase;
import models.combos.ModelOptionTramo;

/**
 *
 * @author Juan
 */
public class ctrlAsignacionLegajo extends GeneralController {

    ExpAsignarLegajo _exp;
    private AbstractModelOptionList<Empleado> _modEmpleado;
    private ModelOptionAgrupamiento _modAgrupamiento;
    private ModelOptionTramo _modTramo;
    private ModelOptionCategoria _modCategoria;
    private ModelOptionClase _modClase;

    public ctrlAsignacionLegajo() {
        _exp = (ExpAsignarLegajo) getExpert(ExpAsignarLegajo.class.getName());
    }

    public AbstractModelOptionList iniciarCU() {
        List<Empleado> lista = _exp.beginCU();
        _modEmpleado = new AbstractModelOptionList<Empleado>(lista) {

            @Override
            protected String devolverValorCombo(Empleado objeto) {
                return objeto.getApellido() + " " + objeto.getNombre();
            }
        };
        return _modEmpleado;
    }

    public AbstractModelOptionList listarAgrupamientos() {
        _modAgrupamiento = new ModelOptionAgrupamiento(_exp.listarAgrupamiento());
        return _modAgrupamiento;
    }

    public AbstractModelOptionList listarTramo(String Index) {
        _modTramo = new ModelOptionTramo(_exp.listarTramo(_modAgrupamiento.getSelectedItem(Index)));
        return _modTramo;
    }

    public AbstractModelOptionList listarCategorias(String IndexTramo) {
        _modCategoria = new ModelOptionCategoria(_exp.listarCategoria(_modTramo.getSelectedItem(IndexTramo)));
        return _modCategoria;
    }

    public AbstractModelOptionList listarClases(String IndexCategoria) throws Exception {
        _modClase = new ModelOptionClase(_exp.listarClase(_modCategoria.getSelectedItem(IndexCategoria)));
        return _modClase;
    }

    public void saveRecategorizar(String IndexEmployee, String IndexCategoria, String IndexClase, String Legajo) throws Exception {
        _exp.saveEmployee(_modEmpleado.getSelectedItem(IndexEmployee), _modCategoria.getSelectedItem(IndexCategoria), _modClase.getSelectedItem(IndexClase), Integer.parseInt(Legajo));
    }

}
