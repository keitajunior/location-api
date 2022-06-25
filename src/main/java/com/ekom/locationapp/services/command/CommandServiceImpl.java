package com.ekom.locationapp.services.command;

import com.ekom.locationapp.dto.CommandDto;
import com.ekom.locationapp.entities.Command;
import com.ekom.locationapp.exceptions.CommandNotFoundException;
import com.ekom.locationapp.exceptions.ProductNotSufficientException;
import com.ekom.locationapp.handlers.CommandHandler;
import com.ekom.locationapp.mappers.CommandMapper;
import com.ekom.locationapp.repositories.CommandRepository;
import com.ekom.locationapp.services.product.ProductService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ekom.locationapp.specifications.CommandSpecs.withStatusLike;

@Service
public class CommandServiceImpl implements CommandService {
    private final CommandRepository commandRepository;
    private final ProductService productService;
    public CommandServiceImpl(CommandRepository commandRepository, ProductService productService) {
        this.commandRepository = commandRepository;
        this.productService = productService;
    }

    @Override
    public CommandDto placeOrder(CommandDto commandDto) throws ProductNotSufficientException {
        Command newOrder = CommandMapper.INSTANCE.toEntity(commandDto);
        CommandHandler.INSTANCE.fullFillCommand(newOrder);
        Command savedOrder = commandRepository.save(newOrder);
        return CommandMapper.INSTANCE.toDto(savedOrder);
    }

    @Override
    public List<CommandDto> listOfCommands() {
        return CommandMapper.INSTANCE.toDtos(commandRepository.findAll());
    }

    @Override
    public CommandDto findCommandById(Long commandId) throws CommandNotFoundException {
        Command searchingOrder = commandRepository.findById(commandId)
                .orElseThrow(() -> new CommandNotFoundException("Commande introuvable"));
        return CommandMapper.INSTANCE.toDto(searchingOrder);
    }

    @Override
    public CommandDto modifyCommandById(Long commandId, CommandDto commandDto) throws CommandNotFoundException {
        Command foundCommand = commandRepository.findById(commandId)
                .orElseThrow(() -> new CommandNotFoundException("Commande introuvable"));
        Command commandFromUi = CommandMapper.INSTANCE.toEntity(commandDto);
        CommandHandler.INSTANCE.updateCommand(foundCommand, commandFromUi);
        Command savedCommand = commandRepository.save(foundCommand);
        return CommandMapper.INSTANCE.toDto(savedCommand);
    }

    @Override
    public void deleteCommandById(Long commandId) throws CommandNotFoundException {
        commandRepository.findById(commandId)
                .orElseThrow(() -> new CommandNotFoundException("Commande impossible à supprimer car inexistante"));
        commandRepository.deleteById(commandId);
    }

    @Override
    public boolean exists(CommandDto commandDto) {
        Command command = CommandMapper.INSTANCE.toEntity(commandDto);
        Example<Command> commandExample = Example.of(command, ExampleMatcher.matching().withIgnoreNullValues());
        return this.commandRepository.exists(commandExample);
    }

    @Override
    public List<CommandDto> searchByStatus(String searchvalue) {
        return CommandMapper.INSTANCE.toDtos(this.commandRepository.findAll(
                withStatusLike(searchvalue)
        ));
    }

}
