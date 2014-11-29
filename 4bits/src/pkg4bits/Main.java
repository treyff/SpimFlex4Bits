/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg4bits;

import Classes.Cliente;
import Classes.Endereco;
import Classes.FuncionarioLogado;
import Classes.Produto;
import telas.atendimento.Ligações;
import telas.atendimento.PesquisarClientes;
import telas.principal.Login;
import telas.principal.Principal;
import telas.supervisao.AlterarCliente;

/**
 *
 * @author User
 */
public class Main {

   public static FuncionarioLogado f = new FuncionarioLogado();
 public static Principal p = new Principal();
 public static Cliente c = new Cliente();
 public static Produto o = new Produto();
 public static AlterarCliente alt = new AlterarCliente();
 public static Endereco e = new Endereco();
 public static PesquisarClientes pesC = new PesquisarClientes();
 public static Ligações a = new Ligações();
    public static void main(String[] args) {
          try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }   
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        Login l = new Login();
        l.setVisible(true);
        
    }
    }
    

