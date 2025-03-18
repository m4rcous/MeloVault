package melo_vault.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMeloVaultDB {
    public static Connection getConnection() {
        Connection con = null;

        // db url
        var db = "melo_vault_db";
        var url = "jdbc:mysql://localhost:3306/" + db;

        // credentials
        var user = "root";
        var pwd = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pwd);

        } catch (Exception e) {
            System.out.println("Error connecting to data base: " + e.getMessage());
        }

        return con;
    }

    public static void main(String[] args) {
        var con = getConnection();

        if (con != null)
            System.out.println("Connection successful");
        else
            System.out.println("Connection failed");
    }
}
