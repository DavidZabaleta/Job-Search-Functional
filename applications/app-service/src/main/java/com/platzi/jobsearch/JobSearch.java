package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.platzi.jobsearch.api.APIHandler;
import com.platzi.jobsearch.model.entities.CLIArguments;
import com.platzi.jobsearch.usecase.functions.CLIFunctions;

import java.util.*;
import java.util.stream.Stream;

import static com.platzi.jobsearch.usecase.functions.CommanderFunctions.buildCommanderWithName;
import static com.platzi.jobsearch.usecase.functions.CommanderFunctions.parseArguments;

public class JobSearch {
    public static void main(String[] args) {
        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);

        Stream<CLIArguments> streamOfCLI =
                parseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(obj -> (CLIArguments) obj);

        Optional<CLIArguments> cliArgumentsOptional =
                streamOfCLI.filter(cli -> !cli.isHelp())
                .filter(cli -> Objects.nonNull(cli.getKeyword()))
                .findFirst();

        cliArgumentsOptional.map(CLIFunctions::toMap)
                .map(APIHandler::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }
}
