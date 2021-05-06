package com.myproject.myweb.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.myproject.myweb.persistence.UserDAO;
import com.myproject.myweb.service.UserService;

@Configuration
public class RootConfig { 
	@Autowired
    private ApplicationContext applicationContext;

	@Bean 
	public DataSource dataSource() { 
		DataSource dataSource = new DataSource(); 
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver"); 
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl"); 
		dataSource.setUsername("haksa"); 
		dataSource.setPassword("haksa"); 
		return dataSource;
	}
	
	
	@Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mappers/*Mapper.xml"));
        
        return sqlSessionFactoryBean.getObject();
    }
    
    
    @Bean
    public SqlSession sqlSession() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sqlSessionTemplate;
    }

	
    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }
    
    @Bean
    public UserDAO userDAO() {
    	return new UserDAO(); 
    }
    
    @Bean
    public UserService userService() {
    	return new UserService();
    }
}