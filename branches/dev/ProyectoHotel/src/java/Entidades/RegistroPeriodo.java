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
 * @author Leo
 */
@Entity
@Table(name = "RegistroPeriodo")
@NamedQueries({
    @NamedQuery(name = "RegistroPeriodo.findAll", query = "SELECT r FROM RegistroPeriodo r WHERE r.eliminado = false")})
public class RegistroPeriodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="id_sequence",strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="id_sequence",sequenceName="registro_periodo_id_sequence")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "FechaEntrada")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;

    @Basic(optional = false)
    @Column(name = "HoraEntrada")
    @Temporal(TemporalType.TIME)
    private Date horaEntrada;

    @Basic(optional = false)
    @Column(name = "FechaSalida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;

    @Basic(optional = false)
    @Column(name = "HoraSalida")
    @Temporal(TemporalType.TIME)
    private Date horaSalida;

    @JoinColumn(name = "idEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado idEmpleado;

    @Basic(optional = false)
    @Column(name = "Eliminado")
    private boolean eliminado;

     public RegistroPeriodo() {
    }

    public RegistroPeriodo(Integer id) {
        this.id = id;
    }

    public RegistroPeriodo(
            Integer id,
            Date fechaEntrada,
            Date horaEntrada,
            Date fechaSalida, 
            Date horaSalida, 
            Empleado idEmpleado,
            boolean eliminado
            ) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.horaEntrada = horaEntrada;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.idEmpleado = idEmpleado;
        this.eliminado = eliminado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fecha) {
        this.fechaEntrada = fecha;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date hora) {
        this.horaEntrada = hora;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fecha) {
        this.fechaSalida = fecha;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date hora) {
        this.horaSalida = hora;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
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
        if (!(object instanceof RegistroReloj)) {
            return false;
        }
        RegistroReloj other = (RegistroReloj) object;
        if ((this.id == null && other.getId() != null) ||
                (this.id != null && !this.id.equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.RegistroReloj[id=" + id + "]";
    }

}
