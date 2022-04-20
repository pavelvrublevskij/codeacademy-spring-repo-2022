package lt.codeacademy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        //simplePlainJavaDIExample();
        diExampleWithSpring();
    }

    private static void simplePlainJavaDIExample() {
        System.out.println("Pazymiu vidurkis: " + new GradeService(new InternalMarksDao()).averageGrade());
    }

    private static void diExampleWithSpring() {
        ApplicationContext springContext = new AnnotationConfigApplicationContext(SpringContextConfig.class);

        GradeService gradeService = springContext.getBean(GradeService.class);
        System.out.println("Pazymiu vidurkis: " + gradeService.averageGrade());
    }
}
