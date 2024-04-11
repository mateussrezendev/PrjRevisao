package com.mateus.PrjRevisao.Entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long PedidoId;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate DataPedido;

	private double ValorTotal;

	@ManyToOne
	private Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Pedido() {

	}

	public Pedido(Long PedidoId, LocalDate DataPedido,
			double ValorTotal) {
		super();
		this.PedidoId = PedidoId;
		this.DataPedido = DataPedido;
		this.ValorTotal = ValorTotal;
	}

	public Long getPedidoId() {
		return PedidoId;
	}

	public void setPedidoId(Long PedidoId) {
		this.PedidoId = PedidoId;
	}


	public LocalDate getDataPedido() {
		return DataPedido;
	}

	public void setDataPedido(LocalDate DataPedido) {
		this.DataPedido = DataPedido;
	}

	public double getValorTotal() {
		return ValorTotal;
	}

	public void setValorTotal(double ValorTotal) {
		this.ValorTotal = ValorTotal;
	}

}