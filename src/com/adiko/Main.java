package com.adiko;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Main extends Application {

    private Map<Integer, Command> commands;
    private Position position = Position.getInstance();

    public static void main(String[] args) {
        launch(args);
    }

    private Stage window;

    private File file;

    private TextField tfInput;
    private TextField tfOutput;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        Label label = new Label("parse from:");

        // TODO later
        // HBox buttons = new HBox();

        ToggleButton tbSource = new ToggleButton("from texfield");

        Button btnGo = new Button("GO!");
        btnGo.setOnAction((ActionEvent e) -> process());

        tfInput = new TextField();
        tfOutput = new TextField();

        layout.getChildren().addAll(tfInput, btnGo, tfOutput);

//        StackPane root = new StackPane();
//        root.getChildren().add(layout);

        window.setScene(new Scene(layout, 300, 300));
        window.show();
    }

    private void process() {

        // chooseFile();
        // parseFile();
        parseTf();
        executeCommands();
    }

    private void executeCommands() {
        // TODO befehle iterieren und ausführen
        commands.forEach((index, command) -> position.execute(command));
        tfOutput.setText(String.format("distance: %d", position.getDistance()));
    }

    private void chooseFile() {
        file = new FileChooser().showOpenDialog(window);
    }

    private void parseFile() {
        if (file != null) {
            StringBuilder sb = new StringBuilder("");
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while (line != null) {
                    sb.append(line);
                    line = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // TODO assert regex?
            parseCommands(sb.toString());
        }
    }

    private void parseTf() {
        // TODO assert regex?
        parseCommands(tfInput.getText());
    }

    private void parseCommands(String commandString) {
        commands = new HashMap<>();
        String[] commandStringSplit = commandString.split(", ");
        for (int i = 0; i < commandStringSplit.length; i++) {
            Turndirection turndirection = Turndirection.parseMove(commandStringSplit[i].substring(0, 1));
            int steps = Integer.parseInt(commandStringSplit[i].substring(1));
            commands.put(i, new Command(turndirection, steps));
        }
    }


}
