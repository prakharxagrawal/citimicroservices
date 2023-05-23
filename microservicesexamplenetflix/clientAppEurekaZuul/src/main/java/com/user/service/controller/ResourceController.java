package com.user.service.controller;

import com.user.service.dto.ApplianceUserDto;
import com.user.service.feignservice.ResourceFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/appliance")
public class ResourceController {

    @Autowired
    private ResourceFeignService resourceFeignService;

    @GetMapping("/getById/{id}")
    public ApplianceUserDto getDetailsById(@PathVariable Integer id) {

        return resourceFeignService.getById(id);
    }

    @GetMapping("/getByName/{applianceName}")
    public List<ApplianceUserDto> getDetailsByName(@PathVariable String name) {

        return resourceFeignService.getByApplianceName(name);
    }

    @PostMapping("/saveOrUpdate")
    public ApplianceUserDto saveOrUpdate(@RequestBody ApplianceUserDto applianceEntityDTO) {

        return resourceFeignService.save(applianceEntityDTO);
    }

    @DeleteMapping("/deleteById/{id}")
    public Map<String, Boolean> deleteById(@PathVariable Integer id) {

        return resourceFeignService.deleteById(id);
    }

}





































