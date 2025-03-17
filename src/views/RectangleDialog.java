package views;

import models.RectangleModel;

import javax.swing.*;

/**
 * Klasa okna dialogowego do wprowadzania parametrów prostokąta.
 *
 * <p>Umożliwia użytkownikowi podanie współrzędnych, wielkości oraz wybór koloru prostokąta.
 * Po zatwierdzeniu danych generowany jest obiekt {@link RectangleModel}, w którym przechowywane są informację
 * wykorzystywane do rysowania prostokąta na obrazie.</p>
 *
 * @see RectangleModel
 */
public class RectangleDialog extends JDialog {

    // TODO: Zaimplementuj pola tekstowe do wprowadzania współrzędnych i wymiarów prostokąta, zmienną do przechowywania wybranego kolor oraz flagę oznaczającą, czy użytkownik potwierdził dane.
    // private final JTextField xField = ...;
    // private final JTextField yField = ...;
    // private final JTextField widthField = ...;
    // private final JTextField heightField = ...;
    // private Color selectedColor = ...;
    // private boolean confirmed = ...;

    public RectangleDialog(JFrame parent) {
        // TODO: Zaimplementuj konstruktor, ustawiając tytuł, rozmiar i układ okna dialogowego.
        // Powinien on także wywołać metody do tworzenia głównego panelu i panelu akcji.
    }

    private JPanel getMainPanel() {
        // TODO: Utwórz panel i dodaj do niego etykiety oraz pola tekstowe.
        return new JPanel();
    }

    private JPanel getActionPanel() {
        // TODO: Utwórz panel z przyciskami OK i Anuluj.
        // Przycisk OK powinien sprawdzać poprawność danych i zamykać okno, jeśli są poprawne.
        return new JPanel();
    }

    public RectangleModel getRectangle() {
        // TODO: Jeśli użytkownik potwierdził dane, zwróć nowy obiekt RectangleModel z odpowiednimi wartościami.
        return new RectangleModel();
    }

    private Boolean validateFields() {
        // TODO: Sprawdź, poprawność danych.
        return false;
    }

    private Integer parseField(JTextField field) {
        try {
            return Integer.parseInt(field.getText());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
