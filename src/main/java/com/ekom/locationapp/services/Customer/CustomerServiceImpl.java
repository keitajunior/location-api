package com.ekom.locationapp.services.Customer;

import com.ekom.locationapp.dto.CustomerDto;
import com.ekom.locationapp.entities.Customer;
import com.ekom.locationapp.exceptions.CustomerNotFoundException;
import com.ekom.locationapp.handlers.CustomerHandler;
import com.ekom.locationapp.mappers.CustomerMapper;
import com.ekom.locationapp.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomerAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.INSTANCE.toEntity(customerDto);
        CustomerHandler.INSTANCE.fullFillCustomerAccount(customer);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.INSTANCE.toDto(savedCustomer);
    }

    @Override
    public List<CustomerDto> listOfCustomers() {
        return CustomerMapper.INSTANCE.toDtos(customerRepository.findAll());
    }

    @Override
    public CustomerDto findCustomerById(Long clientId) throws CustomerNotFoundException {
        return CustomerMapper.INSTANCE.toDto(customerRepository.findById(clientId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer introuvable")));
    }

    @Override
    public CustomerDto modifyCustomerById(Long clientId, CustomerDto customerDto) throws CustomerNotFoundException {
        Customer foundCustomer = CustomerMapper.INSTANCE.toEntity(findCustomerById(clientId));
        CustomerHandler.INSTANCE.updateCustomerAccount(foundCustomer, CustomerMapper.INSTANCE.toEntity(customerDto));
        Customer savedCustomer = customerRepository.save(foundCustomer);
        return CustomerMapper.INSTANCE.toDto(savedCustomer);
    }

    @Override
    public void deleteCustomerById(Long accountId) throws CustomerNotFoundException {
        customerRepository.findById(accountId)
                .orElseThrow(() -> new CustomerNotFoundException("Client non trouvé"));
        customerRepository.deleteById(accountId);
    }
}
