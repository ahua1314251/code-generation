package application.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.geometry.Orientation;
import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import application.Context;
import application.bean.ConnObj;
import application.bean.SelectLabel;
import application.bean.TreeObj;
import application.bean.TreeObj.TreeType;

public class JdbcUtil {

	
	
	public static void setTreeForSQLSERVER(TreeObj item ,ConnObj obj,TreeItem<TreeObj> treeItem,FlowPane flowPane ){
		ResultSet rs = null;
		flowPane.getChildren().clear();
		flowPane.setOrientation(Orientation.VERTICAL);
    	switch (item.getTreeType()) {
    	case CONNECTOR:
    		
			try {
				rs = obj.getConnection().getMetaData().getCatalogs();
	    		 while(rs!=null&&rs.next())
           		 {
	    			 treeItem .getChildren().
           			add(new TreeItem<TreeObj>(new TreeObj(rs.getString("TABLE_CAT"),obj,TreeType.DDTABASE),new ImageView(Context.Icon_Db)));
           		 }
			} catch (SQLException e) {
	
				e.printStackTrace();
			}

            break;
        case DDTABASE:
			try {
				obj.getConnection().setCatalog(item.getName());
				rs = obj.getConnection().getMetaData().getSchemas();
	    		 while(rs!=null&&rs.next())
           		 {
	    			 treeItem.getChildren().
           			add(new TreeItem<TreeObj>(new TreeObj(rs.getString("TABLE_SCHEM"),obj,TreeType.SCHEMA),new ImageView(Context.Icon_Schema)));
           		 }
			} catch (SQLException e) {
	
				e.printStackTrace();
			}   
            break;
        case SCHEMA:
			try {
				rs = obj.getConnection().getMetaData().getTables("ControlSystem",treeItem.getValue().getName(),null, null);
				treeItem.getChildren().clear();
				SelectLabel label ;
	    		 while(rs!=null&&rs.next())
           		 {
	    			 treeItem.getChildren().
           			add(new TreeItem<TreeObj>(new TreeObj(rs.getString("TABLE_NAME")+rs.getString("TABLE_SCHEM"),obj,TreeType.TABLE),new ImageView(Context.Icon_Table)));
	    			    label=  new SelectLabel(rs.getString("TABLE_NAME"));
	    				label.setWrapText(true);
	    				label.setGraphic(new ImageView(Context.Icon_Table2));
	    				label.getStyleClass().add("label1");
	    				label.setConnObj(obj);
	    			    flowPane.getChildren().add(label);
           		 
           		 }
	    		 
			} catch (SQLException e) {
	
				e.printStackTrace();
			}  
            break;
 }
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void setTreeForMYSQL(TreeObj item ,ConnObj obj,TreeItem<TreeObj> treeItem,FlowPane flowPane ){
		ResultSet rs;
		flowPane.getChildren().clear();
		flowPane.setOrientation(Orientation.VERTICAL);
		System.out.println();
		System.out.println(item.getTreeType());
    	switch (item.getTreeType() ) {
    	case CONNECTOR:
    		
			try {
				rs = obj.getConnection().getMetaData().getCatalogs();
	    		 while(rs!=null&&rs.next())
           		 {
	    			 treeItem .getChildren().
           			add(new TreeItem<TreeObj>(new TreeObj(rs.getString("TABLE_CAT"),obj,TreeType.DDTABASE),new ImageView(Context.Icon_Db)));
           		 }
			} catch (SQLException e) {
	
				e.printStackTrace();
			}

            break;

        case DDTABASE:
			try {
				rs = obj.getConnection().getMetaData().getTables(item.getName(),null,null, null);
				SelectLabel label ;
				obj.setCatalog(item.getName());
	    		 while(rs!=null&&rs.next())
           		 {
	    			 treeItem.getChildren().
           			add(new TreeItem<TreeObj>(new TreeObj(rs.getString("TABLE_NAME"),obj,TreeType.TABLE),new ImageView(Context.Icon_Table)));
	    			
	    			    label=  new SelectLabel(rs.getString("TABLE_NAME"));
	    				label.setWrapText(true);
	    				label.setGraphic(new ImageView(Context.Icon_Table2));
	    				label.getStyleClass().add("label1");
	    				label.setConnObj(obj);
	    			    flowPane.getChildren().add(label);
           		 }
			} catch (SQLException e) {
	
				e.printStackTrace();
			}  
            break;
 }
		
	}
	
}
