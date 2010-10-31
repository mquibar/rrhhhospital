/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.tables;

import Entidades.Empleado;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Juan
 */
public class ModeloComboEmpleado extends DefaultComboBoxModel {
    
    List <Empleado> _lista;
    
    public ModeloComboEmpleado (Empleado empleado) {
        addElement("Empleados Encontrados");
        addElement(empleado.getApellido()+", "+empleado.getNombre());
    }

    public ModeloComboEmpleado (List <Empleado> empleados) {
        addElement("Empleados Encontrados");
        try {
            _lista = empleados;
            for (Empleado object : _lista) {
                addElement(object.getApellido()+", "+object.getNombre());
            }
        } catch (Exception e) {
            System.out.println("Vector Nulo");
        }
    }
}
