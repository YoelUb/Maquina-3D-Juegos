package com.maquina3djuegos.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.component.dependency.CssImport;

@Route("inicio")
@RouteAlias("index.html")
@PageTitle("Inicio | Arcade 3D Juegos")
@CssImport("./styles/arcade-screen.css")
public class InicioView extends VerticalLayout {

    private static final String SESSION_PLAYER = "playerName";

    public InicioView() {
        setSizeFull();
        setMargin(false);
        setPadding(false);
        setSpacing(false);
        addClassName("arcade-background");
        setAlignItems(FlexComponent.Alignment.CENTER);
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        Image cabinet = new Image("frontend/images/arcade-cabinet.png", "Cabinet");
        cabinet.setSizeFull();
        cabinet.getStyle()
                .set("position", "absolute")
                .set("top", "0")
                .set("left", "0")
                .set("z-index", "0");
        add(cabinet);

        Button play = new Button(VaadinIcon.PLAY.create());
        play.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_PRIMARY);
        play.addClassName("play-button");
        play.getElement().getStyle()
                .set("z-index", "1")
                .set("width", "80px")
                .set("height", "80px");
        play.addClickListener(e -> openNameDialog());
        add(play);
    }

    private void openNameDialog() {
        Dialog dlg = new Dialog();
        dlg.setCloseOnEsc(false);
        dlg.setCloseOnOutsideClick(false);

        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(true);
        layout.setSpacing(true);

        TextField nameField = new TextField("Nombre de jugador");
        nameField.setWidth("300px");

        Button ok = new Button("Comenzar", ev -> {
            String name = nameField.getValue().trim();
            if (name.isEmpty()) {
                nameField.setErrorMessage("Debes introducir un nombre");
                nameField.setInvalid(true);
                return;
            }
            VaadinSession.getCurrent().setAttribute(SESSION_PLAYER, name);
            dlg.close();
            UI.getCurrent().navigate("menu");
        });
        ok.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        layout.add(nameField, ok);
        dlg.add(layout);
        dlg.open();
    }
}
