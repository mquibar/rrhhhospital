/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Expertos.personal.ExpAltaProfesional;
import Expertos.personal.ExpConsultarSexo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.combos.*;

/**
 *
 * @author MARIANO
 */
public class ctrlAltaProfesional extends GeneralController {

    private ExpAltaProfesional exp;
    private ExpConsultarSexo expsexo;
    private Map<String, AbstractModelOptionList> models;
    private ModelOptionPais modelpais;
    private ModelOptionProvincia modelprovincia;
    private ModelOptionLocalidad modellocalidad;
    private ModelOptionTipoEmpleado modeltipo;
    private ModelOptionTarjeta modelotarjeta;


    public ctrlAltaProfesional() {
        exp = (ExpAltaProfesional) getExpert(ExpAltaProfesional.class.getName());
        expsexo = (ExpConsultarSexo) getExpert(ExpConsultarSexo.class.getName());
        models = new HashMap<String, AbstractModelOptionList>();
        Map<String, List> listas;
        listas = exp.iniciarProfesional();
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
            int i = 1;
        try {

            if(exp.iniciarAlta(modeltipo.getSelectedItem(tipo),nombre,apellido,dni,Tools.ManejaFechas.convertirString(fechaNacimiento),
                    Long.parseLong(telefono),barrio, calle,numero,piso,departamanto,modellocalidad.getSelectedItem(localidad),
                    modelprovincia.getSelectedItem(provincia), modelpais.getSelectedItem(pais),
                    expsexo.listarSexo(sexo),cuil,matricula,titulo,modelotarjeta.getSelectedItem(tarjeta))){
                return "Error: Guardado";
                
            } else {
                return "Error: Error al Guardar";
                
            }
        } catch (Exception ex) {
            return "Error: Error de conexion con servidor de aplicaciones"+ex.toString();
        }

    }

    public ctrlAltaProfesional(Boolean deMentira) {
    }

    public String guardar() {
        return "Guardado con exito";
    }

    public AbstractModelOptionList getModels(String key) {
        try {
            return models.get(key.toUpperCase());
        } catch (Exception e) {
            return null;
        }
    }

    public void cancel() {
    }
}
