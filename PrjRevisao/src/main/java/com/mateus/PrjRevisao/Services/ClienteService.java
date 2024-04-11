package com.mateus.PrjRevisao.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mateus.PrjRevisao.Entities.Cliente;
import com.mateus.PrjRevisao.Repositories.ClienteRepository;


@Service
public class ClienteService {
private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
		public Cliente getClientesById(Long Depcodigo) {
			return clienteRepository.findById(Depcodigo).orElse(null);
		}
		
		public  List<Cliente> getAllClientes(){
			return clienteRepository.findAll();
		}
			
		public Cliente saveClientes(Cliente Cliente) {
			return clienteRepository.save(Cliente);		
		}
		
		public void deleteClientes(Long ClienteId){
			clienteRepository.deleteById(ClienteId);	
		}	


	

}