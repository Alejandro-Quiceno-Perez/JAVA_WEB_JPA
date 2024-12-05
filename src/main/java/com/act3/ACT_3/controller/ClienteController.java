package com.act3.ACT_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.act3.ACT_3.entity.Cliente;
import com.act3.ACT_3.service.ClienteService;

/**
 * Controlador para gestionar las vistas y operaciones relacionadas con la
 * entidad Cliente.
 * Proporciona rutas para realizar operaciones CRUD y paginación.
 */
@Controller
@RequestMapping("/")
public class ClienteController {

       /**
        * Servicio que contiene la lógica de negocio para la entidad Cliente.
        */
       @Autowired
       private ClienteService clienteService;

       /**
        * Muestra la vista principal con la lista de clientes paginada.
        * 
        * @param objModel Modelo utilizado para pasar datos a la vista.
        * @param page     Número de la página solicitada (por defecto es 1).
        * @param size     Cantidad de registros por página (por defecto es 3).
        * @return Nombre de la vista "viewCliente".
        */
       @GetMapping
       public String showViewGetAll(Model objModel, @RequestParam(defaultValue = "1") int page,
                     @RequestParam(defaultValue = "3") int size) {
              Page<Cliente> list = this.clienteService.findPaginated(page - 1, size);
              objModel.addAttribute("clienteList", list);
              objModel.addAttribute("currentPage", page);
              objModel.addAttribute("totalPages", list.getTotalPages());

              return "viewCliente";
       }

       /**
        * Muestra el formulario para crear un nuevo cliente.
        * 
        * @param objModel Modelo utilizado para pasar datos a la vista.
        * @return Nombre de la vista "viewForm".
        */
       @GetMapping("/form")
       public String showViewFormCliente(Model objModel) {
              objModel.addAttribute("cliente", new Cliente());
              objModel.addAttribute("action", "/cliente/create");
              return "viewForm";
       }

       /**
        * Muestra el formulario para actualizar un cliente existente.
        * 
        * @param id       Identificador del cliente a actualizar.
        * @param objModel Modelo utilizado para pasar datos a la vista.
        * @return Nombre de la vista "viewForm".
        */
       @GetMapping("/update/{id}")
       public String showFormUpdate(@PathVariable Long id, Model objModel) {
              Cliente cliente = this.clienteService.findById(id);
              objModel.addAttribute("cliente", cliente);
              objModel.addAttribute("action", "/edit/" + id);

              return "viewForm";
       }

       /**
        * Actualiza un cliente existente en la base de datos.
        * 
        * @param id      Identificador del cliente a actualizar.
        * @param cliente Objeto Cliente con los datos actualizados.
        * @return Redirige a la vista principal.
        */
       @PostMapping("/edit/{id}")
       public String updateCliente(@PathVariable Long id, @ModelAttribute Cliente cliente) {
              this.clienteService.update(id, cliente);
              return "redirect:/";
       }

       /**
        * Elimina un cliente por su identificador.
        * 
        * @param id Identificador del cliente a eliminar.
        * @return Redirige a la vista principal.
        */
       @GetMapping("/delete/{id}")
       public String deleteCliente(@PathVariable Long id) {
              this.clienteService.delete(id);
              return "redirect:/";
       }

       /**
        * Crea un nuevo cliente en la base de datos.
        * 
        * @param cliente Objeto Cliente con los datos a insertar.
        * @return Redirige a la vista principal.
        */
       @PostMapping("/cliente/create")
       public String createCliente(@ModelAttribute Cliente cliente) {
              this.clienteService.insert(cliente);
              return "redirect:/";
       }
}
