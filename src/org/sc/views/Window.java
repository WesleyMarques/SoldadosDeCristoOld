/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sc.views;


import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


/**
 *
 * @author Wesley
 */
public class Window extends JFrame {
    
    
    //private JPanel mainPanel = new JPanel();
    private ImagePanel mainPanel;
    public static final String BASE_PATH = "/images/";

    /**
     * Creates new form Windowa
     */
    public Window() {
        mainPanel = new ImagePanel(BASE_PATH+"background.png");
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setSize(1000, 600);
        initComponents();
        this.add(mainPanel);
        ImageIcon icone = new ImageIcon(getClass().getResource(BASE_PATH+"escudoIcon.png").getPath());
        this.setIconImage(icone.getImage());
        switchPanels(new Home(this));
    }
    
    public void switchPanels(SwitchablePanel newPanel) {
        mainPanel.removeAll();
        //newPanel.setSize(1000, 600);
        mainPanel.add(newPanel);
        mainPanel.validate();
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Departamento Soldados de Cristo");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setName("frameMain"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1434, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 854, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
