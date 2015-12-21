package com.win.xymz.common.editor;

import org.springframework.beans.propertyeditors.PropertiesEditor;

public class IntEditor extends PropertiesEditor {
	@Override
    public void setAsText(String text){
        if (text == null || text.equals("")){
            text = "0";
        }
        setValue(Integer.parseInt(text));    
    }
    
    @Override
    public String getAsText(){
        return getValue().toString();
    }
}
