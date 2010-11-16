/*
 * Experto que realiza la modificación del profesional
 */

package Expertos.personal;

import Entidades.Profesional;
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
public class ExpModificarProfesionalBeans implements ExpModificarProfesional {


    /**
     * Lista los profesionales del hospital, las provincias, paises y localidades
     *
     * @return: Hash map de los empleados del hospital los paises, provincias y localidades
     */
    public Map<String, List> listarProfesional(){
        Map<String,List> lista = new HashMap<String, List>();
        lista.put("PROFESIONAL", (new Intermediarios.IntermediarioProfesional()).findAll());
        lista.put("PAIS", (new Intermediarios.IntermediarioPais()).findAll());
        lista.put("LOCALIDAD", (new Intermediarios.IntermediarioLocalidad().findAll()));
        lista.put("PROVINCIA", (new Intermediarios.IntermediarioProvincia().findAll()));
        return lista;
    }

    /**
     * Realiza la modificacion del profesional con todos los datos que se le envian como parametro
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
     *
     * @return true: si el profesional fue guardado con exito
     */
    public boolean modificarProfesional (Profesional profesional, String nombre, String apellido, String dni, String fechaNacimiento,
            String telefono, String barrio, String calle, String numero, String piso, String departamanto,
            Localidad localidad, Provincia provincia, Pais pais, Sexo sexo, String cuil,
            String matricula, String titulo) {


            profesional.setNombre(nombre);
            profesional.setApellido(apellido);
            profesional.setDni(dni);
            profesional.setFechaNacimiento(Tools.ManejaFechas.convertirString(fechaNacimiento));
            profesional.setTelefono(Long.parseLong(telefono));
            profesional.setIdSexo(sexo);
            profesional.setCuil(cuil);
            modificarDomicilioProfesional (profesional, barrio, calle,
                     numero, piso, departamanto, localidad, provincia, pais);
            profesional.setTitulo(titulo);
            profesional.setMatricula(matricula);

            /*Comienza una transaccion con la base de datos para actulizar el contenido*/
            try{
            GestorConeccion.getInstance().beginTransaction();
            if( (new Intermediarios.IntermediarioProfesional()).actualizar(profesional) ){
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
     * Metodo privado el cual modifica el domicilio del profesional
     *
     * @param profesional
     * @param barrio
     * @param calle
     * @param numero
     * @param piso
     * @param departamanto
     * @param localidad
     * @param provincia
     * @param pais
     *
     * @return: modifica la instancia del objeto profesional que se le envia como parametro
     */
    private void modificarDomicilioProfesional (Profesional profesional, String barrio,
            String calle, String numero, String piso, String departamanto,
            Localidad localidad, Provincia provincia, Pais pais){

            profesional.getIdDomicilio().setCalle(calle);
            profesional.getIdDomicilio().setBarrio(barrio);
            profesional.getIdDomicilio().setNumero(Integer.getInteger(numero));
            profesional.getIdDomicilio().setPiso(piso);
            profesional.getIdDomicilio().setDepartamento(departamanto);
            profesional.getIdDomicilio().setIdLocalidad(localidad);
            profesional.getIdDomicilio().setIdProvincia(provincia);
            profesional.setIdPais(pais);
    }

}
