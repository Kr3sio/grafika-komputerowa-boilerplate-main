package views;

import controllers.FileController;
import controllers.ImageController;
import models.CircleModel;
import models.LineModel;
import models.RectangleModel;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainFrame extends JFrame {

    // Domyślne wymiary okna aplikacji
    private final static Integer DEFAULT_WIDTH = 800;
    private final static Integer DEFAULT_HEIGHT = 600;

    // Panele do wyświetlania obrazów
    private final ImagePanel leftPanel;
    private final ImagePanel rightPanel;

    // Pasek menu aplikacji
    private final MenuBar menuBar;

    // Kontrolery obsługujące obrazy oraz pliki
    private final ImageController imageController;
    private final FileController fileController;

    public MainFrame() {
        super("Grafika komputerowa");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicjalizacja komponentów
        leftPanel = new ImagePanel("Obraz wczytany");
        rightPanel = new ImagePanel("Obraz zmodyfikowany");
        menuBar = new MenuBar();

        // Inicjalizacja kontrolerów
        imageController = new ImageController(this);
        fileController = new FileController(this);

        // Utworzenie kontenera do organizacji komponentów interfejsu użytkownika, ustawiamy siatkę 1x2 dla 2 paneli z obrazami
        JPanel contentPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        contentPanel.add(leftPanel);
        contentPanel.add(rightPanel);
        add(contentPanel, BorderLayout.CENTER);


        setJMenuBar(menuBar); // Dodanie menu do okna
        setMenuBarListeners(); // Ustawienie nasłuchu na zdarzenia wywołania opcji z menubar

        setLocationRelativeTo(null); // Centrowanie okna na ekranie
        setVisible(true); // Ustawienie widoczności okna
    }

    public ImagePanel getRightPanel() {
        return rightPanel;
    }

    public ImagePanel getLeftPanel() {
        return leftPanel;
    }

    /**
     * Dostosowuje rozmiar okna do załadowanego obrazu z lewego panelu.
     *
     * <p>
     * Metoda pobiera obraz z lewego panelu i sprawdza jego rozmiary.
     * Szerokość i wysokość okna są zwiększane w zależności od wymiarów obrazu
     * </p>
     *
     * @see javax.swing.JFrame#setSize(int, int)
     * @see javax.swing.JFrame#setLocationRelativeTo(java.awt.Component)
     */
    public void adjustWindowSize() {
        var image = leftPanel.getModel().getImage();
        if (image == null) {
            return;
        }

        // Obliczenie nowej szerokości okna.
        // Okno powinno mieć co najmniej dwukrotność szerokości obrazu.
        // + 100 - dodaje dodatkową przestrzeń dla marginesów.
        int newWidth = Math.max(getWidth(), image.getWidth() * 2 + 100);

        // Obliczenie nowej wysokości okna.
        // + 100 - dodaje dodatkową przestrzeń dla marginesów.
        int newHeight = Math.max(getHeight(), image.getHeight() + 100);
        setSize(newWidth, newHeight);
        setLocationRelativeTo(null);
    }

    /**
     * <p>Metoda inicjalizację obsługę zdarzeń dla elementów menu w pasku narzędzi.
     * Wykorzystuje wyrażenia lambda jako implementację interfejsu {@code java.awt.event.ActionListener}.<p>
     *
     * <p>Każde wywołanie {@code addActionListener(...)} wymaga przekazania obiektu implementującego interfejs {@code ActionListener}.
     * Zamiast tworzenia anonimowych klas wewnętrznych, wykorzystujemy wyrażenia lambda {@code (_ -> metoda())}.
     * _ jest tutaj symbolem oznaczającym, że argument (obiekt zdarzenia {@code ActionEvent}) nie jest wykorzystywany.
     * Po prawej stronie operatora {@code ->} znajduje się wywołanie metody, które zostanie wykonane po kliknięciu elementu menu.</p>
     *
     * <p>Jako argument {@code addActionListener(...)} można przekazać również anonimową klasę wewnętrzną.</p>
     *
     * <pre>
     * {@code
     *      menuBar.getOpenFileMenuItem().addActionListener(new ActionListener() {
     *          @Override
     *          public void actionPerformed(ActionEvent e) {
     *              showFileChooserDialog();
     *          }
     *      });
     * }
     * </pre>
     *
     * @see java.awt.event.ActionListener
     * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
     * @see javax.swing.AbstractButton#addActionListener(ActionListener)
     */
    private void setMenuBarListeners() {
        menuBar.getOpenFileMenuItem().addActionListener(_ -> showFileChooserDialog());

        menuBar.getSaveFileMenuItem().addActionListener(_ -> showSaveFileDialog());
        menuBar.getExitMenuItem().addActionListener(_ -> System.exit(0));

        menuBar.getCopyLeftPanelMenuItem().addActionListener(_ -> imageController.copyLeftPanel());
        menuBar.getClearLeftPanelMenuItem().addActionListener(_ -> imageController.clearLeftPanel());

        menuBar.getClearRightPanelMenuItem().addActionListener(_ -> imageController.clearRightPanel());
        // TODO: Dodać nasłuch na opcję kopiowania obrazu z prawego panelu do lewego panelu. W addActionListener należy wywołać metodę copyRightPanel() z kontrolera ImageController.
        menuBar.getCopyRightPanelMenuItem().addActionListener(_ -> imageController.copyRightPanel());
        menuBar.getDrawCircleMenuItem().addActionListener(_ -> showCircleDialog());
        // TODO: Dodać nasłuch na opcję rysowania prostokąta. W addActionListener należy wywołać metodę showRectangleDialog().
        menuBar.getDrawRectangleMenuItem().addActionListener(_ -> showRectangleDialog());

        menuBar.getDrawHorizontalLinesMenuItem().addActionListener(_ -> showLineHDialog());

        menuBar.getDrawVerticalLinesMenuItem().addActionListener(_ -> showLineVDialog());

        menuBar.getConvertToGreyMenuItem().addActionListener(_ -> imageController.ConvertGrey());

        menuBar.getConvertToGreyRedMenuItem().addActionListener(_->imageController.ConvertGreyRed());

        menuBar.getConvertToGreyGreenMenuItem().addActionListener(_->imageController.ConvertGreyGreen());

        menuBar.getConvertToGreyBlueMenuItem().addActionListener(_->imageController.ConvertGreyBlue());

        menuBar.getConvertToGrey3MenuItem().addActionListener(_->imageController.ConvertGrey3());

        menuBar.getAdjustBrightnessAndContrastMenuItem().addActionListener(_ -> showAdjustDialog());

        menuBar.getNegationMenuItem().addActionListener(_->imageController.Negation());

        menuBar.getBrightnessRangeMenuItem().addActionListener(_->imageController.BrightnessRange());

        menuBar.getApplyConvolutionMenuItem().addActionListener(_->applyConvolutionSelectMask());

        menuBar.getApplyConvolutionYUVMenuItem().addActionListener(_->applyConvolutionSelectMaskYUV());

        menuBar.getMedianaMenuItem().addActionListener(_->imageController.mediana());

        menuBar.getMinimalMenuItem().addActionListener(_->imageController.minimalny());

        menuBar.getMaksimumMenuItem().addActionListener(_->imageController.maksymalny());

        menuBar.getGradnientPMenuItem().addActionListener(_->imageController.gradientProsty());

        menuBar.getGradientRobertsaMenuItem().addActionListener(_->imageController.gradientRobertsa());

        menuBar.getGradientProgMenuItem().addActionListener(_->showgradientProg());

        menuBar.getGradientTlobialeMenuItem().addActionListener(_->imageController.gradientTlobiale());

        menuBar.getGradientCzarnelinieMenuItem().addActionListener(_->imageController.gradientCzarnelinie());

        menuBar.getGradientObaMenuItem().addActionListener(_->imageController.gradientOba());
    }

    /**
     * Metoda otwiera okno dialogowe umożliwiające użytkownikowi wprowadzenie parametrów prostokąta, który zostanie narysowany na wczytanym obrazie.
     */
    private void showRectangleDialog() {
        // TODO: Wyświetlić okno dialogowe z formularzem dla parametrów prostokąta. Wywołać metodę kontrolera drawRectangle().
        RectangleDialog dialog = new RectangleDialog(this);
        dialog.setVisible(true);
        RectangleModel rect = dialog.getRectangle();

        if(rect != null) {
            imageController.drawRectangle(rect);
        }
    }

    private void showLineHDialog() {
        LineDialog dialog = new LineDialog(this);
        dialog.setVisible(true);
        LineModel line = dialog.getLine();
        if(line != null) {
            imageController.drawHorizontaLines(line);
        }
    }

    private void showLineVDialog() {
        LineDialog dialog = new LineDialog(this);
        dialog.setVisible(true);
        LineModel line = dialog.getLine();
        if(line != null) {
            imageController.drawVerticalLines(line);
        }
    }

    private void showAdjustDialog() {
        AdjustDialog dialog = new AdjustDialog(this);
        dialog.setVisible(true);
        Double[] parameter = dialog.getIntArray();
        if(parameter != null) {
            imageController.adjustBrightnessAndContrast(parameter);
        }
    }

    private void applyConvolutionSelectMask(){
        MaskSelectDialog dialog = new MaskSelectDialog(this);
        dialog.setVisible(true);
        int[][] mask = dialog.getSelectedMask();
        int norm = dialog.getNormalization();
        if(mask != null) {
            imageController.applyConvolution(mask, norm);
        }
    }
    private void applyConvolutionSelectMaskYUV(){
        MaskSelectDialog dialog = new MaskSelectDialog(this);
        dialog.setVisible(true);
        int[][] mask = dialog.getSelectedMask();
        int norm = dialog.getNormalization();
        if(mask != null) {
            imageController.applyConvolutionYUV(mask, norm);
        }
    }

    private void showgradientProg(){
        ProgDialog dialog = new ProgDialog(this);
        dialog.setVisible(true);
        int prog = dialog.getProg();
        if(prog >= 0 && prog <=255){
            imageController.gradientProg(prog);
        }
    }



    /**
     * Metoda otwiera okno dialogowe umożliwiające użytkownikowi wprowadzenie parametrów koła, który zostanie narysowane na wczytanym obrazie.
     *
     * <p>
     * Tworzy instancję okna dialogowego {@code CircleDialog}, który wyświetla formularz do wprowadzania parametrów koła.
     * Po utworzeniu instancji okna dialogowego należy pokazać komponent przez wywołanie funkcji {@code dialog.setVisible(true)}
     * </p>
     *
     * @see CircleDialog
     * @see CircleModel
     * @see ImageController#drawCircle(CircleModel)
     */
    private void showCircleDialog() {
        CircleDialog dialog = new CircleDialog(this);
        dialog.setVisible(true);
        CircleModel circle = dialog.getCircle();

        if (circle != null) {
            imageController.drawCircle(circle);
        }
    }

    /**
     * Metoda otwiera okno dialogowe wyboru pliku graficznego.
     *
     * <p>Tworzy instancję {@code JFileChooser}, umożliwiając użytkownikowi wybór pliku.
     * Przekazuje plik do kontrolera {@code ImageController} w celu załadowania zdjęcia do lewego panelu graficznego.</p>
     *
     * @see JFileChooser
     * @see ImageController#loadImage(File)
     */
    private void showFileChooserDialog() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Wybierz plik graficzny");
        int returnValue = fileChooser.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            imageController.loadImage(file);
        }
    }

    /**
     * Metoda otwiera okno dialogowe zapisu pliku graficznego.
     *
     * <p>
     * Tworzy instancję {@code JFileChooser}, ustawiając filtr plików obsługujący formaty BMP i PNG.
     * Po wybraniu miejscu zapisu przekazuje plik do kontrolera {@code FileController} w celu zapisania obrazu z prawego panelu graficznego.
     * </p>
     *
     * @see JFileChooser
     * @see FileController#saveFile(File)
     */
    private void showSaveFileDialog() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Zapisz obraz");
        fileChooser.setFileFilter(new FileNameExtensionFilter("BMP & PNG Images", "bmp", "png"));
        int returnValue = fileChooser.showSaveDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            fileController.saveFile(file);
        }
    }
}