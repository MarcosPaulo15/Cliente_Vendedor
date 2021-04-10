package br.com.marcos.cliente.vendedor.model.dao;

public class ClienteDao {
    private String cdCl;

    private String dsNome;

    private String idTipo;

    private String cdVend;

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

    public String getCdVend() {
        return cdVend;
    }

    public void setCdVend(String cdVend) {
        this.cdVend = cdVend;
    }

    public Double getDsLim() {
        return dsLim;
    }

    public void setDsLim(Double dsLim) {
        this.dsLim = dsLim;
    }
}
