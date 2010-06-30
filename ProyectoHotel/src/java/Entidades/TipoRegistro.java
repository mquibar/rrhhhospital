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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "TipoRegistro", catalog = "hospital", schema = "public")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({@NamedQuery(name = "TipoRegistro.findAll", query = "SELECT t FROM TipoRegistro t"), @NamedQuery(name = "TipoRegistro.findById", query = "SELECT t FROM TipoRegistro t WHERE t.id = :id"), @NamedQuery(name = "TipoRegistro.findByDtype", query = "SELECT t FROM TipoRegistro t WHERE t.dtype = :dtype")})
public class TipoRegistro implements Serializable {
    protected static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    protected Integer id;
    @Basic(optional = false)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoRegistro", fetch = FetchType.LAZY)
    protected List<RegistroReloj> registroRelojList;

    public TipoRegistro() {
    }

    public TipoRegistro(Integer id) {
        this.id = id;
    }

    public TipoRegistro(Integer id, String dtype) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<RegistroReloj> getRegistroRelojList() {
        return registroRelojList;
    }

    public void setRegistroRelojList(List<RegistroReloj> registroRelojList) {
        this.registroRelojList = registroRelojList;
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
        if (!(object instanceof TipoRegistro)) {
            return false;
        }
        TipoRegistro other = (TipoRegistro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TipoRegistro[id=" + id + "]";
    }

}
