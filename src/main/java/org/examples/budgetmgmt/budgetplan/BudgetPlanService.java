package org.examples.budgetmgmt.budgetplan;
import org.examples.budgetmgmt.expensecategory.ExpenseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetPlanService {

  private final BudgetPlanRepository budgetPlanRepository;
  private final ExpenseCategoryRepository expenseCategoryRepository;

  @Autowired
  public BudgetPlanService(BudgetPlanRepository budgetPlanRepository, ExpenseCategoryRepository expenseCategoryRepository) {
    this.budgetPlanRepository = budgetPlanRepository;
    this.expenseCategoryRepository = expenseCategoryRepository;
  }

  public BudgetPlan save(BudgetPlan budgetPlan) {
    return budgetPlanRepository.save(budgetPlan);
  }

  public BudgetPlanDTO convertToDto(BudgetPlan budgetPlan) {
    return new BudgetPlanDTO(
        budgetPlan.getCategory().getId(),
        budgetPlan.getBudgetAmount(),
        budgetPlan.getStartDate(),
        budgetPlan.getEndDate());
  }

  public BudgetPlan convertToEntity(BudgetPlanDTO budgetPlanDTO) {
    BudgetPlan budgetPlan = new BudgetPlan();
    budgetPlan.setCategory(expenseCategoryRepository.findById(budgetPlanDTO.getCategoryId()).orElse(null));
    budgetPlan.setBudgetAmount(budgetPlanDTO.getBudgetAmount());
    budgetPlan.setStartDate(budgetPlanDTO.getStartDate());
    budgetPlan.setEndDate(budgetPlanDTO.getEndDate());
    return budgetPlan;
  }

  public BudgetPlan findById(Long id) {
    return budgetPlanRepository.findById(id).orElse(null);
  }


  // Other service methods
}
