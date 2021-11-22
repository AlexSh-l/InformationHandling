package com.alex.informationhandling.composite;

import java.util.ArrayList;
import java.util.List;

public class CustomComposite implements CustomComponent {

    private List<CustomComponent> components = new ArrayList<>();

    private CustomComponentType componentType;

    public CustomComposite(CustomComponentType type) {
        this.componentType = type;
    }

    @Override
    public CustomComponentType getComponentType() {
        return componentType;
    }

    @Override
    public void add(CustomComponent component) {
        components.add(component);
    }

    @Override
    public void remove(CustomComponent component) {
        components.remove(component);
    }

    @Override
    public void remove(int index) {
        components.remove(index);
    }

    @Override
    public CustomComponent getChild(int index) {
        return components.get(index);
    }

    @Override
    public List<CustomComponent> getChildren()/* throws CompositeException*/ {
        return components;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        String separator = "";
        switch (componentType) {
            case TEXT -> separator = "\r\n";
            case PARAGRAPH -> separator = " ";
            case SENTENCE -> separator = " ";
        }
        for (int i = 0; i < components.size(); ++i) {
            CustomComponent component = components.get(i);
            if (componentType.equals(CustomComponentType.TEXT)) {
                sb.append("\t");
                sb.append(component.toString().trim());
            } else {
                sb.append(component.toString());
            }
            if (i < components.size() - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }
}
