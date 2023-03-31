package nl.avasten.builderDemo.noBuilder;

import java.time.LocalDate;

public class MyVariousFieldType {

  // Added lots of fields, some necessary, others not
  private final String name;
  private int age;
  private final LocalDate addDate;
  private Boolean isActive;
  private long longer;
  private double percentage;
  private String optionalName;
  private String optionalName2;
  private String optionalName3;
  private String optionalName4;

  public MyVariousFieldType(String name) {
    this.name = name;
    this.addDate = LocalDate.now();
  }

  public MyVariousFieldType(String name, LocalDate addDate, Boolean isActive) {
    this.name = name;
    this.addDate = addDate;
    this.isActive = isActive;
  }

  public MyVariousFieldType(String name, int age, LocalDate addDate, Boolean isActive) {
    this.name = name;
    this.age = age;
    this.addDate = addDate;
    this.isActive = isActive;
  }

  public MyVariousFieldType(
      String name,
      int age,
      LocalDate addDate,
      Boolean isActive,
      String optionalName,
      String optionalName4) {
    this.name = name;
    this.age = age;
    this.addDate = addDate;
    this.isActive = isActive;
    this.optionalName = optionalName;
    this.optionalName4 = optionalName4;
  }

  // Overloaden is mogelijk
  public MyVariousFieldType(
      String name, int age, LocalDate addDate, Boolean isActive, long longer, double percentage) {
    this(name, age, addDate, isActive, longer, percentage, null, null, null, null);
  }

  public MyVariousFieldType(
      String name,
      int age,
      LocalDate addDate,
      Boolean isActive,
      long longer,
      double percentage,
      String optionalName,
      String optionalName2,
      String optionalName3,
      String optionalName4) {
    this.name = name;
    this.age = age;
    this.addDate = addDate;
    this.isActive = isActive;
    this.longer = longer;
    this.percentage = percentage;
    this.optionalName = optionalName;
    this.optionalName2 = optionalName2;
    this.optionalName3 = optionalName3;
    this.optionalName4 = optionalName4;
  }

  // Er zijn nog vele combinaties mogelijk maar voor de demo houden we het hierbij
  // In sommige gevallen kan je overloaden, maar dit wordt enorm groot en complex
}
