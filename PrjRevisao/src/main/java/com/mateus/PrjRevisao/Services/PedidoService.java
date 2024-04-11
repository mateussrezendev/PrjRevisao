package com.mateus.PrjRevisao.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mateus.PrjRevisao.Entities.Pedido;
import com.mateus.PrjRevisao.Repositories.PedidoRepository;


@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> getAllPedidos() {
		return pedidoRepository.findAll();
	}

	public Pedido getPedidoById(long PedidoId) {
		return pedidoRepository.findById(PedidoId).orElse(null);
	}

	public Pedido savePedido(Pedido Pedido) {
		return pedidoRepository.save(Pedido);
	}

	
	public boolean deletePedido(Long id) {
		Optional<Pedido> PedidoExistente = pedidoRepository.findById(id);
		if (PedidoExistente.isPresent()) {
			pedidoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	

		
	

}