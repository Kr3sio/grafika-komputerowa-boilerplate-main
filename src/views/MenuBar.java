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

    private final JMenu filtrPanelMenu;

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

    private final JMenu ConvertToGrey;

    private final JMenuItem ConvertToGreyMenuItem;



    private final JMenuItem ConvertToGrey3MenuItem;

    private final JMenuItem ConvertToGreyRedMenuItem;

    private final JMenuItem ConvertToGreyGreenMenuItem;

    private final JMenuItem ConvertToGreyBlueMenuItem;

    private final JMenuItem adjustBrightnessAndContrastMenuItem;

    private final JMenuItem NegationMenuItem;

    private final JMenuItem BrightnessRangeMenuItem;

    private final JMenuItem applyConvolutionMenuItem;

    private final JMenuItem applyConvolutionYUVMenuItem;

    private final JMenuItem medianaMenuItem;

    private final JMenuItem minimalMenuItem;

    private final JMenuItem maksimumMenuItem;

    private final JMenuItem gradnientPMenuItem;

    private final JMenuItem gradientRobertsaMenuItem;

    private final JMenuItem gradientProgMenuItem;

    private final JMenuItem gradientTlobialeMenuItem;

    private final JMenuItem gradientCzarnelinieMenuItem;

    private final JMenuItem gradientObaMenuItem;





    public MenuBar() {
        // Tworzenie głównych menu
        fileMenu = new JMenu("Plik");
        leftPanelMenu = new JMenu("Lewy panel");
        rightPanelMenu = new JMenu("Prawy panel");
        editPanelMenu = new JMenu("Edycja");
        filtrPanelMenu = new JMenu("Filtry");
        ConvertToGrey = new JMenu("Odcienie szarości");


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


        ConvertToGreyMenuItem = new JMenuItem("Średnia");


        ConvertToGrey3MenuItem = new JMenuItem("Model YUV");

        ConvertToGreyRedMenuItem = new JMenuItem("Red");
        ConvertToGreyGreenMenuItem = new JMenuItem("Green");
        ConvertToGreyBlueMenuItem = new JMenuItem("Blue");

        adjustBrightnessAndContrastMenuItem = new JMenuItem("Zmień Jasność i kontrast");

        NegationMenuItem = new JMenuItem("Odwrócenie kolorów");

        BrightnessRangeMenuItem = new JMenuItem("Zmień zakres jasności");

        //Menu filtry
        applyConvolutionMenuItem = new JMenuItem("splot RGB");

        applyConvolutionYUVMenuItem = new JMenuItem("splot YUV");

        medianaMenuItem = new JMenuItem("Medianowy");

        minimalMenuItem = new JMenuItem("Minimalny");

        maksimumMenuItem = new JMenuItem("Maksymalny");

        gradnientPMenuItem = new JMenuItem("Gradient prosty");

        gradientRobertsaMenuItem = new JMenuItem("Gradient Roberts'a");

        gradientProgMenuItem = new JMenuItem("Gradient z progowaniem");

        gradientTlobialeMenuItem = new JMenuItem("Białe tło");

        gradientCzarnelinieMenuItem = new JMenuItem("Czarne krawędzie");

        gradientObaMenuItem = new JMenuItem("Białe tło i czarne krawędzie");

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



        editPanelMenu.add(adjustBrightnessAndContrastMenuItem);

        editPanelMenu.add(NegationMenuItem);

        editPanelMenu.add(BrightnessRangeMenuItem);

        editPanelMenu.add(ConvertToGrey);

        ConvertToGrey.add(ConvertToGreyMenuItem);

        ConvertToGrey.add(ConvertToGreyRedMenuItem);

        ConvertToGrey.add(ConvertToGreyGreenMenuItem);
        ConvertToGrey.add(ConvertToGreyBlueMenuItem);

        ConvertToGrey.add(ConvertToGrey3MenuItem);



        // Dodawanie elementów do menu filtrów
        filtrPanelMenu.add(applyConvolutionMenuItem);

        filtrPanelMenu.add(applyConvolutionYUVMenuItem);

        filtrPanelMenu.add(medianaMenuItem);

        filtrPanelMenu.add(minimalMenuItem);
        filtrPanelMenu.add(maksimumMenuItem);

        filtrPanelMenu.add(gradnientPMenuItem);

        filtrPanelMenu.add(gradientRobertsaMenuItem);

        filtrPanelMenu.add(gradientProgMenuItem);

        filtrPanelMenu.add(gradientTlobialeMenuItem);

        filtrPanelMenu.add(gradientCzarnelinieMenuItem);

        filtrPanelMenu.add(gradientObaMenuItem);


        // Dodawanie wszystkich menu do paska menu
        add(fileMenu);
        add(leftPanelMenu);
        add(rightPanelMenu);
        add(editPanelMenu);
        add(filtrPanelMenu);
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

    public JMenuItem getConvertToGreyMenuItem() {return ConvertToGreyMenuItem;}

    public JMenuItem getConvertToGreyRedMenuItem() {return ConvertToGreyRedMenuItem;}
    public JMenuItem getConvertToGreyGreenMenuItem() {return ConvertToGreyGreenMenuItem;}
    public JMenuItem getConvertToGreyBlueMenuItem() {return ConvertToGreyBlueMenuItem;}

    public JMenuItem getConvertToGrey3MenuItem() {return ConvertToGrey3MenuItem;}

    public JMenuItem getAdjustBrightnessAndContrastMenuItem() {return adjustBrightnessAndContrastMenuItem;}

    public JMenuItem getNegationMenuItem() {return  NegationMenuItem;}

    public JMenuItem getBrightnessRangeMenuItem(){return BrightnessRangeMenuItem;}

    public JMenuItem getApplyConvolutionMenuItem() {return applyConvolutionMenuItem;}

    public JMenuItem getApplyConvolutionYUVMenuItem(){return applyConvolutionYUVMenuItem;}

    public JMenuItem getMedianaMenuItem(){return  medianaMenuItem;}

    public JMenuItem getMinimalMenuItem(){return minimalMenuItem;}

    public JMenuItem getMaksimumMenuItem(){return maksimumMenuItem;}

    public JMenuItem getGradnientPMenuItem(){return gradnientPMenuItem;}

    public JMenuItem getGradientRobertsaMenuItem(){return gradientRobertsaMenuItem;}

    public JMenuItem getGradientProgMenuItem(){return gradientProgMenuItem;}

    public JMenuItem getGradientTlobialeMenuItem(){return gradientTlobialeMenuItem;}

    public JMenuItem getGradientCzarnelinieMenuItem(){return gradientCzarnelinieMenuItem;}

    public JMenuItem getGradientObaMenuItem(){return gradientObaMenuItem;}



    // TODO: Dodać metody getter dla nowych elementów menu.
}
