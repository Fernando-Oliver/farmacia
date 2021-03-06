package org.generation.farmacia.controller;

import java.util.List;

import org.generation.farmacia.model.Categoria;
import org.generation.farmacia.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetALL(){
	return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Categoria>> GetByName(@PathVariable String categoria){
		return ResponseEntity.ok(repository.findALLByCategoriaContainingIgnoreCase(categoria));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> postcategoria(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));	
	}
	
	@PutMapping
	public ResponseEntity<Categoria> putcategoria(@RequestBody Categoria categoria){
		return ResponseEntity.ok(repository.save(categoria));	
	}
	
	@DeleteMapping
	public void id(@PathVariable long id) {
		repository.deleteById(id);
	}

}
