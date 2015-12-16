package com.win.xymz.editor;

import org.springframework.beans.propertyeditors.PropertiesEditor;

public class DoubleEditor extends PropertiesEditor{
	@Override
    public void setAsText(String text){
        if (text == null || text.equals("")){
            text = "0";
        }
        setValue(Double.parseDouble(text));    
    }
    
    @Override
    public String getAsText(){
        return getValue().toString();
    }
}
