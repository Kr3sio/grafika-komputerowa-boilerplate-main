package models;

import java.awt.*;

public class LineModel {
    private final Integer numberLine;

    private final Integer spaceLine;

    private final Color color;

    public LineModel(Integer numberLine, Integer spaceLine, Color color) {
        this.numberLine = numberLine;
        this.spaceLine = spaceLine;
        this.color = color;
    }

    public Integer getNumberLine() {
        return numberLine;
    }

    public Integer getSpaceLine() {
        return spaceLine;
    }

    public Color getColor() {
        return color;
    }
}
