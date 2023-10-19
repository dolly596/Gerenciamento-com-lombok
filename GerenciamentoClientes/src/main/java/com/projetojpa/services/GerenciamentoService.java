package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Gerenciamento;
import com.projetojpa.repository.GerenciamentoRepository;

@Service
public class GerenciamentoService {
	private final GerenciamentoRepository GerenciamentoRepository;
	

	@Autowired
	public GerenciamentoService(GerenciamentoRepository GerenciamentoRepository) {
		this.GerenciamentoRepository = GerenciamentoRepository;
	}

	public List<Gerenciamento> getAllGerenciamentos() {
		return GerenciamentoRepository.findAll();
	}

	public Gerenciamento getGerenciamentoById(Long id) {
		Optional<Gerenciamento> Gerenciamento = GerenciamentoRepository.findById(id);
		return Gerenciamento.orElse(null);
	}

	public Gerenciamento saveGerenciamento(Gerenciamento Gerenciamento) {
		return GerenciamentoRepository.save(Gerenciamento);
	}

	public Gerenciamento changeGerenciamento(Long id, Gerenciamento changeU) {
		Optional<Gerenciamento> existeGerenciamento = GerenciamentoRepository.findById(id);
		if (existeGerenciamento.isPresent()) {
			changeU.setId(id);
			return GerenciamentoRepository.save(changeU);
		}
		return null;
	}

	public boolean deleteGerenciamento(Long id) {
		Optional<Gerenciamento> existeGerenciamento= GerenciamentoRepository.findById(id);
		if (existeGerenciamento.isPresent()) {
			GerenciamentoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}