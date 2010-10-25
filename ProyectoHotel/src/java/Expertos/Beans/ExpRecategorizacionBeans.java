/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.Beans;

import Entidades.Categoria;
import Entidades.Clase;
import Entidades.ClaseContenida;
import Entidades.ClaseVigente;
import Entidades.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Manuel
 */
public class ExpRecategorizacionBeans {

    @EJB
    Expertos.ExpConsultarCategoria _consultaCategorias;
    Expertos.ExpConsultarPersonal _consultaPersonal;

    public List<Empleado> iniciarRecategorizacion(){
        return _consultaPersonal.listarEmpleadoinOrder();
    }

    public List<Categoria> buscarCategoriasPosibles(Empleado e){
        List<Categoria> posibles, categorias = _consultaCategorias.listarCategorias();
        posibles = new ArrayList<Categoria>();
        List<ClaseContenida> contenidas = null;
        long antiguedad = Tools.ManejaFechas.difencia(e.getFechaIngreso());
        int idx = 0;
        //Completa la lista de las categorias que se pueden listar
        for (Categoria c : categorias) {
            contenidas = new ArrayList<ClaseContenida>();
            idx = 0;
            while(c.getClaseContenida().size()> idx &&
                    antiguedad >= c.getClaseContenida().get(idx).getAntiguedadMinima()){
                contenidas.add(c.getClaseContenida().get(idx));
                idx++;
            }

            c.setClaseContenidaList(contenidas);
            if(!contenidas.isEmpty())
                posibles.add(c);
        }

        Clase cl = null;
        Categoria c=null;
        for (ClaseVigente cv : e.getClaseVigenteList()) {
            if(cv.getVigente()){
                c= cv.getCategoria();
                cl=cv.getClase();
                break;
            }
        }
        if(c!=null){
            posibles.remove(c);
            contenidas = new ArrayList<ClaseContenida>();
            idx= c.getClaseContenida().get(c.getClaseContenida().indexOf(cl)).getNumeroIndiceOrden();
            for (ClaseContenida cC : c.getClaseContenida()) {
                if(cC.getNumeroIndiceOrden()== idx +1 ){
                    contenidas.add(cC);
                    break;
                }
            }
            c.setClaseContenidaList(contenidas);
            posibles.add(0, c);
        }
        
        return posibles;
    }
}
