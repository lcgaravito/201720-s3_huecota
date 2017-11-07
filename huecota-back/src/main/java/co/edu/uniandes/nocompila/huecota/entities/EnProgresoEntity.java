/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import co.edu.uniandes.nocompila.huecota.podam.DateStrategy;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author jpr.arango10
 */
@Entity
public class EnProgresoEntity extends BaseEntity implements Serializable{
    
    /**
     * Fecha de inicio de tapado del hueco.
     */
    private String fechaDeInicio;
    
    @PodamExclude
    @OneToOne(orphanRemoval = true)
    private List<HuecoEntity> huecos;
    
    @PodamExclude
    @OneToOne(orphanRemoval = true)
    private List<CuentaCobroEntity> cuentaCobro;

    public String getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(String fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }
    
    public List<HuecoEntity> getHuecos() {
        return huecos;
    }

    public void setHuecos(List<HuecoEntity> huecos) {
        this.huecos = huecos;
    }

    public List<CuentaCobroEntity> getCuentaCobro() {
        return cuentaCobro;
    }

    public void setCuentaCobro(List<CuentaCobroEntity> cuentaCobro) {
        this.cuentaCobro = cuentaCobro;
    }
    
}
