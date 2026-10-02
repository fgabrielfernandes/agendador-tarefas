package com.javanauta.agendadortarefas.infraestructure.exceptions;

public class ResourceNotFoundException  extends RuntimeException{

    public ResourceNotFoundException(String messagem){
        super(messagem);
    }

    public ResourceNotFoundException(String messagem,Throwable cause){
        super(messagem,cause);
    }
}
