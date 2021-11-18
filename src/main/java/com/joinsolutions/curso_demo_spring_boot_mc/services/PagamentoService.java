package com.joinsolutions.curso_demo_spring_boot_mc.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joinsolutions.curso_demo_spring_boot_mc.entities.Pagamento;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.PagamentoRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.resources.exceptions.ResourceNotFoundException;
import com.joinsolutions.curso_demo_spring_boot_mc.services.exceptions.ObjectNotFoundException;

@Service
public class PagamentoService {
	
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	
	public List<Pagamento> findAll() {
		return pagamentoRepository.findAll();
	}

	public Pagamento finById(Long id) {
		Optional<Pagamento> obj = pagamentoRepository.findById(id);		
		if ( obj.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado no banco! Id: " + id + ", tipo: " + Pagamento.class.getName());			
		}
		return obj.get();
	}
	
	public Pagamento insert(Pagamento obj) {
		return pagamentoRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		try {
			pagamentoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} 
	}
	
	public Pagamento update(Long id, Pagamento obj) {
		try {
			Pagamento pagamento = pagamentoRepository.getById(id);
			updateData(pagamento, obj);
			return pagamentoRepository.save(pagamento);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Pagamento pagamento, Pagamento obj) {
		pagamento.setEstadoPagamentoEnum(obj.getEstadoPagamentoEnum());
		pagamento.setPedido(obj.getPedido());
	}
}

