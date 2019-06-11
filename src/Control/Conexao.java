package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//public static void main (String Args[]) {
    public class Conexao {

        Connection con = null;
        int port = ;
        String user = "";
        String pass = "";
        private static Conexao instance = null;

        public Conexao() {
            inicio();
        }

        public void inicio() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver Carregado");
            } catch (ClassNotFoundException e) {
                System.out.println("O driver do Mysql não pôde ser carregado!" + e.getMessage());
            }
        }

        public static Conexao getInstance() {
            if (instance == null) {
                instance = new Conexao();
            }
            return instance;
        }

        public Connection getConnection() {
            try {
                if ((con == null) || (con.isClosed())) {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:"+port+"/SISCO", user, pass);
                    System.out.println("Conexão Estabelecida");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return con;
        }

        public void destroy() {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }
