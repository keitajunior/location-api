package com.ekom.locationapp.handlers;

import com.ekom.locationapp.entities.Command;
import com.ekom.locationapp.exceptions.ProductNotSufficientException;

import java.time.OffsetDateTime;

public enum CommandHandler {
    INSTANCE;

    public void fullFillCommand(Command command) throws ProductNotSufficientException {
        int orderQuantity= command.getProduct().getOrderQuantity();
        int availableStock= command.getProduct().getAvailableStock();
        if (orderQuantity > availableStock) throw new ProductNotSufficientException("Ne peut commander cette quantité, stock indisponible");
        command.getProduct().setAvailableStock(availableStock - orderQuantity);
        OffsetDateTime now = OffsetDateTime.now();
        command.setCreatedOn(now);
        command.setLastModifyOn(now);
    }

    public void updateCommand(Command foundCommand, Command commandFromUi) {
        if (commandFromUi.getCommandStatus() != null) foundCommand.setCommandStatus(commandFromUi.getCommandStatus());
        if (commandFromUi.getDeliveryAddress() != null) foundCommand.setDeliveryAddress(commandFromUi.getDeliveryAddress());
        if (commandFromUi.getEndDate() != null) foundCommand.setEndDate(commandFromUi.getEndDate());
        foundCommand.setProduct(commandFromUi.getProduct());
        OffsetDateTime now =OffsetDateTime.now();
        foundCommand.setLastModifyOn(now);
    }
}
