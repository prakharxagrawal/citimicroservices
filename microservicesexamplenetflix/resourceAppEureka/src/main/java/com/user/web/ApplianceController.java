package com.user.web;

import com.user.model.ApplianceEntityDTO;
import com.user.service.ApplicanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/appliance")
public class ApplianceController {

    @Autowired
    private ApplicanceService applicanceService;

    @GetMapping("/getById/{id}")
    public ApplianceEntityDTO getDetailsById(@PathVariable Integer id) {

        return applicanceService.getById(id);
    }

    @GetMapping("/getByName/{applianceName}")
    public List<ApplianceEntityDTO> getDetailsByName(@PathVariable String name) {

        return applicanceService.getByApplianceName(name);
    }

    @PostMapping("/saveOrUpdate")
    public ApplianceEntityDTO saveOrUpdate(@RequestBody ApplianceEntityDTO applianceEntityDTO) {

        return applicanceService.save(applianceEntityDTO);
    }

    @DeleteMapping("/deleteById/{id}")
    public Map<String, Boolean> deleteById(@PathVariable Integer id) {

        return applicanceService.deleteById(id);
    }

}





































