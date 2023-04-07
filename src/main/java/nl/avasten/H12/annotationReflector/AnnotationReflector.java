package nl.avasten.H12.annotationReflector;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationReflector {

  public static void showClassAnnotations(
      Class<?> inspectorClass, Class<? extends Annotation> annotationClass) {
    if (inspectorClass.isAnnotationPresent(annotationClass)) {
      System.out.println(
          "Class: "
              + inspectorClass.getName()
              + " is annotated with: "
              + annotationClass.getName());
    }

    for (Method m : inspectorClass.getMethods()) {
      if (m.getAnnotations().length > 0) {
        System.out.println("Method: " + m.getName());
      }

      System.out.println("Aantal annotaties: " + m.getAnnotations().length);

      for (Annotation a : m.getAnnotations()) {
        if (a.annotationType().equals(annotationClass)) {
          System.out.println(a.annotationType());
        }
      }
    }
  }
}
