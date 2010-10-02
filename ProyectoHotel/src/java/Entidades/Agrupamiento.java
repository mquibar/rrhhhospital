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
@Table(name = "Agrupamiento")
@NamedQueries({@NamedQuery(name = "Agrupamiento.findAll", query = "SELECT a FROM Agrupamiento a"), @NamedQuery(name = "Agrupamiento.findById", query = "SELECT a FROM Agrupamiento a WHERE a.id = :id"), @NamedQuery(name = "Agrupamiento.findByNombre", query = "SELECT a FROM Agrupamiento a WHERE a.nombre = :nombre")})
public class Agrupamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="id_sequence",strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="id_sequence",sequenceName="agrupamiento_id_sequence")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAgrupamiento", fetch = FetchType.LAZY)
    private List<Tramo> tramoList;

    public Agrupamiento() {
    }

    public Agrupamiento(Integer id) {
        this.id = id;
    }

    public Agrupamiento(Integer id, String nombre) {
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

    public List<Tramo> getTramoList() {
        return tramoList;
    }

    public void setTramoList(List<Tramo> tramoList) {
        this.tramoList = tramoList;
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
        if (!(object instanceof Agrupamiento)) {
            return false;
        }
        Agrupamiento other = (Agrupamiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Agrupamiento[id=" + id + "]";
    }

}
