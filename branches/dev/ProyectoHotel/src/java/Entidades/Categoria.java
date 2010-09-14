/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "Categoria", catalog = "hospital", schema = "public")
@NamedQueries({@NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"), @NamedQuery(name = "Categoria.findById", query = "SELECT c FROM Categoria c WHERE c.id = :id"), @NamedQuery(name = "Categoria.findByNombre", query = "SELECT c FROM Categoria c WHERE c.nombre = :nombre"), @NamedQuery(name = "Categoria.findByNumero", query = "SELECT c FROM Categoria c WHERE c.numero = :numero")})
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Numero")
    private Integer numero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria", fetch = FetchType.LAZY)
    private List<ClaseVigente> claseVigenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria", fetch = FetchType.LAZY)
    private List<Requisito> requisitoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria", fetch = FetchType.LAZY)
    private List<ClaseContenida> claseContenidaList;
    @JoinColumn(name = "idTramo", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tramo idTramo;

    public Categoria() {
    }

    public Categoria(Integer id) {
        this.id = id;
    }

    public Categoria(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
        this.nombre = nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<ClaseVigente> getClaseVigenteList() {
        return claseVigenteList;
    }

    public void setClaseVigenteList(List<ClaseVigente> claseVigenteList) {
        this.claseVigenteList = claseVigenteList;
    }

    public List<Requisito> getRequisitoList() {
        return requisitoList;
    }

    public void setRequisitoList(List<Requisito> requisitoList) {
        this.requisitoList = requisitoList;
    }

    public List<ClaseContenida> getClaseContenidaList() {
        return claseContenidaList;
    }

    public void setClaseContenidaList(List<ClaseContenida> claseContenidaList) {
        this.claseContenidaList = claseContenidaList;
    }

    public Tramo getIdTramo() {
        return idTramo;
    }

    public void setIdTramo(Tramo idTramo) {
        this.idTramo = idTramo;
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
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Categoria[id=" + id + "]";
    }

    public void addClase(Clase clase, int antMinima, boolean inicial){
        if(claseContenidaList==null)
            claseContenidaList = new ArrayList<ClaseContenida>();
        ClaseContenida cc = new ClaseContenida();
        cc.setIdClase(clase.getId());
        cc.setAntiguedadMinima(antMinima);
        cc.setInicial(inicial);
        cc.setIdCategoria(this);
        claseContenidaList.add(cc);
        cc= null;
    }

}
