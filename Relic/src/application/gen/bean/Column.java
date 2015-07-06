package application.gen.bean;

public class Column {

	String COLUMN_NAME;
	String TYPE_NAME;
	String COLUMN_SIZE;
	String NULLABLE;
	
	public Column(){
		
	}
	
	public Column(String cOLUMN_NAME, String tYPE_NAME, String cOLUMN_SIZE,
			String nULLABLE) {
		super();
		COLUMN_NAME = cOLUMN_NAME;
		TYPE_NAME = tYPE_NAME;
		COLUMN_SIZE = cOLUMN_SIZE;
		NULLABLE = nULLABLE;
		if(TYPE_NAME.equalsIgnoreCase("char")||TYPE_NAME.equalsIgnoreCase("nvarchar")||TYPE_NAME.equalsIgnoreCase("varchar"))
		{
			COLUMN_SIZE ="("+COLUMN_SIZE+")";
		}
		else
		{
			COLUMN_SIZE="";
		}
		TYPE_NAME=TYPE_NAME.toUpperCase();
	}
	
	public String getCOLUMN_NAME() {
		return COLUMN_NAME;
	}
	public String getCOLUMN_NAMEFU() {
		return COLUMN_NAME.replaceFirst(COLUMN_NAME.substring(0, 1), COLUMN_NAME.substring(0, 1).toUpperCase());
	}
	public String getCOLUMN_NAMEFL() {
		return COLUMN_NAME.replaceFirst(COLUMN_NAME.substring(0, 1), COLUMN_NAME.substring(0, 1).toLowerCase());
	}
	
	
	public void setCOLUMN_NAME(String cOLUMN_NAME) {
		COLUMN_NAME = cOLUMN_NAME;
	}
	public String getTYPE_NAME() {
		return TYPE_NAME;
	}
	
	public String getTYPE_NAME_MyBatis() {
		if(TYPE_NAME.equalsIgnoreCase("int"))
		{
			return "INTEGER";
		}
		if(TYPE_NAME.equalsIgnoreCase("datetime"))
		{
			return "TIMESTAMP";
		}
		return TYPE_NAME;
	}
	
	public String getTYPE_NAME_Java() {
		if(TYPE_NAME.equalsIgnoreCase("datetime"))
		{
			return "Date";
		}
		if(TYPE_NAME.equalsIgnoreCase("char")||TYPE_NAME.equalsIgnoreCase("nvarchar")||TYPE_NAME.equalsIgnoreCase("varchar"))
		{
			return "String";
		}
		if(TYPE_NAME.equalsIgnoreCase("INT"))
		{
			return "int";
		}
		if(TYPE_NAME.equalsIgnoreCase("BIT"))
		{
			return "boolean";
		}
		
		return TYPE_NAME;
	}
	
	public void setTYPE_NAME(String tYPE_NAME) {
		TYPE_NAME = tYPE_NAME;
	}
	public String getCOLUMN_SIZE() {
		return COLUMN_SIZE;
	}
	public void setCOLUMN_SIZE(String cOLUMN_SIZE) {
		COLUMN_SIZE = cOLUMN_SIZE;
	}
	public String getNULLABLE() {
		return NULLABLE;
	}
	public void setNULLABLE(String nULLABLE) {
		NULLABLE = nULLABLE;
	}
	
	
}
