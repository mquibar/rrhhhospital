/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Desarrollo
 */
@Embeddable
public class ClaseContenidaPk implements Serializable{

    @JoinColumn(name = "idClase", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clase idClase;
    @JoinColumn(name = "idCategoria", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria idCategoria;

    public ClaseContenidaPk() {
    }

    public ClaseContenidaPk(Clase idClase, Categoria idCategoria) {
        this.idClase = idClase;
        this.idCategoria = idCategoria;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Clase getIdClase() {
        return idClase;
    }

    public void setIdClase(Clase idClase) {
        this.idClase = idClase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += idClase.getId();
        hash += idCategoria.getId();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClaseContenidaPk other = (ClaseContenidaPk) obj;
        if (this.idClase != other.idClase && (this.idClase == null || !this.idClase.equals(other.idClase))) {
            return false;
        }
        if (this.idCategoria != other.idCategoria && (this.idCategoria == null || !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    


}
