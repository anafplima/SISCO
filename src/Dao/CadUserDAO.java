package Dao;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.Statement;

import Control.Conexao;


/*import Connection.Conexao;
import model.Funcionario;
import model.Veiculo;*/
public class CadUserDAO {

    public String cadastrarUsuario(Usuario usuario) throws SQLException {
        Connection con = Conexao.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        String mensagem = "Usuário cadastrado com sucesso!";
        int idUsuario = 0;

        try {
            stmt = con.prepareStatement("INSERT INTO Usuario (nome, endereco, cidade, cep, estado, email,  senha, tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEndereco());
            stmt.setString(3, usuario.getCidade());
            stmt.setInt(4, usuario.getCep());
            stmt.setString(5, usuario.getEstado());
            stmt.setString(6, usuario.getEmail());
            stmt.setString(7, usuario.getSenha());
            stmt.setString(8, usuario.getTipo());

            stmt.executeUpdate();
            result = stmt.getGeneratedKeys();
            if (result.next()) {
                idUsuario = result.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("ErroDao ao cadastrar usuário!" + e.getMessage());
            mensagem = "Erro ao cadastrar usuário.";
        } finally {
            //Conexao.closeConnection(con, stmt, result);
            con.close();
        }
        return mensagem;
    }

    public Boolean usuarioJaCadastrado(Usuario usuario) throws SQLException {
        Connection con = Conexao.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet result = null;
        Boolean retorno = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM Usuario WHERE email=?");
            stmt.setString(1, usuario.getEmail());
            result = stmt.executeQuery();
            if (result.first()) {
                retorno = true;
            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Erro ao verificar usuario.");
            System.out.println("Erro ao verificar usuario." + e.getMessage());
        } finally {
            //Conexao.closeConnection(con, stmt, result);
            con.close();
        }
        return retorno;
    }

    /* public void cadastrarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
