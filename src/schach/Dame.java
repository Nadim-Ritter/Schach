package schach;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Dame{
    
    private int zeileX;
    private int spalteY;
    private String color;
    private GridPane field;

    public Dame(int zeileX, int spalteY, String color, GridPane field) {
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
            if(zeileX + count > 7 || spalteY + count > 7){
                break;
            }
            String checkColor = "";
            if (checkIfNodeExists(zeileX + count, spalteY + count) != null && checkIfNodeExists(zeileX + count, spalteY + count).getId() != null) {
                String temp[] = checkIfNodeExists(zeileX + count, spalteY + count).getId().split("_");
                checkColor = temp[0];
            }
            if (checkColor.equals(color)) {
                break;
            }
            if (checkColor.equals(otherColor)) {
                possibleFields.add((zeileX + count) + ";" + (spalteY + count) + "!");
                
                break;
            }
            possibleFields.add((zeileX + count) + ";" + (spalteY + count));
            count++;
            
        }
        //////////////////////
        int count2 = 1;
        for (int i = spalteY; i < 7; i++) {
            if(zeileX - count2 > 7 || spalteY + count2 > 7){
                break;
            }
            String checkColor = "";
            if (checkIfNodeExists(zeileX - count2, spalteY + count2) != null && checkIfNodeExists(zeileX - count2, spalteY + count2).getId() != null) {
                String temp[] = checkIfNodeExists(zeileX - count2, spalteY + count2).getId().split("_");
                checkColor = temp[0];
            }
            if (checkColor.equals(color)) {
                break;
            }
            if (checkColor.equals(otherColor)) {
                possibleFields.add((zeileX - count2)+ ";" + (spalteY + count2) + "!");
                break;
            }
            possibleFields.add((zeileX - count2) + ";" + (spalteY + count2));
            count2++;
        }
        
        //////
        int count3 = 1;
        for (int i = zeileX; i > 0; i--) {
            if(zeileX - count3 > 7 || spalteY - count3 > 7){
                break;
            }
            String checkColor = "";
            if (checkIfNodeExists(zeileX - count3, spalteY - count3) != null && checkIfNodeExists(zeileX - count3, spalteY - count3).getId() != null) {
                String temp[] = checkIfNodeExists(zeileX - count3, (spalteY - count3)).getId().split("_");
                checkColor = temp[0];
            }
            if (checkColor.equals(color)) {
                break;
            }
            if (checkColor.equals(otherColor)) {
                possibleFields.add((zeileX - count3) + ";" + (spalteY - count3) + "!");
                break;
            }
            possibleFields.add((zeileX - count3) + ";" + (spalteY - count3));
            count3++;
        }
        ///////
        int count4 = 1;
        for (int i = spalteY; i > 0; i--) {
            if(zeileX + count4 > 7 || spalteY - count4 > 7){
                break;
            }
            String checkColor = "";
            if (checkIfNodeExists(zeileX + count4, spalteY - count4) != null && checkIfNodeExists(zeileX + count4, spalteY - count4).getId() != null) {
                String temp[] = checkIfNodeExists(zeileX + count4, spalteY - count4).getId().split("_");
                checkColor = temp[0];
            }
            if (checkColor.equals(color)) {
                break;
            }
            if (checkColor.equals(otherColor)) {
                possibleFields.add((zeileX + count4) + ";" + (spalteY - count4) + "!");
                break;
            }
            possibleFields.add((zeileX + count4)+ ";" + (spalteY - count4));
            count4++;
        }
        //////
        int count5 = 1;
        for (int i = zeileX; i < 7; i++) {
            String checkColor = "";
            if (checkIfNodeExists(zeileX + count5, spalteY) != null && checkIfNodeExists(zeileX + count5, spalteY).getId() != null) {
                String temp[] = checkIfNodeExists(zeileX + count5, spalteY).getId().split("_");
                checkColor = temp[0];
            }
            if (checkColor.equals(color)) {
                break;
            }
            if (checkColor.equals(otherColor)) {
                possibleFields.add((zeileX + count5) + ";" + spalteY + "!");
                break;
            }
            possibleFields.add((zeileX + count5) + ";" + spalteY);
            count5++;
        }
        //////////////////////
        int count6 = 1;
        for (int i = spalteY; i < 7; i++) {
            String checkColor = "";
            if (checkIfNodeExists(zeileX, spalteY + count6) != null && checkIfNodeExists(zeileX, spalteY + count6).getId() != null) {
                String temp[] = checkIfNodeExists(zeileX, spalteY + count6).getId().split("_");
                checkColor = temp[0];
            }
            if (checkColor.equals(color)) {
                break;
            }
            if (checkColor.equals(otherColor)) {
                possibleFields.add(zeileX + ";" + (spalteY + count6) + "!");
                break;
            }
            possibleFields.add(zeileX + ";" + (spalteY + count6));
            count6++;
        }
        //////
        int count7 = 1;
        for (int i = zeileX; i > 0; i--) {
            String checkColor = "";
            if (checkIfNodeExists(zeileX - count7, spalteY) != null && checkIfNodeExists(zeileX - count7, spalteY).getId() != null) {
                String temp[] = checkIfNodeExists(zeileX - count7, spalteY).getId().split("_");
                checkColor = temp[0];
            }
            if (checkColor.equals(color)) {
                break;
            }
            if (checkColor.equals(otherColor)) {
                possibleFields.add((zeileX - count7) + ";" + spalteY + "!");
                break;
            }
            possibleFields.add((zeileX - count7) + ";" + spalteY);
            count7++;
        }
        ///////
        int count8 = 1;
        for (int i = spalteY; i > 0; i--) {
            String checkColor = "";
            if (checkIfNodeExists(zeileX, spalteY - count8) != null && checkIfNodeExists(zeileX, spalteY - count8).getId() != null) {
                String temp[] = checkIfNodeExists(zeileX, spalteY - count8).getId().split("_");
                checkColor = temp[0];
            }
            if (checkColor.equals(color)) {
                break;
            }
            if (checkColor.equals(otherColor)) {
                possibleFields.add(zeileX + ";" + (spalteY - count8) + "!");
                break;
            }
            possibleFields.add(zeileX + ";" + (spalteY - count8));
            count8++;
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