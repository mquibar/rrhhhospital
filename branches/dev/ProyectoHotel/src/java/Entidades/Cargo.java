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
@Table(name = "Cargo")
@NamedQueries({@NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"), @NamedQuery(name = "Cargo.findById", query = "SELECT c FROM Cargo c WHERE c.id = :id"), @NamedQuery(name = "Cargo.findByNombre", query = "SELECT c FROM Cargo c WHERE c.nombre = :nombre"), @NamedQuery(name = "Cargo.findByFechaVigencia", query = "SELECT c FROM Cargo c WHERE c.fechaVigencia = :fechaVigencia"), @NamedQuery(name = "Cargo.findByVigente", query = "SELECT c FROM Cargo c WHERE c.vigente = :vigente")})
public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id@GeneratedValue(generator="id_sequence",strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="id_sequence",sequenceName="cargo_id_sequence")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "FechaVigencia")
    @Temporal(TemporalType.DATE)
    private Date fechaVigencia;
    @Basic(optional = false)
    @Column(name = "Vigente")
    private boolean vigente;
    @JoinColumn(name = "idEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado idEmpleado;
    @JoinColumn(name = "idPuesto", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PuestoJerarquico idPuesto;

    public Cargo() {
    }

    public Cargo(Integer id) {
        this.id = id;
    }

    public Cargo(Integer id, String nombre, Date fechaVigencia, boolean vigente) {
        this.id = id;
        this.nombre = nombre;
        this.fechaVigencia = fechaVigencia;
        this.vigente = vigente;
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

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public boolean getVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public PuestoJerarquico getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(PuestoJerarquico idPuesto) {
        this.idPuesto = idPuesto;
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
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cargo[id=" + id + "]";
    }

}
