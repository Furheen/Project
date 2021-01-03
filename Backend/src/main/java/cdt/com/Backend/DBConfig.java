package cdt.com.Backend;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("cdt.com")

public class DBConfig {
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/test");
		datasource.setUsername("sa");
		datasource.setPassword("");
		System.out.println("====Creating Data Source Bean====");
		return datasource;
	}
	@Bean(name="sessionFactory")
	public SessionFactory getsessionFactory()
	{
		Properties hibernateproperties=new Properties();
        hibernateproperties.put("hibernate.hbm2ddl.auto","update");
		
		hibernateproperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateproperties.put("hibernate.show_sql", true);
		hibernateproperties.put("hibernate.format_sql", true);
		LocalSessionFactoryBuilder factory1=new LocalSessionFactoryBuilder(this.getH2DataSource());
		factory1.addProperties(hibernateproperties)	;
		//factory1.addAnnotatedClass(UserDetail);
		SessionFactory sessionFactory=factory1.buildSessionFactory();
		
		System.out.println("Session is created");
        return sessionFactory;
	
	}
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Creating the TransactionManager Bean");
		return new HibernateTransactionManager(sessionFactory);
		
	}
}
