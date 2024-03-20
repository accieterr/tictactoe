package com.github.accieterr.tictactoeFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	try
    	{
    		Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
		    Scene scene = new Scene(root);
		    scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
		    
		    stage.setResizable(false);
		    stage.setTitle("Tic Tac Toe");
		    
		    Image icon = new Image("/icon.png");
		    stage.getIcons().add(icon);
		    
		    stage.setScene(scene);
		    stage.show();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}