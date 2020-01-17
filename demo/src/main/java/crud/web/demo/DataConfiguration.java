package crud.web.demo;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {
	Connection con;
	private String url = "jdbc:mysql://localhost:3306/eventosapp";
	private String user = "root";
	private String password = "armelin";

	@Bean
	public Connection concetarBanco() {
		if (con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				
			} catch (Exception e) {
				System.out.println("Erro ao conectar");
			}
		}
		return con;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		adapter.setPrepareConnection(true);
		return adapter;
	}
	//se for necessario desconectar do banco
	  /*public void desconctarBanco(){
		  if(con!= null) {
			  try{
			  con.close();
			  System.out.println("Conexão encerrada!");
			  }catch(Exception e) {
				  System.out.println(e);
			  }
		  }
	  }*/
}
