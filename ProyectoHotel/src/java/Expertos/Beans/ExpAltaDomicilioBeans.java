/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Domicilio;
import Entidades.Localidad;
import Entidades.Provincia;
import Expertos.ExpAltaDomicilio;
import Intermediarios.GestorConeccion;
import Intermediarios.IntermediarioDomicilio;
import javax.ejb.Stateless;

/**
 *
 * @author Juan
 */
@Stateless
public class ExpAltaDomicilioBeans implements ExpAltaDomicilio {

    private Domicilio _domicilio;

    public ExpAltaDomicilioBeans() {
        _domicilio = new Domicilio();
    }

    public Domicilio altaDomicilio(String barrio, String calle, String numero,
            String piso, String departamanto, Localidad localidad, Provincia provincia) {
        
        Domicilio resultado;

        _domicilio.setBarrio(barrio);
        _domicilio.setCalle(calle);
        _domicilio.setNumero(Integer.parseInt(numero));
        _domicilio.setPiso(piso);
        _domicilio.setDepartamento(departamanto);
        _domicilio.setIdLocalidad(localidad);
        _domicilio.setIdProvincia(provincia);

        GestorConeccion.getInstance().beginTransaction();
        try{
            if( (new IntermediarioDomicilio()).guardar(_domicilio) ){
                resultado = _domicilio;
                GestorConeccion.getInstance().commitTransaction();
            }
            else{
                resultado = null;
                GestorConeccion.getInstance().rollbackTransaction();
            }
        }catch(Exception ex){
            System.out.println("************ <Error en el Experto de Alta de Domicilio>");
            ex.printStackTrace();
            System.out.println("<\\Error> *****************");
            resultado = null;
        }
        return resultado;
    }
}
