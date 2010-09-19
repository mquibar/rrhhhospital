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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "Clase", catalog = "hospital", schema = "public")
@NamedQueries({@NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c"), @NamedQuery(name = "Clase.findById", query = "SELECT c FROM Clase c WHERE c.id = :id"), @NamedQuery(name = "Clase.findByNombre", query = "SELECT c FROM Clase c WHERE c.nombre = :nombre")})
public class Clase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="id_sequence",strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="id_sequence",sequenceName="clase_id_sequence")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClase", fetch = FetchType.LAZY)
    private List<ClaseVigente> claseVigenteList;

    public Clase() {
    }

    public Clase(Integer id) {
        this.id = id;
    }

    public Clase(Integer id, String nombre) {
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

    public List<ClaseVigente> getClaseVigenteList() {
        return claseVigenteList;
    }

    public void setClaseVigenteList(List<ClaseVigente> claseVigenteList) {
        this.claseVigenteList = claseVigenteList;
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
        if (!(object instanceof Clase)) {
            return false;
        }
        Clase other = (Clase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Clase[id=" + id + "]";
    }

}
