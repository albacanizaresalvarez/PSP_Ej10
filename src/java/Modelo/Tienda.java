/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author albit
 */
@Entity
@Table(name = "TIENDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tienda.findAll", query = "SELECT t FROM Tienda t")
    , @NamedQuery(name = "Tienda.findByIdtienda", query = "SELECT t FROM Tienda t WHERE t.idtienda = :idtienda")
    , @NamedQuery(name = "Tienda.findByNomtienda", query = "SELECT t FROM Tienda t WHERE t.nomtienda = :nomtienda")
    , @NamedQuery(name = "Tienda.findByFechaApertura", query = "SELECT t FROM Tienda t WHERE t.fechaApertura = :fechaApertura")
    , @NamedQuery(name = "Tienda.findByMunicipio", query = "SELECT t FROM Tienda t WHERE t.municipio = :municipio")
    , @NamedQuery(name = "Tienda.findByStocktotal", query = "SELECT t FROM Tienda t WHERE t.stocktotal = :stocktotal")
    , @NamedQuery(name = "Tienda.findByContrasena", query = "SELECT t FROM Tienda t WHERE t.contrasena = :contrasena")
    , @NamedQuery(name = "Tienda.findByFototienda", query = "SELECT t FROM Tienda t WHERE t.fototienda = :fototienda")})
public class Tienda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIENDA")
    private Integer idtienda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NOMTIENDA")
    private String nomtienda;
    @Column(name = "FECHA_APERTURA")
    @Temporal(TemporalType.DATE)
    private Date fechaApertura;
    @Size(max = 25)
    @Column(name = "MUNICIPIO")
    private String municipio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "STOCKTOTAL")
    private BigDecimal stocktotal;
    @Size(max = 25)
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Size(max = 50)
    @Column(name = "FOTOTIENDA")
    private String fototienda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtienda")
    private Collection<Articulos> articulosCollection;

    public Tienda() {
    }

    public Tienda(Integer idtienda) {
        this.idtienda = idtienda;
    }

    public Tienda(Integer idtienda, String nomtienda) {
        this.idtienda = idtienda;
        this.nomtienda = nomtienda;
    }

    public Integer getIdtienda() {
        return idtienda;
    }

    public void setIdtienda(Integer idtienda) {
        this.idtienda = idtienda;
    }

    public String getNomtienda() {
        return nomtienda;
    }

    public void setNomtienda(String nomtienda) {
        this.nomtienda = nomtienda;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public BigDecimal getStocktotal() {
        return stocktotal;
    }

    public void setStocktotal(BigDecimal stocktotal) {
        this.stocktotal = stocktotal;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFototienda() {
        return fototienda;
    }

    public void setFototienda(String fototienda) {
        this.fototienda = fototienda;
    }

    @XmlTransient
    public Collection<Articulos> getArticulosCollection() {
        return articulosCollection;
    }

    public void setArticulosCollection(Collection<Articulos> articulosCollection) {
        this.articulosCollection = articulosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtienda != null ? idtienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tienda)) {
            return false;
        }
        Tienda other = (Tienda) object;
        if ((this.idtienda == null && other.idtienda != null) || (this.idtienda != null && !this.idtienda.equals(other.idtienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Tienda[ idtienda=" + idtienda + " ]";
    }
    
}
