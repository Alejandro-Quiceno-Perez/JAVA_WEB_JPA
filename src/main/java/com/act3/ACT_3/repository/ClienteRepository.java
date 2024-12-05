package com.act3.ACT_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.act3.ACT_3.entity.Cliente;

/**
 * Repositorio para la entidad Cliente.
 * Proporciona métodos básicos para realizar operaciones CRUD y consultas avanzadas
 * a través de JPA.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
