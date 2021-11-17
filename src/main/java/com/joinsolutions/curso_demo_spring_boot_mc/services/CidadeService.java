package com.joinsolutions.curso_demo_spring_boot_mc.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joinsolutions.curso_demo_spring_boot_mc.entities.Cidade;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.CidadeRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.resources.exceptions.ResourceNotFoundException;
import com.joinsolutions.curso_demo_spring_boot_mc.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	
	public List<Cidade> findAll() {
		return cidadeRepository.findAll();
	}

	public Cidade finById(Long id) {
		Optional<Cidade> obj = cidadeRepository.findById(id);		
		if ( obj.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado no banco! Id: " + id + ", tipo: " + Cidade.class.getName());			
		}
		return obj.get();
	}
	
	public Cidade insert(Cidade obj) {
		return cidadeRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		try {
			cidadeRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} 
	}
	
	public Cidade update(Long id, Cidade obj) {
		try {
			Cidade cidade = cidadeRepository.getById(id);
			updateData(cidade, obj);
			return cidadeRepository.save(cidade);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Cidade cidade, Cidade obj) {
		cidade.setNome(obj.getNome());
	}
}
