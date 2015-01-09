/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package molemap;

import javax.swing.SwingUtilities;

/**
 *
 * @author jshickey
 */
public class Main {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            View view = new View();
            view.setPresenter(new Presenter(view, new Model()));
        });
    }
    
}
