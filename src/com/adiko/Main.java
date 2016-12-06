package com.adiko;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main extends Application {

    private Map<Integer, Befehl> befehlsammlung;

    public static void main(String[] args) {
        launch(args);
    }

    Stage window;

    private File file;

    TextField textField;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        VBox layout = new VBox();

        Button btnChooseFile = new Button("choose File...");
        btnChooseFile.setOnAction((ActionEvent e) -> process());


        StackPane root = new StackPane();
        root.getChildren().add(layout);

        window.setScene(new Scene(root, 300, 300));
        window.show();

    }

    private void process() {
        chooseFile();
        parseTf();
        executeBefehle();
    }

    private void executeBefehle() {
        // TODO befehle iterieren und ausführen
        // JAVA 8 stream?
    }

    private void chooseFile() {
        file = new FileChooser().showOpenDialog(window);
    }

    private void parseTf() {
        befehlsammlung = new HashMap<>();
        if (file != null) {
            StringBuffer buffer = new StringBuffer("");
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while (line != null) {
                    buffer.append(line);
                    line = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] befehle = buffer.toString().split(", ");
            for (int i = 0; i < befehle.length; i++) {
                Richtung richtung = Richtung.parseMove(befehle[i].substring(0, 1));
                int schritte = Integer.parseInt(befehle[i].substring(1));
                befehlsammlung.put(i, new Befehl(richtung, schritte));
            }
        }
    }
}
