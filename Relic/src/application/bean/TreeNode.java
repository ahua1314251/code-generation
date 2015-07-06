package application.bean;



import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;

public class TreeNode<T> extends TreeItem<T>{
    String Key;
    public TreeNode(T value)
    {
    	super.setValue((T)value);
    }
    
	public String getKey() {
		return Key;
	}

	public void setKey(String key) {
		Key = key;
	}

    
	
}
