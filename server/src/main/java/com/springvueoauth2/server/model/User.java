package com.springvueoauth2.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String email;

  @Column
  private String name;

  @Column
  private String password;

  @Column
  private String phone;

  @Column
  private String imagePath;

  @Column
  private Role role;

  public User update(String name, String imagePath) {
    this.name = name;
    this.imagePath = imagePath;

    return this;
  }

}
