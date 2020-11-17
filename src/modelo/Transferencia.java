/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "transferencia", catalog = "cajeroautomatico", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transferencia.findAll", query = "SELECT t FROM Transferencia t")
    , @NamedQuery(name = "Transferencia.findByIdtransferencia", query = "SELECT t FROM Transferencia t WHERE t.idtransferencia = :idtransferencia")
    , @NamedQuery(name = "Transferencia.findByFecha", query = "SELECT t FROM Transferencia t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "Transferencia.findByMonto", query = "SELECT t FROM Transferencia t WHERE t.monto = :monto")
    , @NamedQuery(name = "Transferencia.findByDetalle", query = "SELECT t FROM Transferencia t WHERE t.detalle = :detalle")})
public class Transferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtransferencia")
    private Integer idtransferencia;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Double monto;
    @Column(name = "detalle")
    private String detalle;
    @JoinColumn(name = "idcuenta", referencedColumnName = "idcuenta")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cuenta idcuenta;
    @OneToMany(mappedBy = "idtransferencia", fetch = FetchType.LAZY)
    private List<Destinatarios> destinatariosList;

    public Transferencia() {
    }

    public Transferencia(Integer idtransferencia) {
        this.idtransferencia = idtransferencia;
    }

    public Integer getIdtransferencia() {
        return idtransferencia;
    }

    public void setIdtransferencia(Integer idtransferencia) {
        this.idtransferencia = idtransferencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Cuenta getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Cuenta idcuenta) {
        this.idcuenta = idcuenta;
    }

    @XmlTransient
    public List<Destinatarios> getDestinatariosList() {
        return destinatariosList;
    }

    public void setDestinatariosList(List<Destinatarios> destinatariosList) {
        this.destinatariosList = destinatariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransferencia != null ? idtransferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transferencia)) {
            return false;
        }
        Transferencia other = (Transferencia) object;
        if ((this.idtransferencia == null && other.idtransferencia != null) || (this.idtransferencia != null && !this.idtransferencia.equals(other.idtransferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Transferencia[ idtransferencia=" + idtransferencia + " ]";
    }
    
}
