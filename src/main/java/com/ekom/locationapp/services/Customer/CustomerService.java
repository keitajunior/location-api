package com.ekom.locationapp.services.Customer;

import com.ekom.locationapp.dto.CustomerDto;
import com.ekom.locationapp.exceptions.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomerAccount(CustomerDto customerDto);

    List<CustomerDto> listOfCustomers();

    CustomerDto findCustomerById(Long clientId) throws CustomerNotFoundException;

    CustomerDto modifyCustomerById(Long clientId, CustomerDto customerDto) throws CustomerNotFoundException;

    void deleteCustomerById(Long accountId) throws CustomerNotFoundException;
}
