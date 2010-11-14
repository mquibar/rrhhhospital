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
 *
 * @author MARIANO
 */
public class ctrlModificarEmpleado extends GeneralController{

    private ExpModificarEmpleado _exp;
    private ModelOptionEmpleado listaempleado;
    private ExpConsultarSexo expsexo;
    private Map<String, AbstractModelOptionList> models;
    private ExpConsultarPersonal _expconsultar;
    private ModelOptionPais modelpais;
    private ModelOptionProvincia modelprovincia;
    private ModelOptionLocalidad modellocalidad;

    public ctrlModificarEmpleado() {
        _exp = (ExpModificarEmpleado) getExpert(ExpModificarEmpleado.class.getName());
        _expconsultar = (ExpConsultarPersonal) getExpert(ExpConsultarPersonal.class.getName());
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

    /*public String crearTabla(){
        _tabla = new ModelTablaEmpleado(_exp.listarEmpleados());
        return _tabla.toString();
    }*/

    public AbstractModelOptionList getModels(String key) {
        try {
            return models.get(key.toUpperCase());
        } catch (Exception e) {
            return null;
        }
    }

    public String modificarDomicilioPersona (Persona persona, String barrio, String calle, String numero,
            String piso, String departamanto, Localidad localidad, Provincia provincia, Pais pais){
        return "";
    }

    public String modificarEmpleado (String empleado, String nombre, String apellido, String dni, String fechaNacimiento,
            String telefono, String barrio, String calle, String numero, String piso, String departamanto,
            String localidad, String provincia, String pais, String sexo, String cuil) {

         try {

            if(_exp.modificarEmpleado(listaempleado.getSelectedItem(empleado), nombre, apellido, dni,
                    fechaNacimiento, telefono, barrio, calle, numero, piso,
                    departamanto, modellocalidad.getSelectedItem(localidad),
                    modelprovincia.getSelectedItem(provincia), modelpais.getSelectedItem(pais), 
                    expsexo.listarSexo(sexo), cuil)){
                return "Error: Actualizado";

            } else {
                return "Error: Error al Actualizar";

            }
        } catch (Exception ex) {
            return "Error: Error de conexion con servidor de aplicaciones"+ex.toString();
        }
         

    }

    public AbstractModelOptionList getEmpleado(){
        /*if(model ==null)
            model = new ModelOptionProfesional(_exp.listarProfesional().get("PROFESIONAL"));
        return model;*/
        return models.get("EMPLEADO");
    }
}
