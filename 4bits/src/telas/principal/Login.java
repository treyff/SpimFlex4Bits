/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.principal;

import Classes.ClassePrincipal;
import Classes.FuncionarioLogado;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

/**
 *
 * @author felip_000
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();

    }
    Conexao c = new Conexao();
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btAcessar = new javax.swing.JButton();

        setTitle("Login SpimFlex");

        jLabel1.setText("Login:");

        jLabel2.setText("Senha:");

        btAcessar.setText("Acessar");
        btAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAcessarActionPerformed(evt);
            }
        });
        btAcessar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btAcessarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btAcessar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btAcessar)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAcessarActionPerformed
        String user = txtLogin.getText();
        String pass = txtSenha.getText();
        String sql = "select * from mydb.funcionario where login='" + user + "' and senha='" + pass + "';";
        Connection conexao = c.Conectar();
        //f.setNivel(0);
        //f.setLogin("");
        //f.setNome("");
        //f.setSenha("");
       
        
        

        try (PreparedStatement stm = conexao.prepareStatement(sql);
                ResultSet rs = stm.executeQuery()) {

            if (rs.next()) {
                
                ClassePrincipal.f.setLogin(rs.getString("LOGIN"));
                ClassePrincipal.f.setSenha(rs.getString("SENHA"));
                ClassePrincipal.f.setNome(rs.getString("NOME"));
                ClassePrincipal.f.setNivel(rs.getInt("ACESSO"));
                
               

                ClassePrincipal.p = new Principal();
            
                
                
                ClassePrincipal.p.LinkNome.setText(ClassePrincipal.f.getNome());

                if (ClassePrincipal.f.getNivel() == 1) {

                    ClassePrincipal.p.AtCadastrarCliente.setVisible(true);
                    ClassePrincipal.p.AtPesquisarClientes.setVisible(true);
                    ClassePrincipal.p.AtPesquisarProduto.setVisible(true);
                    ClassePrincipal.p.SupAtendimento.setVisible(false);

                    ClassePrincipal.p.SupRelLigaçoes.setVisible(false);
                    ClassePrincipal.p.GestCadastroFunc.setVisible(false);
                    ClassePrincipal.p.GestPesqFunc.setVisible(false);
                    ClassePrincipal.p.GestCrtlProdutos.setVisible(false);
                    ClassePrincipal.p.ligações.setVisible(true);

                }
                if (ClassePrincipal.f.getNivel() == 2) {

                    ClassePrincipal.p.AtCadastrarCliente.setVisible(true);
                    ClassePrincipal.p.AtPesquisarClientes.setVisible(true);
                    ClassePrincipal.p.AtPesquisarProduto.setVisible(true);
                    ClassePrincipal.p.SupAtendimento.setVisible(true);
                    ClassePrincipal.p.SupRelLigaçoes.setVisible(true);
                    ClassePrincipal.p.GestCadastroFunc.setVisible(false);
                    ClassePrincipal.p.GestPesqFunc.setVisible(false);
                    ClassePrincipal.p.GestCrtlProdutos.setVisible(false);

                }
                if (ClassePrincipal.f.getNivel() == 3) {
                    ClassePrincipal.p.AtCadastrarCliente.setVisible(true);
                    ClassePrincipal.p.AtPesquisarClientes.setVisible(true);
                    ClassePrincipal.p.AtPesquisarProduto.setVisible(true);
                    ClassePrincipal.p.SupAtendimento.setVisible(true);
                    ClassePrincipal.p.SupRelLigaçoes.setVisible(true);
                    ClassePrincipal.p.GestCadastroFunc.setVisible(true);
                    ClassePrincipal.p.GestPesqFunc.setVisible(true);
                    ClassePrincipal.p.GestCrtlProdutos.setVisible(true);

                }
                if (ClassePrincipal.f.getNivel() == 4) {
                    ClassePrincipal.p.AtCadastrarCliente.setVisible(true);
                    ClassePrincipal.p.AtPesquisarClientes.setVisible(true);
                    ClassePrincipal.p.AtPesquisarProduto.setVisible(true);
                    ClassePrincipal.p.SupAtendimento.setVisible(true);
                    ClassePrincipal.p.SupRelLigaçoes.setVisible(true);
                    ClassePrincipal.p.GestCadastroFunc.setVisible(true);
                    ClassePrincipal.p.GestPesqFunc.setVisible(true);
                    ClassePrincipal.p.GestCrtlProdutos.setVisible(true);

                }
                if (ClassePrincipal.f.getNivel() == 5) {
                    ClassePrincipal.p.AtCadastrarCliente.setVisible(true);
                    ClassePrincipal.p.AtPesquisarClientes.setVisible(true);
                    ClassePrincipal.p.AtPesquisarProduto.setVisible(true);
                    ClassePrincipal.p.SupAtendimento.setVisible(true);
                    ClassePrincipal.p.SupRelLigaçoes.setVisible(true);
                    ClassePrincipal.p.GestCadastroFunc.setVisible(true);
                    ClassePrincipal.p.GestPesqFunc.setVisible(true);
                    ClassePrincipal.p.GestCrtlProdutos.setVisible(true);
                }
                if (ClassePrincipal.f.getNivel() == 6) {
                    ClassePrincipal.p.AtCadastrarCliente.setVisible(true);
                    ClassePrincipal.p.AtPesquisarClientes.setVisible(true);
                    ClassePrincipal.p.AtPesquisarProduto.setVisible(true);
                    ClassePrincipal.p.SupAtendimento.setVisible(true);
                    ClassePrincipal.p.SupRelLigaçoes.setVisible(true);
                    ClassePrincipal.p.GestCadastroFunc.setVisible(true);
                    ClassePrincipal.p.GestPesqFunc.setVisible(true);
                    ClassePrincipal.p.GestCrtlProdutos.setVisible(true);
                }
                if (ClassePrincipal.f.getNivel() == 7) {
                    ClassePrincipal.p.AtCadastrarCliente.setVisible(true);
                    ClassePrincipal.p.AtPesquisarClientes.setVisible(true);
                    ClassePrincipal.p.AtPesquisarProduto.setVisible(true);
                    ClassePrincipal.p.SupAtendimento.setVisible(true);
                    ClassePrincipal.p.SupRelLigaçoes.setVisible(true);
                    ClassePrincipal.p.GestCadastroFunc.setVisible(true);
                    ClassePrincipal.p.GestPesqFunc.setVisible(true);
                    ClassePrincipal.p.GestCrtlProdutos.setVisible(true);
                }
                if (ClassePrincipal.f.getNivel() == 8) {
                    ClassePrincipal.p.AtCadastrarCliente.setVisible(true);
                    ClassePrincipal.p.AtPesquisarClientes.setVisible(true);
                    ClassePrincipal.p.AtPesquisarProduto.setVisible(true);
                    ClassePrincipal.p.SupAtendimento.setVisible(true);
                    ClassePrincipal.p.SupRelLigaçoes.setVisible(true);
                    ClassePrincipal.p.GestCadastroFunc.setVisible(true);
                    ClassePrincipal.p.GestPesqFunc.setVisible(true);
                    ClassePrincipal.p.GestCrtlProdutos.setVisible(true);
                }
                if (ClassePrincipal.f.getNivel() == 9) {
                    ClassePrincipal.p.AtCadastrarCliente.setVisible(true);
                    ClassePrincipal.p.AtPesquisarClientes.setVisible(true);
                    ClassePrincipal.p.AtPesquisarProduto.setVisible(true);
                    ClassePrincipal.p.SupAtendimento.setVisible(true);
                    ClassePrincipal.p.SupRelLigaçoes.setVisible(true);
                    ClassePrincipal.p.GestCadastroFunc.setVisible(true);
                    ClassePrincipal.p.GestPesqFunc.setVisible(true);
                    ClassePrincipal.p.GestCrtlProdutos.setVisible(true);
                }
                ClassePrincipal.p.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Acesso Negado, contate um gerente!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro sql: " + e);
        }

this.dispose();
    }//GEN-LAST:event_btAcessarActionPerformed

    private void btAcessarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btAcessarKeyReleased

    }//GEN-LAST:event_btAcessarKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAcessar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
