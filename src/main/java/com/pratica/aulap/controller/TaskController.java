package com.pratica.aulap.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratica.aulap.model.Task;
import com.pratica.aulap.repository.TaskRepository;

/**
 * Controller REST para gerenciamento de tarefas.
 * Fornece endpoints para operações CRUD (Create, Read, Update, Delete) de tarefas.
 * 
 * @author Isabeli Romano - RU 4699663
 * @version 1.0
 * @since 2025
 */
@RestController
@RequestMapping({ "/task" })
public class TaskController {
	private TaskRepository repository;

	TaskController(TaskRepository taskRepository) {
		this.repository = taskRepository;
	}

	/**
	 * Recupera todas as tarefas cadastradas no sistema.
	 * 
	 * @return Lista contendo todas as tarefas cadastradas
	 */
	@GetMapping
	public List<?> findAll() {
		return repository.findAll();
	}

	/**
	 * Recupera uma tarefa específica pelo seu ID.
	 * 
	 * @param id ID da tarefa a ser recuperada
	 * @return ResponseEntity contendo a tarefa encontrada ou status 404 se não encontrada
	 */
	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	/**
	 * Cria uma nova tarefa no sistema.
	 * 
	 * @param task Objeto Task contendo os dados da tarefa a ser criada
	 * @return A tarefa criada com ID gerado automaticamente
	 */
	@PostMapping
	public Task create(@RequestBody Task task) {
		return repository.save(task);
	}

	/**
	 * Atualiza uma tarefa existente no sistema.
	 * 
	 * @param id ID da tarefa a ser atualizada
	 * @param task Objeto Task contendo os novos dados da tarefa
	 * @return ResponseEntity contendo a tarefa atualizada ou status 404 se não encontrada
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Task task) {
		return repository.findById(id).map(record -> {
			record.setName(task.getName());
			record.setDeadline(task.getDeadline());
			record.setAssignee(task.getAssignee());
			Task updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	/**
	 * Remove uma tarefa do sistema.
	 * 
	 * @param id ID da tarefa a ser removida
	 * @return ResponseEntity com status 200 se removida com sucesso ou 404 se não encontrada
	 */
	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}