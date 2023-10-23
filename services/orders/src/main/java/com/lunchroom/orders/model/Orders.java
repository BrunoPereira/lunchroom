package com.lunchroom.orders.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Orders {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotBlank
  @Size(min = 0, max = 20)
  private String employee;

  private Date updated;

  private Date created;

  private int calories;

  public void setCreated(Date date) {
    this.created = date;
  }

  public void setUpdated(Date date) {
    this.updated = date;
  }

}
