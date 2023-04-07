package nl.avasten.H12;

import nl.avasten.H12.annotationReflector.AnnotationReflector;

public class Main {

  public static void main(String[] args) {

    Class toBeInspected = nl.avasten.H12.person.Person.class;
    Class annotationclass = nl.avasten.H12.annotations.MyAnnotation.class;

    AnnotationReflector.showClassAnnotations(toBeInspected, annotationclass);
  }
}
