package schach;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Turm {

    private int zeileX;
    private int spalteY;
    private String color;
    private GridPane field;

    public Turm(int zeileX, int spalteY, String color, GridPane field) {
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
        
        ///////////////
        int count = 1;
        for (int i = zeileX; i < 7; i++) {
            String checkColor = "";
            if (checkIfNodeExists(zeileX + count, spalteY) != null && checkIfNodeExists(zeileX + count, spalteY).getId() != null) {
                String temp[] = checkIfNodeExists(zeileX + count, spalteY).getId().split("_");
                checkColor = temp[0];
            }
            if (checkColor.equals(color)) {
                break;
            }
            if (checkColor.equals(otherColor)) {
                possibleFields.add((zeileX + count) + ";" + spalteY + "!");
                break;
            }
            possibleFields.add((zeileX + count) + ";" + spalteY);
            count++;
        }
        //////////////////////
        int count2 = 1;
        for (int i = spalteY; i < 7; i++) {
            String checkColor = "";
            if (checkIfNodeExists(zeileX, spalteY + count2) != null && checkIfNodeExists(zeileX, spalteY + count2).getId() != null) {
                String temp[] = checkIfNodeExists(zeileX, spalteY + count2).getId().split("_");
                checkColor = temp[0];
            }
            if (checkColor.equals(color)) {
                break;
            }
            if (checkColor.equals(otherColor)) {
                possibleFields.add(zeileX + ";" + (spalteY + count2) + "!");
                break;
            }
            possibleFields.add(zeileX + ";" + (spalteY + count2));
            count2++;
        }
        //////
        int count3 = 1;
        for (int i = zeileX; i > 0; i--) {
            String checkColor = "";
            if (checkIfNodeExists(zeileX - count3, spalteY) != null && checkIfNodeExists(zeileX - count3, spalteY).getId() != null) {
                String temp[] = checkIfNodeExists(zeileX - count3, spalteY).getId().split("_");
                checkColor = temp[0];
            }
            if (checkColor.equals(color)) {
                break;
            }
            if (checkColor.equals(otherColor)) {
                possibleFields.add((zeileX - count3) + ";" + spalteY + "!");
                break;
            }
            possibleFields.add((zeileX - count3) + ";" + spalteY);
            count3++;
        }
        ///////
        int count4 = 1;
        for (int i = spalteY; i > 0; i--) {
            String checkColor = "";
            if (checkIfNodeExists(zeileX, spalteY - count4) != null && checkIfNodeExists(zeileX, spalteY - count4).getId() != null) {
                String temp[] = checkIfNodeExists(zeileX, spalteY - count4).getId().split("_");
                checkColor = temp[0];
            }
            if (checkColor.equals(color)) {
                break;
            }
            if (checkColor.equals(otherColor)) {
                possibleFields.add(zeileX + ";" + (spalteY - count4) + "!");
                break;
            }
            possibleFields.add(zeileX + ";" + (spalteY - count4));
            count4++;
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
