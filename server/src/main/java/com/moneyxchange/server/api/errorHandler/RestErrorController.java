package com.moneyxchange.server.api.errorHandler;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestErrorController implements ErrorController {
    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "This is an error.";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
