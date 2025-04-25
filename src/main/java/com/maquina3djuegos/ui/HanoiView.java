package com.maquina3djuegos.ui;

import com.maquina3djuegos.controller.HanoiController;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.dependency.CssImport;
import org.springframework.beans.factory.annotation.Autowired;

@Route("hanoi")
@CssImport("./styles/pico8.css")
public class HanoiView extends VerticalLayout {

    @Autowired
    private HanoiController controller;

    public HanoiView() {
        setClassName("pico8-screen");
        setPadding(true);
        setSpacing(true);

        NumberField discos = new NumberField("Discos");
        discos.setMin(1);
        discos.setValue(3.0);

        // Primero creamos el TextArea
        TextArea output = new TextArea("Movimientos");
        output.setWidthFull();
        output.setHeight("400px");

        // Luego el botón, que ya puede usar 'output'
        Button btn = new Button("Resolver", e -> {
            int d = discos.getValue().intValue();
            String pasos = controller.ejecutar(d);
            output.setValue(pasos);
        });

        add(discos, btn, output);
    }
}
