package com.twy.secondkill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author gongpeng
 * @date 2021/3/29 20:42
 */

@Controller
@RequestMapping("/base")
public class BaseController {
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error() {
        return "error";
    }
}