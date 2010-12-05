/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "TipoHorario")
@NamedQueries({
    @NamedQuery(name = "TipoHorario.findAll", query = "SELECT t FROM TipoHorario t WHERE t.eliminado = false"),
    @NamedQuery(name = "TipoHorario.findById", query = "SELECT t FROM TipoHorario t WHERE t.id = :id")
})
public class TipoHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "tipohorario_id_sequence",initialValue=1)
    @Id
//    @GeneratedValue(generator="id_sequence", strategy=GenerationType.SEQUENCE)
//    @SequenceGenerator(name="id_sequence",sequenceName="tipoHorario_id_sequence")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "HoraIngreso")
    @Temporal(TemporalType.TIME)
    private Date horaIngreso;
    @Basic(optional = false)
    @Column(name = "HoraSalida")
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Eliminado")
    private Boolean eliminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoHorario", fetch = FetchType.LAZY)
    private List<AsignacionHorario> asignacionHorarioList;

    public TipoHorario() {
    }

    public TipoHorario(Integer id) {
        this.id = id;
    }

    public TipoHorario(Integer id, String nombre, Date horaIngreso, Date horaSalida) {
        this.id = id;
        this.nombre = nombre;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
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
        this.nombre = nombre.toUpperCase();
    }

    public Date getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(Date horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.toUpperCase();
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
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
        if (!(object instanceof TipoHorario)) {
            return false;
        }
        TipoHorario other = (TipoHorario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TipoHorario[id=" + id + "]" + "\n"
                + "Nombre: " + nombre + "\n"
                + "Descripcion: " + descripcion + "\n"
                + "Hora Ingreso: " + horaIngreso + "\n"
                + "Hora Salida: " + horaSalida;
    }
}
