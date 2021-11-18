package com.joinsolutions.curso_demo_spring_boot_mc.entities;

import java.time.Instant;

import com.joinsolutions.curso_demo_spring_boot_mc.entities.enums.EstadoPagamentoEnum;

public class PagamentoComBoleto extends Pagamento {
	
	
	private static final long serialVersionUID = 1L;
	
	
	private Instant dataPagamento;
	private Instant dataVencimento;
	
	public PagamentoComBoleto() {}

	public PagamentoComBoleto(Long id, EstadoPagamentoEnum estadoPagamentoEnum, Pedido pedido, Instant dataPagamento,
			Instant dataVencimento) {
		super(id, estadoPagamentoEnum, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}

	public Instant getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Instant dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Instant getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Instant dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	




	
	

	
	
}

