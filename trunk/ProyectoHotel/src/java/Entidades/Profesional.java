/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "Profesional", catalog = "hospital", schema = "public")
@NamedQueries({@NamedQuery(name = "Profesional.findAll", query = "SELECT p FROM Profesional p"), @NamedQuery(name = "Profesional.findByIdProfesional", query = "SELECT p FROM Profesional p WHERE p.idProfesional = :idProfesional"), @NamedQuery(name = "Profesional.findByMatricula", query = "SELECT p FROM Profesional p WHERE p.matricula = :matricula"), @NamedQuery(name = "Profesional.findByTitulo", query = "SELECT p FROM Profesional p WHERE p.titulo = :titulo"), @NamedQuery(name = "Profesional.findByEliminado", query = "SELECT p FROM Profesional p WHERE p.eliminado = :eliminado")})
public class Profesional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idProfesional")
    private Integer idProfesional;
    @Basic(optional = false)
    @Column(name = "Matricula")
    private String matricula;
    @Column(name = "Titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "Eliminado")
    private boolean eliminado;
    @JoinColumn(name = "idProfesional", referencedColumnName = "idEmpleado", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;

    public Profesional() {
    }

    public Profesional(Integer idProfesional) {
        this.idProfesional = idProfesional;
    }

    public Profesional(Integer idProfesional, String matricula, boolean eliminado) {
        this.idProfesional = idProfesional;
        this.matricula = matricula;
        this.eliminado = eliminado;
    }

    public Integer getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Integer idProfesional) {
        this.idProfesional = idProfesional;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesional != null ? idProfesional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesional)) {
            return false;
        }
        Profesional other = (Profesional) object;
        if ((this.idProfesional == null && other.idProfesional != null) || (this.idProfesional != null && !this.idProfesional.equals(other.idProfesional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Profesional[idProfesional=" + idProfesional + "]";
    }

}
