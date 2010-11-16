/*
 * Controlador de Modificación de Persona controlador encargado de derivar
 * la información a los controladores especificos, el de profesional y el de
 * empleado, asi ellos realizan la comunicación
 * 
 */

package controllers;

import Entidades.Empleado;
import Entidades.Profesional;
import Expertos.personal.ExpConsultarPersonal;
import Expertos.personal.ExpModificarProfesional;
import models.combos.AbstractModelOptionList;
import models.combos.ModelOptionEmpleado;
import models.combos.ModelOptionProfesional;

/**
 * Controlador modificar persona, realiza la comunicación entre el
 * los controladores especificos
 * @author Juan
 */

public class ctrlModificarPersona extends GeneralController {

    private ExpModificarProfesional _exp;
    private ModelOptionEmpleado model = null;
    private ModelOptionProfesional model2 = null;
    private ExpConsultarPersonal _expcons;
    private Empleado empleado;
    private Profesional profesional;
    private enum TipoEmpleado {
        EMPLEADO,PROFESIONAL
    }

    /*Consutrutor del controlador de modificar profesional*/
    public ctrlModificarPersona() {
        _exp = (ExpModificarProfesional) super.getExpert(ExpModificarProfesional.class.getName());
        _expcons = (ExpConsultarPersonal) super.getExpert(ExpConsultarPersonal.class.getName());
    }

    /*Obtiene los profesionales del sitio, para realizar la modificacion*/
    public AbstractModelOptionList getProfesionales(){
        if(model2 == null)
            model2 = new ModelOptionProfesional(_expcons.listarProfesionalinOrder());
        return model2;
    }

    /*Obtiene los empleados del sitio, para realizar la modificacion*/
    public AbstractModelOptionList getEmpleados(){
        model = new ModelOptionEmpleado(_expcons.listarEmpleadoinOrder());
        return model;
    }

    /* Recupera la informacion segun el tipo de persona, para poder escribirla en la pantalla
     * para poder leer los datos del empleado. Luego se efectua la modificación
     */
    public String recuperarDato (String valor) {
        String option = (model.getSelectedItem(valor).getIdTipoEmpleado()).getNombre().toUpperCase();
        String url = null;
        try {
        switch (TipoEmpleado.valueOf(option)) {
                case EMPLEADO:
                    empleado = model.getSelectedItem(valor);
                    url="empleado_modificado.jsp?nombre="+empleado.getNombre()+"&"+
                           "apellido="+empleado.getApellido()+"&"+
                           "dni="+empleado.getDni()+"&"+
                           "fechaNacimiento="+Tools.ManejaFechas.convertirDate(empleado.getFechaIngreso())+"&"+
                           "telefono="+Long.toString(empleado.getTelefono())+"&"+
                           "cuil="+empleado.getCuil()+"&"+
                           "calle="+empleado.getIdDomicilio().getCalle()+"&"+
                           "numero="+empleado.getIdDomicilio().getNumero()+"&"+
                           "barrio="+empleado.getIdDomicilio().getBarrio()+"&"+
                           "piso="+empleado.getIdDomicilio().getPiso()+"&"+
                           "departamento="+empleado.getIdDomicilio().getDepartamento()+"&"+
                           "pais="+empleado.getIdPais().getPais()+"&"+
                           "localidad="+empleado.getIdDomicilio().getIdLocalidad().getLocalidad()+"&"+
                           "provincia="+empleado.getIdDomicilio().getIdProvincia().getProvincia()+"&"+
                           "empleado="+valor;
                    break;
                case PROFESIONAL:
                    profesional = (Profesional)model.getSelectedItem(valor);
                    url="profesional_modificado.jsp?nombre="+profesional.getNombre()+"&"+
                           "apellido="+profesional.getApellido()+"&"+
                           "dni="+profesional.getDni()+"&"+
                           "fechaNacimiento="+Tools.ManejaFechas.convertirDate(profesional.getFechaIngreso())+"&"+
                           "telefono="+Long.toString(profesional.getTelefono())+"&"+
                           "matricula="+profesional.getMatricula()+"&"+
                           "titulo="+profesional.getTitulo()+"&"+
                           "cuil="+profesional.getCuil()+"&"+
                           "calle="+profesional.getIdDomicilio().getCalle()+"&"+
                           "numero="+profesional.getIdDomicilio().getNumero()+"&"+
                           "barrio="+profesional.getIdDomicilio().getBarrio()+"&"+
                           "piso="+profesional.getIdDomicilio().getPiso()+"&"+
                           "departamento="+profesional.getIdDomicilio().getDepartamento()+"&"+
                           "pais="+profesional.getIdPais().getPais()+"&"+
                           "localidad="+profesional.getIdDomicilio().getIdLocalidad().getLocalidad()+"&"+
                           "provincia="+profesional.getIdDomicilio().getIdProvincia().getProvincia()+"&"+
                           "profesional="+valor;
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

    /*llama al controlador especifico para el manejo de la clase empleado, asi lo actualiza*/
    public void guardarEmpleado (String nombre, String apellido, String dni, String fechaNacimiento,
            String telefono, String barrio, String calle, String numero, String piso, String departamanto,
            String localidad, String provincia, String pais, String cuil) throws Exception {
            
            ctrlModificarEmpleado controlador = new ctrlModificarEmpleado();
            System.out.println(controlador.modificarEmpleado(empleado, nombre, apellido, dni, fechaNacimiento, telefono,
                    barrio, calle, numero, piso, departamanto, localidad, provincia, pais, "Masculino", cuil));
    
    }

    /*llama al controlador especifico para el manejo de la clase profesional, asi lo actualiza*/
    public void guardarProfesional (String nombre, String apellido, String dni, String fechaNacimiento,
            String telefono, String barrio, String calle, String numero, String piso, String departamanto,
            String localidad, String provincia, String pais, String cuil, String matricula, String titulo) throws Exception {
            System.out.println(telefono);
            System.out.println(calle);
            System.out.println("Telefono del profesional: "+profesional.getTelefono());
            ctrlModificarProfesional controlador = new ctrlModificarProfesional();
            System.out.println(controlador.modificarProfesional(profesional, nombre, apellido, dni, fechaNacimiento,
                    telefono, barrio, calle, numero, piso, departamanto, localidad, provincia, pais,
                    "Masculino", cuil, matricula, titulo));
    }

}
