package no.skatteetaten.aurora.openshift.reference.multids.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SalesService {

    private JdbcTemplate jdbc;

    /**
     * Injection by bean name. Use whichever strategy you find appropriate.
     *
     * @param dataSourceSales
     */
    public SalesService(DataSource dataSourceSales) {
        this.jdbc = new JdbcTemplate(dataSourceSales);
    }

    public List<Transaction> findAllTransactions() {
        return jdbc.query("select * from transaction", new BeanPropertyRowMapper<>(Transaction.class));
    }
}
