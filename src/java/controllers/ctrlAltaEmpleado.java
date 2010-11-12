/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Expertos.personal.ExpAltaEmpleado;
import Expertos.personal.ExpConsultarSexo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.combos.*;

/**
 *
 * @author MARIANO
 */

public class ctrlAltaEmpleado extends GeneralController {

    private ExpAltaEmpleado exp;
    private ExpConsultarSexo expsexo;
    private Map<String, AbstractModelOptionList> models;
    private ModelOptionPais modelpais;
    private ModelOptionProvincia modelprovincia;
    private ModelOptionLocalidad modellocalidad;
    private ModelOptionTipoEmpleado modeltipo;
    private ModelOptionTarjeta modelotarjeta;

    public ctrlAltaEmpleado() {
        exp = (ExpAltaEmpleado) getExpert(ExpAltaEmpleado.class.getName());
        expsexo = (ExpConsultarSexo) getExpert(ExpConsultarSexo.class.getName());
        models = new HashMap<String, AbstractModelOptionList>();
        Map<String, List> listas;
        listas = exp.iniciarEmpleado();
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
            String tarjeta) {
            
        try {

            if(exp.iniciarAlta(modeltipo.getSelectedItem(tipo),nombre,apellido,dni,Tools.ManejaFechas.convertirString(fechaNacimiento),
                    Long.parseLong(telefono),barrio, calle,numero,piso,departamanto,modellocalidad.getSelectedItem(localidad),
                    modelprovincia.getSelectedItem(provincia), modelpais.getSelectedItem(pais),
                    expsexo.listarSexo(sexo),cuil,modelotarjeta.getSelectedItem(tarjeta))){
                return "Error: Guardado";

            } else {
                return "Error: Error al Guardar";

            }
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

    public void cancel() {
    }

}
