package com.platzi.jobsearch.usecase.functions;

import com.platzi.jobsearch.model.entities.CLIArguments;

import java.util.HashMap;
import java.util.Map;

public class CLIFunctions {
    public static Map<String, Object> toMap(CLIArguments cliArguments) {
        Map<String, Object> param = new HashMap<>();

        param.put("description", cliArguments.getKeyword());
        param.put("location", cliArguments.getLocation());
        param.put("full_time", cliArguments.isFullTime());
        param.put("page", cliArguments.getPage());

        if (cliArguments.isMarkDown()) {
            param.put("markdown", true);
        }

        return param;
    }
}
