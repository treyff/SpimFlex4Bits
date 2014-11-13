/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Classes.ClassePrincipal;
import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Atanes
 */
public class ClienteDAO {

    DB acesso;

    public void inserirClientePF(
            
            String nome,
            String email,
            String senha,
            String fone1,
            String cel
    ) throws ParseException {
      
        acesso = new DB();
        String cliente = ("INSERT INTO cliente(NOME,EMAIL,SENHA,FONE1,CEL,ENDERECO_END_ID) VALUES"
         + "('" + nome + "','" + email + "','" + senha + "','"+ fone1 + "','"+ cel +"',(select max(END_ID) from endereco));");
        
        try {
            acesso.getStmt().executeUpdate(cliente);
            //pmst = acesso.PrepareStatement(cliente, Statement.RETURN_GENERATED_KEYS);
            //pmst.execute();
        } catch (SQLException e) {
            //acesso.show("Erro SQL :" + e.getMessage());
            System.out.println("Erro: " + e.getMessage());
        }
        
        
    }
    
   
    
    
    
    
    public void alterarCliente(
            
            String nome,
            String email,
            String senha,
            String fone1,
            String cel
           ) 
    throws ParseException {
      
        {
        acesso = new DB();
        int id =   ClassePrincipal.c.getCliente_id();
        String cmdSQL = "UPDATE cliente SET Nome='" + nome + "',fone1='" + fone1 + "',CEL='" + cel + "',email='"
                + email + "',senha='" + senha+ "'where CLIENTE_ID = "+id;
        try {
            acesso.getStmt().executeUpdate(cmdSQL);
        } catch (SQLException e) {
            acesso.show("Erro SQL :" + e.getMessage());
            System.out.println("Erro SQL: " + e.getMessage());
        }
        acesso.fechaConexao();
    }}
    
   
    
    
    
    
    public void excluir(int cod_Cliente) {
        acesso = new DB();
        String cmdSQL = "DELETE FROM cliente WHERE codigo = " + cod_Cliente +";";
        try {
            acesso.getStmt().executeUpdate(cmdSQL);
        } catch (SQLException e) {
            acesso.show("Erro SQL :" + e.getMessage());
        }
        acesso.fechaConexao();
    }

    
    
    
    
    
    
    

    
    
    
    public ResultSet retornaDados(String buscaNome) {
        acesso = new DB();
        String cmdSQL = "SELECT * FROM cliente WHERE nome like '%" + buscaNome + "%';";
        ResultSet resultado = null;
        try {
            resultado = acesso.getStmt().executeQuery(cmdSQL);
        } catch (SQLException e) {
            acesso.show("Erro SQL :" + e.getMessage());
        }
       
        return resultado;

    }

    public ResultSet retornaDados(int codigo) {
        acesso = new DB();
        String cmdSQL = "SELECT * FROM cliente WHERE codigo = " + codigo+ ";";
        ResultSet resultado = null;
        try {
            resultado = acesso.getStmt().executeQuery(cmdSQL);
        } catch (SQLException e) {
            acesso.show("Erro SQL :" + e.getMessage());
        }
        return resultado;
    }

    public ResultSet retornaDados() {
        acesso = new DB();
        String cmdSQL = "SELECT * FROM cliente";
        ResultSet resultado = null;
        try {
            resultado = acesso.getStmt().executeQuery(cmdSQL);
        } catch (SQLException e) {
            acesso.show("Erro SQL :" + e.getMessage());
        }
        return resultado;
    }
    public void fechaConexao(){
        acesso.fechaConexao();
    }

   
}
