package com.aimockinterview.backend.controller;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api/questions")
@CrossOrigin(origins="http://localhost:5173")
public class QuestionController {
 private final JdbcTemplate db;
 public QuestionController(JdbcTemplate db){this.db=db;}
 @GetMapping public List<Map<String,Object>> find(
 @RequestParam(required=false) Integer companyId,
 @RequestParam Integer specializationId, @RequestParam String level) {
  return db.queryForList("SELECT id,company_id,specialization_id,technology_id,level,question_text FROM questions WHERE is_approved=true AND specialization_id=? AND level=? AND (company_id=? OR company_id IS NULL) ORDER BY CASE WHEN company_id=? THEN 0 ELSE 1 END,created_at DESC LIMIT 20",
   specializationId,level,companyId,companyId);
 }
}
