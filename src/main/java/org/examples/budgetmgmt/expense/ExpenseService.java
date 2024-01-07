package org.examples.budgetmgmt.expense;


import org.examples.budgetmgmt.expensecategory.ExpenseCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

  private final ExpenseRepository expenseRepository;

  @Autowired
  public ExpenseService(ExpenseRepository expenseRepository) {
    this.expenseRepository = expenseRepository;
  }

  public List<Expense> findAll() {
    return expenseRepository.findAll();
  }

  public Expense findById(Long id) {
    return expenseRepository.findById(id).orElse(null);
  }

  public Expense save(Expense expense) {
    return expenseRepository.save(expense);
  }

  public void deleteById(Long id) {
    expenseRepository.deleteById(id);
  }

  public Expense convertToEntity(ExpenseDTO expenseDTO, ExpenseCategory category) {
    Expense expense = new Expense();
    expense.setCategory(category);
    expense.setAmount(expenseDTO.getAmount());
    expense.setPaidDate(expenseDTO.getPaidDate());
    return expense;
  }

  public ExpenseDTO convertToDto(Expense expense) {
    ExpenseDTO expenseDTO = new ExpenseDTO();
    expenseDTO.setCategoryId(expense.getCategory().getId());
    expenseDTO.setAmount(expense.getAmount());
    expenseDTO.setPaidDate(expense.getPaidDate());
    return expenseDTO;
  }
}

