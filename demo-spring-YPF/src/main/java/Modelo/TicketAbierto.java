package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TicketAbierto {

	@Id

	private Integer id_ticket_abierto;
	private Integer numero_ticket;
	private Integer id_fecha_apertura;
	private Integer id_rango_hora_apertura;
	private Integer hora_apertura;
    private Integer id_criticidad;
    private Integer id_tipo_ticket;
    private Integer id_grupo_apertura;
	
    public TicketAbierto(Integer id_ticket_abierto, Integer numero_ticket, Integer id_fecha_apertura,
			Integer id_rango_hora_apertura, Integer hora_apertura, Integer id_criticidad, Integer id_tipo_ticket,
			Integer id_grupo_apertura) {
		super();
		this.id_ticket_abierto = id_ticket_abierto;
		this.numero_ticket = numero_ticket;
		this.id_fecha_apertura = id_fecha_apertura;
		this.id_rango_hora_apertura = id_rango_hora_apertura;
		this.hora_apertura = hora_apertura;
		this.id_criticidad = id_criticidad;
		this.id_tipo_ticket = id_tipo_ticket;
		this.id_grupo_apertura = id_grupo_apertura;
	}
    
	public Integer getId_ticket_abierto() {
		return id_ticket_abierto;
	}

	public void setId_ticket_abierto(Integer id_ticket_abierto) {
		this.id_ticket_abierto = id_ticket_abierto;
	}

	public Integer getNumero_ticket() {
		return numero_ticket;
	}

	public void setNumero_ticket(Integer numero_ticket) {
		this.numero_ticket = numero_ticket;
	}

	public Integer getId_fecha_apertura() {
		return id_fecha_apertura;
	}

	public void setId_fecha_apertura(Integer id_fecha_apertura) {
		this.id_fecha_apertura = id_fecha_apertura;
	}

	public Integer getId_rango_hora_apertura() {
		return id_rango_hora_apertura;
	}

	public void setId_rango_hora_apertura(Integer id_rango_hora_apertura) {
		this.id_rango_hora_apertura = id_rango_hora_apertura;
	}

	public Integer getHora_apertura() {
		return hora_apertura;
	}

	public void setHora_apertura(Integer hora_apertura) {
		this.hora_apertura = hora_apertura;
	}

	public Integer getId_criticidad() {
		return id_criticidad;
	}

	public void setId_criticidad(Integer id_criticidad) {
		this.id_criticidad = id_criticidad;
	}

	public Integer getId_tipo_ticket() {
		return id_tipo_ticket;
	}

	public void setId_tipo_ticket(Integer id_tipo_ticket) {
		this.id_tipo_ticket = id_tipo_ticket;
	}

	public Integer getId_grupo_apertura() {
		return id_grupo_apertura;
	}

	public void setId_grupo_apertura(Integer id_grupo_apertura) {
		this.id_grupo_apertura = id_grupo_apertura;
	}
    
  
}
