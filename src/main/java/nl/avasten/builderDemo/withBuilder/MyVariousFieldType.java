package nl.avasten.builderDemo.withBuilder;

import java.time.LocalDate;

public class MyVariousFieldType {

  // Allemaal required door final, is dit een pattern of een keuze?
  // Gebruik je de Builder pattern alleen bij final objecten?
  private final String name;
  private final int age;
  private final LocalDate addDate;
  private final Boolean isActive;
  private final long longer;
  private final double percentage;
  private final String optionalName;
  private final String optionalName2;
  private final String optionalName3;
  private final String optionalName4;

  private MyVariousFieldType(MyVariousFieldBuilder myVariousFieldBuilder) {
    this.name = myVariousFieldBuilder.name;
    this.age = myVariousFieldBuilder.age;
    this.addDate = myVariousFieldBuilder.addDate;
    this.isActive = myVariousFieldBuilder.isActive;
    this.longer = myVariousFieldBuilder.longer;
    this.percentage = myVariousFieldBuilder.percentage;
    this.optionalName = myVariousFieldBuilder.optionalName;
    this.optionalName2 = myVariousFieldBuilder.optionalName2;
    this.optionalName3 = myVariousFieldBuilder.optionalName3;
    this.optionalName4 = myVariousFieldBuilder.optionalName4;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public LocalDate getAddDate() {
    return addDate;
  }

  public Boolean getActive() {
    return isActive;
  }

  public long getLonger() {
    return longer;
  }

  public double getPercentage() {
    return percentage;
  }

  public String getOptionalName() {
    return optionalName;
  }

  public String getOptionalName2() {
    return optionalName2;
  }

  public String getOptionalName3() {
    return optionalName3;
  }

  public String getOptionalName4() {
    return optionalName4;
  }

  public static class MyVariousFieldBuilder {

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

    // Required args constructor
    public MyVariousFieldBuilder(String name) {
      this.name = name;
      this.addDate = LocalDate.now();
    }

    public MyVariousFieldBuilder setAge(int age) {
      this.age = age;
      return this;
    }

    public MyVariousFieldBuilder age(int age) {
      this.age = age;
      return this;
    }

    public MyVariousFieldBuilder setOptionalName4(String optionalName4) {
      this.optionalName4 = optionalName4;
      return this;
    }

    public MyVariousFieldType build() {
      return new MyVariousFieldType(this);
    }
  }
}
