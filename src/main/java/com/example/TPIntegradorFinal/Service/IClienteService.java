package com.example.TPIntegradorFinal.Service;

import com.example.TPIntegradorFinal.Model.Cliente;

import java.util.List;

public interface IClienteService {

    ///GET
    public List<Cliente> getALLClientes();

    public Cliente getClienteById(Long id);

    //alta
    public void saveCliente(Cliente cliente);

    //baja
    public void deleteCliente(Long id);

    //modificar
    public void editCliente(Long id, Cliente cliente);
}
