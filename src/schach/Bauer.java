package schach;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Bauer {

    private int zeileX;
    private int spalteY;
    private String color;
    private GridPane field;

    public Bauer(int zeileX, int spalteY, String color, GridPane field) {
        this.zeileX = zeileX;
        this.spalteY = spalteY;
        this.color = color;
        this.field = field;
    }

    public ArrayList<String> showPossibleFields() {
        ArrayList<String> possibleFields = new ArrayList();
        String otherColor = "";
        if(color.equals("schwarz")){
            otherColor = "weiss";            
        }else{
            otherColor = "schwarz";
        }

        if (color.equals("schwarz")) {
            if (checkIfNodeExists(zeileX, spalteY + 1) == null) {
                if (spalteY == 1) {
                    possibleFields.add(zeileX + ";" + (spalteY + 1));
                    possibleFields.add(zeileX + ";" + (spalteY + 2));
                } else {
                    possibleFields.add(zeileX + ";" + (spalteY + 1));
                }
            }
            String checkColor = "";
            if(checkIfNodeExists(zeileX + 1, spalteY + 1) != null){
                String temp[] = checkIfNodeExists(zeileX + 1, spalteY + 1).getId().split("_");
                checkColor = temp[0];
            }
            if(checkColor.equals(otherColor)){
                possibleFields.add((zeileX + 1) + ";" + (spalteY + 1) + "!");
            }
            
            String checkColor2 = "";
            if(checkIfNodeExists(zeileX - 1, spalteY + 1) != null){
                String temp[] = checkIfNodeExists(zeileX - 1, spalteY + 1).getId().split("_");
                checkColor2 = temp[0];
            }
            if(checkColor2.equals(otherColor)){
                possibleFields.add((zeileX - 1) + ";" + (spalteY + 1) + "!");
            }
        } else {
            if (checkIfNodeExists(zeileX, spalteY - 1) == null) {
                if (spalteY == 6) {
                    possibleFields.add(zeileX + ";" + (spalteY - 1));
                    possibleFields.add(zeileX + ";" + (spalteY - 2));
                } else {
                    possibleFields.add(zeileX + ";" + (spalteY - 1));
                }
            }
            
            String checkColor = "";
            if(checkIfNodeExists(zeileX + 1, spalteY - 1) != null){
                String temp[] = checkIfNodeExists(zeileX + 1, spalteY - 1).getId().split("_");
                checkColor = temp[0];
            }
            if(checkColor.equals(otherColor)){
                possibleFields.add((zeileX + 1) + ";" + (spalteY - 1) + "!");
            }
            
            String checkColor2 = "";
            if(checkIfNodeExists(zeileX - 1, spalteY - 1) != null){
                String temp[] = checkIfNodeExists(zeileX - 1, spalteY - 1).getId().split("_");
                checkColor2 = temp[0];
            }
            if(checkColor2.equals(otherColor)){
                possibleFields.add((zeileX - 1) + ";" + (spalteY - 1) + "!");
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
