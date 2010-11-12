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
@Table(name = "Sexo")
@NamedQueries({@NamedQuery(name = "Sexo.findAll", query = "SELECT s FROM Sexo s"),
@NamedQuery(name = "Sexo.findById", query = "SELECT s FROM Sexo s WHERE s.id = :id"),
@NamedQuery(name = "Sexo.findBySexo", query = "SELECT s FROM Sexo s WHERE s.sexo = :sexo")})
public class Sexo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="id_sequence",strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="id_sequence",sequenceName="sexo_id_sequence")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Sexo")
    private String sexo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSexo", fetch = FetchType.LAZY)
    private List<Persona> personaList;

    public Sexo() {
    }

    public Sexo(Integer id) {
        this.id = id;
    }

    public Sexo(Integer id, String sexo) {
        this.id = id;
        this.sexo = sexo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
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
        if (!(object instanceof Sexo)) {
            return false;
        }
        Sexo other = (Sexo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Sexo[id=" + id + "]";
    }

}
