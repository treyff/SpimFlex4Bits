/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import DAO.Conexao;
import DAO.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author felip_000
 */
public class FuncionarioLogado {
    String nome;
    String login;
    int nivel;
    String Senha;
    DB acesso;

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    

    public void logarFuncionario(String login, String senha) {
        
        
        FuncionarioLogado funcionario;
        Conexao c = new Conexao();
        try{
            
            Connection conn = c.Conectar();
            Statement stmt;
            ResultSet rs;
            
            String loginsystem = "select * from funcionario where login = "+login+" and senha = "+senha+";";
            
            
            c.stmt = c.conn.createStatement();
            
            stmt = conn.prepareStatement(loginsystem);
            rs = stmt.executeQuery(loginsystem);
            
            while(rs.next()){                
                funcionario = new FuncionarioLogado();
                funcionario.setLogin(rs.getString("LOGIN"));
                funcionario.setSenha(rs.getString("SENHA"));
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setNivel(rs.getInt("ACESSO"));

            }

            // AQUI É RETORNADO O FUNCIONÁRIO
            // SE ENCONTROU, VAI RETORNAR DADOS, SE NÃO IRÁ RETORNAR NULL
            
        }

        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
