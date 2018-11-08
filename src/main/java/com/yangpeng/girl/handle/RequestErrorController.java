package com.yangpeng.girl.handle;

import lombok.extern.java.Log;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @class: RequestErrorController
 * @description:
 * @author: yangpeng03614
 * @date: 2018-11-08 16:34
 */
@Log
public class RequestErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(value=ERROR_PATH)
    public String handleError(){
        return "error/404";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
