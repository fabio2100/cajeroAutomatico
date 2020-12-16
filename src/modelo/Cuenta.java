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
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")
    , @NamedQuery(name = "Cuenta.findByIdcuenta", query = "SELECT c FROM Cuenta c WHERE c.idcuenta = :idcuenta")
    , @NamedQuery(name = "Cuenta.findByNrodecuenta", query = "SELECT c FROM Cuenta c WHERE c.nrodecuenta = :nrodecuenta")
    , @NamedQuery(name = "Cuenta.findBySaldo", query = "SELECT c FROM Cuenta c WHERE c.saldo = :saldo")
    , @NamedQuery(name = "Cuenta.findByFechaalta", query = "SELECT c FROM Cuenta c WHERE c.fechaalta = :fechaalta")
    , @NamedQuery(name = "Cuenta.findByUsuarioalta", query = "SELECT c FROM Cuenta c WHERE c.usuarioalta = :usuarioalta")
    , @NamedQuery(name = "Cuenta.findByFechamodificacion", query = "SELECT c FROM Cuenta c WHERE c.fechamodificacion = :fechamodificacion")
    , @NamedQuery(name = "Cuenta.findByUsuariomodificacion", query = "SELECT c FROM Cuenta c WHERE c.usuariomodificacion = :usuariomodificacion")
    , @NamedQuery(name = "Cuenta.findByFechabaja", query = "SELECT c FROM Cuenta c WHERE c.fechabaja = :fechabaja")
    , @NamedQuery(name = "Cuenta.findByUsuariobaja", query = "SELECT c FROM Cuenta c WHERE c.usuariobaja = :usuariobaja")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuenta")
    private Integer idcuenta;
    @Column(name = "nrodecuenta")
    private String nrodecuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private Double saldo;
    @Column(name = "fechaalta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaalta;
    @Column(name = "usuarioalta")
    private Integer usuarioalta;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Column(name = "usuariomodificacion")
    private Integer usuariomodificacion;
    @Column(name = "fechabaja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechabaja;
    @Column(name = "usuariobaja")
    private Integer usuariobaja;
    @OneToMany(mappedBy = "idcuenta", fetch = FetchType.LAZY)
    private List<Transferencia> transferenciaList;
    @OneToMany(mappedBy = "idcuenta", fetch = FetchType.LAZY)
    private List<Prestamo> prestamoList;
    @OneToMany(mappedBy = "idcuenta", fetch = FetchType.LAZY)
    private List<Movimiento> movimientoList;
    @JoinColumn(name = "idbanco", referencedColumnName = "idbanco")
    @ManyToOne(fetch = FetchType.LAZY)
    private Banco idbanco;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario idusuario;
    @OneToMany(mappedBy = "idcuenta", fetch = FetchType.LAZY)
    private List<Pago> pagoList;

    public Cuenta() {
    }

    public Cuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public Integer getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getNrodecuenta() {
        return nrodecuenta;
    }

    public void setNrodecuenta(String nrodecuenta) {
        this.nrodecuenta = nrodecuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public Integer getUsuarioalta() {
        return usuarioalta;
    }

    public void setUsuarioalta(Integer usuarioalta) {
        this.usuarioalta = usuarioalta;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public Integer getUsuariomodificacion() {
        return usuariomodificacion;
    }

    public void setUsuariomodificacion(Integer usuariomodificacion) {
        this.usuariomodificacion = usuariomodificacion;
    }

    public Date getFechabaja() {
        return fechabaja;
    }

    public void setFechabaja(Date fechabaja) {
        this.fechabaja = fechabaja;
    }

    public Integer getUsuariobaja() {
        return usuariobaja;
    }

    public void setUsuariobaja(Integer usuariobaja) {
        this.usuariobaja = usuariobaja;
    }

    @XmlTransient
    public List<Transferencia> getTransferenciaList() {
        return transferenciaList;
    }

    public void setTransferenciaList(List<Transferencia> transferenciaList) {
        this.transferenciaList = transferenciaList;
    }

    @XmlTransient
    public List<Prestamo> getPrestamoList() {
        return prestamoList;
    }

    public void setPrestamoList(List<Prestamo> prestamoList) {
        this.prestamoList = prestamoList;
    }

    @XmlTransient
    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }

    public Banco getIdbanco() {
        return idbanco;
    }

    public void setIdbanco(Banco idbanco) {
        this.idbanco = idbanco;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @XmlTransient
    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuenta != null ? idcuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.idcuenta == null && other.idcuenta != null) || (this.idcuenta != null && !this.idcuenta.equals(other.idcuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cuenta[ idcuenta=" + idcuenta + " ]";
    }
    
}
