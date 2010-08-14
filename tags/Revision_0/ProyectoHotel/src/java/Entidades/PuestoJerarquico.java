/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.io.Serializable;
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
@Table(name = "PuestoJerarquico", catalog = "hospital", schema = "public")
@NamedQueries({@NamedQuery(name = "PuestoJerarquico.findAll", query = "SELECT p FROM PuestoJerarquico p"), @NamedQuery(name = "PuestoJerarquico.findById", query = "SELECT p FROM PuestoJerarquico p WHERE p.id = :id"), @NamedQuery(name = "PuestoJerarquico.findByNombre", query = "SELECT p FROM PuestoJerarquico p WHERE p.nombre = :nombre")})
public class PuestoJerarquico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @OneToMany(mappedBy = "idPuesto", fetch = FetchType.LAZY)
    private List<PuestoJerarquico> puestoJerarquicoList;
    @JoinColumn(name = "idPuesto", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PuestoJerarquico idPuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPuesto", fetch = FetchType.LAZY)
    private List<Cargo> cargoList;

    public PuestoJerarquico() {
    }

    public PuestoJerarquico(Integer id) {
        this.id = id;
    }

    public PuestoJerarquico(Integer id, String nombre) {
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

    public List<PuestoJerarquico> getPuestoJerarquicoList() {
        return puestoJerarquicoList;
    }

    public void setPuestoJerarquicoList(List<PuestoJerarquico> puestoJerarquicoList) {
        this.puestoJerarquicoList = puestoJerarquicoList;
    }

    public PuestoJerarquico getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(PuestoJerarquico idPuesto) {
        this.idPuesto = idPuesto;
    }

    public List<Cargo> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<Cargo> cargoList) {
        this.cargoList = cargoList;
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
        if (!(object instanceof PuestoJerarquico)) {
            return false;
        }
        PuestoJerarquico other = (PuestoJerarquico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PuestoJerarquico[id=" + id + "]";
    }

}
