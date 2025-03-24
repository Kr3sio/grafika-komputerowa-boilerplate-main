package controllers;

import models.CircleModel;
import models.ImageModel;
import models.RectangleModel;
import views.ImagePanel;
import views.MainFrame;
import models.LineModel;
import views.AdjustDialog;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Color;

/**
 * Kontroler odpowiedzialny za zarządzanie operacjami na obrazach w aplikacji.
 * Obsługuje wczytywanie, czyszczenie, kopiowanie oraz rysowanie kształtów na obrazach.
 */
public class ImageController {

    private final MainFrame mainFrame;

    private final ImagePanel leftPanel;

    private final ImagePanel rightPanel;

    public ImageController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.leftPanel = mainFrame.getLeftPanel();
        this.rightPanel = mainFrame.getRightPanel();
    }

    /**
     * Wczytuje obraz z pliku i ustawia go w lewym panelu.
     *
     * @param file Plik obrazu do wczytania.
     */
    public void loadImage(File file) {
        try {
            var image = ImageIO.read(file);

            var model = new ImageModel(image);
            leftPanel.setModel(model);
            leftPanel.repaint();

            mainFrame.adjustWindowSize(); // Dopasowanie rozmiaru okna po załadowaniu obrazu
        } catch (IOException e) {
            JOptionPane.showMessageDialog(mainFrame, "Nieznany błąd!", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Usuwa obraz z lewego panelu.
     */
    public void clearLeftPanel() {
        leftPanel.setModel(null);
        leftPanel.repaint();
    }

    /**
     * Usuwa obraz z prawego panelu.
     */
    public void clearRightPanel() {
        rightPanel.setModel(null);
        rightPanel.repaint();
    }

    /**
     * Kopiuje obraz z lewego panelu do prawego panelu.
     * Jeśli lewy panel nie zawiera obrazu, operacja nie jest wykonywana.
     */
    public void copyLeftPanel() {
        if (leftPanel.getModel() == null) {
            return;
        }

        // Utworzenie kopii obrazu z lewego panelu, aby modyfikacje nie wpłynęły na oryginalny obraz.
        var image = leftPanel.getModel().getCopyImage();
        var model = new ImageModel(image);

        rightPanel.setModel(model);
        rightPanel.repaint();
    }

    /**
     * Kopiuje obraz z prawego panelu do lewego panelu.
     */
    public void copyRightPanel() {
        if (rightPanel.getModel() == null) {
            return;
        }
        // TODO: Zaimplementować metodę kopiowania obrazu z panelu prawego do panelu lewego.
        var image = rightPanel.getModel().getCopyImage();
        var model = new ImageModel(image);

        leftPanel.setModel(model);
        leftPanel.repaint();
    }

    /**
     * Rysuje koło na obrazie znajdującym się w lewym panelu i umieszcza wynik w prawym panelu.
     * Jeśli lewy panel nie zawiera obrazu, wyświetlane jest komunikat z błędem.
     *
     * @param circle Model kola.
     */
    public void drawCircle(CircleModel circle) {
        if (leftPanel.getModel() == null || leftPanel.getModel().getImage() == null) {
            JOptionPane.showMessageDialog(mainFrame, "Brak załadowanego obrazu!", "Błąd", JOptionPane.ERROR_MESSAGE);
            return;
        }

        var image = leftPanel.getModel().getCopyImage(); // Utworzenie kopii obrazu z lewego panelu

        var model = new ImageModel(image); // Nowa instancje modelu, utworzona z obrazem z panelu lewego.
        model.drawCircle(circle); // Modyfikacja modelu. Narysowanie koła na skopiowany obrazie.

        rightPanel.setModel(model); // Ustawienie zmodyfikowanego modelu w prawym panelu.

        rightPanel.repaint(); // Ponownie narysowanie komponentu.
    }

    /**
     * Rysuje prostokąt na obrazie znajdującym się w lewym panelu i umieszcza wynik w prawym panelu.
     * Jeśli lewy panel nie zawiera obrazu, operacja nie jest wykonywana.
     *
     * @param rectangle Model prostokąta do narysowania.
     */
    public void drawRectangle(RectangleModel rectangle) {
        // TODO: Zaimplementować rysowanie prostokąta na obrazie.
        if(leftPanel.getModel() == null || leftPanel.getModel().getImage() == null) {
            JOptionPane.showMessageDialog(mainFrame, "Brak załadowanego obrazu!", "Błąd",JOptionPane.ERROR_MESSAGE);
            return;
        }
        var image = leftPanel.getModel().getCopyImage();

        var model = new ImageModel(image);
        model.drawRectangle(rectangle);

        rightPanel.setModel(model);
        rightPanel.repaint();
    }

    public void drawHorizontaLines(LineModel line){
        if(leftPanel.getModel() == null || leftPanel.getModel().getImage() == null) {
            JOptionPane.showMessageDialog(mainFrame, "Brak załadowanego obrazu!", "Błąd",JOptionPane.ERROR_MESSAGE);
            return;
        }
        var image = leftPanel.getModel().getCopyImage();

        var model = new ImageModel(image);
        int y = 0;

        for(int i = 1;i <= line.getNumberLine();i++) {
            RectangleModel rect = new RectangleModel(0,y,leftPanel.getWidth(),line.getFat(),line.getColor());
            model.drawRectangle(rect);
            rightPanel.setModel(model);
            rightPanel.repaint();
            y += line.getSpaceLine();
        }


    }

    public void drawVerticalLines(LineModel line){
        if(leftPanel.getModel() == null || leftPanel.getModel().getImage() == null) {
            JOptionPane.showMessageDialog(mainFrame, "Brak załadowanego obrazu!", "Błąd",JOptionPane.ERROR_MESSAGE);
            return;
        }
        var image = leftPanel.getModel().getCopyImage();

        var model = new ImageModel(image);
        int x = 0;

        for(int i = 1;i <= line.getNumberLine();i++) {
            RectangleModel rect = new RectangleModel(x,0,line.getFat(),rightPanel.getHeight(),line.getColor());
            model.drawRectangle(rect);
            rightPanel.setModel(model);
            rightPanel.repaint();
            x += line.getSpaceLine();
        }


    }

    public void ConvertGrey(){
        if(leftPanel.getModel() == null || leftPanel.getModel().getImage() == null) {
            JOptionPane.showMessageDialog(mainFrame, "Brak załadowanego obrazu!", "Błąd",JOptionPane.ERROR_MESSAGE);
            return;
        }
        var image = leftPanel.getModel().getCopyImage();
        Integer width = image.getWidth();
        Integer height = image.getHeight();
        var grayscaleimage = leftPanel.getModel().getCopyImage();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color color = new Color(image.getRGB(x, y));

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                int grayValue = (int) (0.3 * red + 0.59 * green + 0.11 * blue);
                Color grayColor = new Color(grayValue, grayValue, grayValue);

                grayscaleimage.setRGB(x, y, grayColor.getRGB());
            }

        }

        rightPanel.setModel(new ImageModel(grayscaleimage));
        rightPanel.repaint();
    }

    public void adjustBrightnessAndContrast(Integer[] parameter) {
        if(leftPanel.getModel() == null || leftPanel.getModel().getImage() == null) {
            JOptionPane.showMessageDialog(mainFrame, "Brak załadowanego obrazu!", "Błąd",JOptionPane.ERROR_MESSAGE);
            return;
        }
        var image = leftPanel.getModel().getCopyImage();
        Integer width = image.getWidth();
        Integer height = image.getHeight();

        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int brightness = parameter[0];
        int contrast = parameter[1];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Pobranie koloru piksela
                Color color = new Color(image.getRGB(x, y));

                // Przetwarzanie każdej składowej (R, G, B)
                int red = clamp((int) (contrast * color.getRed() + brightness));
                int green = clamp((int) (contrast * color.getGreen() + brightness));
                int blue = clamp((int) (contrast * color.getBlue() + brightness));

                // Tworzenie nowego koloru
                Color newColor = new Color(red, green, blue);

                // Ustawienie piksela w nowym obrazie
                outputImage.setRGB(x, y, newColor.getRGB());
            }
        }
        rightPanel.setModel(new ImageModel(outputImage));
        rightPanel.repaint();
    }

    private int clamp(int value) {
        return Math.max(0, Math.min(255, value));
    }


}
