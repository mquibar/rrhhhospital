/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "ClaseContenida", catalog = "hospital", schema = "public")
@NamedQueries({@NamedQuery(name = "ClaseContenida.findAll", query = "SELECT c FROM ClaseContenida c"), @NamedQuery(name = "ClaseContenida.findByAntiguedadMinima", query = "SELECT c FROM ClaseContenida c WHERE c.antiguedadMinima = :antiguedadMinima"), @NamedQuery(name = "ClaseContenida.findByInicial", query = "SELECT c FROM ClaseContenida c WHERE c.inicial = :inicial"), /*@NamedQuery(name = "ClaseContenida.findByIdClase", query = "SELECT c FROM ClaseContenida c WHERE c.idClase = :idClase"),*/ @NamedQuery(name = "ClaseContenida.findById", query = "SELECT c FROM ClaseContenida c WHERE c.id = :id")})
public class ClaseContenida implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private ClaseContenidaPk claseContenidaPk;
    @Column(name = "AntiguedadMinima")
    private Integer antiguedadMinima;
    @Column(name = "Inicial")
    private Boolean inicial;

    public ClaseContenida() {
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

    public Clase getClase() {
        return claseContenidaPk.getIdClase();
    }

    public void setClase(Clase clase) {
        if(claseContenidaPk == null)
            claseContenidaPk = new ClaseContenidaPk();
        claseContenidaPk.setIdClase(clase);
    }

    public Integer getId() {
        return claseContenidaPk.hashCode();
    }

    public Categoria getCategoria() {
        return claseContenidaPk.getIdCategoria();
    }

    public void setCategoria(Categoria categoria) {
        claseContenidaPk.setIdCategoria(categoria);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += claseContenidaPk.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClaseContenida other = (ClaseContenida) obj;
        if (this.claseContenidaPk != other.claseContenidaPk && (this.claseContenidaPk == null || !this.claseContenidaPk.equals(other.claseContenidaPk))) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "Entidades.ClaseContenida[id=" + claseContenidaPk.hashCode() + "]";
    }

}
