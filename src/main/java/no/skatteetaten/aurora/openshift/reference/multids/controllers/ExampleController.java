package no.skatteetaten.aurora.openshift.reference.multids.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import no.skatteetaten.aurora.openshift.reference.multids.service.Customer;
import no.skatteetaten.aurora.openshift.reference.multids.service.CustomerService;
import no.skatteetaten.aurora.openshift.reference.multids.service.SalesService;

@RestController
public class ExampleController {

    private CustomerService customerService;

    private SalesService salesService;

    public ExampleController(CustomerService customerService, SalesService salesService) {
        this.customerService = customerService;
        this.salesService = salesService;
    }

    @GetMapping("/api/transactions")
    public Object sales() {
        return salesService.findAllTransactions();
    }

    @GetMapping("/api/customers")
    public List<Customer> getCustomers() {
        return customerService.findAllCustomers();
    }
}

