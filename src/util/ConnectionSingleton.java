package util;

import java.nio.channels.ScatteringByteChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
    private static ConnectionSingleton instance;
    public Connection conexao = null;

    private ConnectionSingleton() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/roland_hotel?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "root";
        this.conexao = DriverManager.getConnection(url, user, password);
    }

    public static ConnectionSingleton getInstance() throws SQLException {
        if(instance == null || instance.conexao.isClosed()){
            instance = new ConnectionSingleton();
            //System.out.println(">> Conecção iniciada");
        } else {
            //System.out.println(">> Conecção reestabelecida");
        }
        return instance;
    }

}
