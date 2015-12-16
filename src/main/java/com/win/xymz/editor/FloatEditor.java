package com.win.xymz.editor;

import org.springframework.beans.propertyeditors.PropertiesEditor;

public class FloatEditor extends PropertiesEditor{
	@Override
    public void setAsText(String text){
        if (text == null || text.equals("")){
            text = "0";
        }
        setValue(Float.parseFloat(text));    
    }
    
    @Override
    public String getAsText(){
        return getValue().toString();
    }
}
