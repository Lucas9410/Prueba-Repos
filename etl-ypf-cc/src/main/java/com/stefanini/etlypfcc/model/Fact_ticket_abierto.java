package cubo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="dbo.dim_grupo")
public class Fact_ticket_abierto implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ticket_abierto")
	private int id_ticket_abierto;
	@Column(name="numero_ticket")
	private int numero_ticket; 
	@Column(name="id_fecha_apertura")
	private int id_fecha_apertura; 
	@Column(name="hora_apertura")
	private String hora_apertura;
	@Column(name="id_criticidad") 
	private int id_criticidad;
	@Column(name="id_analista_apertura") 
	private int id_analista_apertura;
	@Column(name="id_grupo_apertura") 
	private int id_grupo_apertura; 
	
	
	public Fact_ticket_abierto() {
		
	}

	public Fact_ticket_abierto(int numero_ticket, int id_fecha_apertura, String hora_apertura, int id_criticidad,
			int id_analista_apertura, int id_grupo_apertura) {
		super();
		this.numero_ticket = numero_ticket;
		this.id_fecha_apertura = id_fecha_apertura;
		this.hora_apertura = hora_apertura;
		this.id_criticidad = id_criticidad;
		this.id_analista_apertura = id_analista_apertura;
		this.id_grupo_apertura = id_grupo_apertura;
	}
	
	

}
