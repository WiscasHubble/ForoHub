package com.aluracursos.forohub.Topicos;

public record DatosListadoTopico(Long id, String mensaje, String fechaDeCreacion, Boolean status, Curso curso) {

    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getMensaje(), topico.getFechaDeCreacion(), topico.getStatus(), topico.getCurso());
    }

}
