
package org.una.work.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.una.work.utils.BaseEntity;

@Entity
@Table(name = "tb_usuario")
public class Usuario extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;


	
	@NotBlank
	@Size(max = 80)
	@Column(name = "nome", nullable = false, length = 80)
	private String nome;

	@Column(name = "email", length = 255, nullable = false, unique = true)
	private String email;

	@Column(name = "password", length = 128, nullable = false)
	private String password;

	public Usuario() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
