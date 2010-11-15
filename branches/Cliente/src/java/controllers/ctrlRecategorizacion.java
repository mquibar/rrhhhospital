/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entidades.Clase;
import Entidades.ClaseContenida;
import Entidades.Empleado;
import Expertos.categorizacion.ExpRecategorizacion;
import java.util.ArrayList;
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
public class ctrlRecategorizacion extends GeneralController {

    private ExpRecategorizacion _exp;
    private AbstractModelOptionList<Empleado> _modEmpleado;
    private ModelOptionAgrupamiento _modAgrupamiento;
    private ModelOptionTramo _modTramo;
    private ModelOptionCategoria _modCategoria;
    private ModelOptionClase _modClase;

    public ctrlRecategorizacion() {
        _exp = (ExpRecategorizacion) getExpert(ExpRecategorizacion.class.getName());
    }

    public AbstractModelOptionList iniciarCU() {
        List<Empleado> lista = _exp.iniciarRecategorizacion();
        _modEmpleado = new AbstractModelOptionList<Empleado>(lista) {

            @Override
            protected String devolverValorCombo(Empleado objeto) {
                return objeto.getApellido() + " " + objeto.getNombre();
            }
        };
        return _modEmpleado;
    }

    public AbstractModelOptionList listarAgrupamientos() {
        _modAgrupamiento = new ModelOptionAgrupamiento(_exp.listarAgrupamientos());
        return _modAgrupamiento;
    }

    public AbstractModelOptionList listarTramo(String Index) {
        _modTramo = new ModelOptionTramo(_exp.listarTramo(_modAgrupamiento.getSelectedItem(Index)));
        return _modTramo;
    }

    public AbstractModelOptionList listarCategorias(String IndexTramo, String IndexEmpleado) {
        _modCategoria = new ModelOptionCategoria(_exp.listarCategoria(_modEmpleado.getSelectedItem(IndexTramo), _modTramo.getSelectedItem(IndexTramo)));
        return _modCategoria;
    }

    public AbstractModelOptionList listarCategorias(String IndexTramo) {
        _modCategoria = new ModelOptionCategoria(_exp.listarCategoria(_modTramo.getSelectedItem(IndexTramo)));
        return _modCategoria;
    }

    public AbstractModelOptionList listarClases(String IndexCategoria) throws Exception {
        List<ClaseContenida> lista = _modCategoria.getSelectedItem(IndexCategoria).getClaseContenida();
        System.out.println("************* " + lista);
        List<Clase> list = new ArrayList<Clase>();
        for (ClaseContenida claseContenida : lista) {
            System.out.println("#####"+claseContenida.getNumeroIndiceOrden());
            System.out.println("&&&&&&"+claseContenida.getClase().getNombre());
            list.add(claseContenida.getClase());
        }
        _modClase = new ModelOptionClase(list);
        return _modClase;
    }

    public void guardarRecategorizar(String IndexCategoria, String IndexClase) throws Exception {

        if (_exp.recategorizar(_modCategoria.getSelectedItem(IndexCategoria), _modClase.getSelectedItem(IndexClase), true)) {
            return;
        } else {
            System.out.println("Se Cago ACa");
            throw new Exception("No se guardo");
        }
    }
}
