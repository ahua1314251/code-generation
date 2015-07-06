/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import application.view.ViewResource;

/**
 *
 * @author tom
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

    	init();
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(ViewResource.class.getResourceAsStream("Main.fxml"));
        
        Scene scene = new Scene(root);        
        scene.getStylesheets().add(ViewResource.class.getResource("main.css").toExternalForm());
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
  // ModalDialog md = new ModalDialog(primaryStage);
    }

    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {    	
        launch(args);
    }
    
    public void start(){
    	launch();
    }
    
    public void init()
    {
    	Context.init();
    	
    }
}
