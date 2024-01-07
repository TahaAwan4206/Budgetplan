package org.examples.budgetmgmt.expense;


import org.examples.budgetmgmt.budgetplan.BudgetAnalysisService;
import org.examples.budgetmgmt.expensecategory.ExpenseCategory;
import org.examples.budgetmgmt.expensecategory.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

  private final ExpenseService expenseService;

  private final ExpenseCategoryService expenseCategoryService;

  private final BudgetAnalysisService budgetAnalysisService;

  @Autowired
  public ExpenseController(ExpenseService expenseService,
                           ExpenseCategoryService expenseCategoryService,
                           BudgetAnalysisService budgetAnalysisService) {
    this.expenseService = expenseService;
    this.expenseCategoryService = expenseCategoryService;
    this.budgetAnalysisService = budgetAnalysisService;
  }

  @GetMapping
  public ResponseEntity<List<Expense>> getAllExpenses() {
    return ResponseEntity.ok(expenseService.findAll());
  }

  @GetMapping("/analysis")
  public ResponseEntity<String> checkBudgetPlans() {
    budgetAnalysisService.checkBudgetPlans();
    return ResponseEntity.ok("ok");
  }

  @GetMapping("/{id}")
  public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
    Expense expense = expenseService.findById(id);
    if (expense != null) {
      return ResponseEntity.ok(expense);
    } else {
      return ResponseEntity.notFound().build();
    }
  }


  @PostMapping
  public ResponseEntity<ExpenseDTO> createExpense(@RequestBody ExpenseDTO expenseDto) throws Exception {
    Optional<ExpenseCategory> expenseCategory = expenseCategoryService.findById(expenseDto.getCategoryId());
    if (expenseCategory.isPresent()) {
      Expense expense = expenseService.convertToEntity(expenseDto, expenseCategory.get());
      Expense savedExpense = expenseService.save(expense);
      ExpenseDTO savedExpenseDTO = expenseService.convertToDto(savedExpense);
      return new ResponseEntity<>(savedExpenseDTO, HttpStatus.CREATED);
    } else {
      throw new Exception("Category not found");
    }
  }


  @PutMapping("/{id}")
  public ResponseEntity<Expense> updateExpense(@PathVariable Long id) {
    Expense expense = expenseService.findById(id);
    if (expense != null) {
      // Update the fields of the existing expense
      // ...
      return ResponseEntity.ok(expenseService.save(expense));
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
    expenseService.deleteById(id);
    return ResponseEntity.ok().build();
  }

  // Additional endpoints as needed
}
