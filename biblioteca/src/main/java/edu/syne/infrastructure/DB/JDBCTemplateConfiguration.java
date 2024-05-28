package edu.syne.infrastructure.DB;

import com.mysql.cj.jdbc.MysqlDataSource;
import edu.syne.Main;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class JDBCTemplateConfiguration {

  @Bean
  public static MysqlDataSource dataSource() throws IOException {
    Properties prop = new Properties();
    MysqlDataSource dataSource = new MysqlDataSource();

    // Carrega as propriedades e vincula ela a var prop.
    InputStream in = Main.class.getClassLoader().getResourceAsStream("application.properties");
    prop.load(in);

    // Se conecta ao banco de dados.
    dataSource.setUrl(prop.getProperty("db.url"));
    dataSource.setUser(prop.getProperty("db.user"));
    dataSource.setPassword(prop.getProperty("db.password"));

    // retorna a conexão com o banco.
    return dataSource;
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    // Transforma a conexão com o banco em um JDBCTemplate.
    return new JdbcTemplate(dataSource);
  }
}