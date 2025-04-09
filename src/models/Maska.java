package models;
public class Maska {
    public String name;
    public float[][] values = new float[3][3];
    public float normalization;

    public Maska(String name, float[][] values, float normalization) {
        this.name = name;
        this.values = values;
        this.normalization = normalization;
    }
}
