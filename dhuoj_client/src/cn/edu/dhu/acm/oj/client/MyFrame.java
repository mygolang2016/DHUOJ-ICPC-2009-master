package cn.edu.dhu.acm.oj.client;

import javax.swing.JOptionPane;

public class MyFrame extends javax.swing.JFrame {

    public void newDialog(javax.swing.JDialog dialog, javax.swing.JPanel p, String title) {
        dialog.setAlwaysOnTop(true);
        dialog.setTitle(title);
        dialog.add(p);
        dialog.pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = dialog.getSize();
        dialog.setLocation((screenSize.width - dialogSize.width) / 2, (screenSize.height - dialogSize.height) / 2);
        dialog.setVisible(true);
    }

    public void smallDialog(final String str, final String title, int model) {
        //javax.swing.JDialog dialog = new javax.swing.JDialog();
        //MessagePanel dlg = new MessagePanel(dialog,str);
        //newDialog(dialog, dlg, title);
        new Thread() {
            public void run() {
                JOptionPane.showMessageDialog(MyFrame.this, str, title, JOptionPane.INFORMATION_MESSAGE);
            }
        }.start();
    }
}
