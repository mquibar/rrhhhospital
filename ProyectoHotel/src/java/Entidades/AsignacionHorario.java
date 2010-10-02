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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "AsignacionHorario")
@NamedQueries({@NamedQuery(name = "AsignacionHorario.findAll", query = "SELECT a FROM AsignacionHorario a"), @NamedQuery(name = "AsignacionHorario.findById", query = "SELECT a FROM AsignacionHorario a WHERE a.id = :id"), @NamedQuery(name = "AsignacionHorario.findByFecha", query = "SELECT a FROM AsignacionHorario a WHERE a.fecha = :fecha"), @NamedQuery(name = "AsignacionHorario.findByDescripcion", query = "SELECT a FROM AsignacionHorario a WHERE a.descripcion = :descripcion"), @NamedQuery(name = "AsignacionHorario.findByVigente", query = "SELECT a FROM AsignacionHorario a WHERE a.vigente = :vigente")})
public class AsignacionHorario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "Vigente")
    private boolean vigente;
    @JoinColumn(name = "idEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado idEmpleado;
    @JoinColumn(name = "idTipoHorario", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoHorario idTipoHorario;

    public AsignacionHorario() {
    }

    public AsignacionHorario(Integer id) {
        this.id = id;
    }

    public AsignacionHorario(Integer id, boolean vigente) {
        this.id = id;
        this.vigente = vigente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public TipoHorario getIdTipoHorario() {
        return idTipoHorario;
    }

    public void setIdTipoHorario(TipoHorario idTipoHorario) {
        this.idTipoHorario = idTipoHorario;
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
        if (!(object instanceof AsignacionHorario)) {
            return false;
        }
        AsignacionHorario other = (AsignacionHorario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.AsignacionHorario[id=" + id + "]";
    }

}
