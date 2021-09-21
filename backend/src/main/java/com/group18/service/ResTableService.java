package com.group18.service;

import com.group18.entities.Booking;
import com.group18.entities.ResTable;
import com.group18.repository.ResTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResTableService {
    @Autowired
    ResTableRepository repository;

    public ResTable getTable(Integer tableNumber) {
        Optional<ResTable> resTable = repository.findById(tableNumber);
        if (resTable.isPresent()) {
            return resTable.get();
        } else {
            return null;
        }
    }

    public List<ResTable> getAvailableTables() {
        List<ResTable> resTable = repository.findAllByIsReserved(false);
        return resTable;
    }

    public ResTable reserveTables(ResTable table, Integer booking) {
        table.setReserved(true);
        table.setBookingNumber(booking);
        repository.save(table);
        return table;
    }

    public List<ResTable> resetTables() {
        List<ResTable> tablesReserved = repository.findAllByIsReserved(true);
        for (ResTable table : tablesReserved) {
            table.setReserved(false);
        }
        repository.saveAll(tablesReserved);
        return tablesReserved;
    }

//    public boolean canCombine(Integer tableCount) {
//        List<ResTable> resTables = repository.findAllByIsReserved(false);
//
//    }

    public void createTable(ResTable resTable) { repository.save(resTable); }
}
