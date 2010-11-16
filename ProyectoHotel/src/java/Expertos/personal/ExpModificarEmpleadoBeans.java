/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import Entidades.Empleado;
import Entidades.Localidad;
import Entidades.Pais;
import Entidades.Provincia;
import Entidades.Sexo;
import Intermediarios.GestorConeccion;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

/**
 * Clase que implementa la interfaz ExpModificarProfesional
 *
 * Experto que realiza todas las tareas necesarias para modificar el profesional
 *
 * @author Juan
 */

@Stateless
public class ExpModificarEmpleadoBeans implements ExpModificarEmpleado {

    public ExpModificarEmpleadoBeans() {
    }

    /**
     * Lista los empleado del hospital, las provincias, paises y localidades
     *
     * @return: Hash map de los empleados del hospital los paises, provincias y localidades
     */
    public Map<String, List> listarEmpleados(){
        Map<String,List> lista = new HashMap<String, List>();
        lista.put("EMPLEADO", (new Intermediarios.IntermediarioEmpleado()).findAll());
        lista.put("PAIS", (new Intermediarios.IntermediarioPais()).findAll());
        lista.put("LOCALIDAD", (new Intermediarios.IntermediarioLocalidad().findAll()));
        lista.put("PROVINCIA", (new Intermediarios.IntermediarioProvincia().findAll()));
        return lista;
    }
    /**
     * Realiza la modificacion del empleado con todos los datos que se le envian como parametro
     *
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
     * @return true: si el empleado fue guardado con exito
     */
    public boolean modificarEmpleado (Empleado empleado, String nombre, String apellido, String dni, String fechaNacimiento,
            String telefono, String barrio, String calle, String numero, String piso, String departamanto,
            Localidad localidad, Provincia provincia, Pais pais, Sexo sexo, String cuil) {
        
            empleado.setNombre(nombre);
            empleado.setApellido(apellido);
            empleado.setDni(dni);
            empleado.setFechaNacimiento(Tools.ManejaFechas.convertirString(fechaNacimiento));
            empleado.setTelefono(Long.parseLong(telefono));
            empleado.setIdSexo(sexo);
            empleado.setCuil(cuil);
            modificarDomicilioEmpleado(empleado, barrio, calle,
                     numero, piso, departamanto, localidad, provincia, pais);

            /*Comienza una transaccion con la base de datos para actulizar el contenido*/
            try{
                GestorConeccion.getInstance().beginTransaction();
            if( (new Intermediarios.IntermediarioEmpleado()).actualizar(empleado) ){
                GestorConeccion.getInstance().commitTransaction();
                return true;
            }
            else{
                GestorConeccion.getInstance().rollbackTransaction();
                return false;
            }

        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

   /**
     * Metodo privado el cual modifica el domicilio del empleado
     *
     * @param empleado
     * @param barrio
     * @param calle
     * @param numero
     * @param piso
     * @param departamanto
     * @param localidad
     * @param provincia
     * @param pais
     *
     * @return: modifica la instancia del objeto empleado que se le envia como parametro
     */
    private void modificarDomicilioEmpleado (Empleado empleado, String barrio,
            String calle, String numero, String piso, String departamanto,
            Localidad localidad, Provincia provincia, Pais pais){

            empleado.getIdDomicilio().setCalle(calle);
            empleado.getIdDomicilio().setBarrio(barrio);
            empleado.getIdDomicilio().setNumero(Integer.getInteger(numero));
            empleado.getIdDomicilio().setPiso(piso);
            empleado.getIdDomicilio().setDepartamento(departamanto);
            empleado.getIdDomicilio().setIdLocalidad(localidad);
            empleado.getIdDomicilio().setIdProvincia(provincia);
            empleado.setIdPais(pais);
  
    }

}
