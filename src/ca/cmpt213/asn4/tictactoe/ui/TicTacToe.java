package ca.cmpt213.asn4.tictactoe.ui;

import ca.cmpt213.asn4.tictactoe.game.Table;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import java.util.ArrayList;
import javafx.scene.layout.Region;
import javafx.scene.control.Control;

public class TicTacToe extends Application {
    //set up Image
    Image plain = new Image("file:photos/plain.png");
    Image xImage = new Image("file:photos/letterX.png");
    Image oImage = new Image("file:photos/letterO.png");

    //create game locgic table
    Table logicTable = new Table();

    //create image table
    ArrayList<ArrayList<ImageView>> imageTable = new ArrayList<ArrayList<ImageView>>();

    //create girdpane
    GridPane gridpane = new GridPane();

    //create notification stating winner
    Label notification = new Label(" ");
    @Override

    //fix
    public void start(Stage primaryStage) throws Exception{
        for (int i = 0; i < 4; i++){
            ArrayList<ImageView> oneRow = new ArrayList<ImageView>();
            for (int j = 0; j < 4; j++){
                ImageView plainView = new ImageView(plain);
                plainView.addEventHandler(MouseEvent.MOUSE_CLICKED, new ImageClickHandler());
                oneRow.add(plainView);
            }
            imageTable.add(oneRow);
        }

        //set up gridpane
        //fix
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                gridpane.add(imageTable.get(j).get(i), i, j);
            }
        }

        //create new game button
        Button newGame = new Button("New Game");

        //set up new game button
        newGame.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                //reset logic table
                logicTable = new Table();

                //create new image table
                imageTable = new ArrayList<ArrayList<ImageView>>();

                //set up new image table
                for (int i = 0; i < 4; i++){
                    ArrayList<ImageView> oneRow = new ArrayList<ImageView>();
                    for (int j = 0; j < 4; j++){
                        ImageView plainView = new ImageView(plain);
                        plainView.addEventHandler(MouseEvent.MOUSE_CLICKED, new ImageClickHandler());
                        oneRow.add(plainView);
                    }
                    imageTable.add(oneRow);
                }

                //reset gridpane
                for (int i = 0; i < 4; i++){
                    for (int j = 0; j < 4; j++){
                        gridpane.add(imageTable.get(j).get(i), i, j);
                    }
                }

                //reset notification label
                notification.setText(" ");
            }
        });

        VBox vbox = new VBox(10, gridpane, notification, newGame);

        Scene scene = new Scene(vbox,400,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.show();
    }

    class ImageClickHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent e) {
            if (logicTable.isxWin() || logicTable.isoWin()){ }

            else if (logicTable.isxWin() == false|| logicTable.isoWin() == false){
                for (int i = 0; i < 4; i++){
                    for (int j = 0; j < 4; j++){
                        if (e.getSource().equals(imageTable.get(i).get(j))) {
                            logicTable.makeMove(i, j);
                            if (logicTable.getElem(i, j) == 1){
                                imageTable.get(i).set(j, new ImageView(xImage));
                                gridpane.add(imageTable.get(i).get(j), j, i);
                            }
                            else if (logicTable.getElem(i, j) == 2){
                                imageTable.get(i).set(j, new ImageView(oImage));
                                gridpane.add(imageTable.get(i).get(j), j, i);
                            }
                            if (logicTable.isxWin()){
                                notification.setText("X wins!");
                            }
                            else if (logicTable.isoWin()){
                                notification.setText("O wins!");
                            }
                            else if (logicTable.isTie()){
                                notification.setText("Tie!");
                            }
                        }
                    }
                }
            }
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}

