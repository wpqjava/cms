package org.wpq.cms.mapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.AmbiguousTableNameException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.wpq.common.util.DBUtil;
import org.xml.sax.InputSource;

public class TestDBUnitBase {
	private final String backupFilePath = "D:/CodeSoftware/STS/cms2016/cms-core/src/test/resources/backup.xml";
	public static IDatabaseConnection dbunitCon ;
	public IDataSet ds;
	
	protected void backupAllDatas(){
		try {
			ds = dbunitCon.createDataSet();
			FlatXmlDataSet.write(ds, new FileWriter(backupFilePath));
		} catch (DataSetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected IDataSet createDateSet(String xmlName){
		try {
			ds =  new FlatXmlDataSet(
					new FlatXmlProducer(
							new InputSource(
									TestDBUnitBase.class.getClassLoader().getResourceAsStream(xmlName+".xml"))));
		} catch (DataSetException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	protected void backupTables(String[] tnames){
		try {
			QueryDataSet qds = new QueryDataSet(dbunitCon);
			for(String str:tnames){
				qds.addTable(str);
			}
			FlatXmlDataSet.write(qds, new FileWriter(backupFilePath));
		} catch (AmbiguousTableNameException e) {
			e.printStackTrace();
		} catch (DataSetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void backupOneTable(String tname){
		backupTables(new String[]{tname});
	}
	
	protected void resume(){
		try {
			ds = new FlatXmlDataSet(new FlatXmlProducer(new InputSource(new FileInputStream(backupFilePath))));
			DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
		} catch (DataSetException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DatabaseUnitException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeClass
	public static void init(){
		try {
			dbunitCon = new DatabaseConnection(DBUtil.getCon());
		} catch (DatabaseUnitException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void closeDbunitCon(){
		try {
			if(dbunitCon!=null)dbunitCon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
