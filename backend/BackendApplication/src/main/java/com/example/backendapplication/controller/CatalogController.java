package com.aimockinterview.backend.controller;
import com.aimockinterview.backend.repository.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController @RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class CatalogController {
 private final CompanyRepository companies;
 private final SpecializationRepository specializations;
 private final TechnologyRepository technologies;
 public CatalogController(CompanyRepository companies, SpecializationRepository specializations, TechnologyRepository technologies) {
  this.companies=companies; this.specializations=specializations; this.technologies=technologies;
 }
 @GetMapping("/companies") public List<Map<String,Object>> companies(){
  return companies.findAll().stream().map(x->Map.<String,Object>of("id",x.getId(),"name",x.getName())).toList();
 }
 @GetMapping("/specializations") public List<Map<String,Object>> specializations(){
  return specializations.findAll().stream().map(x->Map.<String,Object>of("id",x.getId(),"name",x.getName())).toList();
 }
 @GetMapping("/technologies") public List<Map<String,Object>> technologies(){
  return technologies.findAll().stream().map(x->Map.<String,Object>of("id",x.getId(),"name",x.getName())).toList();
 }
}
