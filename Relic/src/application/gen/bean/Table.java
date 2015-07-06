package application.gen.bean;

import java.util.List;

public class Table {
String TABLE_NAME ;
List<Column> columns;
String dbType;
Table(){
	
}

public Table(String TABLE_NAME)
{
	this.TABLE_NAME=TABLE_NAME;
}

public String getTABLE_NAME() {
	return TABLE_NAME;
}
public void setTABLE_NAME(String tABLE_NAME) {
	TABLE_NAME = tABLE_NAME;
}

public String getTABLE_NAMEFU() {
	return TABLE_NAME.replaceFirst(TABLE_NAME.substring(0, 1), TABLE_NAME.substring(0, 1).toUpperCase());
}
public String getTABLE_NAMEFL() {
	return TABLE_NAME.replaceFirst(TABLE_NAME.substring(0, 1), TABLE_NAME.substring(0, 1).toLowerCase());
}


public List<Column> getColumns() {
	return columns;
}
public void setColumns(List<Column> columns) {
	this.columns = columns;
}

public String getDbType() {
	return dbType;
}

public void setDbType(String dbType) {
	this.dbType = dbType;
}



}
