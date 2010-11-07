/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Expertos.ExpAltaProfesional;
import Expertos.ExpConsultarSexo;
import Expertos.ExpAltaTipoEmpleado;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.combos.*;

/**
 *
 * @author MARIANO
 */
public class ctrlAltaProfesional extends GeneralController{

    private ExpAltaProfesional exp;
    private ExpConsultarSexo expsexo;
    private ExpAltaTipoEmpleado exptipo;
    private Map<String,AbstractModelOptionList> models;
    private ModelOptionPais modelpais;
    private ModelOptionProvincia modelprovincia;
    private ModelOptionLocalidad modellocalidad;


    public ctrlAltaProfesional() {
        exptipo =(ExpAltaTipoEmpleado)getExpert(ExpAltaTipoEmpleado.class.getName());
        exptipo.iniciarAlta("Empleado", "1");
        if(exptipo.guardarTipoEmpleado())
            System.out.println("Todo bien con la DB");
        exp =(ExpAltaProfesional)getExpert(ExpAltaProfesional.class.getName());
        expsexo =(ExpConsultarSexo)getExpert(ExpConsultarSexo.class.getName());
        Map<String,List> listas;
        listas= exp.iniciar();
        models = new HashMap<String, AbstractModelOptionList>();
        modellocalidad = new ModelOptionLocalidad(listas.get("LOCALIDAD"));
        modelprovincia = new ModelOptionProvincia(listas.get("PROVINCIA"));
        modelpais = new ModelOptionPais(listas.get("PAIS"));

        models.put("TIPO", new ModelOptionTipoEmpleado(listas.get("TIPO")));
        models.put("PAIS", modelpais);
        models.put("LOCALIDAD", modellocalidad);
        models.put("PROVINCIA", modelprovincia);
    }

    public String iniciarAlta (String nombre, String apellido, String dni,
            String fechaNacimiento, String telefono, String barrio,
            String calle, String numero, String piso, String departamanto,
            String localidad, String provincia, String pais, String sexo, String cuil, String matricula, String titulo){

        try {
            
            if(exp.iniciarAlta(nombre,apellido,dni,java.sql.Date.valueOf(fechaNacimiento),Long.parseLong(telefono),barrio,
                    calle,numero,piso,departamanto,modellocalidad.getSelectedItem(localidad),modelprovincia.getSelectedItem(provincia),
                    modelpais.getSelectedItem(pais),expsexo.listarSexo(sexo),cuil,matricula,titulo)){
                return "Guardado";
                
            }
            else{
                return "Error al Guardar";
                
            }
        } catch (Exception ex) {
            return "Error de conexion con servidor de aplicaciones";
        }
        
    }

    public ctrlAltaProfesional(Boolean deMentira){}

    public String guardar()
    {
        return "Guardado con exito";
    }

    public AbstractModelOptionList getModels(String key){
        return models.get(key.toUpperCase());
    }
    
    public void cancel(){
       
    }
}
