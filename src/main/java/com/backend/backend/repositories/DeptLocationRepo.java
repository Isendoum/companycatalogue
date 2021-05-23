package com.backend.backend.repositories;

import com.backend.backend.entities.DeptLocation;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DeptLocationRepo extends CrudRepository<DeptLocation,Integer> {

    List<DeptLocation> findAll();
}
