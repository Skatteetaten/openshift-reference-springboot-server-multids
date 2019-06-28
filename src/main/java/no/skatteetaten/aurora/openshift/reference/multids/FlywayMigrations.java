package no.skatteetaten.aurora.openshift.reference.multids;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayMigrations {

    private DataSource dataSourceCustomer;
    private DataSource dataSourceSales;

    /**
     * Injects the two datasources by their bean name. There are several strategies that can be used here,
     * like @Qualifier or dedicated custom annotations. Bean name is used here for simplicity.
     *
     * @param dataSourceCustomer
     * @param dataSourceSales
     */
    public FlywayMigrations(DataSource dataSourceCustomer, DataSource dataSourceSales) {
        this.dataSourceCustomer = dataSourceCustomer;
        this.dataSourceSales = dataSourceSales;
    }

    /**
     * Loads migrations for the customer database and runs them.
     */
    @PostConstruct
    public void migrateCustomer() {

        Flyway.configure().dataSource(dataSourceCustomer).outOfOrder(true).locations("db/customer/migration").load()
            .migrate();
    }

    @PostConstruct
    public void migrateSales() {

        Flyway.configure().dataSource(dataSourceSales).outOfOrder(true).locations("db/sales/migration").load()
            .migrate();
    }
}
