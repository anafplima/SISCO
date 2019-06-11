package Model;

import java.sql.Date;

public class Lista {

    private int idLista;
    private int idUsuarioCliente;
    private String nomeLista;
    private Date dataCotacao;
    private float totalCotacao;

    public Lista() {
    }

    public Lista(int idLista, int idUsuarioCliente, String nomeLista, Date dataCotacao, float totalCotacao) {
        this.idLista = idLista;
        this.idUsuarioCliente = idUsuarioCliente;
        this.nomeLista = nomeLista;
        this.dataCotacao = dataCotacao;
        this.totalCotacao = totalCotacao;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public int getIdUsuarioCliente() {
        return idUsuarioCliente;
    }

    public void setIdUsuarioCliente(int idUsuarioCliente) {
        this.idUsuarioCliente = idUsuarioCliente;
    }

    public String getNomeLista() {
        return nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    public Date getDataCotacao() {
        return dataCotacao;
    }

    public void setDataCotacao(Date dataCotacao) {
        this.dataCotacao = dataCotacao;
    }

    public float getTotalCotacao() {
        return totalCotacao;
    }

    public void setTotalCotacao(float totalCotacao) {
        this.totalCotacao = totalCotacao;
    }
}
