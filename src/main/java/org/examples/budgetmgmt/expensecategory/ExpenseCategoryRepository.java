package org.examples.budgetmgmt.expensecategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, Integer> {

}
