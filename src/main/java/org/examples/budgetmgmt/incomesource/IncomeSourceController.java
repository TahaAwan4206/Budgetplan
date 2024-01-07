package org.examples.budgetmgmt.incomesource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income-sources")
public class IncomeSourceController {

  private final IncomeSourceService incomeSourceService;

  @Autowired
  public IncomeSourceController(IncomeSourceService incomeSourceService) {
    this.incomeSourceService = incomeSourceService;
  }

  @GetMapping
  public ResponseEntity<List<IncomeSource>> getAllIncomeSources() {
    return ResponseEntity.ok(incomeSourceService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<IncomeSource> getIncomeSourceById(@PathVariable Long id) {
    IncomeSource incomeSource = incomeSourceService.findById(id);
    if (incomeSource != null) {
      return ResponseEntity.ok(incomeSource);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<IncomeSource> createIncomeSource(@RequestBody IncomeSource incomeSource) {
    return ResponseEntity.ok(incomeSourceService.save(incomeSource));
  }

  @PutMapping("/{id}")
  public ResponseEntity<IncomeSource> updateIncomeSource(@PathVariable Long id, @RequestBody IncomeSource incomeSourceDetails) {
    IncomeSource incomeSource = incomeSourceService.findById(id);
    if (incomeSource != null) {
      // Update the fields of the existing income source
      // ...
      return ResponseEntity.ok(incomeSourceService.save(incomeSource));
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteIncomeSource(@PathVariable Long id) {
    incomeSourceService.deleteById(id);
    return ResponseEntity.ok().build();
  }

  // Additional endpoints as needed
}

