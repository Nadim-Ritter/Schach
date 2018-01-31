package schach;

import java.util.ArrayList;

public class Turm{
    
    private int zeileX;
    private int spalteY;
    private String color;

    public Turm(int zeileX, int spalteY, String color) {
        this.zeileX = zeileX;
        this.spalteY = spalteY;
        this.color = color;
    }
    
    public ArrayList<String> showPossibleFields() {
        ArrayList<String> possibleFields = new ArrayList();
        
        for(int i = zeileX; i <= 7; i++){
            possibleFields.add((zeileX + (7-i)) + ";" + spalteY);
        }
        for(int i = spalteY; i <= 7; i++){
            possibleFields.add(zeileX + ";" + (spalteY + (7-i)));
        }
        for(int i = zeileX; i >= 0; i--){
            possibleFields.add((zeileX - i) + ";" + spalteY);
        }
        for(int i = spalteY; i >= 0; i--){
            possibleFields.add(zeileX + ";" + (spalteY - i));
        }

        return possibleFields;
    }
    
    
    
    

}
