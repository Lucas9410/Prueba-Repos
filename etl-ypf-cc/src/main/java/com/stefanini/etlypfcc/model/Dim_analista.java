package cubo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;



@Entity
@Table(name="dbo.dim_analista")
public class Dim_analista implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_analista")
	private int id_analista;
	@Column(name="usuario")
	private String usuario;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="externo")
	@Type(type = "numeric_boolean")
	private boolean type; 
	public Dim_analista() {
		
	}
	public int getId() {
		return this.id_analista;
	}
	public String getUsuario() {
		return this.usuario;
	}


	

}
