/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Amigo;
import Model.Emprestimo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josep
 */
public class GerenciarAmigos extends javax.swing.JFrame {
    
    private Amigo objetoAmigo;
    private Emprestimo objetoEmprestimo;
    /**
     * Creates new form GerenciarAmigos
     */
    public GerenciarAmigos() {
        initComponents();
        TelaPrincipal.CarregarIcone(this);
        this.objetoAmigo = new Amigo();
        this.objetoEmprestimo = new Emprestimo();
        this.carregarTabela();
        this.jTableGerenciarAmigos.setAutoCreateRowSorter(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGerenciarAmigos = new javax.swing.JTable();
        textNome1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textEmail1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textTelefone1 = new javax.swing.JTextField();
        b_cancelar1 = new javax.swing.JButton();
        b_alterar1 = new javax.swing.JButton();
        b_apagar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ToolShare");

        jTableGerenciarAmigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "E-mail", "Telefone", "Empréstimos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableGerenciarAmigos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGerenciarAmigosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableGerenciarAmigos);
        if (jTableGerenciarAmigos.getColumnModel().getColumnCount() > 0) {
            jTableGerenciarAmigos.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        textNome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNome1ActionPerformed(evt);
            }
        });

        jLabel4.setText("E-mail:");

        jLabel5.setText("Telefone:");

        b_cancelar1.setText("Cancelar");
        b_cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelar1ActionPerformed(evt);
            }
        });

        b_alterar1.setText("Alterar");
        b_alterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_alterar1ActionPerformed(evt);
            }
        });

        b_apagar1.setText("Apagar");
        b_apagar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_apagar1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Nome:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b_cancelar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_alterar1)
                        .addGap(18, 18, 18)
                        .addComponent(b_apagar1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textEmail1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(textTelefone1)
                            .addComponent(textNome1, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancelar1)
                    .addComponent(b_alterar1)
                    .addComponent(b_apagar1))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(725, 462));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textNome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNome1ActionPerformed

    private void b_cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelar1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_b_cancelar1ActionPerformed

    private void b_alterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_alterar1ActionPerformed
        // TODO add your handling code here:
        int id = 0;
        String nome = "";
        String telefone = "";
        String email = "";
        
        try{
            
            if (this.jTableGerenciarAmigos.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro Selecione um amigo para alterar");
            } else {
                id = Integer.parseInt(this.jTableGerenciarAmigos.getValueAt(this.jTableGerenciarAmigos.getSelectedRow(), 0).toString());
            }             
            

            if (this.textNome1.getText().length() < 2) {
                throw new Mensagens ("Nome muito curto");
            } else {
                nome = this.textNome1.getText();
            }

            for (char c : nome.toCharArray())
            {
                if (Character.isDigit(c))
                {
                    throw new Mensagens("Nome deve conter apenas letras");
                }
            }

            if (this.textTelefone1.getText().length() < 8) {       
                throw new Mensagens("Telefone deve conter ao menos 8 caracteres.");
            }          
            else {
                telefone = this.textTelefone1.getText();
            }

            for (char c : telefone.toCharArray())
            {
                if (!Character.isDigit(c))
                {
                    telefone = "";
                    throw new Mensagens("O telefone so deve conter numeros");                    
                }
            }

            if (this.textEmail1.getText().length() < 5) {
                throw new Mensagens("Email muito curto");
            }
            else {
                email = this.textEmail1.getText();
            }
            if (!email.contains("@")) {
               email = "";
               throw new Mensagens("Digite um email valido");                  
            }
            
            System.out.println(id + nome + email  + telefone);
            
            if (this.objetoAmigo.UpdateAmigoBD(id, nome, email, telefone)) {
                this.textNome1.setText(""); 
                this.textEmail1.setText(""); 
                this.textTelefone1.setText("");
                JOptionPane.showMessageDialog(rootPane, "Amigo alterado com sucesso! ");               
            }
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        } finally {
            carregarTabela();
        }   
    }//GEN-LAST:event_b_alterar1ActionPerformed

    private void b_apagar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_apagar1ActionPerformed
        // TODO add your handling code here:
        try {
            int id = 0;
            
            if (this.jTableGerenciarAmigos.getSelectedRow() == -1) {
                throw new Mensagens("Selecione um amigo para apagar");
            } else {
                id = Integer.parseInt(this.jTableGerenciarAmigos.getValueAt(this.jTableGerenciarAmigos.getSelectedRow(), 0).toString());
            }
            
            //int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar esse amigo? ");
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja apagar esse amigo?", "Selecione uma opção", WIDTH);
            
            if (resposta == 0) {
                if (this.objetoEmprestimo.setAmigoIdToNull(id) && this.objetoAmigo.DeleteAmigoBD(id)) {
                    this.textEmail1.setText("");
                    this.textNome1.setText("");
                    this.textTelefone1.setText("");
                    
                    JOptionPane.showMessageDialog(rootPane, "Amigo apagado com sucesso!");
                }
            }
                
        } catch(Mensagens e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        } finally {
            carregarTabela();
        }
    }//GEN-LAST:event_b_apagar1ActionPerformed

    private void jTableGerenciarAmigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGerenciarAmigosMouseClicked
        // TODO add your handling code here:
        if (this.jTableGerenciarAmigos.getSelectedRow() != -1) {

            String nome = this.jTableGerenciarAmigos.getValueAt(this.jTableGerenciarAmigos.getSelectedRow(), 1).toString();
            String telefone = this.jTableGerenciarAmigos.getValueAt(this.jTableGerenciarAmigos.getSelectedRow(), 2).toString();
            String email = this.jTableGerenciarAmigos.getValueAt(this.jTableGerenciarAmigos.getSelectedRow(), 3).toString();
            

            this.textNome1.setText(nome);
            this.textTelefone1.setText(email);
            this.textEmail1.setText(telefone);

        }        
    }//GEN-LAST:event_jTableGerenciarAmigosMouseClicked
   
    @SuppressWarnings("unchecked")
    public void carregarTabela() {
        
        DefaultTableModel model = (DefaultTableModel) this.jTableGerenciarAmigos.getModel();
        model.setNumRows(0);
        
        ArrayList<Amigo> lista = new ArrayList<>();
        
        lista = objetoAmigo.getMinhaLista();
        System.out.println(lista);
        for (Amigo amigo : lista) {
            model.addRow(new Object[]{
                amigo.getId(),
                amigo.getNome(),
                amigo.getEmail(),
                amigo.getTelefone(),
                amigo.getTotalEmp()

            });
        }  
    }
    
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
            java.util.logging.Logger.getLogger(GerenciarAmigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciarAmigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciarAmigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciarAmigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarAmigos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_alterar1;
    private javax.swing.JButton b_apagar1;
    private javax.swing.JButton b_cancelar1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGerenciarAmigos;
    private javax.swing.JTextField textEmail1;
    private javax.swing.JTextField textNome1;
    private javax.swing.JTextField textTelefone1;
    // End of variables declaration//GEN-END:variables
}
