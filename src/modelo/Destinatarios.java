/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "destinatarios", catalog = "cajeroautomatico", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destinatarios.findAll", query = "SELECT d FROM Destinatarios d")
    , @NamedQuery(name = "Destinatarios.findByIddestinatarios", query = "SELECT d FROM Destinatarios d WHERE d.iddestinatarios = :iddestinatarios")
    , @NamedQuery(name = "Destinatarios.findByCbu", query = "SELECT d FROM Destinatarios d WHERE d.cbu = :cbu")
    , @NamedQuery(name = "Destinatarios.findByPersona", query = "SELECT d FROM Destinatarios d WHERE d.persona = :persona")
    , @NamedQuery(name = "Destinatarios.findByCorreo", query = "SELECT d FROM Destinatarios d WHERE d.correo = :correo")
    , @NamedQuery(name = "Destinatarios.findByNombreUsuario", query = "SELECT d FROM Destinatarios d WHERE d.nombreUsuario = :nombreUsuario")})
public class Destinatarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddestinatarios")
    private Integer iddestinatarios;
    @Column(name = "cbu")
    private String cbu;
    @Column(name = "persona")
    private String persona;
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @JoinColumn(name = "idtransferencia", referencedColumnName = "idtransferencia")
    @ManyToOne(fetch = FetchType.LAZY)
    private Transferencia idtransferencia;

    public Destinatarios() {
    }

    public Destinatarios(Integer iddestinatarios) {
        this.iddestinatarios = iddestinatarios;
    }

    public Destinatarios(Integer iddestinatarios, String nombreUsuario) {
        this.iddestinatarios = iddestinatarios;
        this.nombreUsuario = nombreUsuario;
    }

    public Integer getIddestinatarios() {
        return iddestinatarios;
    }

    public void setIddestinatarios(Integer iddestinatarios) {
        this.iddestinatarios = iddestinatarios;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Transferencia getIdtransferencia() {
        return idtransferencia;
    }

    public void setIdtransferencia(Transferencia idtransferencia) {
        this.idtransferencia = idtransferencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddestinatarios != null ? iddestinatarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destinatarios)) {
            return false;
        }
        Destinatarios other = (Destinatarios) object;
        if ((this.iddestinatarios == null && other.iddestinatarios != null) || (this.iddestinatarios != null && !this.iddestinatarios.equals(other.iddestinatarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Destinatarios[ iddestinatarios=" + iddestinatarios + " ]";
    }
    
}
