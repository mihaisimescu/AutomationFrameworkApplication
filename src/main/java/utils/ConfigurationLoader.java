package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationLoader {

    private Properties properties;

    public ConfigurationLoader(String propertyFilePath){
        properties = new Properties();

        try(FileInputStream inputStream = new FileInputStream(propertyFilePath)){

            properties.load(inputStream);

        }catch (IOException e){
            throw new RuntimeException("Property file was not found in " + propertyFilePath);
        }
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

}
