package com.mauricio.projeto.exceptions;

public class TaxaNaoAplicavelException extends Exception{

    public TaxaNaoAplicavelException(String msg){
        super(msg);
    }

    public TaxaNaoAplicavelException(String msg, Throwable cause){
        super(msg, cause);
    }

}
