package schach;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class FXMLDocumentController implements Initializable {

    ArrayList<String> cords = new ArrayList();
    ArrayList<StackPane> coloredFields = new ArrayList();
    ArrayList<ImageView> figuren = new ArrayList();

    @FXML
    private AnchorPane pane;

    @FXML
    private GridPane field;

    @FXML
    private void setStartFormation() {
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
            iv.setFitWidth(30);
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
            iv.setFitWidth(30);
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
            iv.setFitWidth(30);
            field.add(iv, pferdCordsx[i], pferdCordsy[i]);
            figuren.add(iv);
        }
        int l�uferCordsx[] = {2, 5, 2, 5};
        int l�uferCordsy[] = {0, 0, 7, 7};
        for (int i = 0; i < 4; i++) {
            String farbe;
            if (i < 2) {
                farbe = "schwarz";
            } else {
                farbe = "weiss";
            }
            ImageView iv = new ImageView();
            Image l�ufer = new Image("file:figurenBilder/" + farbe + "_l�ufer.PNG");
            iv.setId(farbe + "_l�ufer");
            iv.setImage(l�ufer);
            iv.setPreserveRatio(true);
            iv.setFitWidth(30);
            field.add(iv, l�uferCordsx[i], l�uferCordsy[i]);
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
            iv.setFitWidth(30);
            field.add(iv, dameCordsx[i], dameCordsy[i]);
            figuren.add(iv);
        }
        int k�nigCordsx[] = {4, 4};
        int k�nigCordsy[] = {0, 7};
        for (int i = 0; i < 2; i++) {
            String farbe;
            if (i < 1) {
                farbe = "schwarz";
            } else {
                farbe = "weiss";
            }
            ImageView iv = new ImageView();
            Image k�nig = new Image("file:figurenBilder/" + farbe + "_k�nig.PNG");
            iv.setId(farbe + "_dame");
            iv.setImage(k�nig);
            iv.setPreserveRatio(true);
            iv.setFitWidth(30);
            field.add(iv, k�nigCordsx[i], k�nigCordsy[i]);
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

                    if (colorFigur[1].equals("bauer")) {
                        Bauer bauer = new Bauer(GridPane.getColumnIndex(iv), GridPane.getRowIndex(iv), colorFigur[0]);
                        colorFields(bauer.showPossibleFields(), iv);
                    } else if (colorFigur[1].equals("turm")) {
                        Turm turm = new Turm(GridPane.getColumnIndex(iv), GridPane.getRowIndex(iv), colorFigur[0]);
                        colorFields(turm.showPossibleFields(), iv);
                    }

                }
            });
        }

    }

    @FXML
    private void colorFields(ArrayList<String> possibleFields, ImageView iv) {
        field.getChildren().removeAll(coloredFields);

        for (int i = 0; i < possibleFields.size(); i++) {
            String pField[] = possibleFields.get(i).split(";");
            int x = Integer.parseInt(pField[0]);
            int y = Integer.parseInt(pField[1]);

            StackPane color = new StackPane();

//            if (checkIfEat(x, y) != null) {
//                color.setStyle("-fx-border-color: #e82727 ;\n"
//                             + "-fx-border-width: 3;");
//            } else {
//                color.setStyle("-fx-border-color: #21a52f ;\n"
//                             + "-fx-border-width: 3;");
//            }
            color.setStyle("-fx-border-color: #21a52f ;\n"
                    + "-fx-border-width: 3;");

//            if (checkIfEat(x, y) == true) {
//                System.out.println("test");
//            }
            checkIfEat(x, y);


            field.add(color, x, y);
            coloredFields.add(color);
            color.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent arg0) {
                    field.getChildren().remove(iv);
                    field.add(iv, x, y);
                    field.getChildren().removeAll(coloredFields);
                }
            });

        }

    }

    public void checkIfEat(int x, int y) {
        //boolean check = true;
        for (Node node : field.getChildren()) {
            if (GridPane.getColumnIndex(node) == x && GridPane.getRowIndex(node) == y) {
//                check = true;
//                return check;
                System.out.println("true");
            }else{
//                check = false;
//                return check;
                System.out.println("qwer");
            }
        }
        //return check;
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setStartFormation();
        move();

        // TODO
    }

}
