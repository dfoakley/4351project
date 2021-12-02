package com.group18.service;

import com.group18.entities.ResTable;
import com.group18.repository.ResTableRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ResTableServiceTest {
    ResTable resTable;
    ResTable table;

    Integer tableNumber = 0;
    Integer maxGuests = 2;
    boolean isReserved = false;
    Integer bookingNumber = 1;

    @InjectMocks
    ResTableService resTableService;
    @Mock
    ResTableRepository resTableRepository;

    @Before
    public void init() { MockitoAnnotations.initMocks(this); }

    @Before
    public void InitEntity() {
        resTable = new ResTable(tableNumber, maxGuests, isReserved, bookingNumber);
        table = new ResTable(tableNumber, maxGuests, isReserved, bookingNumber);
    }

    @Test
    public void shouldGetTable() throws Exception {
         when(resTableRepository.findById(anyInt())).thenReturn(Optional.of(resTable));
         ResTable result = resTableService.getTable(tableNumber);
         assertEquals(tableNumber, result.getTableNumber());
    }

    @Test
    public void shouldGetAllTables() throws Exception {
        List<ResTable> listTables = new ArrayList<>();
        listTables.add(resTable);
        when(resTableRepository.findAll()).thenReturn(listTables);

        List<ResTable> result = resTableService.getAllTables();
        assertEquals(1, result.size());
    }

    @Test
    public void shouldGetAvailableTables() throws Exception {
        List<ResTable> listTables = new ArrayList<>();
        listTables.add(resTable);
        when(resTableRepository.findAllByIsReserved(false)).thenReturn(listTables);

        List<ResTable> result = resTableService.getAvailableTables();
        assertEquals(listTables, result);
    }

    @Test
    public void shouldReserveTable() throws Exception {
        table.setReserved(true);
        table.setBookingNumber(bookingNumber);

        when(resTableRepository.save(table)).thenReturn(null);
        ResTable result = resTableService.reserveTables(table, bookingNumber);
        assertNotEquals(resTable, result);
    }

    @Test
    public void shouldResetTables() throws Exception {
        Integer tableNumber = 0;
        Integer maxGuests = 2;
        boolean isReserved = true;
        Integer bookingNumber = 1;

        List<ResTable> listTables = new ArrayList<>();
        resTable = new ResTable(tableNumber, maxGuests, isReserved, bookingNumber);
        listTables.add(resTable);

        List<ResTable> oldlistTables = new ArrayList<>();
        table = new ResTable(tableNumber, maxGuests, isReserved, bookingNumber);
        oldlistTables.add(table);

        when(resTableRepository.findAllByIsReserved(true)).thenReturn(listTables);
        for (ResTable resTable : listTables) {
            resTable.setReserved(false);
        }
        when(resTableRepository.saveAll(listTables)).thenReturn(listTables);
        List<ResTable> result = resTableService.resetTables();
        assertNotEquals(oldlistTables, result);
    }

    @Test
    public void shouldDeleteAllResTables() throws Exception {
        Integer tableNumber = 0;
        Integer maxGuests = 2;
        boolean isReserved = true;
        Integer bookingNumber = 1;

        List<ResTable> listTables = new ArrayList<>();
        resTable = new ResTable(tableNumber, maxGuests, isReserved, bookingNumber);
        listTables.add(resTable);

        resTableService.deleteAllResTables();
        verify(resTableRepository).deleteAll();
    }
}
