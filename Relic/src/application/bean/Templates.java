package application.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author tom.liu
 *For template-config.xml
 */
@XmlRootElement(name = "Templates")
@XmlAccessorType (XmlAccessType.FIELD)
public class Templates 
{
	@XmlElement(name = "Template")
	private List<Template> templates = null;

	Templates(){
		templates =new ArrayList<Template>();
	}

	public List<Template> getTemplates() {
		return templates;
	}

	public void setTemplates(List<Template> templates) {
		this.templates = templates;
	}


}
