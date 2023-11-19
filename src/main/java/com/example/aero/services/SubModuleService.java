package com.example.aero.services;

import com.example.aero.dto.SubModule;
import com.example.aero.repository.SubModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubModuleService {
    @Autowired
    SubModuleRepository subModuleRepository;

    public SubModule getSubModuleById(int id) {
        return subModuleRepository.findById(id).get();
    }

    public List<SubModule> getSubModuleByCategoryId(int cId) {
        return subModuleRepository.getSubModuleForCategory(cId);
    }

    public SubModule addSubModule(SubModule subModule) {
        return subModuleRepository.save(subModule);
    }
}
