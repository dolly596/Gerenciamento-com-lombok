package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.entities.Gerenciamento;

	public interface GerenciamentoRepository extends JpaRepository<Gerenciamento, Long> {
		
	}

