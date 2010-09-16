/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "Profesional", catalog = "hospital", schema = "public")
@PrimaryKeyJoinColumn(name="idProfesional",referencedColumnName="idEmpleado")
@NamedQueries({@NamedQuery(name = "Profesional.findAll", query = "SELECT p FROM Profesional p"), @NamedQuery(name = "Profesional.findByMatricula", query = "SELECT p FROM Profesional p WHERE p.matricula = :matricula"), @NamedQuery(name = "Profesional.findByTitulo", query = "SELECT p FROM Profesional p WHERE p.titulo = :titulo"), @NamedQuery(name = "Profesional.findByEliminado", query = "SELECT p FROM Profesional p WHERE p.eliminado = :eliminado")})
public class Profesional extends Empleado {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Matricula")
    private String matricula;
    @Column(name = "Titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "Eliminado")
    private boolean profesionalEliminado;

    public Profesional() {
    }

    public Profesional(Integer idProfesional) {
        super(idProfesional);
    }

    public Profesional(Integer idProfesional, String matricula, boolean eliminado) {
        super(idProfesional);
        this.matricula = matricula;
        this.profesionalEliminado = eliminado;
    }

    public Integer getIdProfesional() {
        return id;
    }

    public void setIdProfesional(Integer idProfesional) {
        id = idProfesional;
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

    public boolean getProfesionalEliminado() {
        return profesionalEliminado;
    }

    public void setProfesionalEliminado(boolean eliminado) {
        this.profesionalEliminado = eliminado;
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
        if (!(object instanceof Profesional)) {
            return false;
        }
        Profesional other = (Profesional) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Profesional[idProfesional=" + id + "]";
    }

}
