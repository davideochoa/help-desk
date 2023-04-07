package com.helpdesk.application.app.web;

import com.helpdesk.application.app.data.entity.UsuarioSoporteEntity;
import com.helpdesk.application.components.appnav.AppNav;
import com.helpdesk.application.components.appnav.AppNavItem;
import com.helpdesk.application.security.AuthenticatedUser;
import com.helpdesk.application.views.about.AboutView;
import com.helpdesk.application.views.cardlist.CardListView;
import com.helpdesk.application.views.helloworld.HelloWorldView;
import com.helpdesk.application.views.personform.PersonFormView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.auth.AccessAnnotationChecker;
import com.vaadin.flow.theme.lumo.LumoUtility;
import java.io.ByteArrayInputStream;
import java.util.Optional;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    private AuthenticatedUser authenticatedUser;
    private AccessAnnotationChecker accessChecker;

    public MainLayout(AuthenticatedUser authenticatedUser, AccessAnnotationChecker accessChecker) {
        this.authenticatedUser = authenticatedUser;
        this.accessChecker = accessChecker;

        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.getElement().setAttribute("aria-label", "Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("HelpDesk");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private AppNav createNavigation() {
        // AppNav is not yet an official component.
        // For documentation, visit https://github.com/vaadin/vcf-nav#readme
        AppNav nav = new AppNav();

        if (accessChecker.hasAccess(FoliosGridView.class)) {
            nav.addItem(new AppNavItem("Listado de Folios", FoliosGridView.class, LineAwesomeIcon.GLOBE_SOLID.create()));

        }

        if (accessChecker.hasAccess(CatalogosView.class)) {
            nav.addItem(new AppNavItem("Catalogos", CatalogosView.class, LineAwesomeIcon.THINK_PEAKS.create()));

        }

        if (accessChecker.hasAccess(HelloWorldView.class)) {
            nav.addItem(new AppNavItem("Hello World", HelloWorldView.class, LineAwesomeIcon.GLOBE_SOLID.create()));

        }
        if (accessChecker.hasAccess(CardListView.class)) {
            nav.addItem(new AppNavItem("Card List", CardListView.class, LineAwesomeIcon.LIST_SOLID.create()));

        }
        if (accessChecker.hasAccess(PersonFormView.class)) {
            nav.addItem(new AppNavItem("Person Form", PersonFormView.class, LineAwesomeIcon.USER.create()));

        }
        if (accessChecker.hasAccess(AboutView.class)) {
            nav.addItem(new AppNavItem("About", AboutView.class, LineAwesomeIcon.FILE.create()));

        }

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        Optional<UsuarioSoporteEntity> maybeUser = authenticatedUser.get();
        if (maybeUser.isPresent()) {
            UsuarioSoporteEntity user = maybeUser.get();

            Avatar avatar = new Avatar(user.getNombrePropio());
           /* StreamResource resource = new StreamResource("profile-pic",
                    () -> new ByteArrayInputStream(user.getProfilePicture()));*/
            //avatar.setImageResource(resource);
            avatar.setThemeName("xsmall");
            avatar.getElement().setAttribute("tabindex", "-1");

            MenuBar userMenu = new MenuBar();
            userMenu.setThemeName("tertiary-inline contrast");

            MenuItem userName = userMenu.addItem("");
            Div div = new Div();
            div.add(avatar);
            div.add(user.getNombrePropio());
            div.add(new Icon("lumo", "dropdown"));
            div.getElement().getStyle().set("display", "flex");
            div.getElement().getStyle().set("align-items", "center");
            div.getElement().getStyle().set("gap", "var(--lumo-space-s)");
            userName.add(div);
            userName.getSubMenu().addItem("Sign out", e -> {
                authenticatedUser.logout();
            });

            layout.add(userMenu);
        } else {
            Anchor loginLink = new Anchor("login", "Sign in");
            layout.add(loginLink);
        }

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
