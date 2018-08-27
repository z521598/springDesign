package com.github.bean;

/**
 * Created by langshiquan on 2018/8/25.
 */
public class ChildSimpleBean extends SimpleBean {
    private String chileProperty;

    public String getChileProperty() {
        return chileProperty;
    }

    public void setChileProperty(String chileProperty) {
        this.chileProperty = chileProperty;
    }

    @Override
    public String toString() {
        return "ChildSimpleBean{" +
                "chileProperty='" + chileProperty + '\'' +
                '}';
    }
}
