/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Expertos.personal.ExpAltaPersonal;
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

        private ExpAltaPersonal exp;
        private ExpConsultarSexo expsexo;
        private ctrlAltaEmpleado controladorEmpleado;
        private ctrlAltaProfesional controladorProfesional;
        private Map<String, AbstractModelOptionList> models;
        private ModelOptionPais modelpais;
        private ModelOptionProvincia modelprovincia;
        private ModelOptionLocalidad modellocalidad;
        private ModelOptionTipoEmpleado modeltipo;
        private ModelOptionTarjeta modelotarjeta;
        private ModelOptionSexo modelsexo;
        private String tipoPersona;
        private enum AltaPersona {
            EMPLEADO,PROFESIONAL
        }


    public ctrlAltaPersonal() {
        exp = (ExpAltaPersonal) super.getExpert(ExpAltaPersonal.class.getName());
        expsexo = (ExpConsultarSexo) super.getExpert(ExpConsultarSexo.class.getName());
        controladorProfesional = new ctrlAltaProfesional();
        controladorEmpleado = new ctrlAltaEmpleado();

        models = new HashMap<String, AbstractModelOptionList>();
        Map<String, List> listas;
        listas = exp.iniciarPersonal();
        modelotarjeta = new ModelOptionTarjeta(listas.get("TARJETA"));
        modeltipo = new ModelOptionTipoEmpleado(listas.get("TIPO"));
        modelpais = new ModelOptionPais(listas.get("PAIS"));
        modellocalidad = new ModelOptionLocalidad(listas.get("LOCALIDAD"));
        modelprovincia = new ModelOptionProvincia(listas.get("PROVINCIA"));
        modelsexo = new ModelOptionSexo(expsexo.listAll());
        models.put("TIPO", modeltipo);
        models.put("PAIS", modelpais);
        models.put("LOCALIDAD", modellocalidad);
        models.put("PROVINCIA", modelprovincia);
        models.put("TARJETA", modelotarjeta);
        models.put("SEXO", modelsexo);

    }
    /**
     * Inicia el alta de la persona dependiendo el tipo
     * @param valor: valor del tipo de persona
     * @return, Retorna el contenido de la pagina a cargar
     */
    public String iniciar (String valor) {
        tipoPersona = valor;
        String option = modeltipo.getSelectedItem(valor).getNombre().toUpperCase();
        String url = null;
        try {
        switch (AltaPersona.valueOf(option)) {
                case EMPLEADO:
                    url="alta_empleado.jsp?";
                    break;
                case PROFESIONAL:
                    url="alta_profesional.jsp?";
                    break;
                default:
                    System.out.println("default entro");
                    url="underContruction.html";
        }
        } catch (Exception e){
            System.out.println("exception"+e.getMessage());
        }
         return url;

    }


    public String iniciarAltaEmpleado(String nombre, String apellido, String dni,
            String fechaNacimiento, String telefono, String barrio,
            String calle, String numero, String piso, String departamanto,
            String localidad, String provincia, String pais, String sexo, String cuil,
            String tarjeta) {
            
            try {
                return controladorEmpleado.iniciarAlta(modeltipo.getSelectedItem(tipoPersona),nombre,
                            apellido,dni,Tools.ManejaFechas.convertirString(fechaNacimiento),
                            Long.parseLong(telefono),barrio, calle,numero,piso,departamanto,
                            modellocalidad.getSelectedItem(localidad),
                            modelprovincia.getSelectedItem(provincia), modelpais.getSelectedItem(pais),
                            modelsexo.getSelectedItem(sexo),cuil,modelotarjeta.getSelectedItem(tarjeta));
                
            } catch (Exception ex) {
                return "Error: Error de conexion con servidor de aplicaciones"+ex.toString();
            }

    }


    public String iniciarAltapRrofesional(String nombre, String apellido, String dni,
            String fechaNacimiento, String telefono, String barrio,
            String calle, String numero, String piso, String departamanto,
            String localidad, String provincia, String pais, String sexo, String cuil,
            String matricula, String titulo, String tarjeta) {

            try {
                return controladorProfesional.iniciarAlta(modeltipo.getSelectedItem(tipoPersona),nombre,apellido,dni,Tools.ManejaFechas.convertirString(fechaNacimiento),
                                    Long.parseLong(telefono),barrio, calle,numero,piso,departamanto,modellocalidad.getSelectedItem(localidad),
                                    modelprovincia.getSelectedItem(provincia), modelpais.getSelectedItem(pais),
                                    modelsexo.getSelectedItem(sexo),cuil,matricula,titulo,modelotarjeta.getSelectedItem(tarjeta));

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
