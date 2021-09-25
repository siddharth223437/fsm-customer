package com.fsm.customer.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class PropertyMap implements Serializable {

    private  Map<String,String> propertyLabel = new HashMap<>();
    private  Map<String,String> props = new HashMap<>();
    private Map<String,String> validProperty = new HashMap<>();
    private Map<String,Boolean> validPropertyCache = new HashMap<>();

    public PropertyMap(){
        this.validPropertyCache.clear();
        setupValidProperties();
    }

    protected void setupProperty(String property,String label){
        this.validPropertyCache.clear();
        this.propertyLabel.put(property,label);
        this.validProperty.put(property,label);
    }

    protected void setupValidProperties(){}

    public void set(String property,String value) throws IllegalAccessException {
        this.assertValidateProperty(property);
        if(value == null ){
            props.remove(property);
        }else {
            this.props.put(property,value);
        }

    }

    public String get(String property) throws IllegalAccessException {
        this.assertValidateProperty(property);
        return this.props.get(property);
    }

    public void assertValidateProperty(String property) throws IllegalAccessException {
        boolean validator = false;
        if(this.validPropertyCache.get(property) != null) return;

        for(String str : this.validProperty.keySet()){
            if(property.matches(str)){
                validator = true;
                this.validPropertyCache.put(property,true);
                return;
            }
        }
        throw new IllegalAccessException("Property is not available");

    }
}
