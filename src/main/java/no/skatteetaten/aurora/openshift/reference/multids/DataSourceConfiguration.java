package no.skatteetaten.aurora.openshift.reference.multids;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
class DataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "datasources.customer")
    public DataSourceProperties customerDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "datasources.sales")
    public DataSourceProperties salesDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource dataSourceCustomer() {

        return createDataSource(customerDataSourceProperties());
    }

    @Bean
    public DataSource dataSourceSales() {

        return createDataSource(salesDataSourceProperties());
    }

    private DataSource createDataSource(DataSourceProperties sp) {
        return DataSourceBuilder.create()
            .url(sp.getUrl())
            .username(sp.getUsername())
            .password(sp.getPassword())
            .build();
    }
}
