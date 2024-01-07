package org.examples.budgetmgmt.budgetplan;
import org.examples.budgetmgmt.expensecategory.ExpenseCategory;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class BudgetPlan {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id", nullable = false)
  private ExpenseCategory category;

  private BigDecimal budgetAmount;
  private LocalDate startDate; // Start date of the budget period
  private LocalDate endDate;   // End date of the budget period

  public BigDecimal getBudgetAmount() {
    return budgetAmount;
  }

  public ExpenseCategory getCategory() {
    return category;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setBudgetAmount(BigDecimal budgetAmount) {
    this.budgetAmount = budgetAmount;
  }

  public void setCategory(ExpenseCategory category) {
    this.category = category;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }
}

