package nl.avasten.H12.annotationReflector;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

public class AnnotationReflector {

  public static void showClassAnnotations(
      Class<?> inspectorClass, List<Class<? extends Annotation>> annotationClass) {
    for (Class<? extends Annotation> a : annotationClass) {
      if (inspectorClass.isAnnotationPresent(a)) {
        System.out.println(
            "Class: " + inspectorClass.getName() + " is annotated with: " + a.getName());

        for (Method m : inspectorClass.getMethods()) {
          if (m.getAnnotations().length > 0) {
            System.out.println("Method: " + m.getName() + " is annotated!");

            if (m.isAnnotationPresent(a)) {
              System.out.println("Method: " + m.getName() + " is annotated with: " + a.getName());

              Annotation annotation = m.getAnnotation(a);
              try {
                Method valueMethod = a.getMethod("value");
                String value = (String) valueMethod.invoke(annotation);
                System.out.println(value);
              } catch (Exception e) {
                // Handle exception if necessary
              }
            }
          }
        }
      } else {
        System.out.println(
            "Class: " + inspectorClass.getName() + " is not annotated with: " + a.getName());
      }
    }
  }
}
