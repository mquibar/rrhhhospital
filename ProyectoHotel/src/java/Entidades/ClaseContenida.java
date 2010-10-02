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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "ClaseContenida")
@NamedQueries({@NamedQuery(name = "ClaseContenida.findAll", query = "SELECT c FROM ClaseContenida c"), @NamedQuery(name = "ClaseContenida.findByAntiguedadMinima", query = "SELECT c FROM ClaseContenida c WHERE c.antiguedadMinima = :antiguedadMinima"), @NamedQuery(name = "ClaseContenida.findByInicial", query = "SELECT c FROM ClaseContenida c WHERE c.inicial = :inicial"), /*@NamedQuery(name = "ClaseContenida.findByIdClase", query = "SELECT c FROM ClaseContenida c WHERE c.idClase = :idClase"),*/ @NamedQuery(name = "ClaseContenida.findById", query = "SELECT c FROM ClaseContenida c WHERE c.id = :id")})
public class ClaseContenida implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(generator="id_sequence",strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="id_sequence",sequenceName="clasecontenida_id_sequence")
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;


    @Column(name = "AntiguedadMinima")
    private Integer antiguedadMinima;
    @Column(name = "Inicial")
    private Boolean inicial;

    @JoinColumn(name = "idCategoria", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria categoria;

    @JoinColumn(name = "idClase", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clase clase;

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
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase=clase;
    }

    public Integer getId() {
        return id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria=categoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
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
