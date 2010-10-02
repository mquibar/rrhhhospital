/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "Empleado")
@PrimaryKeyJoinColumn(name="idEmpleado",referencedColumnName="id")
@NamedQueries({@NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"), @NamedQuery(name = "Empleado.findByCuil", query = "SELECT e FROM Empleado e WHERE e.cuil = :cuil"), @NamedQuery(name = "Empleado.findByFechaIngreso", query = "SELECT e FROM Empleado e WHERE e.fechaIngreso = :fechaIngreso"), @NamedQuery(name = "Empleado.findByLegajo", query = "SELECT e FROM Empleado e WHERE e.legajo = :legajo"), @NamedQuery(name = "Empleado.findByEliminado", query = "SELECT e FROM Empleado e WHERE e.eliminado = :eliminado")})
public class Empleado extends Persona{
    private static final long serialVersionUID = 1L;
    @Column(name = "Cuil")
    protected String cuil;
    @Column(name = "FechaIngreso")
    @Temporal(TemporalType.DATE)
    protected Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "Legajo")
    protected int legajo;
    @Column(name = "Eliminado")
    protected Boolean eliminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado", fetch = FetchType.LAZY)
    protected List<ClaseVigente> claseVigenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado", fetch = FetchType.LAZY)
    protected List<Cargo> cargoList;
    @JoinColumn(name = "idTarjeta", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    protected Tarjeta idTarjeta;
    @JoinColumn(name = "idTipoEmpleado", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    protected TipoEmpleado idTipoEmpleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado", fetch = FetchType.LAZY)
    protected List<Licencia> licenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado", fetch = FetchType.LAZY)
    protected List<AsignacionHorario> asignacionHorarioList;


    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        super(idEmpleado);
    }

    public Empleado(Integer idEmpleado, int legajo) {
        super(idEmpleado);
        this.legajo = legajo;
    }

    public Integer getIdEmpleado() {
        return id;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        id = idEmpleado;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public List<ClaseVigente> getClaseVigenteList() {
        return claseVigenteList;
    }

    public void setClaseVigenteList(List<ClaseVigente> claseVigenteList) {
        this.claseVigenteList = claseVigenteList;
    }

    public List<Cargo> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<Cargo> cargoList) {
        this.cargoList = cargoList;
    }

    public Tarjeta getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Tarjeta idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public TipoEmpleado getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(TipoEmpleado idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    public List<Licencia> getLicenciaList() {
        return licenciaList;
    }

    public void setLicenciaList(List<Licencia> licenciaList) {
        this.licenciaList = licenciaList;
    }

    public List<AsignacionHorario> getAsignacionHorarioList() {
        return asignacionHorarioList;
    }

    public void setAsignacionHorarioList(List<AsignacionHorario> asignacionHorarioList) {
        this.asignacionHorarioList = asignacionHorarioList;
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((id == null && other.id != null) || (id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Empleado[idEmpleado=" + id + "]";
    }

}
