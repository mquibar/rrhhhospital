/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Expertos.personal;

import javax.ejb.Remote;

/**
 *
 * @author MARIANO
 */
@Remote
public interface ExpConsultarSexo {

    public Entidades.Sexo listarSexo(java.lang.String sexo);

    public Entidades.Sexo listarPorId(int id);

    public java.util.List<Entidades.Sexo> listAll();

}