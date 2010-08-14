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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "ClaseContenida", catalog = "hospital", schema = "public")
@NamedQueries({@NamedQuery(name = "ClaseContenida.findAll", query = "SELECT c FROM ClaseContenida c"), @NamedQuery(name = "ClaseContenida.findByAntiguedadMinima", query = "SELECT c FROM ClaseContenida c WHERE c.antiguedadMinima = :antiguedadMinima"), @NamedQuery(name = "ClaseContenida.findByInicial", query = "SELECT c FROM ClaseContenida c WHERE c.inicial = :inicial"), @NamedQuery(name = "ClaseContenida.findByIdClase", query = "SELECT c FROM ClaseContenida c WHERE c.idClase = :idClase"), @NamedQuery(name = "ClaseContenida.findById", query = "SELECT c FROM ClaseContenida c WHERE c.id = :id")})
public class ClaseContenida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AntiguedadMinima")
    private Integer antiguedadMinima;
    @Column(name = "Inicial")
    private Boolean inicial;
    @Basic(optional = false)
    @Column(name = "idClase")
    private int idClase;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "idCategoria", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria idCategoria;

    public ClaseContenida() {
    }

    public ClaseContenida(Integer id) {
        this.id = id;
    }

    public ClaseContenida(Integer id, int idClase) {
        this.id = id;
        this.idClase = idClase;
    }

    public Integer getAntiguedadMinima() {
        return antiguedadMinima;
    }

    public void setAntiguedadMinima(Integer antiguedadMinima) {
        this.antiguedadMinima = antiguedadMinima;
    }

    public Boolean getInicial() {
        return inicial;
    }

    public void setInicial(Boolean inicial) {
        this.inicial = inicial;
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
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
        if (!(object instanceof ClaseContenida)) {
            return false;
        }
        ClaseContenida other = (ClaseContenida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ClaseContenida[id=" + id + "]";
    }

}
