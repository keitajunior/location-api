package com.ekom.locationapp.endpoints.v1;

import com.ekom.locationapp.dto.CommandDto;
import com.ekom.locationapp.endpoints.LocationApiVersions;
import com.ekom.locationapp.exceptions.CommandNotFoundException;
import com.ekom.locationapp.exceptions.ProductNotSufficientException;
import com.ekom.locationapp.services.command.CommandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(LocationApiVersions.V1_COMMANDS)
public class CommandEndpoint {
    private final CommandService commandService;

    public CommandEndpoint(CommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping
    public CommandDto addCommand(@RequestBody CommandDto commandDto) throws ProductNotSufficientException {
        return this.commandService.placeOrder(commandDto);
    }

    @GetMapping
    public List<CommandDto> getCommands() {
        return this.commandService.listOfCommands();
    }

    @GetMapping("/{commandId}")
    public CommandDto getCommand(@PathVariable Long commandId) throws CommandNotFoundException {
        return this.commandService.findCommandById(commandId);
    }

    @PutMapping("/{commandId}")
    public CommandDto updateCommand(@PathVariable Long commandId, CommandDto commandDto) throws CommandNotFoundException {
        return this.commandService.modifyCommandById(commandId, commandDto);
    }

    @DeleteMapping("/{commandId}")
    public void deleteCommand(@PathVariable Long commandId) throws CommandNotFoundException {
        this.commandService.deleteCommandById(commandId);
    }

    @PostMapping("/check")
    public boolean check(@RequestBody CommandDto commandDto) {
        return this.commandService.exists(commandDto);
    }

    @GetMapping("/search")
    public List<CommandDto> searchBy(@RequestParam String searchValue) {
        return this.commandService.searchByStatus(searchValue);
    }
}
