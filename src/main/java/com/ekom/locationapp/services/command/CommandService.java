package com.ekom.locationapp.services.command;

import com.ekom.locationapp.dto.CommandDto;
import com.ekom.locationapp.exceptions.CommandNotFoundException;
import com.ekom.locationapp.exceptions.ProductNotSufficientException;

import java.util.List;

public interface CommandService {
    CommandDto placeOrder(CommandDto commandDto) throws ProductNotSufficientException;

    List<CommandDto> listOfCommands();

    CommandDto findCommandById(Long commandId) throws CommandNotFoundException;

    CommandDto modifyCommandById(Long commandId, CommandDto commandDto) throws CommandNotFoundException;

    void deleteCommandById(Long commandId) throws CommandNotFoundException;

    boolean exists(CommandDto commandDto);

    List<CommandDto> searchByStatus(String searchValue);
}
