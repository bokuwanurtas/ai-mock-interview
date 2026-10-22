package com.aimockinterview.backend.controller;
import com.aimockinterview.backend.dto.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
@RestController @RequestMapping("/api/interviews")
@CrossOrigin(origins="http://localhost:5173")
public class InterviewController {
 private final JdbcTemplate db;
 public InterviewController(JdbcTemplate db) { this.db=db; }
 @PostMapping public Map<String,Object> create(@Valid @RequestBody InterviewRequest req) {
  if (!List.of("Intern","Junior","Middle","Senior").contains(req.level()) || !List.of("text","voice").contains(req.mode()))
   throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid level or mode");
  UUID id=UUID.randomUUID();
  db.update("INSERT INTO interviews(id,user_id,company_id,specialization_id,level,mode) VALUES (?,?,?,?,?,?)",
   id,req.userId(),req.companyId(),req.specializationId(),req.level(),req.mode());
  return Map.of("id",id,"status","in_progress");
 }
 @GetMapping("/{id}/messages") public List<Map<String,Object>> messages(@PathVariable UUID id) {
  return db.queryForList("SELECT id,role,content,sequence_number,created_at FROM interview_messages WHERE interview_id=? ORDER BY sequence_number",id);
 }
 @PostMapping("/{id}/messages") public Map<String,Object> addMessage(@PathVariable UUID id,@Valid @RequestBody MessageRequest req) {
  if (!List.of("assistant","user").contains(req.role())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid role");
  UUID messageId=UUID.randomUUID();
  int rows=db.update("INSERT INTO interview_messages (id,interview_id,role,content,sequence_number) SELECT ?, ?, ?, ?, COALESCE(MAX(sequence_number),0)+1 FROM interview_messages WHERE interview_id=?",
    messageId,id,req.role(),req.content(),id);
  return Map.of("id",messageId,"saved",rows==1);
 }
 @PatchMapping("/{id}/complete") public Map<String,String> complete(@PathVariable UUID id) {
  int changed=db.update("UPDATE interviews SET status='completed', completed_at=CURRENT_TIMESTAMP WHERE id=? AND status='in_progress'",id);
  if(changed==0) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Active interview not found");
  return Map.of("status","completed");
 }
}
