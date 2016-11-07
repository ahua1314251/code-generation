package application;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class AddDbAction {

	private MenuItem mItemMySql;
	
	public AddDbAction(MenuItem mItemMySql){
		
		this.mItemMySql = mItemMySql;

		mItemMySql.setOnAction((ActionEvent t) -> {  
              System.out.println(123123);
          	System.out.println("1111111111111111111111");
			Stage a = new Stage();
			ModalDialog dialog = new ModalDialog(a);
            });
		
		
		
		
		
	} 
	
}
