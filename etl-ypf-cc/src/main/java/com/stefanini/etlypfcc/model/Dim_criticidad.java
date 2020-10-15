package cubo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="dbo.dim_criticidad")
public class Dim_criticidad implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_criticidad")
	private int id_criticidad;
	@Column(name="descripcion")
	private String descripcion;
	
	public Dim_criticidad() {
		
	}
	public int getId() {
		return this.id_criticidad;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public void setDescripcion(String value) {
		this.descripcion =  value;
	}

}
