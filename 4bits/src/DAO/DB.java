/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Atanes Family
 */
public class DB {

    private Statement stmt = null;
    private Connection conn = null;
    public ResultSet rs = null;
    private String driverName = "org.gjt.mm.mysql.Driver";
    private String conString = "jdbc:mysql://localhost:3306/mydb";
    private String usuario = "root";
    private String senha = "root";

    public DB() {
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(conString, usuario, senha);
            stmt = conn.createStatement();

        } catch (SQLException e) {
            show("Erro SQL: " + e.getMessage());
        } catch (ClassNotFoundException ce) {
            show("Classe não foi encontrada: " + ce.getMessage());
        }
    }

    public Statement getStmt() {
        return stmt;
    }

    public final void show(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void fechaConexao() {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            show(ex.getMessage());
        }

    }

}
