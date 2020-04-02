package com.platzi.jobsearch.usecase.functions;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.platzi.jobsearch.model.entities.CLIArguments;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CommanderFunctions {
    public static <T> JCommander buildCommanderWithName(String cliName, Supplier<T> argumentSupplier) {
        JCommander jCommander = JCommander.newBuilder()
                .addObject(argumentSupplier.get())
                .build();

        jCommander.setProgramName(cliName);

        return jCommander;
    }

    public static Optional<List<Object>> parseArguments(
            JCommander jCommander,
            String[] arguments,
            Consumer<JCommander> onError
    ) {
        try {
            jCommander.parse(arguments);
            return Optional.of(jCommander.getObjects());
        } catch (ParameterException paramEx) {
            onError.accept(jCommander);
        }
        return Optional.empty();
    }
}
