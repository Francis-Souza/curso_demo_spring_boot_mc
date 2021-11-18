package com.joinsolutions.curso_demo_spring_boot_mc.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joinsolutions.curso_demo_spring_boot_mc.entities.ItemPedido;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.ItemPedidoRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.resources.exceptions.ResourceNotFoundException;
import com.joinsolutions.curso_demo_spring_boot_mc.services.exceptions.ObjectNotFoundException;

@Service
public class ItemPedidoService {
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	
	public List<ItemPedido> findAll() {
		return itemPedidoRepository.findAll();
	}

	public ItemPedido finById(Long id) {
		Optional<ItemPedido> obj = itemPedidoRepository.findById(id);		
		if ( obj.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado no banco! Id: " + id + ", tipo: " + ItemPedido.class.getName());			
		}
		return obj.get();
	}
	
	public ItemPedido insert(ItemPedido obj) {
		return itemPedidoRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		try {
			itemPedidoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} 
	}
	
	public ItemPedido update(Long id, ItemPedido obj) {
		try {
			ItemPedido itemPedido = itemPedidoRepository.getById(id);
			updateData(itemPedido, obj);
			return itemPedidoRepository.save(itemPedido);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(ItemPedido itemPedido, ItemPedido obj) {
		itemPedido.setDesconto(obj.getDesconto());
		itemPedido.setPreco(obj.getPreco());
		itemPedido.setQuantidade(obj.getQuantidade());
		itemPedido.setProduto(obj.getProduto());
	}
}
