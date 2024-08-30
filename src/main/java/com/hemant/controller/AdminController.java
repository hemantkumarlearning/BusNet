package com.hemant.controller;

import com.hemant.exceptions.BusException;
import com.hemant.exceptions.RouteException;
import com.hemant.model.Bus;
import com.hemant.model.Route;
import com.hemant.service.BusService;
import com.hemant.service.RouteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private BusService busService;

    @PostMapping("/saveRoute")
    public ResponseEntity<Route> saveRoute(@RequestBody Route route) throws RouteException {
        Route route1 = routeService.addRoute(route);
        return new ResponseEntity<>(route1, HttpStatus.CREATED);
    }

    @PutMapping("/updateRoute/")
    public ResponseEntity<Route> updateRouteById(@Valid @RequestBody Route route) throws RouteException {

        return new ResponseEntity<Route>(routeService.updateRoute(route),HttpStatus.OK);
    }

    @DeleteMapping("/deleteRoute/{routeId}")
    public ResponseEntity<Route> deleteRouteById(@PathVariable int routeId) throws RouteException {

        return new ResponseEntity<Route>(routeService.deleteRoute(routeId),HttpStatus.OK);
    }



    @PostMapping("/saveBus")
    public ResponseEntity<Bus> saveBus(@RequestBody Bus bus) throws BusException {
        Bus bus1 = busService.addBus(bus);
        return new ResponseEntity<>(bus1, HttpStatus.CREATED);
    }

    @PutMapping("/updateBus")
    public ResponseEntity<Bus> updateBusById(@Valid @RequestBody Bus bus) throws BusException {

        return new ResponseEntity<Bus>(busService.updateBus(bus),HttpStatus.OK);
    }

    @DeleteMapping("/deleteBus/{busId}")
    public ResponseEntity<Bus> deleteBus(@PathVariable int busId)throws BusException {

        return new ResponseEntity<Bus>(busService.deleteBus(busId),HttpStatus.OK);
    }
}
