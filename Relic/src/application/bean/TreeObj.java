package application.bean;

public class TreeObj {
public	enum TreeType
	{  
		CONNECTOR,
		DDTABASE,
		SCHEMA,
		TABLE;
	}
private String name ="root";
private Object object;
private TreeType treeType = TreeType.CONNECTOR;
public TreeObj()
{
}
public TreeObj(String name,Object obj){
	this.name=name;
	this.object=obj;
}

public TreeObj(String name,Object obj,TreeType treeType ){
	this.name=name;
	this.object=obj;
	this.treeType=treeType;
}


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Object getObject() {
	return object;
}
public void setObject(Object object) {
	this.object = object;
}

public TreeType getTreeType() {
	return treeType;
}
public void setTreeType(TreeType treeType) {
	this.treeType = treeType;
}


@Override
public String toString() {
		return name;
}
}
