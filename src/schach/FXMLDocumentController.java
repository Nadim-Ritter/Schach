package schach;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class FXMLDocumentController implements Initializable {

    ArrayList<String> cords = new ArrayList();
        ArrayList<StackPane> coloredFields = new ArrayList();
    ArrayList<ImageView> figuren = new ArrayList();
    String currentColor = "weiss";
    String otherColor;

    @FXML
    private AnchorPane pane;

    @FXML
    private GridPane field;

    @FXML
    private void setStartFormation() {
        
        field.setStyle("-fx-background-image: url('file:figurenBilder/schachbrett.jpg')");
        
        int grösse = 35;
        int zeileX = 0;
        for (int i = 0; i < 16; i++) {
            String farbe;
            int spalteY;
            if (i < 8) {
                farbe = "schwarz";
                spalteY = 1;
            } else {
                farbe = "weiss";
                spalteY = 6;
            }
            if (i == 8) {
                zeileX = 0;
            }
            ImageView iv = new ImageView();
            Image bauer = new Image("file:figurenBilder/" + farbe + "_bauer.PNG");
            iv.setId(farbe + "_bauer");
            iv.setImage(bauer);
            iv.setPreserveRatio(true);
            iv.setFitWidth(grösse);
            field.add(iv, zeileX, spalteY);
            figuren.add(iv);
            zeileX++;
        }
        int turmCordsx[] = {0, 7, 0, 7};
        int turmCordsy[] = {0, 0, 7, 7};
        for (int i = 0; i < 4; i++) {
            String farbe;
            if (i < 2) {
                farbe = "schwarz";
            } else {
                farbe = "weiss";
            }
            ImageView iv = new ImageView();
            Image turm = new Image("file:figurenBilder/" + farbe + "_turm.PNG");
            iv.setId(farbe + "_turm");
            iv.setImage(turm);
            iv.setPreserveRatio(true);
            iv.setFitWidth(grösse);
            field.add(iv, turmCordsx[i], turmCordsy[i]);
            figuren.add(iv);
        }
        int pferdCordsx[] = {1, 6, 1, 6};
        int pferdCordsy[] = {0, 0, 7, 7};
        for (int i = 0; i < 4; i++) {
            String farbe;
            if (i < 2) {
                farbe = "schwarz";
            } else {
                farbe = "weiss";
            }
            ImageView iv = new ImageView();
            Image pferd = new Image("file:figurenBilder/" + farbe + "_pferd.PNG");
            iv.setId(farbe + "_pferd");
            iv.setImage(pferd);
            iv.setPreserveRatio(true);
            iv.setFitWidth(grösse);
            field.add(iv, pferdCordsx[i], pferdCordsy[i]);
            figuren.add(iv);
        }
        int läuferCordsx[] = {2, 5, 2, 5};
        int läuferCordsy[] = {0, 0, 7, 7};
        for (int i = 0; i < 4; i++) {
            String farbe;
            if (i < 2) {
                farbe = "schwarz";
            } else {
                farbe = "weiss";
            }
            ImageView iv = new ImageView();
            Image läufer = new Image("file:figurenBilder/" + farbe + "_läufer.PNG");
            iv.setId(farbe + "_läufer");
            iv.setImage(läufer);
            iv.setPreserveRatio(true);
            iv.setFitWidth(grösse);
            field.add(iv, läuferCordsx[i], läuferCordsy[i]);
            figuren.add(iv);
        }
        int dameCordsx[] = {3, 3};
        int dameCordsy[] = {0, 7};
        for (int i = 0; i < 2; i++) {
            String farbe;
            if (i < 1) {
                farbe = "schwarz";
            } else {
                farbe = "weiss";
            }
            ImageView iv = new ImageView();
            Image dame = new Image("file:figurenBilder/" + farbe + "_dame.PNG");
            iv.setId(farbe + "_dame");
            iv.setImage(dame);
            iv.setPreserveRatio(true);
            iv.setFitWidth(grösse);
            field.add(iv, dameCordsx[i], dameCordsy[i]);
            figuren.add(iv);
        }
        int königCordsx[] = {4, 4};
        int königCordsy[] = {0, 7};
        for (int i = 0; i < 2; i++) {
            String farbe;
            if (i < 1) {
                farbe = "schwarz";
            } else {
                farbe = "weiss";
            }
            ImageView iv = new ImageView();
            Image könig = new Image("file:figurenBilder/" + farbe + "_könig.PNG");
            iv.setId(farbe + "_könig");
            iv.setImage(könig);
            iv.setPreserveRatio(true);
            iv.setFitWidth(grösse);
            field.add(iv, königCordsx[i], königCordsy[i]);
            figuren.add(iv);
        }
    }

    @FXML
    private void move() {
        for (int i = 0; i < figuren.size(); i++) {
            ImageView iv = figuren.get(i);

            figuren.get(i).onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent arg0) {
                    String colorFigur[] = iv.getId().split("_");
                    otherColor = "";
                    if (currentColor.equals("weiss")) {
                        otherColor = "schwarz";
                    } else {
                        otherColor = "weiss";
                    }
                    if (colorFigur[0].equals(currentColor)) {   
                        if (colorFigur[1].equals("bauer")) {
                            Bauer bauer = new Bauer(GridPane.getColumnIndex(iv), GridPane.getRowIndex(iv), colorFigur[0], field);
                            colorFields(bauer.showPossibleFields(), iv);
                        } else if (colorFigur[1].equals("turm")) {
                            Turm turm = new Turm(GridPane.getColumnIndex(iv), GridPane.getRowIndex(iv), colorFigur[0], field);
                            colorFields(turm.showPossibleFields(), iv);
                        } else if (colorFigur[1].equals("läufer")) {
                            Läufer läufer = new Läufer(GridPane.getColumnIndex(iv), GridPane.getRowIndex(iv), colorFigur[0], field);
                            colorFields(läufer.showPossibleFields(), iv);
                        } else if (colorFigur[1].equals("dame")) {
                            Dame dame = new Dame(GridPane.getColumnIndex(iv), GridPane.getRowIndex(iv), colorFigur[0], field);
                            colorFields(dame.showPossibleFields(), iv);
                        } else if (colorFigur[1].equals("pferd")) {
                            Pferd pferd = new Pferd(GridPane.getColumnIndex(iv), GridPane.getRowIndex(iv), colorFigur[0], field);
                            colorFields(pferd.showPossibleFields(), iv);
                        } else if (colorFigur[1].equals("könig")) {
                            König könig = new König(GridPane.getColumnIndex(iv), GridPane.getRowIndex(iv), colorFigur[0], field);
                            colorFields(könig.showPossibleFields(), iv);
                        }
                    }

                }
            });
        }

    }

    @FXML
    private void colorFields(ArrayList<String> possibleFields, ImageView iv) {
        field.getChildren().removeAll(coloredFields);

        //check if king could be eaten
        if (iv.getId().contains("könig")) {
            for (int u = 0; u < field.getChildren().size(); u++) {
                if (field.getChildren().get(u).getId() != null) {
                    if (field.getChildren().get(u).getId().contains(otherColor)) {
                        String colorFigur[] = field.getChildren().get(u).getId().split("_");

                        if (colorFigur[1].equals("bauer")) {
                            ArrayList<String> options = new ArrayList();
                            if (colorFigur[0].equals("schwarz")) {
                                int x1 = GridPane.getColumnIndex(field.getChildren().get(u)) + 1;
                                int y1 = GridPane.getRowIndex(field.getChildren().get(u)) + 1;

                                int x2 = GridPane.getColumnIndex(field.getChildren().get(u)) - 1;
                                int y2 = GridPane.getRowIndex(field.getChildren().get(u)) + 1;

                                options.add(x1 + ";" + y1);
                                options.add(x2 + ";" + y2);
                                options.add(x1 + ";" + y1 + "!");
                                options.add(x2 + ";" + y2 + "!");
                            } else {
                                int x1 = GridPane.getColumnIndex(field.getChildren().get(u)) + 1;
                                int y1 = GridPane.getRowIndex(field.getChildren().get(u)) - 1;

                                int x2 = GridPane.getColumnIndex(field.getChildren().get(u)) - 1;
                                int y2 = GridPane.getRowIndex(field.getChildren().get(u)) - 1;

                                options.add(x1 + ";" + y1);
                                options.add(x2 + ";" + y2);
                                options.add(x1 + ";" + y1 + "!");
                                options.add(x2 + ";" + y2 + "!");
                            }
                            for (int z = 0; z < options.size(); z++) {
                                for (int s = 0; s < possibleFields.size(); s++) {
                                    if (options.get(z).equals(possibleFields.get(s))) {
                                        possibleFields.remove(s);
                                    }
                                }
                            }
                        } else if (colorFigur[1].equals("turm")) {
                            Turm turm = new Turm(GridPane.getColumnIndex(field.getChildren().get(u)), GridPane.getRowIndex(field.getChildren().get(u)), colorFigur[0], field);
                            for (int z = 0; z < turm.showPossibleFields().size(); z++) {
                                System.out.println(turm.showPossibleFields());
                                for (int s = 0; s < possibleFields.size(); s++) {
                                    System.out.println(possibleFields.get(s));
                                    if (turm.showPossibleFields().get(z).equals(possibleFields.get(s))) {
                                        possibleFields.remove(s);
                                    }
                                }
                            }
                        } else if (colorFigur[1].equals("läufer")) {
                            Läufer läufer = new Läufer(GridPane.getColumnIndex(field.getChildren().get(u)), GridPane.getRowIndex(field.getChildren().get(u)), colorFigur[0], field);
                            for (int z = 0; z < läufer.showPossibleFields().size(); z++) {
                                for (int s = 0; s < possibleFields.size(); s++) {
                                    if (läufer.showPossibleFields().get(z).equals(possibleFields.get(s))) {
                                        possibleFields.remove(s);
                                    }
                                }
                            }
                        } else if (colorFigur[1].equals("dame")) {
                            Dame dame = new Dame(GridPane.getColumnIndex(field.getChildren().get(u)), GridPane.getRowIndex(field.getChildren().get(u)), colorFigur[0], field);
                            for (int z = 0; z < dame.showPossibleFields().size(); z++) {
                                for (int s = 0; s < possibleFields.size(); s++) {
                                    if (dame.showPossibleFields().get(z).equals(possibleFields.get(s))) {
                                        possibleFields.remove(s);
                                    }
                                }
                            }
                        } else if (colorFigur[1].equals("pferd")) {
                            Pferd pferd = new Pferd(GridPane.getColumnIndex(field.getChildren().get(u)), GridPane.getRowIndex(field.getChildren().get(u)), colorFigur[0], field);
                            for (int z = 0; z < pferd.showPossibleFields().size(); z++) {
                                for (int s = 0; s < possibleFields.size(); s++) {
                                    if (pferd.showPossibleFields().get(z).equals(possibleFields.get(s))) {
                                        possibleFields.remove(s);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        /////////

        for (int i = 0; i < possibleFields.size(); i++) {
            boolean enemy = false;
            String possibleField = "";
            if (possibleFields.get(i).contains("!")) {
                enemy = true;
                possibleField = possibleFields.get(i).replaceAll("!", "");
            } else {
                possibleField = possibleFields.get(i);
            }

            String pField[] = possibleField.split(";");

            int x = Integer.parseInt(pField[0]);
            int y = Integer.parseInt(pField[1]);

            StackPane color = new StackPane();

            if (enemy == false) {
                color.setStyle("-fx-border-color: #39c615 ;\n"
                        + "-fx-border-width: 3;");
            } else {
                color.setStyle("-fx-border-color: #e22424 ;\n"
                        + "-fx-border-width: 3;");
            }
            try {
                field.add(color, x, y);
            } catch (IllegalArgumentException e) {

            }

            coloredFields.add(color);
            color.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent arg0) {
                    currentColor = otherColor;
                    field.getChildren().remove(iv);
                    field.add(iv, x, y);
                    if (checkIfNodeExists(x, y).getId() != null) {
                        field.getChildren().remove(checkIfNodeExists(x, y));
                    }
                    field.getChildren().removeAll(coloredFields);
                }
            });
        }
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setStartFormation();
        move();
    }
}
