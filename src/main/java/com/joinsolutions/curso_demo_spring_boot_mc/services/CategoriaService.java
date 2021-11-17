package com.joinsolutions.curso_demo_spring_boot_mc.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joinsolutions.curso_demo_spring_boot_mc.entities.Categoria;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.CategoriaRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.resources.exception.ResourceNotFoundException;
import com.joinsolutions.curso_demo_spring_boot_mc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria finById(Long id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);		
		if ( obj.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado no banco! Id: " + id + ", tipo: " + Categoria.class.getName());			
		}
		return obj.get();
	}
	
	public Categoria insert(Categoria obj) {
		return categoriaRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		try {
			categoriaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} 
	}
	
	public Categoria update(Long id, Categoria obj) {
		try {
			Categoria categoria = categoriaRepository.getById(id);
			updateData(categoria, obj);
			return categoriaRepository.save(categoria);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Categoria categoria, Categoria obj) {
		categoria.setNome(obj.getNome());
	}
}
