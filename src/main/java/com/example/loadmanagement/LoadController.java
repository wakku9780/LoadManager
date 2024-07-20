package com.example.loadmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadService loadService;

    @PostMapping
    public String addLoad(@RequestBody Load load) {
        loadService.addLoad(load);
        return "Load details added successfully";
    }

    @GetMapping
    public List<Load> getLoadsByShipperId(@RequestParam UUID shipperId) {
        return loadService.getLoadsByShipperId(shipperId);
    }

    @GetMapping("/{loadId}")
    public Load getLoadById(@PathVariable UUID loadId) {
        return loadService.getLoadById(loadId);
    }

    @PutMapping("/{loadId}")
    public Load updateLoad(@PathVariable UUID loadId, @RequestBody Load load) {
        return loadService.updateLoad(loadId, load);
    }

    @DeleteMapping("/{loadId}")
    public void deleteLoad(@PathVariable UUID loadId) {
        loadService.deleteLoad(loadId);
    }
}
