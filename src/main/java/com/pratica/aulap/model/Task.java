package com.pratica.aulap.model;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidade que representa uma tarefa no sistema.
 * Contém informações como nome, data de entrega e responsável.
 * 
 * @author Isabeli Romano - RU 4699663
 * @version 1.0
 * @since 2025
 */
@Entity
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate deadline;

	private String assignee;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDeadline() {
		return this.deadline;
	}
    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) { this.assignee = assignee;}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", deadline=" + deadline + ", assignee=" + assignee + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(deadline, assignee, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(deadline, other.deadline) && Objects.equals(assignee, other.assignee) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}
}
