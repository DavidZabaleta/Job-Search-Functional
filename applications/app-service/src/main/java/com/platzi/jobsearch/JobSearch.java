package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.platzi.jobsearch.model.entities.CLIArguments;

import static com.platzi.jobsearch.CommanderFunctions.buildCommanderWithName;

public class JobSearch {
    public static void main(String[] args) {
        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::builder);
    }
}
