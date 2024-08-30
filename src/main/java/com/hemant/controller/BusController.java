package com.hemant.controller;

import com.hemant.dto.BusDTO;
import com.hemant.exceptions.BusException;
import com.hemant.model.Bus;
import com.hemant.service.BusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusService busService;


    @GetMapping("/{busType}")
    public ResponseEntity<List<Bus>> getBusesByType(@PathVariable("busType") String busType) throws BusException{

        List<Bus> listOfBuses=busService.viewBusByType(busType);

        return new ResponseEntity<List<Bus>>(listOfBuses,HttpStatus.OK);
    }

    @GetMapping("/buses")
    public ResponseEntity<List<Bus>> getAllBuses() throws BusException{

        List<Bus> listOfBuses=busService.viewAllBuses();

        return new ResponseEntity<List<Bus>>(listOfBuses,HttpStatus.OK);
    }

    @PostMapping("/BusByRoute")
    public ResponseEntity<List<Bus>> getAllBusesByRoute(@RequestBody BusDTO busDTO) throws BusException{

        List<Bus> bus = busService.getBusByRoute(busDTO.getRouteFrom(), busDTO.getRouteTo());

        return new ResponseEntity<List<Bus>>(bus,HttpStatus.OK);
    }
}
