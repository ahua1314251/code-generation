package application.bean;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import application.file.Resource;


/**
 * 
 * @author tom.liu
 * For db
 */
@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class DbConfiguration {
   private String url;
   private String name;
   private String driver;
   private String userName;
   private String passWord;
   private String hostName;
   private String port;
   private String dbType;
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public String getDriver() {
	return driver;
}

public void setDriver(String driver) {
	this.driver = driver;
}
public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassWord() {
	return passWord;
}

public void setPassWord(String passWord) {
	this.passWord = passWord;
}
public String getHostName() {
	return hostName;
}

public void setHostName(String hostName) {
	this.hostName = hostName;
}
public String getPort() {
	return port;
}

public void setPort(String port) {
	this.port = port;
}


	public String getUrl() {
	return url;
}

public void setUrl(String url) {
	this.url = url;
}

	public String getDbType() {
	return dbType;
}

public void setDbType(String dbType) {
	this.dbType = dbType;
}

	public static void main(String args[]) throws JAXBException{
		DbConfiguration obj = new DbConfiguration();
		JAXBContext jaxbContext = JAXBContext.newInstance(DbConfigurations.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		DbConfigurations lists=new DbConfigurations();
		obj.name="SQL_local";
		obj.hostName="127.0.0.1";
		obj.userName="sa";
		obj.passWord="Scotiabank1";
		obj.setDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		obj.setPort("1433");
		lists.getDbConfigurations().add(obj);
		File file= new File(Resource.class.getResource("DbConfig.xml").getFile());


		System.out.println(Resource.class);
		System.out.println(file.getAbsolutePath());
		jaxbMarshaller.marshal(lists,file);
	}
}
