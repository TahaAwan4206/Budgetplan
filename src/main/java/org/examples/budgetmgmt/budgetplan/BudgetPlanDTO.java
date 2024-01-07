package org.examples.budgetmgmt.budgetplan;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BudgetPlanDTO {
  BigDecimal budgetAmount;
  private int categoryId;
  private LocalDate startDate;
  private LocalDate endDate;
  public BudgetPlanDTO(Integer categoryId, BigDecimal budgetAmount, LocalDate startDate, LocalDate endDate) {
    this.categoryId = categoryId;
    this.budgetAmount = budgetAmount;
    this.startDate = startDate;
    this.endDate = endDate;
  }


  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public BigDecimal getBudgetAmount() {
    return budgetAmount;
  }

  public void setBudgetAmount(BigDecimal budgetAmount) {
    this.budgetAmount = budgetAmount;
  }

}
