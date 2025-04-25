package com.maquina3djuegos.ui;

import com.maquina3djuegos.controller.NReinasController;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.dependency.CssImport;
import org.springframework.beans.factory.annotation.Autowired;

@Route("nreinas")
@CssImport("./styles/pico8.css")
public class NReinasView extends VerticalLayout {

    @Autowired
    private NReinasController controller;

    public NReinasView() {
        setClassName("pico8-screen");
        setPadding(true);
        setSpacing(true);

        // Campo para el tamaño N (usa Double)
        NumberField nField = new NumberField("Tamaño N");
        nField.setMin(1);
        nField.setValue(8.0);

        TextArea output = new TextArea("Tablero");
        output.setWidthFull();
        output.setHeight("400px");

        // Botón que ya puede usar 'output'
        Button btn = new Button("Resolver", e -> {
            int n = nField.getValue().intValue();
            String salida = controller.ejecutar(n);
            output.setValue(salida);
        });

        add(nField, btn, output);
    }
}
