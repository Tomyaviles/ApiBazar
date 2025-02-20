package com.example.TPIntegradorFinal.Service;

import com.example.TPIntegradorFinal.Model.Cliente;
import com.example.TPIntegradorFinal.Repository.ClienteRepository;
import com.example.TPIntegradorFinal.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<Cliente> getALLClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes;
    }

    @Override
    public Cliente getClienteById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        return cliente;
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);

    }

    @Override
    public void deleteCliente(Long id) {

        clienteRepository.deleteById(id);

    }

    @Override
    public void editCliente(Long id_original, Cliente cliente) {
        Cliente aux = clienteRepository.findById(id_original).orElse(null);
        aux.setNombre(cliente.getNombre());
        aux.setApellido(cliente.getApellido());
        aux.setDni(cliente.getDni());
        aux.setId_cliente(id_original);

        clienteRepository.save(aux);


    }
}
