/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Entidades.Empleado;
import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Persona;
import Entidades.Provincia;
import Entidades.Sexo;
import Expertos.personal.ExpConsultarPersonal;
import Expertos.personal.ExpConsultarSexo;
import Expertos.personal.ExpModificarEmpleado;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.combos.AbstractModelOptionList;
import models.combos.ModelOptionEmpleado;
import models.combos.ModelOptionLocalidad;
import models.combos.ModelOptionPais;
import models.combos.ModelOptionProvincia;

/**
 *  Controlador especifico que se encarga de modificar un empleado
 *
 * @author Juan
 */
public class ctrlModificarEmpleado extends GeneralController{

    private ExpModificarEmpleado _exp;
    private ModelOptionEmpleado listaempleado;
    private ExpConsultarSexo expsexo;
    private Map<String, AbstractModelOptionList> models;
    private ModelOptionPais modelpais;
    private ModelOptionProvincia modelprovincia;
    private ModelOptionLocalidad modellocalidad;

    /**
     * Crea e inicializa el controlador especifico que modificará al empleado
     */
    public ctrlModificarEmpleado() {
        _exp = (ExpModificarEmpleado) getExpert(ExpModificarEmpleado.class.getName());
        expsexo = (ExpConsultarSexo) getExpert(ExpConsultarSexo.class.getName());

        Map<String, List> listas;
        listas = _exp.listarEmpleados();
        models = new HashMap<String, AbstractModelOptionList>();
        listaempleado = new ModelOptionEmpleado(listas.get("EMPLEADO"));
        modelpais = new ModelOptionPais(listas.get("PAIS"));
        modellocalidad = new ModelOptionLocalidad(listas.get("LOCALIDAD"));
        modelprovincia = new ModelOptionProvincia(listas.get("PROVINCIA"));

        models.put("EMPLEADO", listaempleado);
        models.put("PAIS", modelpais);
        models.put("LOCALIDAD", modellocalidad);
        models.put("PROVINCIA", modelprovincia);
    }

    /**
     * Envia a pantalla un combo dependiendo de los parametros
     * @param key : parametro que indica que combo envia a pantalla
     * @return : retorna un AbstractModelOptionList que contiene la informacion
     *           que se mostrara en el combo
     */
    public AbstractModelOptionList getModels(String key) {
        try {
            return models.get(key.toUpperCase());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Metodo que dispara la modificacion del empleado con los parametros
     * correctos para la entidad
     * @param empleado
     * @param nombre
     * @param apellido
     * @param dni
     * @param fechaNacimiento
     * @param telefono
     * @param barrio
     * @param calle
     * @param numero
     * @param piso
     * @param departamanto
     * @param localidad
     * @param provincia
     * @param pais
     * @param sexo
     * @param cuil
     * @return string dependiendo de lo que suceda
     *      * "Empleado Actualizado" : el empleado se actualizo
     *      * "Error al Actualizar al empleado" : el empleado no se pudo guardar
     *      * "Error: Error de conexion con servidor de aplicaciones"+ex.toString(): exepcion
     */

    public  String modificarEmpleado (Empleado empleado, String nombre, String apellido, String dni, String fechaNacimiento,
            String telefono, String barrio, String calle, String numero, String piso, String departamanto,
            String localidad, String provincia, String pais, String sexo, String cuil) {

         try {

            if(_exp.modificarEmpleado(empleado, nombre, apellido, dni,
                    fechaNacimiento, telefono, barrio, calle, numero, piso,
                    departamanto, modellocalidad.getSelectedItem(localidad),
                    modelprovincia.getSelectedItem(provincia), modelpais.getSelectedItem(pais), 
                    expsexo.listarSexo(sexo), cuil)){
                return "Empleado: Actualizado";

            } else {
                return "Error:  al Actualizar el Empleado";

            }
        } catch (Exception ex) {
            return "Error: Error de conexion con servidor de aplicaciones"+ex.toString();
        }
    }

}