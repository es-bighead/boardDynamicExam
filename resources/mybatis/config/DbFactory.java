package mybatis.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbFactory {
	
	private static SqlSessionFactory sqlSessionFactory;

	static{
		String dbConfig = "mybatis/config/sqlConfig.xml"; 
		
		Reader reader;
		
		try {
			reader = Resources.getResourceAsReader(dbConfig);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			System.out.println("DB연결성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB연결실패");
		}
		
	}
	
	public static SqlSessionFactory getSqlSessionFacotry(){
		return sqlSessionFactory;
	}
	
}
