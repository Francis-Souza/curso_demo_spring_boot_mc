package com.joinsolutions.curso_demo_spring_boot_mc.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joinsolutions.curso_demo_spring_boot_mc.entities.Endereco;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.EnderecoRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.resources.exceptions.ResourceNotFoundException;
import com.joinsolutions.curso_demo_spring_boot_mc.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	
	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}

	public Endereco finById(Long id) {
		Optional<Endereco> obj = enderecoRepository.findById(id);		
		if ( obj.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado no banco! Id: " + id + ", tipo: " + Endereco.class.getName());			
		}
		return obj.get();
	}
	
	public Endereco insert(Endereco obj) {
		return enderecoRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		try {
			enderecoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} 
	}
	
	public Endereco update(Long id, Endereco obj) {
		try {
			Endereco endereco = enderecoRepository.getById(id);
			updateData(endereco, obj);
			return enderecoRepository.save(endereco);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Endereco endereco, Endereco obj) {
		endereco.setLogradouro(obj.getLogradouro());
		endereco.setNumero(obj.getNumero());
		endereco.setBairro(obj.getBairro());
		endereco.setComplemento(obj.getComplemento());
		endereco.setCidade(obj.getCidade());
		endereco.setCliente(obj.getCliente());
	}
}
