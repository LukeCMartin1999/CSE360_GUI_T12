import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;


public class Main extends Application implements EventHandler <ActionEvent> {
	Button addItem;

	public static void main(String[] args) {
		
			launch(args);
	}
	
	
	
	@Override 
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("To-Do List Application");
		addItem = new Button();
		addItem.setText("Add item to my To-Do List");
		addItem.setOnAction(this);
		
		StackPane layout = new StackPane();
		layout.getChildren().add(addItem);
				
		Scene scene = new Scene(layout, 600, 600);
			
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	@Override 
	public void handle(ActionEvent event) {
		
		if(event.getSource() == addItem) 
		{ 			
			System.out.println("Add Some item to the list");
			
		} 		
		
	}
}
