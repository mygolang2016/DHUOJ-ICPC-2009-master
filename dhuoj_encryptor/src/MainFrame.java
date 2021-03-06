/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import cn.edu.dhu.acm.oj.common.paperdistribute.*;
import java.io.*;

/*
 * MainFrame.java
 *
 * Created on 2009-9-1, 9:03:46
 */

/**
 *
 * @author Sun Cihai
 */
public class MainFrame extends javax.swing.JFrame {

    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        JTF_Password = new javax.swing.JTextField();
        JB_Encrypt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        jLabel1.setText("Password:");
        jToolBar1.add(jLabel1);
        jToolBar1.add(JTF_Password);

        JB_Encrypt.setText("Encrypt");
        JB_Encrypt.setFocusable(false);
        JB_Encrypt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JB_Encrypt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        JB_Encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_EncryptActionPerformed(evt);
            }
        });
        jToolBar1.add(JB_Encrypt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void JB_EncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_EncryptActionPerformed
		String pwd = JTF_Password.getText();
		if(pwd.equals("")){
			JTF_Password.setText("Enter your password first!!!");
			return;
		}
		javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
		if (chooser.showOpenDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION) {
			try {
				String fileName = chooser.getSelectedFile().getPath();
				File file = new File(fileName);
				File fileDir = file.getParentFile();
				System.out.println(fileDir);
				PaperDistributor.distributePaper(file, fileDir, JTF_Password.getText());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
}//GEN-LAST:event_JB_EncryptActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Encrypt;
    private javax.swing.JTextField JTF_Password;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
