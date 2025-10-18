package com.sandysystems.menu.menuUnidad2LYAII;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenu extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                MainMenu.class.getResource("/com/sandysystems/menu/menuUnidad2LYAII/menu.fxml")
        );
        Scene scene = new Scene(loader.load(), 1000, 700);
        stage.setTitle("Menú_ Generación de código intermedio");
        stage.setScene(scene);
        stage.show();
    }
}
