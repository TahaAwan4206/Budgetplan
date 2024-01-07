package org.examples.budgetmgmt.expensecategory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseCategoryService {

  private final ExpenseCategoryRepository repository;

  @Autowired
  public ExpenseCategoryService(ExpenseCategoryRepository repository) {
    this.repository = repository;
  }

  public List<ExpenseCategory> findAll() {
    return repository.findAll();
  }

  public Optional<ExpenseCategory> findById(Integer id) {
    return repository.findById(id);
  }

  public ExpenseCategory save(ExpenseCategory expenseCategory) {
    return repository.save(expenseCategory);
  }

  public void deleteById(Integer id) {
    repository.deleteById(id);
  }

  // Additional methods as needed
}
