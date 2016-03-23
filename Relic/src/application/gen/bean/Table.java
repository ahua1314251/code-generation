package application.gen.bean;

import java.util.List;

import application.util.StringUtil;

public class Table {
	private String TABLE_NAME;
	private List<Column> columns;
	private String dbType;

	Table() {

	}

	public Table(String TABLE_NAME) {
		this.TABLE_NAME = TABLE_NAME;
	}

	public String getTABLE_NAME() {
		return TABLE_NAME;
	}

	public void setTABLE_NAME(String tABLE_NAME) {
		TABLE_NAME = tABLE_NAME;
	}

	public String getTABLE_NAMEFU() {
		return StringUtil.convertToFU(StringUtil.convertToHump(TABLE_NAME));
	}

	public String getTABLE_NAMEFL() {
		return StringUtil.convertToHump(TABLE_NAME);
	}

	public String getTABLE_BEAN_NAME() {
		return StringUtil.convertToHump(TABLE_NAME);
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
