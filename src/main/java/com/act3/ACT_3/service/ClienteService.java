package com.act3.ACT_3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.act3.ACT_3.entity.Cliente;
import com.act3.ACT_3.repository.ClienteRepository;

/**
 * Servicio que gestiona las operaciones relacionadas con la entidad Cliente.
 * Ofrece métodos para realizar operaciones CRUD y paginación de registros.
 */
@Service
public class ClienteService {

       /**
        * Repositorio de la entidad Cliente, utilizado para acceder a la base de datos.
        */
       @Autowired
       private ClienteRepository objClienteRepository;

       /**
        * Obtiene todos los registros de clientes.
        * 
        * @return Lista de todos los clientes almacenados.
        */
       public List<Cliente> findAll() {
              return this.objClienteRepository.findAll();
       }

       /**
        * Obtiene una lista paginada de clientes.
        * 
        * @param page Número de la página (comienza desde 0).
        * @param size Cantidad de registros por página.
        * @return Página de clientes que contiene los registros correspondientes.
        */
       public Page<Cliente> findPaginated(int page, int size) {
              if (page < 0) {
                     page = 1; // Asegura que la página sea válida.
              }

              Pageable oPageable = PageRequest.of(page, size);

              return this.objClienteRepository.findAll(oPageable);
       }

       /**
        * Inserta un nuevo cliente en la base de datos.
        * 
        * @param cliente Objeto Cliente que se desea guardar.
        * @return El cliente guardado con su ID generado.
        */
       public Cliente insert(Cliente cliente) {
              return this.objClienteRepository.save(cliente);
       }

       /**
        * Actualiza un cliente existente en la base de datos.
        * 
        * @param id      Identificador único del cliente a actualizar.
        * @param cliente Objeto Cliente con los datos actualizados.
        * @return El cliente actualizado, o {@code null} si el cliente no existe.
        */
       public Cliente update(Long id, Cliente cliente) {
              Cliente objClienteDB = this.findById(id);

              if (objClienteDB == null) {
                     return null; // Retorna null si el cliente no existe.
              }

              objClienteDB = cliente;
              return this.objClienteRepository.save(objClienteDB);
       }

       /**
        * Elimina un cliente de la base de datos.
        * 
        * @param id Identificador único del cliente a eliminar.
        */
       public void delete(Long id) {
              this.objClienteRepository.deleteById(id);
       }

       /**
        * Busca un cliente por su identificador único.
        * 
        * @param id Identificador único del cliente.
        * @return El cliente encontrado, o {@code null} si no existe.
        */
       public Cliente findById(Long id) {
              return this.objClienteRepository.findById(id).orElse(null);
       }
}