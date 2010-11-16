/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Expertos.personal.ExpAltaEmpleado;
import Expertos.personal.ExpAltaProfesional;
import Expertos.personal.ExpConsultarSexo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.combos.*;

/**
 *
 * Controlador general de Persona el cual maneja el alta tanto de empleado como de profesional
 *
 * @author Juan
 */
public class ctrlAltaPersonal extends GeneralController {

        private ExpAltaProfesional expprof;
        private ExpAltaEmpleado expemp;
        private ExpConsultarSexo expsexo;
        private ctrlAltaEmpleado controladorEmpleado;
        private ctrlAltaProfesional controladorProfesional;
        private Map<String, AbstractModelOptionList> models;
        private ModelOptionPais modelpais;
        private ModelOptionProvincia modelprovincia;
        private ModelOptionLocalidad modellocalidad;
        private ModelOptionTipoEmpleado modeltipo;
        private ModelOptionTarjeta modelotarjeta;
        private enum TipoEmpleado {
        EMPLEADO,PROFESIONAL
    }


    public ctrlAltaPersonal() {
        expprof = (ExpAltaProfesional) getExpert(ExpAltaProfesional.class.getName());
        expemp = (ExpAltaEmpleado) getExpert(ExpAltaEmpleado.class.getName());
        expsexo = (ExpConsultarSexo) getExpert(ExpConsultarSexo.class.getName());
        controladorProfesional = new ctrlAltaProfesional();
        controladorEmpleado = new ctrlAltaEmpleado();

        models = new HashMap<String, AbstractModelOptionList>();
        Map<String, List> listas;
        listas = expprof.iniciarProfesional();
        modelotarjeta = new ModelOptionTarjeta(listas.get("TARJETA"));
        modeltipo = new ModelOptionTipoEmpleado(listas.get("TIPO"));
        modelpais = new ModelOptionPais(listas.get("PAIS"));
        modellocalidad = new ModelOptionLocalidad(listas.get("LOCALIDAD"));
        modelprovincia = new ModelOptionProvincia(listas.get("PROVINCIA"));

        models.put("TIPO", modeltipo);
        models.put("PAIS", modelpais);
        models.put("LOCALIDAD", modellocalidad);
        models.put("PROVINCIA", modelprovincia);
        models.put("TARJETA", modelotarjeta);

    }

    public String iniciarAlta(String tipo, String nombre, String apellido, String dni,
            String fechaNacimiento, String telefono, String barrio,
            String calle, String numero, String piso, String departamanto,
            String localidad, String provincia, String pais, String sexo, String cuil,
            String matricula, String titulo, String tarjeta) {
            
            String option = (modeltipo.getSelectedItem(tipo).getNombre()).toUpperCase();
            String respuesta = null;
            try {
            switch (TipoEmpleado.valueOf(option)) {
                case EMPLEADO:
                    respuesta = controladorEmpleado.iniciarAlta(modeltipo.getSelectedItem(tipo),nombre,
                            apellido,dni,Tools.ManejaFechas.convertirString(fechaNacimiento),
                            Long.parseLong(telefono),barrio, calle,numero,piso,departamanto,
                            modellocalidad.getSelectedItem(localidad),
                            modelprovincia.getSelectedItem(provincia), modelpais.getSelectedItem(pais),
                            expsexo.listarSexo(sexo),cuil,modelotarjeta.getSelectedItem(tarjeta));
                    break;
               case PROFESIONAL:
                    respuesta = controladorProfesional.iniciarAlta(modeltipo.getSelectedItem(tipo),nombre,apellido,dni,Tools.ManejaFechas.convertirString(fechaNacimiento),
                                    Long.parseLong(telefono),barrio, calle,numero,piso,departamanto,modellocalidad.getSelectedItem(localidad),
                                    modelprovincia.getSelectedItem(provincia), modelpais.getSelectedItem(pais),
                                    expsexo.listarSexo(sexo),cuil,matricula,titulo,modelotarjeta.getSelectedItem(tarjeta));
                    break;
                default:
                    respuesta = "Tipo de Empleado no encontrado";
                    break;

            }
            return respuesta;
        } catch (Exception ex) {
            return "Error: Error de conexion con servidor de aplicaciones"+ex.toString();
        }

    }

    public AbstractModelOptionList getModels(String key) {
        try {
            return models.get(key.toUpperCase());
        } catch (Exception e) {
            return null;
        }
    }

}
