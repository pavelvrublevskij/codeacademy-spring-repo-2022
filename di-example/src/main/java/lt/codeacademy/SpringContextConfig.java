package lt.codeacademy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringContextConfig {

    @Bean
    public MarksDao markDao() {
        return new InternalMarksDao();
    }

    @Bean
    public GradeService gradeService() {
        return new GradeService(this.markDao());
    }
}
