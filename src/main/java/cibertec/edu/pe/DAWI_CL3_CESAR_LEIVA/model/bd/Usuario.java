package cibertec.edu.pe.DAWI_CL3_CESAR_LEIVA.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="usuario")
public class Usuario {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "email")
	private String email;
	@Column(name = "usuario")
	private String usuario;
	@Column(name = "contra")
	private String contra;
	}