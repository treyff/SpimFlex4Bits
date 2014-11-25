/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Classes.ClassePrincipal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Atanes
 */
public class EnderecosDAO {

    DB acesso;

    public void inserirEndereco(
            
            String rua,
            int numero,
            String complemento,
            String bairro,
            String cidade,
            String uf,
            String cep
            
    ) throws ParseException {
      
        acesso = new DB();
        
        
        //Código SQL teste
        
        
        String endereco = ("INSERT INTO endereco(RUA,NUMERO,COMPLEMENTO,BAIRRO,CIDADE,UF,CEP) VALUES"
         + "('" + rua + "','" + numero + "','" + complemento + "','"+ bairro + "','"+ cidade +"','"+ uf +"','"+ cep +"');");
        
        try {
           // PreparedStatement pmst = acesso.PrepareStatement(endereco, Statement.RETURN_GENERATED_KEYS);
            acesso.getStmt().executeUpdate(endereco);
            
        } catch (SQLException e) {
            acesso.show("Erro SQL :" + e.getMessage());
            System.out.println("Erro: " + e.getMessage());
        }
        acesso.fechaConexao();
    }

    
    public void alterarEndereco(
            
            String rua,
            int numero,
            String complemento,
            String bairro,
            String cidade,
            String uf,
            String cep
           ) 
    throws ParseException {
      
    { int id =   ClassePrincipal.e.getId_end();
        acesso = new DB();
        String cmdSQL = "UPDATE endereco SET RUA='" + rua + "',NUMERO='" + numero + "',COMPLEMENTO='" + complemento +"',CEP='" + cep + "',BAIRRO='" + bairro + "',CIDADE='"
                + cidade + "',UF='" + uf+"' where CLIENTE_ID = "+id;
        try {
            acesso.getStmt().executeUpdate(cmdSQL);
        } catch (SQLException e) {
            acesso.show("Erro SQL :" + e.getMessage());
        }
        acesso.fechaConexao();
    }}
    
    
    
    
    
    
    
    
    
    
    

    public void excluir(int cod_Cliente) {
        acesso = new DB();
        String cmdSQL = "DELETE FROM endereco WHERE END_ID = " + cod_Cliente;
        try {
            acesso.getStmt().executeUpdate(cmdSQL);
        } catch (SQLException e) {
            acesso.show("Erro SQL :" + e.getMessage());
        }
        acesso.fechaConexao();
    }

    

//    public ResultSet retornaDados(int criterio) {
//        acesso = new DB();
//        String cmdSQL = "SELECT * FROM endereco WHERE ENDERECO_ID = " + criterio + ";";
//        ResultSet resultado = null;
//        try {
//            resultado = acesso.getStmt().executeQuery(cmdSQL);
//        } catch (SQLException e) {
//            acesso.show("Erro SQL :" + e.getMessage());
//        }
//        return resultado;
//    }
    public void fechaConexao(){
        acesso.fechaConexao();
    }
    

    public void inserir(String nome, String email, String senha, String fone1, String fone2, String fone3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
