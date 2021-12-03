package dao;

import java.sql.*;

public abstract class ConnectionDAO {
    Connection con; //conexão
    PreparedStatement pst; //declaração preparada
    Statement st; //query/declaração
    ResultSet rs; // resultado retornado

    String database = "bancoMuseu";
    String url = "jdbc:mysql://127.0.0.1:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    String user = "root";
    String password = "123root456";

    public void connectToDB() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão deu certo!");
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        }
    }
}
