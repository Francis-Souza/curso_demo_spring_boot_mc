package com.joinsolutions.curso_demo_spring_boot_mc.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joinsolutions.curso_demo_spring_boot_mc.entities.Cliente;
import com.joinsolutions.curso_demo_spring_boot_mc.repositories.ClienteRepository;
import com.joinsolutions.curso_demo_spring_boot_mc.resources.exceptions.ResourceNotFoundException;
import com.joinsolutions.curso_demo_spring_boot_mc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente finById(Long id) {
		Optional<Cliente> obj = clienteRepository.findById(id);		
		if ( obj.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado no banco! Id: " + id + ", tipo: " + Cliente.class.getName());			
		}
		return obj.get();
	}
	
	public Cliente insert(Cliente obj) {
		return clienteRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		try {
			clienteRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} 
	}
	
	public Cliente update(Long id, Cliente obj) {
		try {
			Cliente cliente = clienteRepository.getById(id);
			updateData(cliente, obj);
			return clienteRepository.save(cliente);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Cliente cliente, Cliente obj) {
		cliente.setNome(obj.getNome());
		cliente.setEmail(obj.getEmail());
		cliente.setCpfcnpj(obj.getCpfcnpj());
		cliente.setTelefones(obj.getTelefones());
	}
}
