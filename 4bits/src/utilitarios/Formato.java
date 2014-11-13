/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilitarios;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Atanes Family
 */
 public  class Formato {

     public static JFormattedTextField getFormatado(String formato) {
         JFormattedTextField campoFormatado = null;
         MaskFormatter format = new MaskFormatter();

         format.setPlaceholderCharacter('_');
         format.setValueContainsLiteralCharacters(false);

         try {
             format.setMask(formato);
             campoFormatado = new JFormattedTextField(format);
         } catch (ParseException ex) {
         }
         return campoFormatado;
     }

     public static JFormattedTextField getTelefoneFixo() {
         return getFormatado("(##) ####-####");
     }
     public static JFormattedTextField getTelefoneCelular() {
         return getFormatado("(##) #####-####");
     }
     public static JFormattedTextField getCNPJ() {
         return getFormatado("##.###.###/####-##");
     }

     public static JFormattedTextField getCPF() {
         return getFormatado("###.###.###-##");
     }

     public static JFormattedTextField getMoeda() {
         return getFormatado("R$ ##.###,00");
     }
     public static JFormattedTextField getCep() {
         return getFormatado("#####-###");
     }
     public static JFormattedTextField getNAcesso() {
         return getFormatado("#");
     }

 }