package com.mateus.PrjRevisao.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.PrjRevisao.Entities.Cliente;
import com.mateus.PrjRevisao.Services.ClienteService;



@RestController
@RequestMapping("/departamentos")
public class ClienteController {

	@GetMapping("/home")
    public String paginaInicial() {
        return "index";
    }
	private final ClienteService ClienteService;

	public ClienteController(ClienteService ClienteService) {
		this.ClienteService = ClienteService;		
	}
	@GetMapping("/{depcodigo}")	
    public ResponseEntity<Cliente> getJogo(@PathVariable Long ClienteId) {
		Cliente Cliente = ClienteService.getClientesById(ClienteId);
        if (Cliente != null) {
            return ResponseEntity.ok(Cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }	
	@PostMapping
	public Cliente createDepartamentos(@RequestBody Cliente Cliente) {
		return ClienteService.saveClientes(Cliente);
	}
	
	@DeleteMapping("/{depcodigo}")
	public void deleteDepartamentos(@PathVariable Long ClienteId) {
		ClienteService.deleteClientes(ClienteId);
	}
	
		@GetMapping
		public ResponseEntity<List<Cliente>> getAllClientes(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Cliente> Cliente = ClienteService.getAllClientes();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(Cliente);
		}
		
}