package com.kaishengit.tms.exception;

public class ServiceException extends RuntimeException {

    public ServiceException(){

    }

    public ServiceException(Throwable th){
        super(th);
    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String message, Throwable th){
        super(message, th);
    }

}
