package qa.virgosol.test.AI.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import qa.virgosol.test.AI.model.YAMLModel;

import java.io.File;
import java.io.IOException;

public class ReadYAML {

    private static YAMLModel model;

    static {
        File file = new File("src/test/resources/configuration.yml");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            model = objectMapper.readValue(file, YAMLModel.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getElementType(){
        return model.getElementType();
    }
    public static String getYourLocator(){
        return model.getYourLocator();
    }
    public static String getYourLocatorType(){
        return model.getYourLocatorType();
    }

    public static String getTestURL(){
        return model.getTestURL();
    }

    public static String getBrowserType(){
        return model.getBrowserType();
    }

    public static boolean getHeadlessStatus(){
        return model.isHeadless();
    }
}
