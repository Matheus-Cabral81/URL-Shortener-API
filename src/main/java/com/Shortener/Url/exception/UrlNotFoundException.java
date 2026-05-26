package com.Shortener.Url.exception;


public class UrlNotFoundException extends RuntimeException{

    public UrlNotFoundException(String url){

        super("URL não encontrada " + url);
    }
}