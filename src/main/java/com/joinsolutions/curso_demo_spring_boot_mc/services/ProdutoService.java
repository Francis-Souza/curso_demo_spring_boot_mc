package com.joinsolutions.curso_demo_spring_boot_mc.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joinsolutions.curso_demo_spring_boot_mc.entities.Produto;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.ProdutoRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.resources.exceptions.ResourceNotFoundException;
import com.joinsolutions.curso_demo_spring_boot_mc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto finById(Long id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		if ( obj.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado no banco! Id: " + id + ", tipo: " + Produto.class.getName());			
		}
		return obj.get();
	}
	
	public Produto insert(Produto obj) {
		return produtoRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		try {
			produtoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
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
		produto.setPreco(obj.getPreco());
	}
}
