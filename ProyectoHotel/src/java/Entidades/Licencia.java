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
@Table(name = "Licencia")
@NamedQueries({@NamedQuery(name = "Licencia.findAll", query = "SELECT l FROM Licencia l"), @NamedQuery(name = "Licencia.findById", query = "SELECT l FROM Licencia l WHERE l.id = :id"), @NamedQuery(name = "Licencia.findByFechaInicio", query = "SELECT l FROM Licencia l WHERE l.fechaInicio = :fechaInicio"), @NamedQuery(name = "Licencia.findByFechaFin", query = "SELECT l FROM Licencia l WHERE l.fechaFin = :fechaFin"), @NamedQuery(name = "Licencia.findByMotivo", query = "SELECT l FROM Licencia l WHERE l.motivo = :motivo"), @NamedQuery(name = "Licencia.findByEliminada", query = "SELECT l FROM Licencia l WHERE l.eliminada = :eliminada"), @NamedQuery(name = "Licencia.findByIdTipoLicencia", query = "SELECT l FROM Licencia l WHERE l.idTipoLicencia = :idTipoLicencia")})
public class Licencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(generator="id_sequence",strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="id_sequence",sequenceName="licencia_id_sequence")
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "FechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "FechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "Motivo")
    private String motivo;
    @Column(name = "Eliminada")
    private Boolean eliminada;
    @Basic(optional = false)
    @Column(name = "idTipoLicencia")
    private int idTipoLicencia;
    @JoinColumn(name = "idEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado idEmpleado;

    public Licencia() {
    }

    public Licencia(Integer id) {
        this.id = id;
    }

    public Licencia(Integer id, Date fechaInicio, Date fechaFin, int idTipoLicencia) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idTipoLicencia = idTipoLicencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Boolean getEliminada() {
        return eliminada;
    }

    public void setEliminada(Boolean eliminada) {
        this.eliminada = eliminada;
    }

    public int getIdTipoLicencia() {
        return idTipoLicencia;
    }

    public void setIdTipoLicencia(int idTipoLicencia) {
        this.idTipoLicencia = idTipoLicencia;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
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
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Licencia[id=" + id + "]";
    }

}
