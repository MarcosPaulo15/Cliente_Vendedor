package br.com.marcos.cliente.vendedor.model.repository;

import br.com.marcos.cliente.vendedor.model.entity.VendedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorEntity, String> {
    public VendedorEntity findByCdVend(String cdVend);

    @Modifying
    @Query(value = "update vendedores i set  i.dsnome = :dsnome, i.cdtab = :cdtab , i.dtnasc = :dtnasc where i.cdvend = :cdvend", nativeQuery = true)
    public void updateByCdVend(@Param("cdvend") String cdVend, @Param("dsnome") String dsNome, @Param("cdtab") Integer cdTab, @Param("dtnasc") Date dtNasc);

    public void deleteByCdVend(String cdVend);

}
