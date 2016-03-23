package application.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author tom.liu
 *For template-config.xml
 */
@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Template {
private String templatePath;
private String genDir;
private String namePre;
private String nameSuf;
private String dbType;
/**
 * 1 代表默认 所有 模板 2.代表mybatis模板类型
 */
private int type = 1;
public String getTemplatePath() {
	return templatePath;
}
public void setTemplatePath(String templatePath) {
	this.templatePath = templatePath;
}
public String getGenDir() {
	return genDir;
}
public void setGenDir(String genDir) {
	this.genDir = genDir;
}
public String getNamePre() {
	return namePre;
}
public void setNamePre(String namePre) {
	this.namePre = namePre;
}
public String getNameSuf() {
	return nameSuf;
}
public void setNameSuf(String nameSuf) {
	this.nameSuf = nameSuf;
}
public String getDbType() {
	return dbType;
}
public void setDbType(String dbType) {
	this.dbType = dbType;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}


}
