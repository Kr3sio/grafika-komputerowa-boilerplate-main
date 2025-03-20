package views;

import javax.swing.*;

/**
 * Pasek menu aplikacji, zawierający opcje zarządzania plikami, edycji oraz operacji na panelach.
 * Klasa rozszerza {@link JMenuBar} i definiuje strukturę menu dla aplikacji.
 */
public class MenuBar extends JMenuBar {

    private final JMenu fileMenu;
    private final JMenu leftPanelMenu;
    private final JMenu rightPanelMenu;
    private final JMenu editPanelMenu;

    private final JMenuItem openFileMenuItem;
    private final JMenuItem saveFileMenuItem;
    private final JMenuItem exitMenuItem;

    private final JMenuItem clearLeftPanelMenuItem;
    private final JMenuItem copyLeftPanelMenuItem;

    private final JMenuItem clearRightPanelMenuItem;
    // TODO: Dodać opcję menu umożliwiającą skopiowanie obrazu z prawego panelu do lewego panelu.
    private final JMenuItem copyRightPanelMenuItem;
    private final JMenuItem drawCircleMenuItem;
    // TODO: Dodać opcję menu umożliwiającą narysowanie prostokąta na obrazie.\
    private final JMenuItem drawRectangleMenuItem;

    private final JMenuItem drawHorizontalLinesMenuItem;

    private final JMenuItem drawVerticalLinesMenuItem;

    public MenuBar() {
        // Tworzenie głównych menu
        fileMenu = new JMenu("Plik");
        leftPanelMenu = new JMenu("Lewy panel");
        rightPanelMenu = new JMenu("Prawy panel");
        editPanelMenu = new JMenu("Edycja");

        // Menu plik
        openFileMenuItem = new JMenuItem("Otwórz");
        saveFileMenuItem = new JMenuItem("Zapisz");
        exitMenuItem = new JMenuItem("Zakończ");

        // Menu Panel lewy
        clearLeftPanelMenuItem = new JMenuItem("Wyczyść");
        copyLeftPanelMenuItem = new JMenuItem("Kopiuj obraz");

        // Menu Panel prawy
        clearRightPanelMenuItem = new JMenuItem("Wyczyść");
        // TODO: Dodać nowy element menu kopiowania prawego panelu.
        copyRightPanelMenuItem = new JMenuItem("Kopiuj obraz");
        // Menu Edycja
        drawCircleMenuItem = new JMenuItem("Narysuj koło");
        // TODO: Dodać nowy element menu rysowania prostokąta.
        drawRectangleMenuItem = new JMenuItem("Narysuj prostokąt");

        drawHorizontalLinesMenuItem =new JMenuItem("Narysuj linie poziome");

        drawVerticalLinesMenuItem = new JMenuItem("Narysuj linie pionowe");

        // Dodanie elementów do menu Plik
        fileMenu.add(openFileMenuItem);
        fileMenu.add(saveFileMenuItem);
        fileMenu.add(new JSeparator());
        fileMenu.add(exitMenuItem);

        // Dodanie elementów do menu Panel lewy
        leftPanelMenu.add(clearLeftPanelMenuItem);
        leftPanelMenu.add(copyLeftPanelMenuItem);

        // Dodanie elementów do menu Panel prawy
        rightPanelMenu.add(clearRightPanelMenuItem);
        // TODO: Dodać nowy element menu kopiowania prawego panelu.
        rightPanelMenu.add(copyRightPanelMenuItem);
        // Dodanie elementów do menu Edycja
        editPanelMenu.add(drawCircleMenuItem);
        // TODO: Dodać nowy element menu rysowania prostokąta.
        editPanelMenu.add(drawRectangleMenuItem);

        editPanelMenu.add(drawHorizontalLinesMenuItem);

        editPanelMenu.add(drawVerticalLinesMenuItem);

        // Dodawanie wszystkich menu do paska menu
        add(fileMenu);
        add(leftPanelMenu);
        add(rightPanelMenu);
        add(editPanelMenu);
    }

    public JMenuItem getOpenFileMenuItem() {
        return openFileMenuItem;
    }

    public JMenuItem getSaveFileMenuItem() {
        return saveFileMenuItem;
    }

    public JMenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    public JMenuItem getClearLeftPanelMenuItem() {
        return clearLeftPanelMenuItem;
    }

    public JMenuItem getCopyLeftPanelMenuItem() {
        return copyLeftPanelMenuItem;
    }

    public JMenuItem getClearRightPanelMenuItem() {
        return clearRightPanelMenuItem;
    }

    public JMenuItem getDrawCircleMenuItem() {
        return drawCircleMenuItem;
    }

    public JMenuItem getDrawRectangleMenuItem() {return drawRectangleMenuItem;}

    public JMenuItem getDrawHorizontalLinesMenuItem() {return drawHorizontalLinesMenuItem;}

    public JMenuItem getCopyRightPanelMenuItem() {return copyRightPanelMenuItem;}

    public JMenuItem getDrawVerticalLinesMenuItem() {return drawVerticalLinesMenuItem;}

    // TODO: Dodać metody getter dla nowych elementów menu.
}
