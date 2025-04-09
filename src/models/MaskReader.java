package models;
import java.io.*;
import java.util.*;


public class MaskReader {
    public static List<Maska> readMasksFromFile(String filename) throws IOException {
        List<Maska> maski = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));

        String line;
        String name = null;
        float[][] values = new float[3][3];
        float normalization = 1.0f;
        int row = 0;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#")) continue;

            if (line.startsWith("Name:")) {
                name = line.substring(5).trim();
                row = 0;
            } else if (line.startsWith("Normalization:")) {
                normalization = Float.parseFloat(line.substring(14).trim());
                maski.add(new Maska(name, values, normalization));
                values = new float[3][3];  // reset for next mask
            } else {
                String[] parts = line.split("\\s+");
                for (int i = 0; i < 3; i++) {
                    values[row][i] = Float.parseFloat(parts[i]);
                }
                row++;
            }
        }
        br.close();
        return maski;
    }
}

