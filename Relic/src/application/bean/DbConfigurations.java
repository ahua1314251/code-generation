package application.bean;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dbConfigurations")
@XmlAccessorType (XmlAccessType.FIELD)
public class DbConfigurations 
{
	@XmlElement(name = "dbConfiguration")
	private List<DbConfiguration> dbConfigurations = null;

	DbConfigurations(){
		dbConfigurations =new ArrayList<DbConfiguration>();
	}
	public List<DbConfiguration> getDbConfigurations() {
		return dbConfigurations;
	}

	public void setDbConfigurations(List<DbConfiguration> dbConfigurations) {
		this.dbConfigurations = dbConfigurations;
	}
}