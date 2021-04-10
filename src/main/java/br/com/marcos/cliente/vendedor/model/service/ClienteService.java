package br.com.marcos.cliente.vendedor.model.service;

import br.com.marcos.cliente.vendedor.model.entity.ClienteEntity;
import br.com.marcos.cliente.vendedor.model.entity.VendedorEntity;
import br.com.marcos.cliente.vendedor.model.repository.ClienteRepository;
import br.com.marcos.cliente.vendedor.model.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    VendedorRepository vendedorRepository;

    public void criarCliente(ClienteEntity cliente){
        clienteRepository.save(cliente);
    }

    public ClienteEntity buscarPorId(String cdCl){
        return clienteRepository.findByCdCl(cdCl);
    }

    public List<ClienteEntity> buscarTodos(){
        return clienteRepository.findAll();
    }

    public List<ClienteEntity> buscarPorCodVend(String cdVend){
        return clienteRepository.findByCdVend(vendedorRepository.findByCdVend(cdVend));
    }

    @Transactional
    public void editarCliente(ClienteEntity cliente){
        clienteRepository.updateByCdCl(cliente.getCdCl(),cliente.getDsNome(),cliente.getIdTipo(),cliente.getCdVend().getCdVend(),cliente.getDsLim());
    }

    @Transactional
    public void deletarCliente(String cdCl){
        clienteRepository.deleteByCdCl(cdCl);
    }
}
