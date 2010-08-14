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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "TipoCarga", catalog = "hospital", schema = "public")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({@NamedQuery(name = "TipoCarga.findAll", query = "SELECT t FROM TipoCarga t"), @NamedQuery(name = "TipoCarga.findById", query = "SELECT t FROM TipoCarga t WHERE t.id = :id"), @NamedQuery(name = "TipoCarga.findByNombre", query = "SELECT t FROM TipoCarga t WHERE t.nombre = :nombre"), @NamedQuery(name = "TipoCarga.findByDescripcion", query = "SELECT t FROM TipoCarga t WHERE t.descripcion = :descripcion"), @NamedQuery(name = "TipoCarga.findByDtype", query = "SELECT t FROM TipoCarga t WHERE t.dtype = :dtype")})
public class TipoCarga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    protected Integer id;
    @Basic(optional = false)
    @Column(name = "Nombre")
    protected String nombre;
    @Column(name = "Descripcion")
    protected String descripcion;

    public TipoCarga() {
    }

    public TipoCarga(Integer id) {
        this.id = id;
    }

    public TipoCarga(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCarga)) {
            return false;
        }
        TipoCarga other = (TipoCarga) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TipoCarga[id=" + id + "]";
    }

}
