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
@Table(name = "RegistroReloj")
@NamedQueries({@NamedQuery(name = "RegistroReloj.findAll", query = "SELECT r FROM RegistroReloj r"), @NamedQuery(name = "RegistroReloj.findById", query = "SELECT r FROM RegistroReloj r WHERE r.id = :id"), @NamedQuery(name = "RegistroReloj.findByFecha", query = "SELECT r FROM RegistroReloj r WHERE r.fecha = :fecha"), @NamedQuery(name = "RegistroReloj.findByHora", query = "SELECT r FROM RegistroReloj r WHERE r.hora = :hora"), @NamedQuery(name = "RegistroReloj.findByNumero", query = "SELECT r FROM RegistroReloj r WHERE r.numero = :numero"), @NamedQuery(name = "RegistroReloj.findByIdEmpleado", query = "SELECT r FROM RegistroReloj r WHERE r.idEmpleado = :idEmpleado"), @NamedQuery(name = "RegistroReloj.findByEliminado", query = "SELECT r FROM RegistroReloj r WHERE r.eliminado = :eliminado")})
public class RegistroReloj implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="id_sequence",strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="id_sequence",sequenceName="registro_reloj_id_sequence")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "Hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Basic(optional = false)
    @Column(name = "Numero")
    private long numero;
    @Basic(optional = false)
    @Column(name = "idEmpleado")
    private int idEmpleado;
    @Basic(optional = false)
    @Column(name = "Eliminado")
    private boolean eliminado;
    @JoinColumn(name = "idTipoRegistro", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoRegistro idTipoRegistro;

    public RegistroReloj() {
    }

    public RegistroReloj(Integer id) {
        this.id = id;
    }

    public RegistroReloj(Integer id, Date fecha, Date hora, long numero, int idEmpleado, boolean eliminado) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.numero = numero;
        this.idEmpleado = idEmpleado;
        this.eliminado = eliminado;
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

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public TipoRegistro getIdTipoRegistro() {
        return idTipoRegistro;
    }

    public void setIdTipoRegistro(TipoRegistro idTipoRegistro) {
        this.idTipoRegistro = idTipoRegistro;
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
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.RegistroReloj[id=" + id + "]";
    }

}
