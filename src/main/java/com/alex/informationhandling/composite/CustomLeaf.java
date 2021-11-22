package com.alex.informationhandling.composite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;

import java.util.List;

public class CustomLeaf implements CustomComponent {

    private static final Logger logger = LogManager.getLogger();

    private char value;

    private CustomComponentType componentType;

    public CustomLeaf(char value, CustomComponentType componentType) {
        this.value = value;
        this.componentType = componentType;
    }

    public char getValue() {
        return value;
    }

    public CustomComponentType getComponentType() {
        return componentType;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public void setComponentType(CustomComponentType componentType) {
        this.componentType = componentType;
    }

    @Override
    public void add(CustomComponent component) {
        logger.warn("You can't add this element.");
    }

    @Override
    public void remove(CustomComponent component) {
        logger.warn("You can't remove this element.");
    }

    @Override
    public void remove(int index) {
        logger.warn("You can't remove this element.");
    }

    @Override
    public CustomComponent getChild(int index) {
        logger.warn("You can't get a child of this element.");
        return null;
    }

    @Override
    public List<CustomComponent> getChildren() {
        logger.warn("This element doesn't have children.");
        return Collections.emptyList();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
