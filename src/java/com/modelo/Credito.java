/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 *
 * @author Juan Pablo
 */
@Entity
@Table(name = "credito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credito.getAll", query = "SELECT c FROM Credito c")})
public class Credito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_credito")
    private Integer idCredito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_inicial")
    private BigDecimal montoInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plazo_meses")
    private int plazoMeses;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tasa_interes")
    private float tasaInteres;

    public Credito() {
    }

    public Credito(Integer idCredito) {
        this.idCredito = idCredito;
    }

    public Credito(String nombreCliente, BigDecimal montoInicial, int plazoMeses, float tasaInteres) {
        this.nombreCliente = nombreCliente;
        this.montoInicial = montoInicial;
        this.plazoMeses = plazoMeses;
        this.tasaInteres = tasaInteres;
    }
    
    public Credito(Integer idCredito, String nombreCliente, BigDecimal montoInicial, int plazoMeses, float tasaInteres) {
        this.idCredito = idCredito;
        this.nombreCliente = nombreCliente;
        this.montoInicial = montoInicial;
        this.plazoMeses = plazoMeses;
        this.tasaInteres = tasaInteres;
    }

    public Integer getIdCredito() {
        return idCredito;
    }

    public void setIdCredito(Integer idCredito) {
        this.idCredito = idCredito;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public BigDecimal getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(BigDecimal montoInicial) {
        this.montoInicial = montoInicial;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(int plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public float getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(float tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCredito != null ? idCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credito)) {
            return false;
        }
        Credito other = (Credito) object;
        if ((this.idCredito == null && other.idCredito != null) || (this.idCredito != null && !this.idCredito.equals(other.idCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Credito[ idCredito=" + idCredito + " ]";
    }
    
}
