package com.joinsolutions.curso_demo_spring_boot_mc.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joinsolutions.curso_demo_spring_boot_mc.entities.Pedido;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.PedidoRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.resources.exceptions.ResourceNotFoundException;
import com.joinsolutions.curso_demo_spring_boot_mc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	public Pedido finById(Long id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);		
		if ( obj.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado no banco! Id: " + id + ", tipo: " + Pedido.class.getName());			
		}
		return obj.get();
	}
	
	public Pedido insert(Pedido obj) {
		return pedidoRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		try {
			pedidoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} 
	}
	
	public Pedido update(Long id, Pedido obj) {
		try {
			Pedido pedido = pedidoRepository.getById(id);
			updateData(pedido, obj);
			return pedidoRepository.save(pedido);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Pedido pedido, Pedido obj) {
		pedido.setEnderecoDeEntrega(obj.getEnderecoDeEntrega());
		pedido.setCliente(obj.getCliente());
		pedido.setDataPedido(obj.getDataPedido());		
	}
}
