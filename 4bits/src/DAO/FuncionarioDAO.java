/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Classes.FuncionarioLogado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author felip_000
 */
public class FuncionarioDAO {
    
    DB acesso;

    public void inserirFuncionario(
            
            String nome,
            String email,
            String usuario,
            String senha,
            String fone1,
            String fone2,
            
            String cpf,
            String data_nasc,
            
            int nivel
           
            
            
           

    
    ) throws ParseException {
      
        acesso = new DB();
        
        //Código SQL teste
        //idend = retornoDoID.get(1); //Pronto você tem o ID inserido nesse insert.
        
        
        String cliente = ("INSERT INTO funcionario(NOME,EMAIL,LOGIN,SENHA,FONE1,CEL,CPF,DATA_NASC,ACESSO,ENDERECO_END_ID) VALUES"
         + "('" + nome + "','" + email + "','" + usuario +"','" + senha + "','"+ fone1 + "','"+ fone2 +"','"+ cpf + "','"+ data_nasc + "','"+ nivel +"',(select max(END_ID) from endereco));");
        
        
        
        try {
            acesso.getStmt().executeUpdate(cliente);
            //pmst = acesso.PrepareStatement(cliente, Statement.RETURN_GENERATED_KEYS);
            //pmst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro de funcionario efetuado com sucesso!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            acesso.show("Erro SQL :" + e.getMessage());
            System.out.println("Erro: " + e.getMessage());
        }
    }



        
}




        
  
    
