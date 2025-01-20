package com.aluracursos.forohub.Topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRespuestaTopico(

        Long id,

        String titulo,

        String mensaje,

        String fechaDeCreacion,

        Boolean status,

        Curso curso
) {
}
