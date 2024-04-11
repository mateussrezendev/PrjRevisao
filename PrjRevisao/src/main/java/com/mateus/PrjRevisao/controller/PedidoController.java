package com.mateus.PrjRevisao.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.PrjRevisao.Entities.Pedido;
import com.mateus.PrjRevisao.Services.PedidoService;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
    private final PedidoService PedidoService;
	
	public PedidoController(PedidoService PedidoService) {
		this.PedidoService = PedidoService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findPedidobyId(@PathVariable Long id) {
		Pedido Pedido = PedidoService.getPedidoById(id);
		if (Pedido != null) {
			return ResponseEntity.ok(Pedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	
	@GetMapping("/")
	public ResponseEntity<List<Pedido>> findAllUsuarioscontrol() {
		List<Pedido> Pedido = PedidoService.getAllPedidos();
		return ResponseEntity.ok(Pedido);
	}

	@PostMapping("/")
	public ResponseEntity<Pedido> insertUsuariosControl(@RequestBody Pedido Pedido) {
		Pedido novoPedido = PedidoService.savePedido(Pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
	}

    

	@DeleteMapping("/id")
	public ResponseEntity<String> deleteUsuarioControl(@PathVariable Long PedidoId) {
		boolean remover = PedidoService.deletePedido(PedidoId);
		if (remover) {
			return ResponseEntity.ok().body("usuario Excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}