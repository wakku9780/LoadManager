package com.example.loadmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class LoadService {

    @Autowired
    private LoadRepository loadRepository;

    public Load addLoad(Load load) {
        return loadRepository.save(load);
    }

    public List<Load> getLoadsByShipperId(UUID shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    public Load getLoadById(UUID loadId) {
        return loadRepository.findById(loadId).orElse(null);
    }

    public Load updateLoad(UUID loadId, Load loadDetails) {
        Load load = loadRepository.findById(loadId).orElse(null);
        if (load != null) {
            load.setLoadingPoint(loadDetails.getLoadingPoint());
            load.setUnloadingPoint(loadDetails.getUnloadingPoint());
            load.setProductType(loadDetails.getProductType());
            load.setTruckType(loadDetails.getTruckType());
            load.setNoOfTrucks(loadDetails.getNoOfTrucks());
            load.setWeight(loadDetails.getWeight());
            load.setComment(loadDetails.getComment());
            load.setDate(loadDetails.getDate());
            return loadRepository.save(load);
        }
        return null;
    }

    public void deleteLoad(UUID loadId) {
        loadRepository.deleteById(loadId);
    }
}
