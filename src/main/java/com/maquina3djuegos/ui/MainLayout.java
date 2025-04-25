package com.maquina3djuegos.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

@CssImport("./styles/pico8.css")
public class MainLayout extends AppLayout {

    public MainLayout() {
        // --- Cabecera ---
        H1 title = new H1("Arcade 3D Juegos");
        title.getStyle()
                .set("margin", "0")
                .set("font-size", "1.5rem");
        addToNavbar(title);

        // --- Menú lateral ---
        VerticalLayout menu = new VerticalLayout();
        menu.setPadding(false);
        menu.setSpacing(false);

        RouterLink inicioLink = new RouterLink();
        inicioLink.setRoute(InicioView.class);
        inicioLink.setHighlightCondition(HighlightConditions.sameLocation());
        inicioLink.add(VaadinIcon.HOME.create(), new Span("Inicio"));

        RouterLink reinasLink = new RouterLink();
        reinasLink.setRoute(NReinasView.class);
        reinasLink.add(VaadinIcon.COG.create(), new Span("N Reinas"));

        RouterLink caballoLink = new RouterLink();
        caballoLink.setRoute(CaballoView.class);
        caballoLink.add(VaadinIcon.SITEMAP.create(), new Span("Recorrido Caballo"));

        RouterLink hanoiLink = new RouterLink();
        hanoiLink.setRoute(HanoiView.class);
        hanoiLink.add(VaadinIcon.CUBES.create(), new Span("Torres de Hanoi"));

        menu.add(inicioLink, reinasLink, caballoLink, hanoiLink);
        addToDrawer(menu);
    }
}
