package com.framework.scaped.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {
    private String propFileName;

    public PropertyFileReader(String propFileName) {
        this.propFileName = propFileName;
    }


    InputStream inputStream;

    /**
     * @param key
     * @return
     * @throws IOException
     */
    public String getPropValue(String key) throws IOException {
        String value = "";
        try {
            Properties prop = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("Property File: '" + propFileName + "' not found in the classpath");
            }

            value = prop.getProperty(key);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return value;
    }
}

