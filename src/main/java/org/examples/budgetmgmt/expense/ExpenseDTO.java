package org.examples.budgetmgmt.expense;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseDTO {
  private int categoryId;
  private BigDecimal amount;
  private LocalDate paidDate;

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public LocalDate getPaidDate() {
    return paidDate;
  }

  public void setPaidDate(LocalDate paidDate) {
    this.paidDate = paidDate;
  }
}
