package Dao;

import Model.Produto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Control.Conexao;

public class ProdutoDAO
{

    Connection connection = null;

    public Produto getProduto() {
        System.out.println("Pesquisar Produto");
        // inicia a conexao com o Banco de dados chamando a classe conexao
        connection = Conexao.getInstance().getConnection();
        System.out.println("conectado e preparando para consultar");
        Statement stmt = null;
        try {
            String sql = "SELECT * FROM Produto ";
            System.out.println("SQL: " + sql);
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
         
            if (rs.next()) {
               Produto produto = new Produto(rs.getInt("idProduto"), rs.getString("nome"), rs.getString("peso"));
               return produto;
            } else {
               return null;
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            // este bloco finally sempre executa na instrução try para fechar a conexão a cada conexão aberta
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    } 
    
    public boolean inserirProduto(Produto produto) {
        System.out.println("inserir Produto");
        
        connection = Conexao.getInstance().getConnection();
        System.out.println("conectado e preparando para inserir");
        Statement stmt = null;
        try {    
            stmt = connection.createStatement();

            String sql = "INSERT INTO Produto (idProduto, nome, peso) VALUES (" + produto.getCodigo() + ",'" + produto.getNome() +"','" + produto.getPeso() + "');";
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);
            // Incluindo produtos na listaProduto que vai ser retornada
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    }

    public boolean atualizarProduto(Produto produto) {
        System.out.println("atualizar Produto");

        connection = Conexao.getInstance().getConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();

            String sql = "UPDATE Produto SET nome = '" + produto.getNome() + "', quantidade = '" + produto.getQuantidade() + "', marca = '" + produto.getMarca() + "', descricao = '" + produto.getDescricao() + "', preco = '" + produto.getPreco() + "', peso = '" + produto.getPeso() + "' WHERE codigo = " + produto.getCodigo() + ";";
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    } 

    public ArrayList<Produto> getListaProduto() {
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
      
        connection = Conexao.getInstance().getConnection();
        System.out.println("conectado e preparando listagem");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Produto ORDER BY nome");
            while (rs.next()) {
                Produto produto = new Produto(rs.getInt("idProduto"), rs.getString("nome"), rs.getString("peso"));
                listaProdutos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
        return listaProdutos;
    } 

    public boolean excluirProduto(Produto produto) {
        System.out.println("excluir Produto");

        connection = Conexao.getInstance().getConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "DELETE FROM Produto WHERE idProduto = " + produto.getCodigo() + ";";
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    }
}