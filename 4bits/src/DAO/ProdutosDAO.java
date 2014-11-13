/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Atanes
 */
public class ProdutosDAO {

    DB acesso;

    public void inserirEndereco(
            
            String nome,
            
            String modelo,
            String material,
            String especificacoes,
            String fotos,
            String valor
            
            
    ) throws ParseException {
      
        acesso = new DB();
        
        //Código SQL teste
        
        
            String endereco = ("INSERT INTO produto(NOME,MODELO,MATERIAL,ESPECIFICACOES,FOTOS,VALOR) VALUES"
         + "('" + nome + "','" + modelo + "','" + material + "','"+ especificacoes + "','"+ fotos +"','"+ valor +"');");
        
        try {
            acesso.getStmt().executeUpdate(endereco);
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            acesso.show("Erro SQL :" + e.getMessage());
            System.out.println("Erro: " + e.getMessage());
        }
        acesso.fechaConexao();
    }

    
    public void alterar(
            
            String nome,
            String email,
            String senha,
            String fone1,
            String fone2,
            String fone3,
            String cpf
           ) 
    throws ParseException {
      
        acesso = new DB();
        java.util.Date DataNascFr = null;
        String DataNascDb = null;
        

        //DataNascFr = (java.util.Date) new SimpleDateFormat("dd/MM/yyyy").parse(DNasc);
        DataNascDb = new SimpleDateFormat("yyyy-MM-dd").format(DataNascFr);

    {
        acesso = new DB();
        String cmdSQL = "UPDATE contatos SET Nome='" + nome + "',fone1='" + fone1 + "',fone2='" + fone2 + "',fone3='" + fone3 + "',email='"
                + email + "',datanasc='" + DataNascDb;
        try {
            acesso.getStmt().executeUpdate(cmdSQL);
        } catch (SQLException e) {
            acesso.show("Erro SQL :" + e.getMessage());
        }
        acesso.fechaConexao();
    }}
    
    
    
    
    
    
    
    
    
    
    

    public void excluir(int cod_Cliente) {
        acesso = new DB();
        String cmdSQL = "DELETE FROM contatos WHERE codigo = " + cod_Cliente;
        try {
            acesso.getStmt().executeUpdate(cmdSQL);
        } catch (SQLException e) {
            acesso.show("Erro SQL :" + e.getMessage());
        }
        acesso.fechaConexao();
    }

    public ResultSet retornaDados(String buscaNome) {
        acesso = new DB();
        String cmdSQL = "SELECT * FROM contatos WHERE nome like '%" + buscaNome + "%'";
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
        String cmdSQL = "SELECT * FROM Clientes WHERE codigo = " + codigo;
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
        String cmdSQL = "SELECT * FROM Clientes";
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

    public void inserir(String nome, String email, String senha, String fone1, String fone2, String fone3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
