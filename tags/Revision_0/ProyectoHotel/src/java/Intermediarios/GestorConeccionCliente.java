/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermediarios;

import javax.ejb.Remote;

/**
 *
 * @author Familia
 */
@Remote
public interface GestorConeccionCliente {

    public boolean BeginTxClient();
    public void CommitTxClient();
    public void RollBackTxClient();
}
