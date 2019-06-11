package Model;

public class ValorProduto {
    private int codValorProduto;
    private Usuario fornecedor;
    private int codFornecedor;
    private Produto produto;
    private float valorProduto;
    
    public ValorProduto(){
        
    }

    public ValorProduto(int codValorProduto,int codFornecedor,Produto produto,float valorProduto) {
        this.codValorProduto=codValorProduto;
        this.codFornecedor=codFornecedor;
        this.produto=produto;
        this.valorProduto=valorProduto;
    }
    
    public int getCodValorProduto() {
        return codValorProduto;
    }

    public void setCodValorProduto(int codValorProduto) {
        this.codValorProduto = codValorProduto;
    }

    public Usuario getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Usuario fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }

    /**
     * @return the codFornecedor
     */
    public int getCodFornecedor() {
        return codFornecedor;
    }

    /**
     * @param codFornecedor the codFornecedor to set
     */
    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    
}
