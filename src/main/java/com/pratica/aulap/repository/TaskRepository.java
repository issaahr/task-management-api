package com.pratica.aulap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratica.aulap.model.Task;

/**
 * Interface de repositório para operações de persistência da entidade Task.
 * Estende JpaRepository fornecendo métodos CRUD básicos automaticamente.
 * 
 * @author Isabeli Romano - RU 4699663
 * @version 1.0
 * @since 2025
 */
@Repository
public interface TaskRepository extends JpaRepository <Task, Long>{

}
