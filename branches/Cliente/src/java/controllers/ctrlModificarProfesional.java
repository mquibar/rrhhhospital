/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Expertos.personal.ExpConsultarSexo;
import Expertos.personal.ExpModificarProfesional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.combos.AbstractModelOptionList;
import models.combos.ModelOptionLocalidad;
import models.combos.ModelOptionPais;
import models.combos.ModelOptionProfesional;
import models.combos.ModelOptionProvincia;

/**
 * Controlador especifico que se encarga de la modificacion de un profesional
 *
 * @author Juan
 */
public class ctrlModificarProfesional extends GeneralController {

    private ExpModificarProfesional _exp;
    private ExpConsultarSexo _expsexo;
    private Map<String, AbstractModelOptionList> models;
    private ModelOptionPais modelpais;
    private ModelOptionProvincia modelprovincia;
    private ModelOptionLocalidad modellocalidad;
    private ModelOptionProfesional modelprofesional;

    /**
     * Crea e inicializa el controlador especifico que modificará al profesional
     */
    public ctrlModificarProfesional() {
        _exp = (ExpModificarProfesional) getExpert(ExpModificarProfesional.class.getName());
        _expsexo = (ExpConsultarSexo) getExpert(ExpConsultarSexo.class.getName());
        Map<String, List> listas;
        listas = _exp.listarProfesional();
        models = new HashMap<String, AbstractModelOptionList>();
        modelprofesional = new ModelOptionProfesional(listas.get("PROFESIONAL"));
        modelpais = new ModelOptionPais(listas.get("PAIS"));
        modellocalidad = new ModelOptionLocalidad(listas.get("LOCALIDAD"));
        modelprovincia = new ModelOptionProvincia(listas.get("PROVINCIA"));
        models.put("PROFESIONAL", modelprofesional);
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
     * Controlador que dispara la modificacion del profesional, con los datos
     * enviados desde la pantalla
     *
     * @param profesional
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
     * @param matricula
     * @param titulo
     * @return: string dependiendo de lo que suceda
     *      * "Profesional Actualizado" : el profesional se actualizo
     *      * "Error al Actualizar al profesional" : el profesional no se pudo guardar
     *      * "Error: Error de conexion con servidor de aplicaciones"+ex.toString(): exepcion
     *
     */
    public  String modificarProfesional (String profesional, String nombre, String apellido, String dni, String fechaNacimiento,
            String telefono, String barrio, String calle, String numero, String piso, String departamanto,
            String localidad, String provincia, String pais, String sexo, String cuil, String matricula, String titulo) {

         try {

            if(_exp.modificarProfesional(modelprofesional.getSelectedItem(profesional), nombre, apellido, dni,
                    fechaNacimiento, telefono, barrio, calle, numero, piso,
                    departamanto, modellocalidad.getSelectedItem(localidad),
                    modelprovincia.getSelectedItem(provincia), modelpais.getSelectedItem(pais),
                    _expsexo.listarSexo(sexo), cuil, matricula, titulo)){
                return "Profesional Actualizado";

            } else {
                return "Error al Actualizar al profesional";

            }
        } catch (Exception ex) {
            return "Error: Error de conexion con servidor de aplicaciones"+ex.toString();
        }
    }

}
