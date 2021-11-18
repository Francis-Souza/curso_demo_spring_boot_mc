package com.joinsolutions.curso_demo_spring_boot_mc.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joinsolutions.curso_demo_spring_boot_mc.entities.Pagamento;
import com.joinsolutions.curso_demo_spring_boot_mc.services.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoResource {

	@Autowired
	PagamentoService pagamentoService;

	@GetMapping()
	public ResponseEntity<List<Pagamento>> findAll() {
		List<Pagamento> lista = pagamentoService.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pagamento> findById(@PathVariable Long id) {

		Pagamento obj = pagamentoService.finById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Pagamento> insert(@RequestBody Pagamento obj) {
		obj = pagamentoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		pagamentoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Pagamento> update(@PathVariable Long id, @RequestBody Pagamento obj) {
		obj = pagamentoService.update(id, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);

	}

}
