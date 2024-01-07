package org.examples.budgetmgmt.expense;

import org.examples.budgetmgmt.expensecategory.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

  @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.category = :category and e.paidDate >= :startDate and e.paidDate <= :endDate")
  public Integer sumExpenses(ExpenseCategory category, LocalDate startDate, LocalDate endDate);
}
