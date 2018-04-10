package com.kaishengit.exception;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFountException extends RuntimeException {
}
