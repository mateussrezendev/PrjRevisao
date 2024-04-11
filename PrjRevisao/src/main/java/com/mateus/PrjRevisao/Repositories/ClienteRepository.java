package com.mateus.PrjRevisao.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.PrjRevisao.Entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
}