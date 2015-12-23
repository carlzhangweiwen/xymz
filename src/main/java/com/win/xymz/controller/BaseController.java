package com.win.xymz.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.win.xymz.common.editor.DoubleEditor;
import com.win.xymz.common.editor.FloatEditor;
import com.win.xymz.common.editor.IntEditor;

public class BaseController {
	protected static final Logger logger = LoggerFactory.getLogger("");
	@InitBinder
	protected void initBinder(WebDataBinder binder) {  
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyyMMdd HHmmssSS"), true));  
		binder.registerCustomEditor(int.class,new IntEditor()); 
		binder.registerCustomEditor(int.class,new DoubleEditor()); 
		binder.registerCustomEditor(int.class,new FloatEditor()); 
	}  
}
