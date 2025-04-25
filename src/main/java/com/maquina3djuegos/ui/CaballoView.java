package com.maquina3djuegos.ui;

import com.maquina3djuegos.controller.CaballoController;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.dependency.CssImport;
import org.springframework.beans.factory.annotation.Autowired;

@Route("caballo")
@CssImport("./styles/pico8.css")
public class CaballoView extends VerticalLayout {

    @Autowired
    private CaballoController controller;

    public CaballoView() {
        setClassName("pico8-screen");
        setPadding(true);
        setSpacing(true);

        NumberField xField = new NumberField("X Inicial");
        xField.setMin(0);
        xField.setMax(7);
        xField.setValue(0.0);

        NumberField yField = new NumberField("Y Inicial");
        yField.setMin(0);
        yField.setMax(7);
        yField.setValue(0.0);

        // Primero creamos el TextArea
        TextArea output = new TextArea("Recorrido");
        output.setWidthFull();
        output.setHeight("400px");

        // Ahora el botón puede usar 'output'
        Button btn = new Button("Resolver", e -> {
            int x = xField.getValue().intValue();
            int y = yField.getValue().intValue();
            String salida = controller.ejecutar(x, y);
            output.setValue(salida);
        });

        add(xField, yField, btn, output);
    }
}
