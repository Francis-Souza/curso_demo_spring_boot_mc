package com.joinsolutions.curso_demo_spring_boot_mc.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.joinsolutions.curso_demo_spring_boot_mc.entities.enums.EstadoPagamentoEnum;

@Entity
@Table(name = "tb_pagamento_com_cartao")
public class PagamentoComCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;

	
	private Integer numeroDeParcelas;	
	
	public PagamentoComCartao() {}


	public PagamentoComCartao(Long id, EstadoPagamentoEnum estadoPagamentoEnum, Pedido pedido,
			Integer numeroDeParcelas) {
		super(id, estadoPagamentoEnum, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}


	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}


	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
}
