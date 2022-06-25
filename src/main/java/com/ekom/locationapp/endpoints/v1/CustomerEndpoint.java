package com.ekom.locationapp.endpoints.v1;

import com.ekom.locationapp.dto.CustomerDto;
import com.ekom.locationapp.endpoints.LocationApiVersions;
import com.ekom.locationapp.exceptions.CustomerNotFoundException;
import com.ekom.locationapp.services.Customer.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(LocationApiVersions.V1_CUSTOMERS)
public class CustomerEndpoint {
    private final CustomerService customerService;

    public CustomerEndpoint(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerDto addClient(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomerAccount(customerDto);
    }

    @GetMapping
    public List<CustomerDto> getCustomers() {
        return customerService.listOfCustomers();
    }

    @GetMapping("/{customerId}")
    public CustomerDto getCustomer(@PathVariable Long customerId) throws CustomerNotFoundException {
        return customerService.findCustomerById(customerId);
    }

    @PutMapping("/{customerId}")
    public CustomerDto updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDto customerDto) throws CustomerNotFoundException {
        return customerService.modifyCustomerById(customerId, customerDto);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomerAccount(@PathVariable Long customerId) throws CustomerNotFoundException {
        customerService.deleteCustomerById(customerId);
    }
}
