package models;

import java.awt.*;

public class LineModel {
    private final Integer numberLine;

    private final Integer spaceLine;

    private final Integer fat;

    private final Color color;


    public LineModel(Integer numberLine, Integer spaceLine,Integer fat, Color color) {
        this.numberLine = numberLine;
        this.spaceLine = spaceLine;
        this.fat = fat;
        this.color = color;
    }

    public Integer getNumberLine() {
        return numberLine;
    }

    public Integer getSpaceLine() {
        return spaceLine;
    }

    public Integer getFat(){return fat;}

    public Color getColor() {
        return color;
    }
}
