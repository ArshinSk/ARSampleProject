package com.autorabit.resuableUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    static Properties prop = new Properties();
    static String prop_file;

    public static String getPropertyValue(String propertyKey) {
        //String propFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + prop_file;
        String propFilePath =  prop_file;
        FileInputStream src = null;
            try {
                src = new FileInputStream(new File(propFilePath));
            } catch (FileNotFoundException e) {
                System.out.println("Failed to find Property File provided in the path:" + propFilePath + " " + e.getStackTrace());
            }

            //Load data from the properties file
            try {
                prop.load(src);
            } catch (IOException e) {
                System.out.println("Failed to Read Property file in the path:"+propFilePath+" --> "+e.getStackTrace());
            }
        String value = prop.getProperty(propertyKey).toString();
            if(value.isEmpty()){
                System.out.println("Value is not available for Key: "+propertyKey+" in "+propFilePath+" file");
                //throw new Exception("Value is not available for Key: "+propertyKey+" in "+propFilePath+" file");
            }
    return value;
    }

    public static void configurePropertyFile(String filename){
        prop_file=filename;
    }
}
