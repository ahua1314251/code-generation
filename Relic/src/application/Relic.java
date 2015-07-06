package application;

import application.view.ViewResource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Relic extends Application{

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
	
    public void start(){
    	launch();
    }
}
