/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package molemap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jshickey
 */
class View {
    Presenter presenter;
    JLabel statusLabel;
    JTextField inputField;
    JFrame frame;
    
    public View() {
        createUI();
    }
    
    void createUI() {
        statusLabel =  new JLabel("This is a label that will update:");
        inputField = new JTextField(20);
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener((ActionEvent e) -> {
            presenter.login(inputField.getText());
        });
        Box topBox = Box.createHorizontalBox();
        topBox.add(statusLabel);
        topBox.add(Box.createHorizontalStrut(5));
        topBox.add(inputField);
        topBox.add(Box.createHorizontalStrut(5));
        topBox.add(loginButton);
        
        frame = new JFrame("Passive MVP Swing");
        ((JPanel)frame.getContentPane()).setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(topBox, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);       
    }
    
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
    
    public void updateStatusLabel(String text) {
        statusLabel.setText(text);
    }
}
