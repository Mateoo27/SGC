package com.sgc.cobros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/cobro")
public class CobroController {

    @Autowired
    private CobroService cobroService;

    @GetMapping("/all")
    public ResponseEntity<List<Cobro>> findAll() {
        List<Cobro> cobros = cobroService.findAll();
        return ResponseEntity.ok(cobros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cobro> findById(@PathVariable Long id) {
        Cobro cobro = cobroService.findById(id);
        return ResponseEntity.ok().body(cobro);
    }
    
    @PostMapping
    public Cobro insertCobro(@RequestBody Cobro cobro) {
        return cobroService.insert(cobro);
    }

    @PutMapping("/{id}")
    public Cobro updateCobro(@PathVariable Long id, @RequestBody Cobro cobroDetails) {
        @SuppressWarnings("unused")
        Cobro updateCobro = cobroService.findById(id);
        return cobroService.update(id, cobroDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cobro> deleteCobro(@PathVariable("id") Long id) {
        cobroService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public Cobro update(@PathVariable Long id, @RequestBody Cobro cobroDetails) {
        
        return cobroService.update(id, cobroDetails);
    }
}
