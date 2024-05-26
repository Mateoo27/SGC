package com.sgc.details;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sgc.ResourceNotFoundException;

public class DetailService {

    @Autowired
    private DetailRepository detailRepository;

    @Transactional(readOnly = true)
    public List<Detail> findAll() {
        return detailRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Detail findById(Long id) {
        return detailRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Detail not found"));
    }

    @Transactional
    public Detail insert(Detail detail) {
        return detailRepository.save(detail);
    }

    @Transactional
    public Detail update(Long id, Detail detail) {
        Detail existingDetail = detailRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Detail not found"));
        existingDetail.setDetailAmount(detail.getDetailType());
        existingDetail.setDetailAmount(detail.getDetailType());
        existingDetail.setDetailAmount(detail.getDetailType());
        existingDetail.setDetailDescription(detail.getDetailDescription());
        return detailRepository.save(existingDetail);
    }

    
    public void delete(Long id) {
        if (!detailRepository.existsById(id)) {
            throw new ResourceNotFoundException("Detail not found");
        }
        detailRepository.deleteById(id);
    }

}
