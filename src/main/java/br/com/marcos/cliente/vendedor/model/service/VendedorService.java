package br.com.marcos.cliente.vendedor.model.service;

import br.com.marcos.cliente.vendedor.model.entity.VendedorEntity;
import br.com.marcos.cliente.vendedor.model.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Component
public class VendedorService {

    @Autowired
    VendedorRepository vendedorRepository;

    public void criarVendedor(VendedorEntity vendedor){
        vendedorRepository.save(vendedor);
    }

    public VendedorEntity buscarPorCdVend(String cdVend){
       return vendedorRepository.findByCdVend(cdVend);
    }

    public List<VendedorEntity> buscarTodos(){
        return vendedorRepository.findAll();
    }

    @Transactional
    public void editarVendedor(VendedorEntity vendedorEntity){
        Date dataNasc = vendedorEntity.getDtNasc() == null ? new Date() : vendedorEntity.getDtNasc();
        vendedorRepository.updateByCdVend(vendedorEntity.getCdVend(),vendedorEntity.getDsNome(), vendedorEntity.getCdTab(),dataNasc);
    }

    @Transactional
    public void excluirVendedor(String cdVend){
        vendedorRepository.deleteByCdVend(cdVend);
    }

}
