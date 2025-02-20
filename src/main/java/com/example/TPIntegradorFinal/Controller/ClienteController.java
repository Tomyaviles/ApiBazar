package com.example.TPIntegradorFinal.Controller;

import com.example.TPIntegradorFinal.Model.Cliente;
import com.example.TPIntegradorFinal.Service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

                    ///ENDPOINTS

    ///CREACION
    @PostMapping
    public String crearCliente(@RequestBody Cliente cliente) {
        clienteService.saveCliente(cliente);

        return "Cliente registrado con exito";
    }

    ///LISTA COMPLETA DE CLIENTES
    @GetMapping
    public List<Cliente> listarClientes() {

        return clienteService.getALLClientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarCliente(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }


    ///ELIMINAR
    @DeleteMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);

        return "Cliente eliminado con exito";
    }


    ///MODIFICAR
    //NO MODIFICA ID
    @PutMapping("/editar/{id_original}")
    public Cliente editarCliente(@PathVariable Long id_original,
                                 @RequestBody Cliente cliente) {
        clienteService.editCliente(id_original, cliente);
        Cliente aux = clienteService.getClienteById(id_original);
        return aux;

    }




}
