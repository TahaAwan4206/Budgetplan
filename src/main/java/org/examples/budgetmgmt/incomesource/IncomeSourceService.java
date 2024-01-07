package org.examples.budgetmgmt.incomesource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeSourceService {

  private final IncomeSourceRepository incomeSourceRepository;

  @Autowired
  public IncomeSourceService(IncomeSourceRepository incomeSourceRepository) {
    this.incomeSourceRepository = incomeSourceRepository;
  }

  public List<IncomeSource> findAll() {
    return incomeSourceRepository.findAll();
  }

  public IncomeSource findById(Long id) {
    return incomeSourceRepository.findById(id).orElse(null);
  }

  public IncomeSource save(IncomeSource incomeSource) {
    return incomeSourceRepository.save(incomeSource);
  }

  public void deleteById(Long id) {
    incomeSourceRepository.deleteById(id);
  }

  // Additional methods as needed
}

