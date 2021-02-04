/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author " "
 */
@Entity
@Table(name = "UBICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicacion.findAll", query = "SELECT u FROM Ubicacion u")
    , @NamedQuery(name = "Ubicacion.findByFkcorreoe", query = "SELECT u FROM Ubicacion u WHERE u.fkcorreoe = :fkcorreoe")
    , @NamedQuery(name = "Ubicacion.findByLatitud", query = "SELECT u FROM Ubicacion u WHERE u.latitud = :latitud")
    , @NamedQuery(name = "Ubicacion.findByLongitud", query = "SELECT u FROM Ubicacion u WHERE u.longitud = :longitud")})
public class Ubicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FKCORREOE")
    private String fkcorreoe;
    @Size(max = 25)
    @Column(name = "LATITUD")
    private String latitud;
    @Size(max = 25)
    @Column(name = "LONGITUD")
    private String longitud;

    public Ubicacion() {
    }

    public Ubicacion(String fkcorreoe) {
        this.fkcorreoe = fkcorreoe;
    }

    public String getFkcorreoe() {
        return fkcorreoe;
    }

    public void setFkcorreoe(String fkcorreoe) {
        this.fkcorreoe = fkcorreoe;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fkcorreoe != null ? fkcorreoe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicacion)) {
            return false;
        }
        Ubicacion other = (Ubicacion) object;
        if ((this.fkcorreoe == null && other.fkcorreoe != null) || (this.fkcorreoe != null && !this.fkcorreoe.equals(other.fkcorreoe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Ubicacion[ fkcorreoe=" + fkcorreoe + " ]";
    }
    
}
