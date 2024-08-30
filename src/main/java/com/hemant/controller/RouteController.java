package com.hemant.controller;

import com.hemant.exceptions.RouteException;
import com.hemant.model.Route;
import com.hemant.service.RouteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;


    @GetMapping("/viewAll")
    public ResponseEntity<List<Route>> getAllRoutes()throws RouteException {

        return new ResponseEntity<List <Route>>(routeService.viewAllRoute(),HttpStatus.OK);
    }

    @GetMapping("/find/{routeId}")
    public ResponseEntity<Route> getRouteById(@PathVariable int routeId)throws RouteException{

        Route route = routeService.viewRoute(routeId);

        return new ResponseEntity<Route>(route,HttpStatus.OK);
    }


}
