package br.com.marcos.cliente.vendedor.model.repository;

import br.com.marcos.cliente.vendedor.model.entity.ClienteEntity;
import br.com.marcos.cliente.vendedor.model.entity.VendedorEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {

    public ClienteEntity findByCdCl(String cdCl);

    public List<ClienteEntity> findByCdVend(VendedorEntity cdVend);

    @Modifying
    @Query(value = "update clientes i set  i.dsnome = :dsnome, i.idtipo = :idtipo , i.cd_vend = :cd_vend,i.dslim = :dslim where i.cdcl = :cdcl", nativeQuery = true)
    public void updateByCdCl(@Param("cdcl") String cdCl, @Param("dsnome") String dsNome, @Param("idtipo") String idTipo, @Param("cd_vend") String cdVend, @Param("dslim") Double dsLim);

    public void deleteByCdCl(String cdCl);
}
