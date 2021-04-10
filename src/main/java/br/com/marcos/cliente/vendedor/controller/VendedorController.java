package br.com.marcos.cliente.vendedor.controller;

import br.com.marcos.cliente.vendedor.model.entity.VendedorEntity;
import br.com.marcos.cliente.vendedor.model.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {
    @Autowired
    private VendedorService vendedorService;

    @PostMapping
    @ResponseBody
    public void criarVendedor(@RequestBody final VendedorEntity vendedorEntity) {
        vendedorService.criarVendedor(vendedorEntity);
    }

    @GetMapping("/buscarPorId/{cdVend}")
    public VendedorEntity buscarVendedorPorCdVend(@PathVariable String cdVend) {
        return vendedorService.buscarPorCdVend(cdVend);
    }

    @GetMapping
    public List < VendedorEntity > buscarListaVendedores() {
        return vendedorService.buscarTodos();
    }

    @DeleteMapping("/{cdVend}")
    public void deletarVendedor(@PathVariable String cdVend) {
        vendedorService.excluirVendedor(cdVend);
    }

    @PutMapping
    public void editarVendedor(@RequestBody final VendedorEntity vendedorEntity) {
        vendedorService.editarVendedor(vendedorEntity);
    }
}