package br.com.marcos.cliente.vendedor.controller;

import br.com.marcos.cliente.vendedor.model.dao.ClienteDao;
import br.com.marcos.cliente.vendedor.model.entity.ClienteEntity;
import br.com.marcos.cliente.vendedor.model.repository.VendedorRepository;
import br.com.marcos.cliente.vendedor.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VendedorRepository vendedorRepository;

    @PostMapping
    @ResponseBody
    public void criarCliente(@RequestBody final ClienteDao clienteDao) {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setCdCl(clienteDao.getCdCl());
        cliente.setCdVend(vendedorRepository.findByCdVend(clienteDao.getCdVend()));
        cliente.setDsLim(clienteDao.getDsLim());
        cliente.setDsNome(clienteDao.getDsNome());
        cliente.setIdTipo(clienteDao.getIdTipo());
        clienteService.criarCliente(cliente);
    }

    @GetMapping("/buscarPorId/{cdCl}")
    public ClienteEntity buscarPorId(@PathVariable String cdCl) {
        return clienteService.buscarPorId(cdCl);
    }

    @GetMapping
    public List < ClienteEntity > buscarTodosClientes() {
        return clienteService.buscarTodos();
    }

    @GetMapping("/buscarPorCodigoVendedor/{codVend}")
    public List < ClienteEntity > buscarPorCodVendedor(@PathVariable String codVend) {
        return clienteService.buscarPorCodVend(codVend);
    }

    @PutMapping
    public void editarCliente(@RequestBody final ClienteDao clienteDao) {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setCdCl(clienteDao.getCdCl());
        cliente.setCdVend(vendedorRepository.findByCdVend(clienteDao.getCdVend()));
        cliente.setDsLim(clienteDao.getDsLim());
        cliente.setDsNome(clienteDao.getDsNome());
        cliente.setIdTipo(clienteDao.getIdTipo());
        clienteService.editarCliente(cliente);
    }

    @DeleteMapping("/{cdCl}")
    public void deletarCliente(@PathVariable String cdCl) {
        clienteService.deletarCliente(cdCl);
    }

}