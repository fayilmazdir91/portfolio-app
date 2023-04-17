package com.project.portfolioapp.service;

import com.project.portfolioapp.entity.Technology;
import com.project.portfolioapp.exception.ResourceAlreadyExistsException;
import com.project.portfolioapp.exception.ResourceNotFoundException;
import com.project.portfolioapp.repository.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnologyService {

    private final TechnologyRepository technologyRepository;

    public Technology createTechnology(Technology technology) throws ResourceAlreadyExistsException {

        if(technologyRepository.findByName(technology.getName()) != null) {
            throw new ResourceAlreadyExistsException("Technology with name " + technology.getName() + " already exists!");
        }
        return technologyRepository.save(technology);
    }

    public Technology getTechnology(Long id) throws ResourceNotFoundException {
        return technologyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Technology with " + id + " not found!"));
    }

    public List<Technology> getAllTechnologies() {
        return technologyRepository.findAll();
    }

    public Technology updateTechnology(Technology technology) throws ResourceNotFoundException {
        getTechnology(technology.getId());
        return technologyRepository.save(technology);
    }

}
