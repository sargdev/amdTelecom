package com.sarg.assessment4.misc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class MyProperties {

    private final Properties properties = new Properties();

    private MyProperties(){
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class LazyHolder
    {
        private static final MyProperties INSTANCE = new MyProperties();
    }

    public static MyProperties getInstance()
    {
        return LazyHolder.INSTANCE;
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

    public Set<String> getAllPropertyNames(){
        return properties.stringPropertyNames();
    }

    public boolean containsKey(String key){
        return properties.containsKey(key);
    }


}
