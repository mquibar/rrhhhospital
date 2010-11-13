/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Entidades.Empleado;
import Expertos.categorizacion.ExpRecategorizacion;
import java.util.List;
import models.combos.AbstractModelOptionList;
import models.combos.ModelOptionAgrupamiento;
import models.combos.ModelOptionCategoria;
import models.combos.ModelOptionTramo;

/**
 *
 * @author Juan
 */
public class ctrlRecategorizacion extends GeneralController {

    private ExpRecategorizacion _exp;
    private AbstractModelOptionList<Empleado> _modEmpleado;
    private ModelOptionAgrupamiento _modAgrupamiento;
    private ModelOptionTramo _modTramo;
    private ModelOptionCategoria _modCategoria;

    public ctrlRecategorizacion() {
        _exp = (ExpRecategorizacion) getExpert(ExpRecategorizacion.class.getName());
    }

    public AbstractModelOptionList iniciarCU(){
        List<Empleado> lista = _exp.iniciarRecategorizacion();
        _modEmpleado = new AbstractModelOptionList<Empleado>(lista) {

            @Override
            protected String devolverValorCombo(Empleado objeto) {
                return objeto.getApellido() + " " + objeto.getNombre();
            }
        };
        return _modEmpleado;
    }

    public AbstractModelOptionList listarAgrupamientos(){
        _modAgrupamiento = new ModelOptionAgrupamiento(_exp.listarAgrupamientos());
        return _modAgrupamiento;
    }

    public AbstractModelOptionList listarTramo(String Index){
        _modTramo = new ModelOptionTramo(_exp.listarTramo(_modAgrupamiento.getSelectedItem(Index)));
        return _modTramo;
    }

    public AbstractModelOptionList listarCategorias(String IndexTramo, String IndexEmpleado){
        _modCategoria = new ModelOptionCategoria(_exp.listarCategoria(_modEmpleado.getSelectedItem(IndexTramo),_modTramo.getSelectedItem(IndexTramo)));
        return _modCategoria;
    }

    public AbstractModelOptionList listarCategorias(String IndexTramo){
        _modCategoria = new ModelOptionCategoria(_exp.listarCategoria(_modTramo.getSelectedItem(IndexTramo)));
        return _modCategoria;
    }
}
