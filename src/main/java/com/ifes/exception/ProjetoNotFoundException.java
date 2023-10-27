package com.ifes.exception;

public class ProjetoNotFoudException extends Exception{
    public ProjetoNotFoudException(){
        super("Projeto não encontrado.");
    }
    
}
