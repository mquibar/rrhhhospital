/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package security;

import javax.ejb.Remote;

/**
 *
 * @author Manuel
 */
@Remote
public interface GestorUserAdminRemote {

    public java.util.List<Entidades.seguridad.Usuario> listarUsuarios();

    /**
     * Este modulo es usado solamente desde la consola de administración, por lo que solamente recibira
     * el <code>password</code> nuevo que se le desea asignar a un usuario
     * @param user usuario al que se le cambiara el password
     * @param password nuevo password a asignar
     * @throws system.exception.InvalidDataException la exception sera largada si alguno de los datos solicitados son invalidos o null
     */
    public void modificarPass(Entidades.seguridad.Usuario user, java.lang.String password, Entidades.seguridad.Perfil perfil) throws system.exception.InvalidDataException, system.exception.GenericException;

    /**
     * Con este metodo un usuario logeado puede cambiar el password cdo lo desee,
     * debe mandar 3 passwords, el actual y uno nuevo con su confirmación
     * @param passwords mediante este parametro ingreso los passwords que deben ser: actual, nuevo, confirmación
     * @throws system.exception.InvalidDataException
     * @throws system.exception.GenericException
     */
    public void changePass(java.lang.String... passwords) throws system.exception.InvalidDataException, system.exception.GenericException;

    public java.util.List<Entidades.seguridad.Perfil> listarPerfiles();
    
}
