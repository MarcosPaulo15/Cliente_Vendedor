package br.com.marcos.cliente.vendedor.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "clientes")
public class ClienteEntity implements Serializable {

    @Id
    @Column(name = "CDCL", nullable = false, unique = true, columnDefinition = "VARCHAR(36)")
    private String cdCl;

    @Column(name = "DSNOME", columnDefinition="VARCHAR(50)")
    private String dsNome;

    @Column(name = "IDTIPO",columnDefinition="VARCHAR(2) default 'PF'")
    private String idTipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdVend")
    private VendedorEntity cdVend;

    @Column(name="DSLIM",precision=15, scale=2)
    private Double dsLim;

    public String getCdCl() {
        return cdCl;
    }

    public void setCdCl(String cdCl) {
        this.cdCl = cdCl;
    }

    public String getDsNome() {
        return dsNome;
    }

    public void setDsNome(String dsNome) {
        this.dsNome = dsNome;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public VendedorEntity getCdVend() {
        return cdVend;
    }

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public void setCdVend(VendedorEntity cdVend) {
        this.cdVend = cdVend;
    }

    public Double getDsLim() {
        return dsLim;
    }

    public void setDsLim(Double dsLim) {
        this.dsLim = dsLim;
    }
}