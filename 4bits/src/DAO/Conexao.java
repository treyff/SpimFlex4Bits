/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felip_000
 */
public class Conexao {
    public Statement stmt = null;
    public Connection conn = null;
    public ResultSet rs = null;
    private String driverName = "org.gjt.mm.mysql.Driver";
    private String conString = "jdbc:mysql://localhost:3306/mydb";
    private String usuario = "root";
    private String senha = "root";

    public void conexao() {       
        try {
            Class.forName(driverName);
        } 
        catch (ClassNotFoundException ex) {
            
        }
    }
    
    public Connection Conectar(){
        try {
            conn = DriverManager.getConnection(conString, usuario, senha);
        } catch (SQLException ex) {
            
        }
        return conn;
    }
    
}
