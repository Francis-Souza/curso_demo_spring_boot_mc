package com.joinsolutions.curso_demo_spring_boot_mc.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {


	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataPedido;
	
	
	/*Associação com tabela ItemPedido*/
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")	
	private Pagamento pagamento;
	
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "endereco_de_entrega_id")
	private Endereco enderecoDeEntrega;
	
	
	public Pedido() {
		
		
	}


	public Pedido(Long id, @NotNull Instant dataPedido, Cliente cliente,
			Endereco enderecoDeEntrega) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;		
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Instant getDataPedido() {
		return dataPedido;
	}



	public void setDataPedido(Instant dataPedido) {
		this.dataPedido = dataPedido;
	}



	public Set<ItemPedido> getItens() {
		return itens;
	}



	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}



	public Pagamento getPagamento() {
		return pagamento;
	}



	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}



	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
	
	
	public Double getTotal() {		 
		double sum = 0.00;
		for(ItemPedido x : itens ) {
			sum += x.getSubTotal();
		}		
		return sum;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
