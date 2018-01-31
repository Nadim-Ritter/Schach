package schach;

import java.util.ArrayList;

public class Bauer {

    private int zeileX;
    private int spalteY;
    private String color;

    public Bauer(int zeileX, int spalteY, String color) {
        this.zeileX = zeileX;
        this.spalteY = spalteY;
        this.color = color;
        
    }

    public ArrayList<String> showPossibleFields() {
        ArrayList<String> possibleFields = new ArrayList();
        if (color.equals("schwarz")) {
            if (spalteY == 1) {
                possibleFields.add(zeileX + ";" + (spalteY + 1));
                possibleFields.add(zeileX + ";" + (spalteY + 2));
            } else {
                possibleFields.add(zeileX + ";" + (spalteY + 1));
            }
        }else{
            if (spalteY == 6) {
                possibleFields.add(zeileX + ";" + (spalteY - 1));
                possibleFields.add(zeileX + ";" + (spalteY - 2));
            } else {
                possibleFields.add(zeileX + ";" + (spalteY - 1));
            }
            
        }

        return possibleFields;
    }

}
