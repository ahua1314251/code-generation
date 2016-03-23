package application.gen;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import application.Context;
import application.bean.ConnObj;
import application.gen.bean.Column;
import application.gen.bean.Table;
import application.util.MybatisUtil;

/**
 * @author tom.liu
 * @version $Id: Example.java 463298 2006-10-12 16:10:32Z henning $
 */
public class gen {

	public static void main(String[] args) {
		Context.init();
		ConnObj cc = new ConnObj(Context.DbList.getDbConfigurations().get(0));

		String[] ss = { "CoreProduct", "Product", "Product_Backup", "ProductAvailable", "ProductBundle",
				"ProductBundleItems", "ProductChannelType", "ProductGroupCountryAbove", "ProductGroupCountryBelow",
				"ProductInsurance", "ProductMapping", "ProductRoutine", "Skill" };
		List<Table> tables = getTablesName(ss, cc.getConnection());
		genFile(tables);

	}

	public static void genFile(List<Table> tableList) {
		Properties pros = new Properties();
		try {
			pros.load(new FileInputStream("RelicConfig" + File.separator + "velocity.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("cant found the velocity.properties");
			e.printStackTrace();
		}
		Velocity.init(pros);

		VelocityContext context = new VelocityContext();
		for (application.bean.Template tem : Context.templateList.getTemplates()) {
			for (Table table : tableList) {
				if (table.getDbType().equalsIgnoreCase(tem.getDbType())) {
					context.put("schemaName", "main");
					context.put("proName",
							tem.getNamePre() + table.getTABLE_NAMEFU() + tem.getNameSuf().replace(".sql", ""));
					context.put("tableName", table.getTABLE_NAME());
					context.put("tableNameFU", table.getTABLE_NAMEFU());
					context.put("tableNameFL", table.getTABLE_NAMEFL());
					context.put("columns", table.getColumns());
					context.put("table", table);
					gen(context, tem.getTemplatePath(),
							tem.getGenDir() + tem.getNamePre() + table.getTABLE_NAMEFU() + tem.getNameSuf());

				}
			}
		}
	}

	public static void genUpdateScript(Table table) {
		VelocityContext context = new VelocityContext();
		context.put("schemaName", "main");
		context.put("proName", "usp" + table.getTABLE_NAME() + "Update001");
		context.put("tableName", table.getTABLE_NAME());
		context.put("columns", table.getColumns());
		context.put("table", table);
		gen(context, "/src/application/gen/template/mySql/sqlUpdate.sql",
				"\\mysql\\usp" + table.getTABLE_NAME() + "Update001.sql");
	}

	public static void genGetScript(Table table) {
		VelocityContext context = new VelocityContext();
		context.put("schemaName", "main");
		context.put("proName", "usp" + table.getTABLE_NAME() + "Get001");
		context.put("tableName", table.getTABLE_NAME());
		context.put("columns", table.getColumns());
		gen(context, "/src/application/gen/template/mySql/sqlGet.sql",
				"\\mysql\\usp" + table.getTABLE_NAME() + "Get001.sql");
	}

	public static void genCreateScript(Table table) {
		VelocityContext context = new VelocityContext();
		context.put("schemaName", "main");
		context.put("proName", "usp" + table.getTABLE_NAME() + "Create001");
		context.put("tableName", table.getTABLE_NAME());
		context.put("columns", table.getColumns());
		context.put("table", table);
		gen(context, "/src/application/gen/template/mySql/sqlCreate.sql",
				"\\mysql\\usp" + table.getTABLE_NAME() + "Create001.sql");
	}

	public static void genMybatisMapper(Table table) {
		VelocityContext context = new VelocityContext();
		context.put("schemaName", "main");
		context.put("proName", "usp" + table.getTABLE_NAME() + "Update001");
		context.put("tableName", table.getTABLE_NAME());
		context.put("columns", table.getColumns());
		context.put("table", table);
		gen(context, "/src/application/gen/template/mybatis/MaterialMapper.xml",
				"\\mybatis\\" + table.getTABLE_NAME() + ".xml");
	}

	public static List<Table> getTablesName(String[] tableNames, Connection con) {
		List<Table> list = new ArrayList<Table>();

		try {
			/*
			 * ResultSet rs=con.getMetaData().getTables("ControlSystem", "dbo",
			 * null, new String[]{"TABLE"}); while(rs!=null&&rs.next()) { //
			 * System.out.println(rs.getString(3)); list.add(new
			 * Table(rs.getString("TABLE_NAME"))); }
			 */
			list.add(new Table("ProductBundleItems"));
			for (String tmp : tableNames) {
				Table table = new Table(tmp);
				table.setColumns(getColumns(con, null, null, tmp));
				list.add(table);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static List<Table> getTablesName(List<String> tableNames, Connection con, String catalog, String schema,
			String dbType) {
		List<Table> list = new ArrayList<Table>();

		try {
			/*
			 * ResultSet rs=con.getMetaData().getTables("ControlSystem", "dbo",
			 * null, new String[]{"TABLE"}); while(rs!=null&&rs.next()) { //
			 * System.out.println(rs.getString(3)); list.add(new
			 * Table(rs.getString("TABLE_NAME"))); }
			 */
			for (String tmp : tableNames) {
				Table table = new Table(tmp);
				table.setDbType(dbType);
				table.setColumns(getColumns(con, catalog, schema, tmp));
				list.add(table);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static List<Column> getColumns(Connection con, String catalog, String schema, String tableName)
			throws SQLException {
		List<Column> list = new ArrayList<Column>();
		ResultSet rs = con.getMetaData().getColumns(catalog, schema, tableName, "%");
		while (rs != null && rs.next()) {
			// System.out.println(rs.getString("COLUMN_NAME")+"
			// "+rs.getString("TYPE_NAME")+" "+rs.getString("COLUMN_SIZE")+"
			// "+rs.getString("NULLABLE"));
			Column column = new Column(rs.getString("COLUMN_NAME"), rs.getString("TYPE_NAME"),
					rs.getString("COLUMN_SIZE"), rs.getString("NULLABLE"));
			list.add(column);
		}

		return list;
	}

	public static void gen(VelocityContext context, String templateFile, String genFilePath) {
		try {
			Template template = null;
			try {
				template = Velocity.getTemplate(templateFile);

			} catch (ResourceNotFoundException rnfe) {
				System.out.println("Example : error : cannot find template " + templateFile);
			} catch (ParseErrorException pee) {
				System.out.println("Example : Syntax error in template " + templateFile + ":" + pee);
			}

			// BufferedWriter writer = new BufferedWriter(new
			// OutputStreamWriter(System.out));
			StringWriter ww = new StringWriter();
			BufferedWriter writer = new BufferedWriter(ww);
			if (template != null)
				template.merge(context, ww);
			// System.out.println(ww.toString());
			FileUtils.writeStringToFile(new File(genFilePath), ww.toString(), "utf-8");
			System.out.println("generate file" + genFilePath);
			/*
			 * flush and cleanup
			 */
			writer.flush();
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	public static void genMybatisFile(List<Table> tableList, ConnObj obj) {
		Properties pros = new Properties();
		String configPath = "";
		try {
			pros.load(new FileInputStream("RelicConfig" + File.separator + "velocity.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("cant found the velocity.properties");
			e.printStackTrace();
		}
		Velocity.init(pros);

		VelocityContext context = new VelocityContext();
		for (application.bean.Template tem : Context.templateList.getTemplates()) {
			if (tableList.get(0).getDbType().equalsIgnoreCase(tem.getDbType()) && tem.getType() == 2) {
				context.put("tableList", tableList);
				context.put("dbConfiguration", obj.getDbConfiguration());
				context.put("url", obj.getDbConfiguration().getUrl() + "/" + obj.getCatalog());
				configPath = tem.getGenDir() + tem.getNamePre() + "generatorConfigMyBatis" + tem.getNameSuf();
				gen(context, tem.getTemplatePath(), configPath);
			}
		}
		MybatisUtil.genMybatis(configPath);
	}

}
