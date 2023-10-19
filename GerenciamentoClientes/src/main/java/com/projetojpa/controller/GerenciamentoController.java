package com.projetojpa.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Gerenciamento;
import com.projetojpa.services.GerenciamentoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Gerenciamentos", description = "API REST DE GERENCIAMENTO DO Gerenciamento")
@RestController
@RequestMapping("/Gerenciamento")
public class GerenciamentoController {

	private final GerenciamentoService GerenciamentoService;

	@Autowired
	public GerenciamentoController(GerenciamentoService GerenciamentoService) {
		this.GerenciamentoService = GerenciamentoService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza Gerenciamento por ID")
	public ResponseEntity<Gerenciamento> buscaGerenciamentoControlId(@PathVariable Long id) {
		Gerenciamento Gerenciamento = GerenciamentoService.getGerenciamentoById(id);
		if (Gerenciamento != null) {
			return ResponseEntity.ok(Gerenciamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	@Operation(summary = "apresenta todos os Gerenciamentos")
	public ResponseEntity<List<Gerenciamento>> buscaTodasLigacoesControl() {
		List<Gerenciamento> Gerenciamento = GerenciamentoService.getAllGerenciamentos();
		return ResponseEntity.ok(Gerenciamento);
	}

	@PostMapping("/")
	@Operation(summary = "cadastra os Gerenciamentos")
	public ResponseEntity<Gerenciamento> saveGerenciamentoControl(@RequestBody @Valid Gerenciamento Gerenciamento) {
		Gerenciamento saveGerenciamento = GerenciamentoService.saveGerenciamento(Gerenciamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveGerenciamento);
	}

	@PutMapping("/{id}")
	@Operation(summary = "altera os Gerenciamentos")
	public ResponseEntity<Gerenciamento> alteraGerenciamentoControl(@PathVariable Long id, @RequestBody @Valid Gerenciamento Gerenciamento) {
		Gerenciamento alteraGerenciamento = GerenciamentoService.changeGerenciamento(id, Gerenciamento);

		if (alteraGerenciamento != null) {
			return ResponseEntity.ok(Gerenciamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "deleta os Gerenciamentos")
	public ResponseEntity<String> deleteGerenciamentoControl(@PathVariable Long id) {
		boolean delete = GerenciamentoService.deleteGerenciamento(id);
		if (delete) {
			return ResponseEntity.ok().body("O produto foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}