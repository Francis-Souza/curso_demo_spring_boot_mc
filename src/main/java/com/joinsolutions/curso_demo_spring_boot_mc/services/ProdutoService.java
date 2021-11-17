package com.joinsolutions.curso_demo_spring_boot_mc.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joinsolutions.curso_demo_spring_boot_mc.entities.Produto;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.ProdutoRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.services.exceptions.DatabaseException;
import com.joinsolutions.curso_demo_spring_boot_mc.services.exceptions.ResourceNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto finById(Long id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Produto insert(Produto obj) {
		return produtoRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		try {
			produtoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Produto update(Long id, Produto obj) {
		try {
			Produto produto = produtoRepository.getById(id);
			updateData(produto, obj);
			return produtoRepository.save(produto);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Produto produto, Produto obj) {
		produto.setNome(obj.getNome());
	}
}
