/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Manuel
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "Persona")
@NamedQueries({@NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
@NamedQuery(name = "Persona.findById", query = "SELECT p FROM Persona p WHERE p.id = :id"),
@NamedQuery(name = "Persona.findByApellido", query = "SELECT p FROM Persona p WHERE p.apellido = :apellido"),
@NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
@NamedQuery(name = "Persona.findByDni", query = "SELECT p FROM Persona p WHERE p.dni = :dni"),
@NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento"),
@NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono")})
public abstract class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_sequence")
    @SequenceGenerator(name="id_sequence",sequenceName="persona_id_sequence")
    @Basic(optional = false)
    @Column(name = "id",nullable=false)
    protected Integer id;
    @Basic(optional = false)
    @Column(name = "Apellido")
    protected String apellido;
    @Column(name = "Nombre")
    protected String nombre;
    @Basic(optional = false)
    @Column(name = "DNI")
    protected String dni;
    @Column(name = "FechaNacimiento")
    @Temporal(TemporalType.DATE)
    protected Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "Telefono")
    protected long telefono;
    @JoinColumn(name = "idDomicilio", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    protected Domicilio idDomicilio;
    @JoinColumn(name = "idPais", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    protected Pais idPais;
    @JoinColumn(name = "idSexo", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    protected Sexo idSexo;

    public Persona() {
    }

    public Persona(Integer id) {
        this.id = id;
    }

    public Persona(Integer id, String apellido, String dni, long telefono) {
        this.id = id;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Domicilio getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Domicilio idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
    }

    public Sexo getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Sexo idSexo) {
        this.idSexo = idSexo;
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Persona[id=" + id + "]";
    }

}
