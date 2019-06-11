package Model;

public class Item {

    private int idItem;
    private int idLista;
    private Produto produto;
    private float valorCotacao;
    private int idUsuarioFornecedor;

    public Item() {

    }

    public Item(int idItem, int idLista, Produto produto, float valorCotacao, int idUsuarioFornecedor) {
        this.idItem = idItem;
        this.idLista = idLista;
        this.produto = produto;
        this.valorCotacao = valorCotacao;
        this.idUsuarioFornecedor = idUsuarioFornecedor;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public float getValorCotacao() {
        return valorCotacao;
    }

    void setValorCotacao(float valorCotacao) {
        this.valorCotacao = valorCotacao;
    }

    public int getIdUsuarioFornecedor() {
        return idUsuarioFornecedor;
    }

    public void setIdUsuarioFornecedor(int idUsuarioFornecedor) {
        this.idUsuarioFornecedor = idUsuarioFornecedor;
    }
}
