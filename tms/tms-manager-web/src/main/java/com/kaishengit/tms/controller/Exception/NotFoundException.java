package com.kaishengit.tms.controller.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND , reason="找不到")
public class NotFoundException extends RuntimeException {
}
