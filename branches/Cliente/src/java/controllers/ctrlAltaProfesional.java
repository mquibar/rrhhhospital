/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Provincia;
import Entidades.Sexo;
import Expertos.ExpAltaProfesional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.combos.AbstractModelOptionList;
import models.combos.ModelOptionPais;
import models.combos.ModelOptionTipoEmpleado;

/**
 *
 * @author MARIANO
 */
public class ctrlAltaProfesional extends GeneralController{

    private ExpAltaProfesional exp;
    private Map<String,AbstractModelOptionList> models;

    public ctrlAltaProfesional() {
        exp =(ExpAltaProfesional)getExpert(ExpAltaProfesional.class.getName());
        Map<String,List> listas;
        listas= exp.iniciar();
        models = new HashMap<String, AbstractModelOptionList>();
        models.put("TIPO", new ModelOptionTipoEmpleado(listas.get("TIPO")));
        models.put("PAIS", new ModelOptionPais(listas.get("PAIS")));
        models.put("LOCALIDAD", new ModelOptionPais(listas.get("LOCALIDAD")));
        models.put("PROVINCIA", new ModelOptionPais(listas.get("PROVINCIA")));
    }

    public void iniciarAlta (String nombre, String apellido, String dni,
            Date fechaNacimiento, long telefono, String barrio,
            String calle, String numero, String piso, String departamanto,
            Localidad localidad, Provincia provincia, Pais pais, Sexo sexo, String cuil, String matricula, String titulo){

        try {
            
            if(exp.iniciarAlta(nombre,apellido,dni,fechaNacimiento,telefono,barrio,
                    calle,numero,piso,departamanto,localidad,provincia,pais,sexo,cuil,matricula,titulo)){
                System.out.println("Guardado");
                return;
            }
            else{
                System.out.println("Error al Guardar");
                return;
            }
        } catch (Exception ex) {
            System.out.println("Error de conexion con servidor de aplicaciones");
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
