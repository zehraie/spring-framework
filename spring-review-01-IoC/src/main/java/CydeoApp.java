import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotations.config.AppConfig;
import stereotype_annotations.model.DataStructure;
import stereotype_annotations.model.Microservice;

import java.util.zip.DataFormatException;

public class CydeoApp {

    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        DataStructure ds = container.getBean(DataStructure.class);
        ds.getTotalHours();

        Microservice ms = container.getBean(Microservice.class);
        ms.getTotalHours();
    }
}
// ONLY I can not PUT