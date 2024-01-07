package org.examples.budgetmgmt.expensecategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense-categories")
public class ExpenseCategoryController {

  private final ExpenseCategoryService service;

  @Autowired
  public ExpenseCategoryController(ExpenseCategoryService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<ExpenseCategory>> getAllCategories() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ExpenseCategory> getCategoryById(@PathVariable Integer id) {
    return service.findById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<ExpenseCategory> createCategory(@RequestBody ExpenseCategory category) {
    return ResponseEntity.ok(service.save(category));
  }

  // Additional endpoints as needed
}
