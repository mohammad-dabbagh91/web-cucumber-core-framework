package dataProviders;

import enums.DriverType;
import enums.EnvironmentType;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {

    private final Properties properties;

    public ConfigFileReader() {
        String propertyFilePath = "/config/configuration.properties";
        properties = new Properties();
        try {
            InputStream stream = ConfigFileReader.class.getResourceAsStream(propertyFilePath);
            properties.load(stream);
            setEnvProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void setEnvProperties() {

            try {

                String envFolder = properties.getProperty("env");
                File[] files = new File(System.getProperty("user.dir")+"/src/main/resources/config/"+envFolder+"/").listFiles();
                for (File eachFile : files){
                    properties.load(ConfigFileReader.class.getResourceAsStream("/config/"+envFolder+"/"+eachFile.getName()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getUrl() {
        String url = properties.getProperty("url");

        //Simply If...Else
        if (url != null) return url;
        else
            throw new RuntimeException("url not specified in the config file.");
    }

    public long getTime() {
        String timeout = properties.getProperty("timeout");

        //Common If...Else
        if (timeout != null) {
            return Long.parseLong(timeout);
        } else {
            throw new RuntimeException("timeout not specified in the config file.");
        }
    }

    public DriverType getBrowser() {
        String browserName = properties.getProperty("browser");

        switch (browserName) {
            case "chrome":
                return DriverType.CHROME;
            case "firefox":
                return DriverType.FIREFOX;
            case "edge":
                return DriverType.EDGE;
            case "safari":
                return DriverType.SAFARI;
            default:
                throw new RuntimeException("Browser name key value in configuration file is not matched: " + browserName);
        }
    }

    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("run.environment");

        switch (environmentName) {
            case "local":
                return EnvironmentType.LOCAL;
            case "remote":
                return EnvironmentType.REMOTE;
            default:
                throw new RuntimeException("Environment type key value in configuration file is not matched: " + environmentName);
        }
    }
}
