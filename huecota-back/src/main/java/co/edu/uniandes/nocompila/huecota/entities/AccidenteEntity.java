/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
/**
 *
 * @author ma.puentes
 */
@Entity
public class AccidenteEntity  extends BaseEntity implements Serializable
{
	/**
	 * Atributo que representa un cliente para la clase accidente.
	 */
	@PodamExclude
    @OneToOne
    private ClienteEntity cliente;
	
	/**
	 * Atributo que representa un cliente para la clase accidente.
	 */
    @PodamExclude
    @ManyToOne
	 private HuecoEntity hueco;

	/**
	 * Atributo que representa la fecha del accidente.
	 */
    @Temporal(TemporalType.DATE)
	private Date fecha;
	
	/**
	 * Atributo que reresenta la descripción de un accidente.
	 */
	private String descripcion;
	
	
	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public HuecoEntity getHueco() {
		return hueco;
	}

	public void setHueco(HuecoEntity hueco) {
		this.hueco = hueco;
	}
	
	/**
	 * Método que retorna la fecha.
	 * @return 
	 */
	public Date getFecha()
	{
		return fecha;
	}
	/**
	 * M{etodo que cambia la fecha de la clase pro la que recibe por parámetro.
	 * @param pFecha 
	 */
	public void setFecha(Date pFecha)
	{
		this.fecha = pFecha;
	}
	
	
}
