import java.io.*;
import java.util.Properties;

public class PropertiesReader{
    private  Properties properties;
    private String propertiesFilePath ="src/main/resources/application.properties";
    public static String USER_NAME;
    public static String PASSWORD;
    public static String BASE_URL;

    public PropertiesReader(){
        properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(propertiesFilePath );
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadProperties(){
        USER_NAME= properties.getProperty("userName");
        PASSWORD = properties.getProperty("password");
        BASE_URL = properties.getProperty("baseUrl");
    }
}
