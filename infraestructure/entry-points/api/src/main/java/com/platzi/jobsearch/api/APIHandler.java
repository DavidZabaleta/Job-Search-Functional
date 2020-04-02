package com.platzi.jobsearch.api;

import com.platzi.jobsearch.api.interfaces.APIJobs;
import com.platzi.jobsearch.model.entities.JobPosition;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

import static com.platzi.jobsearch.usecase.functions.interfaces.APIFunctions.buildAPI;

public class APIHandler {
    public static Stream<JobPosition> executeRequest(Map<String, Object> params) {
        APIJobs api = buildAPI(APIJobs.class, "https://jobs.github.com");

        return Stream.of(params)
                .map(api::jobs)
                .flatMap(Collection::stream);
    }
}
