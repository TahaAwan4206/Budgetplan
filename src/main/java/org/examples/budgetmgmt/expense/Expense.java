package org.examples.budgetmgmt.expense;


import org.examples.budgetmgmt.expensecategory.ExpenseCategory;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Expense {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private BigDecimal amount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id", nullable = false)
  private ExpenseCategory category;

  private LocalDate paidDate; // Date the expense was paid

  public ExpenseCategory getCategory() {
    return category;
  }

  public Long getId() {
    return id;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public LocalDate getPaidDate() {
    return paidDate;
  }

  public void setCategory(ExpenseCategory category) {
    this.category = category;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public void setPaidDate(LocalDate paidDate) {
    this.paidDate = paidDate;
  }
  // Constructors, getters, and setters
}
