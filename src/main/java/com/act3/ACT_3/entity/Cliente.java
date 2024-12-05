package com.act3.ACT_3.entity;

import jakarta.persistence.*;

/**
 * Representa la entidad Cliente para ser persistida en la base de datos.
 * Mapea la tabla "cliente" mediante JPA.
 * 
 * Contiene información básica del cliente como su nombre, cédula, dirección y
 * teléfono.
 */
@Entity
@Table(name = "cliente")
public class Cliente {

       /**
        * Identificador único del cliente.
        * Es generado automáticamente por la base de datos.
        */
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       /**
        * Nombre del cliente.
        */
       private String name;

       /**
        * Cédula del cliente. Debe ser única.
        */
       private String cedula;

       /**
        * Dirección física del cliente.
        */
       private String direccion;

       /**
        * Teléfono de contacto del cliente.
        */
       private String telefono;

       /**
        * Constructor sin argumentos.
        * Requerido por JPA para instanciar la entidad.
        */
       public Cliente() {
       }

       // Getters y Setters

       /**
        * Obtiene el identificador único del cliente.
        * 
        * @return El identificador del cliente.
        */
       public Long getId() {
              return id;
       }

       /**
        * Establece el identificador único del cliente.
        * 
        * @param id El nuevo identificador del cliente.
        */
       public void setId(Long id) {
              this.id = id;
       }

       /**
        * Obtiene el nombre del cliente.
        * 
        * @return El nombre del cliente.
        */
       public String getName() {
              return name;
       }

       /**
        * Establece el nombre del cliente.
        * 
        * @param name El nuevo nombre del cliente.
        */
       public void setName(String name) {
              this.name = name;
       }

       /**
        * Obtiene la cédula del cliente.
        * 
        * @return La cédula del cliente.
        */
       public String getCedula() {
              return cedula;
       }

       /**
        * Establece la cédula del cliente.
        * 
        * @param cedula La nueva cédula del cliente.
        */
       public void setCedula(String cedula) {
              this.cedula = cedula;
       }

       /**
        * Obtiene la dirección del cliente.
        * 
        * @return La dirección del cliente.
        */
       public String getDireccion() {
              return direccion;
       }

       /**
        * Establece la dirección del cliente.
        * 
        * @param direccion La nueva dirección del cliente.
        */
       public void setDireccion(String direccion) {
              this.direccion = direccion;
       }

       /**
        * Obtiene el teléfono del cliente.
        * 
        * @return El teléfono del cliente.
        */
       public String getTelefono() {
              return telefono;
       }

       /**
        * Establece el teléfono del cliente.
        * 
        * @param telefono El nuevo teléfono del cliente.
        */
       public void setTelefono(String telefono) {
              this.telefono = telefono;
       }

       /**
        * Devuelve una representación en formato de texto del cliente.
        * 
        * @return Una cadena con los detalles del cliente.
        */
       @Override
       public String toString() {
              return "Cliente [id=" + id + ", name=" + name + ", cedula=" + cedula
                            + ", direccion=" + direccion + ", telefono=" + telefono + "]";
       }
}