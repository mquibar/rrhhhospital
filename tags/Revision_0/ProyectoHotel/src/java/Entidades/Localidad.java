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
@Table(name = "Localidad", catalog = "hospital", schema = "public")
@NamedQueries({@NamedQuery(name = "Localidad.findAll", query = "SELECT l FROM Localidad l"), @NamedQuery(name = "Localidad.findById", query = "SELECT l FROM Localidad l WHERE l.id = :id"), @NamedQuery(name = "Localidad.findByLocalidad", query = "SELECT l FROM Localidad l WHERE l.localidad = :localidad")})
public class Localidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Localidad")
    private String localidad;
    @JoinColumn(name = "IdPovincia", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Provincia idPovincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLocalidad", fetch = FetchType.LAZY)
    private List<Domicilio> domicilioList;

    public Localidad() {
    }

    public Localidad(Integer id) {
        this.id = id;
    }

    public Localidad(Integer id, String localidad) {
        this.id = id;
        this.localidad = localidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Provincia getIdPovincia() {
        return idPovincia;
    }

    public void setIdPovincia(Provincia idPovincia) {
        this.idPovincia = idPovincia;
    }

    public List<Domicilio> getDomicilioList() {
        return domicilioList;
    }

    public void setDomicilioList(List<Domicilio> domicilioList) {
        this.domicilioList = domicilioList;
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
        if (!(object instanceof Localidad)) {
            return false;
        }
        Localidad other = (Localidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Localidad[id=" + id + "]";
    }

}
