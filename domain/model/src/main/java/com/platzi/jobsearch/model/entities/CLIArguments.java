package com.platzi.jobsearch.model.entities;

import com.beust.jcommander.Parameter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CLIArguments {
    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            description = "KEYWORD"
    )
    private String keyword;

    @Parameter(
            names = {"--location","-l"},
            description = "Cada busqueda puede incluir una ubicacion"
    )
    private String location;

    @Parameter(
            names = {"--page", "-p"},
            description = "La API devuelve 50 resultados, usa un numero para la pagina"
    )
    private int page;

    @Parameter(
            names = {"--full-time", "-ft"},
            description = "Agrega si queremos trabajos de tiempo completo"
    )
    private boolean isFullTime;

    @Parameter(
            names = {"--markdown", "-md"},
            description = "Obtener los resultados en formato Markdown"
    )
    private boolean isMarkDown;

    @Parameter(
            names = "--help",
            help = true,
            description = "Mostrar la ayuda"
    )
    private boolean isHelp;
}
