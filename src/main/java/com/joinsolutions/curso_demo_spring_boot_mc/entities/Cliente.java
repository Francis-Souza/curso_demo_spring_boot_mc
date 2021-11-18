package com.joinsolutions.curso_demo_spring_boot_mc.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.joinsolutions.curso_demo_spring_boot_mc.entities.enums.TipoClienteEnum;


@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String email;
	
	@NotNull
	private String cpfcnpj;
	
	@Enumerated(EnumType.STRING) 
	private TipoClienteEnum tipoClienteEnum;
	
	@JsonManagedReference /*Proteção cíclica Json*/
	@OneToMany(mappedBy = "cliente")
	private Set<Endereco> enderecos = new HashSet<>();
	
	
	
	/*Cria tabela fraca no banco de dados*/
	@ElementCollection
	@CollectionTable(name = "tb_telefone")
	private Set<String> telefones = new HashSet<>();
	
	
	@OneToMany(mappedBy = "cliente")
	private Set<Pedido> pedidos = new HashSet<>();
	
	
	public Cliente() {
		
	}


	public Cliente(Long id, @NotNull String nome, @NotNull String email, @NotNull String cpfcnpj,
			TipoClienteEnum tipoClienteEnum) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfcnpj = cpfcnpj;
		this.tipoClienteEnum = tipoClienteEnum;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getCpfcnpj() {
		return cpfcnpj;
	}


	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}


	public TipoClienteEnum getTipoClienteEnum() {
		return tipoClienteEnum;
	}


	public void setTipoClienteEnum(TipoClienteEnum tipoClienteEnum) {
		this.tipoClienteEnum = tipoClienteEnum;
	}
	
	
	public Set<String> getTelefones() {
		return telefones;
	}


	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
	
	public Set<Endereco> getEnderecos() {
		return enderecos;
	}
	
	
	public Set<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}









}
