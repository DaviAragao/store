package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao 
{
    final private String Drive = "com.mysql.jdbc.Driver";
    final private String Url = "jdbc:mysql://localhost/db_sistema";
    final private String Usuario = "root";
    final private String Senha = "root";
    
    public Connection Conectar()
    {
        Connection Conn = null;
        try
        {            
            Class.forName(Drive);
            Conn = DriverManager.getConnection(Url, Usuario, Senha);
        }
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return Conn;        
    }
}
