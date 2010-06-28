/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "Tramo", catalog = "hospital", schema = "public")
@NamedQueries({@NamedQuery(name = "Tramo.findAll", query = "SELECT t FROM Tramo t"), @NamedQuery(name = "Tramo.findById", query = "SELECT t FROM Tramo t WHERE t.id = :id"), @NamedQuery(name = "Tramo.findByNombre", query = "SELECT t FROM Tramo t WHERE t.nombre = :nombre")})
public class Tramo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @JoinColumn(name = "idAgrupamiento", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Agrupamiento idAgrupamiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTramo", fetch = FetchType.LAZY)
    private List<Categoria> categoriaList;

    public Tramo() {
    }

    public Tramo(Integer id) {
        this.id = id;
    }

    public Tramo(Integer id, String nombre) {
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

    public Agrupamiento getIdAgrupamiento() {
        return idAgrupamiento;
    }

    public void setIdAgrupamiento(Agrupamiento idAgrupamiento) {
        this.idAgrupamiento = idAgrupamiento;
    }

    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
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
        if (!(object instanceof Tramo)) {
            return false;
        }
        Tramo other = (Tramo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tramo[id=" + id + "]";
    }

}
