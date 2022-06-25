package com.ekom.locationapp.handlers;

import com.ekom.locationapp.entities.Customer;
import com.ekom.locationapp.entities.Command;

import java.time.OffsetDateTime;
import java.util.List;

public enum CustomerHandler {
    INSTANCE;

    public void fullFillCustomerAccount(Customer customer) {
        OffsetDateTime now = OffsetDateTime.now();
        customer.setCreatedOn(now);
        customer.setLastModifyOn(now);

        List<Command> commands = customer.getCommands();
        if (commands != null && !commands.isEmpty()) commands.forEach(command -> command.setCustomer(customer));
    }

    public void updateCustomerAccount(Customer customerFromDb, Customer customerFromUi) {
        if (customerFromUi.getPhoneNumber() != null)
            customerFromDb.setPhoneNumber(customerFromUi.getPhoneNumber());
        if (customerFromUi.getFirstname() != null)
            customerFromDb.setFirstname(customerFromUi.getFirstname());
        if (customerFromUi.getLastname() != null)
            customerFromDb.setLastname(customerFromUi.getLastname());
        if (customerFromUi.getAddress() != null)
            customerFromDb.setAddress(customerFromUi.getAddress());
        if (customerFromUi.getLogin() != null)
            customerFromDb.setLogin(customerFromUi.getLogin());
        if (customerFromUi.getPassword() != null)
            customerFromDb.setPassword(customerFromUi.getPassword());

        if (customerFromUi.getCommands() != null && !customerFromUi.getCommands().isEmpty()) {
            customerFromDb.getCommands().clear();
            customerFromDb.getCommands().addAll(customerFromUi.getCommands());
            customerFromDb.getCommands().forEach(command -> command.setCustomer(customerFromDb));
        }
        OffsetDateTime now = OffsetDateTime.now();
        customerFromDb.setLastModifyOn(now);
    }
}
