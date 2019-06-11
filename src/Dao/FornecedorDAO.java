package Dao;

import Model.Produto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Control.Conexao;
import Model.Usuario;
import Model.ValorProduto;

public class FornecedorDAO {

    Connection connection = null;

    /*public Produto getIdProduto(Produto produto) {

        System.out.println("Pesquisar Produto");
        // inicia a conexao com o Banco de dados chamando a classe conexao
        connection = Conexao.getInstance().getConnection();
        System.out.println("conectado e preparando para consultar");
        Statement stmt = null;
        try {
            String sql = "SELECT * FROM Produto where nome = " + produto.getNome();
            System.out.println("SQL: " + sql);
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                Produto prod = new Produto(rs.getInt("idProduto"));
                return prod;
            } else {
                return null;
            }
        } catch (SQLException e) {
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
    }*/
    public boolean salvarListaProduto(ValorProduto vProduto) {
        System.out.println("inserir Produto");

        connection = Conexao.getInstance().getConnection();
        System.out.println("conectado e preparando para inserir");
        Statement stmt = null;
        String sql;
        if (vProduto.getCodValorProduto() == 0) {
            sql = "INSERT INTO ValorProduto (idUsuarioFornecedor, idProduto, valorProduto) VALUES (" + vProduto.getCodFornecedor() + "," + vProduto.getProduto().getCodigo() + "," + vProduto.getValorProduto() + ");";
        } else {
            sql = "UPDATE ValorProduto  SET valorProduto=" + vProduto.getValorProduto() + " WHERE idValorProduto=" + vProduto.getCodValorProduto() + ";";
        }

        try {
            stmt = connection.createStatement();
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

    public Usuario getUsuario(String email) {

        connection = Conexao.getInstance().getConnection();
        Statement stmt = null;
        Usuario usuario = new Usuario();
        try {
            System.out.println("buscando id");
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Usuario where email = '" + email + "'");
            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setCep(rs.getInt("cep"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(rs.getString("tipo"));
            }
            return usuario;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return usuario;
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    }
    public Usuario getUsuarioPorID(int idUsuario) {

        connection = Conexao.getInstance().getConnection();
        Statement stmt = null;
        Usuario usuario = new Usuario();
        try {
            System.out.println("buscando id");
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Usuario where idUsuario = " + idUsuario);
            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setCep(rs.getInt("cep"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(rs.getString("tipo"));
            }
            return usuario;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return usuario;
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    }

    public ArrayList<Produto> getListaProduto(String user_login) {
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

        connection = Conexao.getInstance().getConnection();
        System.out.println("conectado e preparando listagem");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *\n"
                    + "FROM Produto\n"
                    + "WHERE idProduto NOT IN (SELECT idProduto\n"
                    + "FROM  ValorProduto VP INNER JOIN Usuario U ON VP.idUsuarioFornecedor=U.idUsuario \n"
                    + "WHERE U.email='" + user_login + "')\n"
                    + "ORDER BY nome");
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

    public ArrayList<ValorProduto> getListaProdutoFornecedor(String user_login) {
        ArrayList<ValorProduto> listaProdutos = new ArrayList<ValorProduto>();

        connection = Conexao.getInstance().getConnection();
        System.out.println("conectado e preparando listagem");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT P.*, VP.*  FROM ValorProduto VP INNER JOIN Usuario U ON VP.idUsuarioFornecedor=U.idUsuario INNER JOIN Produto P ON VP.idProduto=P.idProduto WHERE U.email='" + user_login + "' ORDER BY P.nome");
            while (rs.next()) {
                Produto produto = new Produto(rs.getInt("idProduto"), rs.getString("nome"), rs.getString("peso"));

                ValorProduto vproduto = new ValorProduto(rs.getInt("idValorProduto"), rs.getInt("idUsuarioFornecedor"), produto, rs.getFloat("valorProduto"));
                listaProdutos.add(vproduto);
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

    public boolean excluirProduto(int idValorProduto) {
        System.out.println("excluir Produto");

        connection = Conexao.getInstance().getConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "DELETE FROM ValorProduto WHERE idValorProduto = " + idValorProduto + ";";
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
