package com.group18.repository;

import com.group18.entities.ResTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResTableRepository extends JpaRepository<ResTable, Integer> {
    public Optional<ResTable> findById(Integer tableNumber);
    public List<ResTable> findAll();
    public List<ResTable> findAllByIsReserved(boolean isReserved);
}
