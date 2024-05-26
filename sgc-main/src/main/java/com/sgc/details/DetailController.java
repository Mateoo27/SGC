package com.sgc.details;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class DetailController {
    
    @Autowired
    private DetailService detailService;

    @GetMapping("/all")
    public ResponseEntity<List<Detail>> findAll() {
        List<Detail> details = detailService.findAll();
        return ResponseEntity.ok(details);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detail> findById(@PathVariable Long id) {
        Detail detail = detailService.findById(id);
        return ResponseEntity.ok().body(detail);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/client/{id}")
    public List<Detail> findByClientId(@PathVariable Long id) {
        List<Detail> details = (List<Detail>) detailService.findById(id);
        return (List<Detail>) ResponseEntity.ok(details);
    }

    @PostMapping
    public Detail insertDetail(@RequestBody Detail detail) {
        return detailService.insert(detail);
    }

    @PutMapping("/{id}")
    public Detail updateDetail(@PathVariable Long id, @RequestBody Detail detail) {
        @SuppressWarnings("unused")
        Detail updateDetail = detailService.findById(id);
        return detailService.update(id, detail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Detail> deleteDetail(@PathVariable("id") Long id) {
        detailService.delete(id);
        return ResponseEntity.ok().build();
    }
}
