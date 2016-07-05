package application;

import java.io.File;
import java.sql.Connection;
import java.util.List;

import javafx.scene.image.Image;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import application.bean.DbConfigurations;
import application.bean.Templates;
import application.file.Resource;

public class Context {
public static String cDir = System.getProperty("user.dir");
public static List<Connection> conList;
public static DbConfigurations DbList;
public static Templates templateList;
public static Image Icon_Connector  = new Image(Resource.class.getResourceAsStream("database.png"));  
public static Image Icon_Db  = new Image(Resource.class.getResourceAsStream("connector2.png"));
public static Image Icon_Schema  = new Image(Resource.class.getResourceAsStream("schema2.png"));
public static Image Icon_Table  = new Image(Resource.class.getResourceAsStream("table2.png"));
public static Image Icon_Table2  = new Image(Resource.class.getResourceAsStream("table.png"));
public static void init(){
	JAXBContext jaxbContext;
	try {
		jaxbContext = JAXBContext.newInstance(DbConfigurations.class,Templates.class);
		Unmarshaller  unmarshaller=jaxbContext.createUnmarshaller();
		/*templateList =(Templates) unmarshaller.unmarshal(new File(Resource.class.getResource("relic-config.xml").getFile()));
		DbList =(DbConfigurations) unmarshaller.unmarshal(new File(Resource.class.getResource("DbConfig.xml").getFile()));*/
		templateList =(Templates) unmarshaller.unmarshal(new File("RelicConfig"+File.separator+"relic-config.xml"));
		DbList =(DbConfigurations) unmarshaller.unmarshal(new File("RelicConfig"+File.separator+"DbConfig.xml"));
		
		
   System.out.println(DbList.getDbConfigurations().get(0).getName()+"init Connectors from DbConfig.xml");
	} catch (JAXBException e) {
		e.printStackTrace();
	}

}

static
{
	init();
	
}

public static void main(String args[])
{
	}
}
