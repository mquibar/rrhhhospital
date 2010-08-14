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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "TipoEmpleado", catalog = "hospital", schema = "public")
@NamedQueries({@NamedQuery(name = "TipoEmpleado.findAll", query = "SELECT t FROM TipoEmpleado t"), @NamedQuery(name = "TipoEmpleado.findById", query = "SELECT t FROM TipoEmpleado t WHERE t.id = :id"), @NamedQuery(name = "TipoEmpleado.findByNombre", query = "SELECT t FROM TipoEmpleado t WHERE t.nombre = :nombre"), @NamedQuery(name = "TipoEmpleado.findByCodigo", query = "SELECT t FROM TipoEmpleado t WHERE t.codigo = :codigo")})
public class TipoEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="id_sequence")
    @SequenceGenerator(name="id_sequence",sequenceName="tipoempleado_id_sequence")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Codigo")
    private String codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEmpleado", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList;
    @ManyToMany(fetch=FetchType.EAGER,mappedBy="tipoEmpleadoList")
    private List<TipoLicencia> tipolicenciaList;

    public TipoEmpleado() {
    }

    public TipoEmpleado(Integer id) {
        this.id = id;
    }

    public TipoEmpleado(Integer id, String nombre) {
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
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
        if (!(object instanceof TipoEmpleado)) {
            return false;
        }
        TipoEmpleado other = (TipoEmpleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TipoEmpleado[id=" + id + "]";
    }

    /**
     * @return the tipolicenciaList
     */
    public List<TipoLicencia> getTipolicenciaList() {
        return tipolicenciaList;
    }

    /**
     * @param tipolicenciaList the tipolicenciaList to set
     */
    public void setTipolicenciaList(List<TipoLicencia> tipolicenciaList) {
        this.tipolicenciaList = tipolicenciaList;
    }

}
