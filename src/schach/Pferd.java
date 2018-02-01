package schach;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Pferd{
    
    private int zeileX;
    private int spalteY;
    private String color;
    private GridPane field;

    public Pferd(int zeileX, int spalteY, String color, GridPane field) {
        this.zeileX = zeileX;
        this.spalteY = spalteY;
        this.color = color;
        this.field = field;
    }
    
    public ArrayList<String> showPossibleFields() {
        ArrayList<String> possibleFields = new ArrayList();
        String otherColor = "";
        if(color.equals("weiss")){
            otherColor = "schwarz";
        }else{
            otherColor = "weiss";
        }
        int x = 0;
        int y = 0;
        for (int i = zeileX; i < 8; i++) {
            switch (i) {
                case 0:
                    x = 2;
                    y = 1;
                    break;
                case 1:
                    x = 2;
                    y = -1;
                    break;
                case 2:
                    x = -2;
                    y = 1;
                    break;
                case 3:
                    x = -2;
                    y = -1;
                    break;
                case 4:
                    x = 1;
                    y = 2;
                    break;
                case 5:
                    x = 1;
                    y = -2;
                    break;
                case 6:
                    x = -1;
                    y = 2;
                    break;
                case 7:
                    x = -1;
                    y = -2;
                    break;
                default:
                    break;
            }
            
            String checkColor = "";
            if (checkIfNodeExists(zeileX + x, spalteY + y) != null && checkIfNodeExists(zeileX + x, spalteY + y).getId() != null) {
                String temp[] = checkIfNodeExists(zeileX + x, spalteY + y).getId().split("_");
                checkColor = temp[0];
            }           
            if (checkColor.equals(otherColor)) {
                possibleFields.add((zeileX + x) + ";" + (spalteY + y) + "!");
            }else if(!checkColor.equals(color)){
                possibleFields.add((zeileX + x) + ";" + (spalteY + y));                
            }           
        }        

        return possibleFields;
    }

    public Node checkIfNodeExists(int x, int y) {
        for (Node node : field.getChildren()) {
            try {
                if (GridPane.getColumnIndex(node) == x && GridPane.getRowIndex(node) == y) {
                    return node;
                }
            } catch (NullPointerException e) {
            }
        }
        return null;

    }

}
