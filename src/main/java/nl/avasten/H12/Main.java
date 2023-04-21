package nl.avasten.H12;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import nl.avasten.H12.annotationReflector.AnnotationReflector;

public class Main {

  // TODO ask why ever you need annotation with retention type class
  public static void main(String[] args) {

    Class toBeInspected = nl.avasten.H12.person.Person.class;
    Class annotationClass = nl.avasten.H12.annotations.MyAnnotation.class;
    Class annotationClass2 = nl.avasten.H12.annotations.MyAnnotation2.class;

    List<Class<? extends Annotation>> annotationclasses = new ArrayList<>();
    annotationclasses.add(annotationClass);
    annotationclasses.add(annotationClass2);

    AnnotationReflector.showClassAnnotations(toBeInspected, annotationclasses);
  }
}
