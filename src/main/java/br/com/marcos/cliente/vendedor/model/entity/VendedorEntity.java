package br.com.marcos.cliente.vendedor.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vendedores")
public class VendedorEntity {

    @Id
    @Column(name = "CDVEND", nullable = false, unique = true,columnDefinition="VARCHAR(36)")
    private String cdVend;

    @Column(name = "DSNOME", columnDefinition="VARCHAR(50)")
    private String dsNome;

    @Column(name = "CDTAB",nullable = false)
    private int cdTab;

    @Column(name = "DTNASC")
    private Date dtNasc;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cdVend")
    private List<ClienteEntity> clientes;

    public String getCdVend() {
        return cdVend;
    }

    public void setCdVend(String cdVend) {
        this.cdVend = cdVend;
    }

    public String getDsNome() {
        return dsNome;
    }

    public void setDsNome(String dsNome) {
        this.dsNome = dsNome;
    }

    public int getCdTab() {
        return cdTab;
    }

    public void setCdTab(int cdTab) {
        this.cdTab = cdTab;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }
}
