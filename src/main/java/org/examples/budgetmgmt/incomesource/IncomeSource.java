package org.examples.budgetmgmt.incomesource;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class IncomeSource {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name; // Name of the income source
  private BigDecimal amount; // Amount of income
  private LocalDate dateReceived; // Date when the income was received

  // Constructors, getters, and setters
}
