package lt.codeacademy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringContextConfig {

    @Bean
    public MarksDao markDao() {
        return new ExternalMarksDao();
    }
/*
    @Bean
    public GradeService gradeService() {
        return new GradeService(this.markDao());
    }*/
}
