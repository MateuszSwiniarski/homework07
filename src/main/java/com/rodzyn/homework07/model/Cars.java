package com.rodzyn.homework07.model;

public class Cars {

  private long carId;
  private String mark;
  private String model;
  private String color;
  private long productionYear;

  public Cars() {
  }

  public Cars(long carId, String mark, String model, String color, long productionYear) {
    this.carId = carId;
    this.mark = mark;
    this.model = model;
    this.color = color;
    this.productionYear = productionYear;
  }


  public long getCarId() {
    return carId;
  }

  public void setCarId(long carId) {
    this.carId = carId;
  }


  public String getMark() {
    return mark;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }


  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }


  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }


  public long getProductionYear() {
    return productionYear;
  }

  public void setProductionYear(long productionYear) {
    this.productionYear = productionYear;
  }

  @Override
  public String toString() {
    return "Cars{" +
            "carId=" + carId +
            ", mark='" + mark + '\'' +
            ", model='" + model + '\'' +
            ", color='" + color + '\'' +
            ", productionYear=" + productionYear +
            '}';
  }
}
