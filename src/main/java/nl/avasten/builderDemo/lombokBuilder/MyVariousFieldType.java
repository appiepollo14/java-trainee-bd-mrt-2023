package nl.avasten.builderDemo.lombokBuilder;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
public class MyVariousFieldType {

  @NonNull
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
}
