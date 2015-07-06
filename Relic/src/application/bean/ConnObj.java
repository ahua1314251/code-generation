package application.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import application.Context;

public class ConnObj {
Connection connection;
DbConfiguration dbConfiguration;
String catalog;
String url="jdbc:sqlserver://127.0.0.1:1433";
String url2="jdbc:mysql://localhost:3306";
public ConnObj(){
	
}
public ConnObj(DbConfiguration dbConfiguration){
	this.dbConfiguration=dbConfiguration;
}
public Connection getConnection() {
	if(connection!=null)
	{
		return connection;
	}
	
	try {
		
		System.out.println(dbConfiguration.getDriver());
/*		Class.forName(dbConfiguration.getDriver());*/
		Class.forName("com.mysql.jdbc.Driver");
		Class.forName(dbConfiguration.getDriver());
		System.out.println("driver:--"+dbConfiguration.getDriver());
		System.out.println("geting Connection "+url + dbConfiguration.getUserName()+"||"+dbConfiguration.getPassWord());
		connection = DriverManager.getConnection(dbConfiguration.getUrl(),dbConfiguration.getUserName(),dbConfiguration.getPassWord());
		 
	} catch (Exception e) {
		e.printStackTrace();
	}
System.out.println("get Connection "+url);
	return connection;
	
}
public void setConnection(Connection connection) {
	this.connection = connection;
}
public DbConfiguration getDbConfiguration() {
	return dbConfiguration;
}
public void setDbConfiguration(DbConfiguration dbConfiguration) {
	this.dbConfiguration = dbConfiguration;
}



public String getCatalog() {
	return catalog;
}
public void setCatalog(String catalog) {
	this.catalog = catalog;
}
public static void main(String args[]){
	Context.init();
	ConnObj cc=new ConnObj(Context.DbList.getDbConfigurations().get(0));
	cc.getConnection();
	cc.setCatalog("e_resource");
/*	
	try {
		java.sql.PreparedStatement st=cc.getConnection().prepareStatement("INSERT INTO `e_resource`.`material` ( `MaterialName`, `MaterialQuantity`, `ApplicableModels`, `MaterialPrice`, `Customer`, `Leader`, `Remark`, `EntryTime`, `OutTime`) VALUES ('232', '123', '123', '213', '123', '21', '21', '2015-04-27 09:43:51', '2015-05-10 09:43:54')");
		
		for(int i=0;i<3000;i++)
		{
		st.addBatch();
		System.out.println(i);
		}
		st.executeBatch();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
}

}
