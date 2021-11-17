package com.joinsolutions.curso_demo_spring_boot_mc.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joinsolutions.curso_demo_spring_boot_mc.entities.Estado;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.EstadoRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.resources.exceptions.ResourceNotFoundException;
import com.joinsolutions.curso_demo_spring_boot_mc.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {
	
	@Autowired
	EstadoRepository estadoRepository;
	
	
	public List<Estado> findAll() {
		return estadoRepository.findAll();
	}

	public Estado finById(Long id) {
		Optional<Estado> obj = estadoRepository.findById(id);		
		if ( obj.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado no banco! Id: " + id + ", tipo: " + Estado.class.getName());			
		}
		return obj.get();
	}
	
	public Estado insert(Estado obj) {
		return estadoRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		try {
			estadoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} 
	}
	
	public Estado update(Long id, Estado obj) {
		try {
			Estado estado = estadoRepository.getById(id);
			updateData(estado, obj);
			return estadoRepository.save(estado);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Estado estado, Estado obj) {
		estado.setNome(obj.getNome());
	}
}
