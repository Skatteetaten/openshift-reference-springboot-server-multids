package no.skatteetaten.aurora.openshift.reference.multids;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;

@Configuration
class FlywayMigrations {

    private DataSource dataSourceCustomer;
    private DataSource dataSourceSales;

    public FlywayMigrations(DataSource dataSourceCustomer, DataSource dataSourceSales) {
        this.dataSourceCustomer = dataSourceCustomer;
        this.dataSourceSales = dataSourceSales;
    }

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
