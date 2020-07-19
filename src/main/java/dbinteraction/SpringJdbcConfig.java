package dbinteraction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("dbinteraction")
public class SpringJdbcConfig {
    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.oracle.database.jdbc.ojdbc8");
        dataSource.setUrl("jdbc:oracle://localhost:1521/XEPDB1");
        dataSource.setUsername("RIPOD");
        dataSource.setPassword("ST290pro");

        return dataSource;
    }
}