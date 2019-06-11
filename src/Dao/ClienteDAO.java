package Dao;

import Control.Conexao;
import Model.Item;
import Model.Lista;
import Model.Produto;
import Model.ValorProduto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO {

    Connection connection = null;

    public int salvarListaCliente(Lista lista) {
        System.out.println("Inserir Lista");

        connection = Conexao.getInstance().getConnection();
        System.out.println("conectado e preparando para inserir");
        Statement stmt = null;
        String sql;
        int idLista = 0;

        try {
            stmt = connection.createStatement();
            if (lista.getIdLista() == 0) {
                sql = "INSERT INTO Lista (idUsuarioCliente, nomeLista) VALUES (" + lista.getIdUsuarioCliente() + ",'" + lista.getNomeLista() + "');";
                System.out.println("SQL: " + sql);
                stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                ResultSet result = stmt.getGeneratedKeys();
                if (result.next()) {
                    idLista = result.getInt(1);
                }
            } else {
                sql = "UPDATE Lista  SET nomeLista='" + lista.getNomeLista() + "', dataCotacao=" + lista.getDataCotacao() + " WHERE idLista=" + lista.getIdLista() + ";";
                System.out.println("SQL: " + sql);
                stmt.executeUpdate(sql);
                idLista = lista.getIdLista();
            }

            return idLista;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return idLista;
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    }

    public boolean salvarItemListaCliente(ArrayList<Item> listItem) {
        System.out.println("Inserir Item");

        connection = Conexao.getInstance().getConnection();

        System.out.println("conectado e preparando para inserir");
        Statement stmt = null;
        String sql;

        try {
            connection.setAutoCommit(false);
            for (Item item : listItem) {
                if (item.getIdItem() == 0) {
                    sql = "INSERT INTO Item (idLista, idProduto) VALUES (" + item.getIdLista() + "," + item.getProduto().getCodigo() + ");";
                } else {
                    sql = "UPDATE Item  SET valorCotacao=" + item.getValorCotacao() + " WHERE idItem=" + item.getIdItem() + ";";
                }
                stmt = connection.createStatement();
                System.out.println("SQL: " + sql);
                stmt.executeUpdate(sql);
            }
            connection.commit();
            // Incluindo produtos na listaProduto que vai ser retornada
            return true;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException er) {
                System.out.println("Erro ao fazer rollback" + er.getMessage());
            }
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                stmt.close();
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }

    }

    public int getUsuario(String email) {

        connection = Conexao.getInstance().getConnection();
        Statement stmt = null;
        int idUsuario = 0;
        try {
            System.out.println("buscando id");
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idUsuario FROM Usuario where email = '" + email + "'");
            if (rs.next()) {
                idUsuario = rs.getInt("idUsuario");
            }
            return idUsuario;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    }

    public boolean gerarCotacao(int idLista) {

        ArrayList<Item> listItem = this.getListaProdutoCliente(idLista);

        System.out.println("Cotar Item");

        connection = Conexao.getInstance().getConnection();

        System.out.println("conectado e preparando para inserir");
        Statement stmt = null;
        String sql;

        try {
            connection.setAutoCommit(false);
            for (Item item : listItem) {

                int idUsuarioFornecedor = 0;
                float valorProduto = 0;

                stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("select idUsuarioFornecedor, min(valorProduto) as valorProduto \n"
                        + "from ValorProduto \n"
                        + "where idProduto=" + item.getProduto().getCodigo() + " \n"
                        + "group by idUsuarioFornecedor \n"
                        + "limit 1");
                if (rs.next()) {
                    idUsuarioFornecedor = rs.getInt("idUsuarioFornecedor");
                    valorProduto = rs.getFloat("valorProduto");

                    sql = "update Item \n"
                            + "set valorCotacao=" + valorProduto + ", \n"
                            + "idUsuarioFornecedor=" + idUsuarioFornecedor + " \n"
                            + "where idItem=" + item.getIdItem() + ";\n";
                    System.out.println("SQL: " + sql);
                    stmt.executeUpdate(sql);

                }
            }

            sql = "update Lista "
                    + "set totalCotacao=(select sum(valorCotacao) from Item where idLista=" + idLista + "), "
                    + "dataCotacao=NOW() where idLista=" + idLista;
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);
            connection.commit();
            // Incluindo produtos na listaProduto que vai ser retornada
            return true;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException er) {
                System.out.println("Erro ao fazer rollback" + er.getMessage());
            }
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                stmt.close();
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    }

    public ArrayList<Lista> getListaCliente(String user_login) {
        ArrayList<Lista> listaProdutos = new ArrayList<Lista>();

        connection = Conexao.getInstance().getConnection();
        System.out.println("conectado e preparando listagem");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * \n"
                    + "FROM Lista L INNER JOIN Usuario U ON L.idUsuarioCliente=U.idUsuario \n"
                    + "WHERE U.email='" + user_login + "' \n"
                    + "ORDER BY nomeLista");
            while (rs.next()) {
                Lista lista = new Lista(rs.getInt("idLista"), rs.getInt("idUsuarioCliente"), rs.getString("nomeLista"), rs.getDate("dataCotacao"), rs.getFloat("totalCotacao"));
                listaProdutos.add(lista);
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

    public ArrayList<Produto> getListaProduto(int idLista) {
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

        connection = Conexao.getInstance().getConnection();
        System.out.println("conectado e preparando listagem");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *\n"
                    + "FROM Produto\n"
                    + "WHERE idProduto NOT IN (SELECT idProduto\n"
                    + "FROM  Item I INNER JOIN Lista L ON I.idLista=L.idLista \n"
                    + "WHERE L.idLista=" + idLista + ")\n"
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

    public ArrayList<Item> getListaProdutoCliente(int idLista) {
        ArrayList<Item> listaProdutos = new ArrayList<Item>();

        connection = Conexao.getInstance().getConnection();
        System.out.println("conectado e preparando listagem");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT P.*, I.*  FROM Item I INNER JOIN Lista L ON I.idLista=L.idLista INNER JOIN Produto P ON I.idProduto=P.idProduto WHERE L.idLista='" + idLista + "' ORDER BY P.nome");
            while (rs.next()) {
                Produto produto = new Produto(rs.getInt("idProduto"), rs.getString("nome"), rs.getString("peso"));

                Item item = new Item(rs.getInt("idItem"), rs.getInt("idLista"), produto, rs.getFloat("valorCotacao"), rs.getInt("idUsuarioFornecedor"));
                listaProdutos.add(item);
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

    public boolean excluirItem(int idItem) {
        System.out.println("excluir Produto");

        connection = Conexao.getInstance().getConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "DELETE FROM Item WHERE idItem = " + idItem + ";";
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

    public boolean excluirLista(int idLista) {
        System.out.println("Excluir Lista");

        connection = Conexao.getInstance().getConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "DELETE FROM Lista WHERE idLista = " + idLista + ";";
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

    public void excluirListaCotacao(Integer valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
