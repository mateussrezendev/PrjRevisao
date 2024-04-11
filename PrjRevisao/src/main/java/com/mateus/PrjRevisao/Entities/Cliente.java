package com.mateus.PrjRevisao.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ClienteId;
	
	private String Nome;
	
	private String Email;
	
	private String Telefone;
	
	public Cliente() {	
	}

	public Cliente(Long ClienteId, String Nome, String Email, String Telefone) {
		super();
		this.ClienteId = ClienteId;
		this.Nome = Nome;
		this.Email = Email;
		this.Telefone = Telefone;
	}

	public Long getClienteId() {
		return ClienteId;
	}

	public void setClienteId(Long ClienteId) {
		this.ClienteId = ClienteId;
	}

	
	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	
	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String Telefone) {
		this.Telefone = Telefone;
	}


}