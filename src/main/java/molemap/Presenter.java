/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molemap;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

/**
 *
 * @author jshickey
 */
class Presenter {

    View view;
    Model model;
    Binding binding = new Binding();
    GroovyShell gShell;

    Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
        binding.setVariable("presenter", this);
        binding.setVariable("view", view);
        binding.setVariable("model", model);
        gShell = new GroovyShell(binding);
    }

    public void handleLiterButton(String liters) {
       // update model
       model.setLiters(Double.valueOf(liters));
        
       // update view
       view.setVolumeButtonText(liters);
    }
}
