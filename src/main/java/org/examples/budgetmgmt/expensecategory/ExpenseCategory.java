package org.examples.budgetmgmt.expensecategory;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ExpenseCategory {

  @Id
  private Integer id; // ID determines the category

  @Column(name = "name", nullable = false, unique = true)
  private String name;


  // Constructors, getters, and setters


  public String getName() {
    return name;
  }

  public Integer getId() {
    return id;


  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }
}
