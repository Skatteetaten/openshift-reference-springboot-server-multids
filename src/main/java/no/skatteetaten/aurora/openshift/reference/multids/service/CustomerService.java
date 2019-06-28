package no.skatteetaten.aurora.openshift.reference.multids.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class CustomerService {

    private JdbcTemplate jdbc;

    public CustomerService(DataSource dataSourceCustomer) {
        this.jdbc = new JdbcTemplate(dataSourceCustomer);
    }

    public List<Customer> findAllCustomers() {
        return jdbc.query("select * from customer", new BeanPropertyRowMapper<>(Customer.class));
    }
}
