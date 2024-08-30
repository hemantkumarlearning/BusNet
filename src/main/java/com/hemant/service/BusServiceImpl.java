package com.hemant.service;

import com.hemant.exceptions.BusException;
import com.hemant.model.Bus;
import com.hemant.model.Route;
import com.hemant.repository.BusRepo;
import com.hemant.repository.RouteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService{


    @Autowired
    private BusRepo busRepo;

    @Autowired
    private RouteRepo routeRepo;

    @Override
    public Bus addBus(Bus bus) throws BusException{

        Route route = routeRepo.findByRouteFromAndRouteTo(bus.getRouteFrom(), bus.getRouteTo());

        if (route!=null) {
          //  route.getBus().add(bus);
            bus.setRoute(route);
            return busRepo.save(bus);
        } else {
            throw new BusException("Bus not added due to technical error");
        }

    }

    @Override
    public Bus updateBus(Bus bus) throws BusException {

        Bus bus1 = new Bus();

        Optional<Bus> optional = busRepo.findById(bus.getBusId());
        if (optional.isPresent()){
            bus1.setBusId(bus.getBusId());
            bus1.setBusName(bus.getBusName());
            bus1.setRoute(bus.getRoute());
            bus1.setRouteFrom(bus.getRouteFrom());
            bus1.setRouteTo(bus.getRouteTo());
            bus1.setFarePerSeat(bus.getFarePerSeat());
            bus1.setBusType(bus.getBusType());
            bus1.setArrivalTime(bus.getArrivalTime());
            bus1.setDepartureTime(bus.getDepartureTime());
            bus1.setDriverName(bus.getDriverName());
            bus1.setAvailableSeats(bus.getAvailableSeats());
            bus1.setSeats(bus.getSeats());

            Route route = routeRepo.findByRouteFromAndRouteTo(bus.getRouteFrom(), bus.getRouteTo());
            if (route!=null) {
                bus1.setRoute(route);
            } else {
                throw new BusException("Invalid route!");
            }
            return busRepo.save(bus1);
        } else {
            throw new BusException(" Bus not found for id :: " + bus.getBusId());
        }

    }

    @Override
    public Bus deleteBus(int busId) throws BusException {
        Optional<Bus> optional = busRepo.findById(busId);
        if (optional.isPresent()){
            busRepo.deleteById(busId);
            return optional.get();
        } else {
            throw new BusException("Bus not found for id :: " + busId);
        }
    }

    @Override
    public Bus viewBus(int busId) throws BusException {
        Optional<Bus> optional = busRepo.findById(busId);
        if (optional.isPresent()){
            return optional.get();
        } else {
            throw new BusException("Bus not found for id :: " + busId);
        }
    }

    @Override
    public List<Bus> viewBusByType(String BusType) throws BusException{
        List<Bus> busList = busRepo.findByBusType(BusType);
        if (!busList.isEmpty()) {
            return busList;
        } else {
            throw new BusException("No buses found for type :: " + BusType);
        }
    }

    @Override
    public List<Bus> viewAllBuses() throws BusException{
        List<Bus> busList = busRepo.findAll();
        if (busList.size()>0) {
            return busList;
        } else {
            throw new BusException("No buses found");
        }
    }

    @Override
    public List<Bus> getBusByRoute(String routeFrom, String routeTo) throws BusException {
        List<Bus> bus = busRepo.getBusByRoute(routeFrom, routeTo);
        if (!bus.isEmpty()){
            return bus;
        } else {
            throw new BusException("No bus are available on this route");
        }
    }
}
