package org.examples.budgetmgmt.budgetplan;

import org.examples.budgetmgmt.expensecategory.ExpenseCategory;
import org.examples.budgetmgmt.expensecategory.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/api/budget-plans")
public class BudgetPlanController {

  private final BudgetPlanService budgetPlanService;
  private final ExpenseCategoryService expenseCategoryService;

  @Autowired
  public BudgetPlanController(BudgetPlanService budgetPlanService, ExpenseCategoryService expenseCategoryService) {
    this.budgetPlanService = budgetPlanService;
    this.expenseCategoryService = expenseCategoryService;
  }

  @PostMapping
  public ResponseEntity<BudgetPlan> createBudgetPlan(@RequestBody BudgetPlanDTO budgetPlanDTO) throws Exception {
    BudgetPlan budgetPlan = new BudgetPlan();
    budgetPlan.setBudgetAmount(budgetPlanDTO.getBudgetAmount());
    budgetPlan.setStartDate(budgetPlanDTO.getStartDate());
    budgetPlan.setEndDate(budgetPlanDTO.getEndDate());
    Optional<ExpenseCategory> BudgetCategory = expenseCategoryService.findById(budgetPlanDTO.getCategoryId());
    if (BudgetCategory.isPresent()) {
      budgetPlan.setCategory(BudgetCategory.get());
      return ResponseEntity.ok(budgetPlanService.save(budgetPlan));
    }
    else {
      System.out.println("Not a valid category!");
      throw new Exception("Category not found");
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<BudgetPlan> updateBudgetPlan(@PathVariable Long id) {
    BudgetPlan budgetPlan = budgetPlanService.findById(id);
    if (budgetPlan != null) {
      return ResponseEntity.ok(budgetPlan);
    } else {
      return ResponseEntity.notFound().build();
    }
  }


  @GetMapping("/{id}")
  public ResponseEntity<BudgetPlan> getBudgetPlanById(@PathVariable Long id) {
    BudgetPlan budgetPlan = budgetPlanService.findById(id);
    if (budgetPlan != null) {
      return ResponseEntity.ok(budgetPlan);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // Other CRUD methods
}
