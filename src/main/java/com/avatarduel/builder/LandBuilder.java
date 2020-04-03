package com.avatarduel.builder;

import com.avatarduel.model.Element;
import com.avatarduel.model.Land;

public class LandBuilder {
    /**
     * Builder Pattern for LandController
     */

    private String name;
    private String description;
    private Element element;

    public Land build(){
        Land ret = new Land();
        ret.setName(name);
        ret.setDescription(description);
        ret.setElement(element);
        return ret;
    }

    public LandBuilder name(String name){
        this.name = name;
        return this;
    }

    public LandBuilder description(String description){
        this.description = description;
        return this;
    }

    public LandBuilder element(Element element){
        this.element = element;
        return this;
    }

}
