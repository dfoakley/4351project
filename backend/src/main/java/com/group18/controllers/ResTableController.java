package com.group18.controllers;

import com.group18.entities.Booking;
import com.group18.entities.ResTable;
import com.group18.service.BookingService;
import com.group18.service.ResTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ResTable")
@CrossOrigin
public class ResTableController {
    @Autowired
    ResTableService resTableService;
    @Autowired
    BookingService bookingService;

    @GetMapping(value = "/{tableNumber}", produces = "application/json")
    public ResponseEntity<ResTable> getTable (
            @PathVariable("tableNumber") Integer tableNumber
    ) {
        ResTable resTable = resTableService.getTable(tableNumber);
        return new ResponseEntity<ResTable>(resTable, HttpStatus.OK);
    }

    @GetMapping(value = "/availableTables", produces = "application/json")
    public ResponseEntity<List<ResTable>> getAvailableTables () {
        List<ResTable> resTable = resTableService.getAvailableTables();
        return new ResponseEntity<List<ResTable>>(resTable, HttpStatus.OK);
    }

    @PutMapping(value = "/reserveTables", produces = "application/json")
    public ResponseEntity<ResTable> reserveTables (
            @RequestBody ResTable resTable,
            @RequestParam Integer bookingId
    ) {
        resTableService.reserveTables(resTable, bookingId);
        return new ResponseEntity<ResTable>(resTable, HttpStatus.OK);
    }

    @PutMapping(value = "/resetTables", produces = "application/json")
    public ResponseEntity<List<ResTable>> resetTables () {
        resTableService.resetTables();
        return new ResponseEntity<List<ResTable>>(HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<ResTable> createTable (
            @RequestBody ResTable resTable
    ) {
        resTableService.createTable(resTable);
        return new ResponseEntity<ResTable>(resTable, HttpStatus.CREATED);
    }
}
