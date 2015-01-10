/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molemap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jshickey
 */
class View {

    Presenter presenter;
    // GUI Components that will updated by the model
    JLabel volumeLabel = new JLabel("Volume(I)");
    JButton volumeButton = new JButton("0.0");

    JFrame frame;

    public View() {
        createUI();
    }

    void createUI() {
        Box topBox = Box.createVerticalBox();
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout(0,0));
        volumeLabel.setFont(new java.awt.Font("Lucida Grande", 0, 36));
        topBox.add(volumeLabel);
        volumeButton.setSize(new Dimension());
        //volumeButton.setPreferredSize(new Dimension(600, 50));
        volumeButton.setFont(new java.awt.Font("Lucida Grande", 0, 15));
        topPanel.add(volumeButton);
        volumeButton.addActionListener((ActionEvent e) -> {
            displayVolumeInputDialog();
        });
        topBox.add(topPanel);
        topBox.add(createVolumeFormulaBox());

        // Create Top Level JFrame
        frame = new JFrame("Chemistry Mole Calculator by Camericaware");
        ((JPanel) frame.getContentPane()).setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(topBox, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void setVolumeButtonText(String s) {
        volumeButton.setText(s);
    }

    void displayVolumeInputDialog() {
        String s = (String) JOptionPane.showInputDialog("Enter the new number of Liters");
//                frame,
//                "Enter the new number of Liters",
//                "Liters Input",
//                JOptionPane.QUESTION_MESSAGE);

        if ((s != null) && (s.length() > 0)) {
            presenter.handleLiterButton(s);
            //volumeButton.setText(s);
            // TODO: invoke a method on the presenter to update the view!
            // by passing the value of S into the presenter
        }
        //TODO You should add some validation logic to make sure the
        // user input a valid number.
    }

    Box createVolumeFormulaBox() {
        Box volumeLabelBox = Box.createHorizontalBox();
        volumeLabelBox.add(Box.createGlue());
        volumeLabelBox.add(createVolumeFormulaMultiply());
        volumeLabelBox.add(Box.createGlue());
        volumeLabelBox.add(createVolumeFormulaDivide());
        volumeLabelBox.add(Box.createGlue());
        return volumeLabelBox;
    }

    // Helper Methods for Creating the View

    Box createVolumeFormulaMultiply() {
        Box b = Box.createVerticalBox();
        b.add(new JLabel("^"));
        b.add(new JLabel("*22.4"));
        return b;
    }

    Box createVolumeFormulaDivide() {
        Box b = Box.createVerticalBox();
        b.add(new JLabel("122.4"));
        b.add(new JLabel("V"));
        return b;
    }
}
