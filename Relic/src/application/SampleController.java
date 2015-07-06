package application;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;
import application.bean.ConnObj;
import application.bean.DbConfiguration;
import application.bean.SelectLabel;
import application.bean.TreeNode;
import application.bean.TreeObj;
import application.file.Resource;
import application.gen.gen;
import application.gen.bean.Table;
import application.util.JdbcUtil;

public class SampleController  implements Initializable{
	final Rectangle selection = new Rectangle() ;
	public final ObservableList<String> oList =  FXCollections.observableArrayList();
	@FXML
	public ListView<String> dbView;
	@FXML
	public FlowPane tableView;
     @FXML ImageView logo;
     @FXML TreeView<TreeObj> treeView;
     @FXML FlowPane flowPane;
     @FXML AnchorPane flowPaneRoot;
     @FXML Button genButton;
     
	public ObservableList<String> getoList() {
		return oList;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		initRectangle();
		initLogo();
		initTreeView();
		initGenButton();
		for(int i=0; i<50;i++){
			SelectLabel label =  new SelectLabel("asd");
			
			label.setWrapText(true);
			label.setGraphic(new ImageView(Context.Icon_Table2));
			label.getStyleClass().add("label1");
			
		flowPane.getChildren().add(label);
		}
		
		flowPane.setPadding(new Insets(5, 0, 0, 5));
		flowPane.setVgap(5);
		flowPane.setHgap(5);
		flowPaneRoot.getChildren().add(selection);	
	}


	public void initLogo(){
		InputStream in=Resource.class.getResourceAsStream("MyLogo50.png");
		Image image = new Image(in);
		logo.setImage(image);
	}
	
	public void initTreeView(){
		TreeItem<TreeObj> rootItem1 = new TreeItem<TreeObj> (new TreeObj("root",123));
		
        for(DbConfiguration dbc: Context.DbList.getDbConfigurations())
        {
        	
        	TreeNode<TreeObj> leaf1=new TreeNode<TreeObj>(new TreeObj(dbc.getName(),new ConnObj(dbc)));
        	leaf1.setGraphic(new ImageView(Context.Icon_Connector));
        	leaf1.setExpanded(true);
  
        	rootItem1.getChildren().add(leaf1);
      
        }
		rootItem1.setExpanded(true);
		
		treeView.setRoot(rootItem1);
		treeView.setEditable(false);
		treeView.setCellFactory(new Callback<TreeView<TreeObj>,TreeCell<TreeObj>>(){
            @Override
            public TreeCell<TreeObj> call(TreeView<TreeObj> p) {
                return new TextFieldTreeCellImpl();
            }
        });
		
	}

	 private final class TextFieldTreeCellImpl extends TreeCell<TreeObj> { 
	        private TextField textField; 
	        public TextFieldTreeCellImpl() {
	        	 final TreeCell<TreeObj> this$ = this;
		        	this.addEventHandler(MouseEvent.ANY, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							if(event.getEventType()==MouseEvent.MOUSE_PRESSED){
			                if(event.getClickCount()==2){
			                	ConnObj obj=(ConnObj) getItem().getObject();
			                	if("sqlServer".equalsIgnoreCase(obj.getDbConfiguration().getDbType()))
			                	{
			                		JdbcUtil.setTreeForSQLSERVER(getItem(),obj, this$.getTreeItem(), flowPane);
			                	}
			                	else
			                	{
			                		JdbcUtil.setTreeForMYSQL(getItem(),obj, this$.getTreeItem(), flowPane);
			                	}
			                	
			                //	this$.getTreeItem().getChildren().add(new TreeItem<TreeObj>(new TreeObj("1111111",3333))); 	
			                }}}
						
					});
	        }
/*	        @Override
	        public void startEdit() {
	            super.startEdit();
	            if (textField == null) {
	                createTextField();
	            }
	            setText(null);
	            setGraphic(textField);
	            textField.selectAll();
	        }
	 
	        @Override
	        public void cancelEdit() {
	            super.cancelEdit();
	            setText(((TreeObj) getItem()).toString());
	            setGraphic(getTreeItem().getGraphic());
	        }*/
	 
	        @Override
	        public void updateItem(TreeObj item, boolean empty) {
	            super.updateItem(item, empty);
	           
	            if (empty) {
	                setText(null);
	                setGraphic(null);
	            } else {
	                if (isEditing()) {
	                    if (textField != null) {
	                        textField.setText(getString());
	                    }
	                    setText(null);
	                    setGraphic(textField);
	                } else {
	                    setText(getString());
	                    setGraphic(getTreeItem().getGraphic());
	                }
	            }
	        }
	 
	      /*  private void createTextField() {
	            textField = new TextField(getString());
	            textField.setOnKeyReleased(new EventHandler<KeyEvent>() {
	 
	                @Override
	                public void handle(KeyEvent t) {
	                    if (t.getCode() == KeyCode.ENTER) {
	                    	getTreeItem().getValue().setName(textField.getText());
	                        commitEdit(getTreeItem().getValue());
	                    } else if (t.getCode() == KeyCode.ESCAPE) {
	                        cancelEdit();
	                    }
	                }
	            });
	        }*/
	  
	        private String getString() {
	            return getItem() == null ? "" : getItem().toString();
	        }

	    }
	 
	 
	 
	 public void initRectangle(){
		  selection.setFill(null);
	      selection.setStroke(Color.BLUE);
	      selection.setStrokeWidth(0.1);
	      
	      flowPaneRoot.addEventHandler(MouseEvent.ANY, new EventHandler<MouseEvent>(){
    	    double sw; 
    	    double sh;
    	    double ew; 
    	    double eh;
			@Override
			public void handle(MouseEvent event) {
				
				if(event.getEventType()==MouseEvent.MOUSE_DRAGGED)
				{//System.out.println(event.getX());
				ew = event.getX();
				eh = event.getY();
				if(ew-sw>0)
				{
				selection.setWidth(ew-sw);
				
				}
				 if(eh-sh>0)
				{
					selection.setHeight(eh-sh);
				}
				 if(ew-sw<0)
				{
					selection.setX(event.getX());
					selection.setWidth(sw-ew);
				
				}
				
				 if(eh-sh<0)
				{
					selection.setY(event.getY());	
					selection.setHeight(sh-eh);
				}
				
				    for(Object tmp: flowPane.getChildren())
				    {
				    	if(tmp.getClass()==SelectLabel.class)
				    	{
				    		SelectLabel tmp2 = (SelectLabel)tmp;
				    		if(selection.intersects(tmp2.getBoundsInParent()))
				    		{
				    			tmp2.getStyleClass().clear();
				    			tmp2.getStyleClass().add("label1_select");
				    			tmp2.setSelected(true);
				    		}
				    		else{
				    			tmp2.getStyleClass().clear();
				    			tmp2.getStyleClass().add("label1");
				    			tmp2.setSelected(false);
				    		}
				    	}
				    }
				 
				}
				
				if(event.getEventType()==MouseEvent.MOUSE_PRESSED)
				{//System.out.println(event.getSceneX());
				    sw=event.getX();
				    sh=event.getY();
					selection.setX(sw);
					selection.setY(sh);
				}
				if(event.getEventType()==MouseEvent.MOUSE_RELEASED)
				{
				    sw=0;
				    sh=0;
				    ew=0;
				    eh=0;
					selection.setX(0);
					selection.setY(0);	
					selection.setWidth(0);
					selection.setHeight(0);
				}
				
			}
        	
        });
		
		 
	 }
	 
	 
		private void initGenButton() {
		genButton.addEventHandler(MouseEvent.ANY, new EventHandler<MouseEvent>(){
			List<String> tableNames = new ArrayList<String>();
			@Override
			public void handle(MouseEvent event) {
				if(event.getEventType()==MouseEvent.MOUSE_RELEASED&&flowPane.getChildren().size()>0)
				{   ConnObj obj = ((SelectLabel)flowPane.getChildren().get(1)).getConnObj();
				    for(Object tmp: flowPane.getChildren())
				    {
				    	if(tmp.getClass()==SelectLabel.class&&((SelectLabel)tmp).isSelected())
				    	{
				    		tableNames.add( ((SelectLabel)tmp).getText());
				        }
			}
				    System.out.println(obj.getCatalog()+"************");
				    List<Table> tables=gen.getTablesName(tableNames,obj.getConnection(),obj.getCatalog(),null,obj.getDbConfiguration().getDbType());  
                    gen.genFile(tables);
				}}
		});
		}

}
