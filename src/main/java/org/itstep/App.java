package org.itstep;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App extends Application {

    @Override
    public void start(Stage stage) {
//        ImageView logoView = new ImageView();
//
//        Image image = new Image(pathToCard("itstep-logo.png"));
//
//        logoView.setImage(image);
//        logoView.setPreserveRatio(true);
//        logoView.setFitWidth(100);
//
//        playAnimation(logoView);


//        Rectangle rectangle = new Rectangle(1900,1000);
//        rectangle.setFill(Paint.valueOf("green"));

        ImageView backgroundView = new ImageView();
        Image background = new Image(pathToCard("background2.png"));
        backgroundView.setImage(background);
        backgroundView.setFitHeight(1080);
        backgroundView.setFitWidth(1920);
        backgroundView.setPreserveRatio(true);

        Rectangle rectangle = new Rectangle(500,1200);
        rectangle.setFill(Paint.valueOf("black"));
        rectangle.setX(1450);

        TextField textField = new TextField();
        textField.relocate(1700, 100);

        Label text1 = new Label("Bet");
        text1.setFont(Font.font("Bolt Gothic", 25));
        text1.setTextFill(Paint.valueOf("white"));
        text1.relocate(1600, 95); // указываем местоположение метки - отступ по 10px сверху и слева

        Button buttonPlaceBet = new Button("Place");
        buttonPlaceBet.relocate(1650, 130);

        Button buttonPlay = new Button("Play");
        buttonPlay.relocate(1650, 180);

        Button buttonSave = new Button("Save");
        buttonSave.relocate(1650, 230);

        Button buttonExit = new Button("Exit");
        buttonExit.relocate(1650, 280);




        Pane rootNode = new Pane();


        rootNode.getChildren().add(backgroundView);
        rootNode.getChildren().add(rectangle);
        rootNode.getChildren().add(textField);
        rootNode.getChildren().add(text1);
        rootNode.getChildren().add(buttonPlaceBet);
        rootNode.getChildren().add(buttonPlay);
        rootNode.getChildren().add(buttonSave);
        rootNode.getChildren().add(buttonExit);



        Scene scene = new Scene(rootNode, 1900, 1000);
        stage.setScene(scene);
        stage.setTitle("BlackJack");
        stage.getIcons().add(new Image("icon.png"));
        stage.show();


    }

    private String pathToCard(String cardFilename) {
        if(cardFilename == null) return null;
        String[] parts = cardFilename.split("/");
        return App.class.getClassLoader().getResource(parts[0]) + (parts.length == 2 ? parts[1] : "");
    }

    private void playAnimation(ImageView logoView) {
        //Creating scale Transition
        FadeTransition fadeTransition = new FadeTransition();
        ScaleTransition scaleTransition = new ScaleTransition();

        final Duration duration = Duration.millis(1500);

        //Setting the duration for the transition
        scaleTransition.setDuration(duration);
        fadeTransition.setDuration(duration);

        //Setting the node for the transition
        scaleTransition.setNode(logoView);
        fadeTransition.setNode(logoView);

        //Setting the dimensions for scaling
        scaleTransition.setByY(2);
        scaleTransition.setByX(2);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);

        //Setting the cycle count for the translation
        //scaleTransition.setCycleCount(50);

        //Setting auto reverse value to true
        scaleTransition.setAutoReverse(true);

        scaleTransition.play();
        fadeTransition.play();
    }

    public static void main(String[] args) throws URISyntaxException {
        launch();
    }

}