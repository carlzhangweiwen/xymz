/**
 * BokeMecn
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package com.win.xymz.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.win.xymz.bean.Test;

/**
 * 
 * @author robin.tian
 * @version $Id: JsonTestController.java, v 0.1 2015年12月20日 下午3:31:19 robin.tian Exp $
 */
@Controller
public class JsonTestController {

    @RequestMapping(value = "/test.json", method = RequestMethod.GET)
    public Test testJson(HttpServletRequest request, HttpServletResponse response, ModelMap modelmap) {

        Test test = new Test();

        test.setId("1");
        test.setName("1");
        test.setPassword("password");
        return test;
    }

}
