package com.ifes.dwIntegracao.exception;

public class NotFoundException extends Exception
{
    public String getMessage()
    {
        String message;
        message = "Objeto não achado.";
        return message;
    }
    public String ProjetoNotFoundException(){
        return "Projeto não Encontrado.";
    }
}
