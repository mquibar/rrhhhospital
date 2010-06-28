/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "TipoLicencia", catalog = "hospital", schema = "public")
@NamedQueries({@NamedQuery(name = "TipoLicencia.findAll", query = "SELECT t FROM TipoLicencia t"), @NamedQuery(name = "TipoLicencia.findById", query = "SELECT t FROM TipoLicencia t WHERE t.id = :id"), @NamedQuery(name = "TipoLicencia.findByNombre", query = "SELECT t FROM TipoLicencia t WHERE t.nombre = :nombre"), @NamedQuery(name = "TipoLicencia.findByDescripcion", query = "SELECT t FROM TipoLicencia t WHERE t.descripcion = :descripcion"), @NamedQuery(name = "TipoLicencia.findByEliminado", query = "SELECT t FROM TipoLicencia t WHERE t.eliminado = :eliminado")})
public class TipoLicencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "Eliminado")
    private boolean eliminado;

    public TipoLicencia() {
    }

    public TipoLicencia(Integer id) {
        this.id = id;
    }

    public TipoLicencia(Integer id, String nombre, boolean eliminado) {
        this.id = id;
        this.nombre = nombre;
        this.eliminado = eliminado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoLicencia)) {
            return false;
        }
        TipoLicencia other = (TipoLicencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TipoLicencia[id=" + id + "]";
    }

}
