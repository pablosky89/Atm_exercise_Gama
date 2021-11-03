package com.gama.CaxaExercise.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gama.CaxaExercise.dto.AtmDto;
import com.gama.CaxaExercise.services.AtmService;

@RestController
@RequestMapping(value = "/atm")
public class AtmResource {
	
	@Autowired
	private AtmService service;
	
	@GetMapping
	public ResponseEntity<List<AtmDto>> findAll(){
		List<AtmDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<AtmDto> insert(@RequestBody AtmDto dto){
		dto = service.withdraw(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	

}
