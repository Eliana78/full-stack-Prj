package com.Esame.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="biglietti")
public class Biglietto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_operazione")
	private Integer id;
	
	@Column(name="data_ora")
	private LocalDate date;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_pagamento")
	private TipoPagamento tipoPagamento;
	
	private int quantita;
	
	@ManyToOne
	@JoinColumn(name="cod_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="cod_replica")
	private Replica replica;
	
	
	
	
	public Biglietto() {
		// TODO Auto-generated constructor stub
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public LocalDate getDate() {
		return date;
	}




	public void setDate(LocalDate date) {
		this.date = date;
	}




	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}




	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}




	public int getQuantita() {
		return quantita;
	}




	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}




	public Cliente getCliente() {
		return cliente;
	}




	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}




	public Replica getReplica() {
		return replica;
	}




	public void setReplica(Replica replica) {
		this.replica = replica;
	}
	
	
	
	
}
