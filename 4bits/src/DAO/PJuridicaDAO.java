/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author felip_000
 */
public class PJuridicaDAO {
    DB acesso;

    public void inserirPJuridica(

            String cnpj,
            String responsavel,
            String razao_social)
            
throws ParseException, SQLException {
      
        acesso = new DB();
        
       
        String fisica = ("INSERT INTO fisica(CPF,DATA_NASC,CLIENTE_CLIENTE_ID) VALUES"
         + "('" + cnpj + "','" + responsavel +"',(select max(CLIENTE_ID) from cliente));");
         
try {
            acesso.getStmt().executeUpdate(fisica);
            JOptionPane.showMessageDialog(null, "Cadastro fisico efetuado com sucesso!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            acesso.show("Erro SQL :" + e.getMessage());
            System.out.println("Erro: " + e.getMessage());
        }
        acesso.fechaConexao();
    }}