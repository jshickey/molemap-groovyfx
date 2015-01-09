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

    void login(String pass) {
        String result = "Incorrect Password";
        if (model.getPassword().equals(pass)) {
            result = "correct password";
        }
        result = gShell.evaluate(pass).toString();
        view.updateStatusLabel(result);
    }
}
