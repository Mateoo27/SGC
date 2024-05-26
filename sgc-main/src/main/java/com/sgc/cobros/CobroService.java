package com.sgc.cobros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgc.ResourceNotFoundException;

import java.util.List;

@Service
public class CobroService {

    @Autowired
    private CobroRepository cobroRepository;

    @Transactional(readOnly = true)
    public List<Cobro> findAll() {
        return cobroRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cobro findById(Long id) {
        return cobroRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Cobro not found"));
    }

    @Transactional
    public Cobro insert(Cobro cobro) {
        return cobroRepository.save(cobro);
    }

    @Transactional
    public Cobro update(Long id, Cobro cobroDetails) {
        Cobro existingCobro = cobroRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Cobro not found"));
               existingCobro.setCobroAmount(cobroDetails.getCobroAmount());


               return cobroRepository.save(existingCobro);
    }

    public void delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
