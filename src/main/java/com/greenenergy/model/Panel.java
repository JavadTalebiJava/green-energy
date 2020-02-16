package com.greenenergy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Panel class hold information related to a Solar panel.
 */
@Data
@Entity
@Table(name = "panel")
public class Panel implements Serializable {

  private static final long serialVersionUID = -8527695980909864257L;

  @JsonIgnore
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(name = "serial", unique = true)
  private String serial;

  @Column(name = "longitude")
  private Double longitude;

  @Column(name = "latitude")
  private Double latitude;

  @Nullable
  @Column(name = "brand")
  private String brand;


}
