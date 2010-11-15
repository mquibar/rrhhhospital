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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Domicilio")
@NamedQueries({@NamedQuery(name = "Domicilio.findAll", query = "SELECT d FROM Domicilio d"),
@NamedQuery(name = "Domicilio.findById", query = "SELECT d FROM Domicilio d WHERE d.id = :id"),
@NamedQuery(name = "Domicilio.findByBarrio", query = "SELECT d FROM Domicilio d WHERE d.barrio = :barrio"),
@NamedQuery(name = "Domicilio.findByCalle", query = "SELECT d FROM Domicilio d WHERE d.calle = :calle"),
@NamedQuery(name = "Domicilio.findByNumero", query = "SELECT d FROM Domicilio d WHERE d.numero = :numero"),
@NamedQuery(name = "Domicilio.findByPiso", query = "SELECT d FROM Domicilio d WHERE d.piso = :piso"),
@NamedQuery(name = "Domicilio.findByDepartamento", query = "SELECT d FROM Domicilio d WHERE d.departamento = :departamento")})
public class Domicilio implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(generator="id_sequence",strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="id_sequence",sequenceName="domicilio_id_sequence")
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Barrio")
    private String barrio;
    @Column(name = "Calle")
    private String calle;
    @Column(name = "Numero")
    private Integer numero;
    @Column(name = "Piso")
    private String piso;
    @Column(name = "Departamento")
    private String departamento;
    @JoinColumn(name = "IdLocalidad", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Localidad idLocalidad;
    @JoinColumn(name = "IdProvincia", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Provincia idProvincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDomicilio", fetch = FetchType.LAZY)
    private List<Persona> personaList;

    public Domicilio() {
    }

    public Domicilio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Localidad getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Localidad idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public Provincia getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Provincia idProvincia) {
        this.idProvincia = idProvincia;
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
        if (!(object instanceof Domicilio)) {
            return false;
        }
        Domicilio other = (Domicilio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Domicilio[id=" + id + "]";
    }

}
