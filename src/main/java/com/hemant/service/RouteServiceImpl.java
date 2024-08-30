package com.hemant.service;

import com.hemant.exceptions.RouteException;
import com.hemant.model.Route;
import com.hemant.repository.RouteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService{

    @Autowired
    private RouteRepo routeRepo;

    @Override
    public Route addRoute(Route route) throws RouteException {
        Route route1 = routeRepo.save(route);
        if (route1 != null){
            return route1;
        }
    else {
        throw new RouteException("Route not added due to technical error");
    }
    }

    @Override
    public Route updateRoute(Route route) throws RouteException {

        Route route1 = new Route();
        Optional<Route> optional = routeRepo.findById(route.getRouteId());
        if (optional.isPresent()) {
           route1.setRouteId(route.getRouteId());
           route1.setRouteFrom(route.getRouteFrom());
           route1.setRouteTo(route.getRouteTo());
           route1.setDistance(route.getDistance());
            return routeRepo.save(route1);
        }   else {
        throw new RouteException(" Route not found");
    }

    }

    @Override
    public Route deleteRoute(int routeId) throws RouteException {
        Optional<Route> optional = routeRepo.findById(routeId);
        if (optional.isPresent()){
            routeRepo.deleteById(routeId);
            return optional.get();
        } else {
            throw new RouteException(" Route not found for id " + routeId);
        }
    }

    @Override
    public Route viewRoute(int routeId) throws RouteException {
        Optional<Route> optional = routeRepo.findById(routeId);
        if (optional.isPresent()){
            return optional.get();
        } else {
            throw new RouteException(" Route not found for id " + routeId);
        }

    }

    @Override
    public List<Route> viewAllRoute() throws RouteException {
        List<Route> routes = routeRepo.findAll();
        if (routes!=null){
            return routes;
        } else{
            throw new RouteException("Route not found");
        }

    }
}
