package application.bean;

import javafx.scene.control.Label;

public class SelectLabel  extends Label{
private	ConnObj connObj;
private boolean selected;
public SelectLabel(String SelectLabel){
	super.setText(SelectLabel); 
	
}
public boolean isSelected() {
	return selected;
}

public void setSelected(boolean selected) {
	this.selected = selected;
}
public ConnObj getConnObj() {
	return connObj;
}
public void setConnObj(ConnObj connObj) {
	this.connObj = connObj;
}


}
