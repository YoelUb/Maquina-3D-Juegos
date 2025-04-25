package com.maquina3djuegos.controller;

import com.vaadin.flow.component.UI;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    public void navegar(String ruta) {
        if (ruta == null || ruta.isEmpty() || ruta.equalsIgnoreCase("index")) {
            UI.getCurrent().navigate("");
        } else {
            UI.getCurrent().navigate(ruta);
        }
    }

}
