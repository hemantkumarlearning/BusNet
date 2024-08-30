package com.hemant.service;

import com.hemant.exceptions.BusException;
import com.hemant.model.Bus;

import java.util.List;

public interface BusService {

    public Bus addBus(Bus bus) throws BusException;
    public Bus updateBus(Bus bus) throws BusException;
    public Bus deleteBus(int busId) throws BusException;
    public Bus viewBus(int busId) throws BusException;
    public List<Bus> viewBusByType(String BusType) throws BusException;
    public List<Bus> viewAllBuses() throws BusException;
    public List<Bus> getBusByRoute(String routeFrom, String routeTo) throws BusException;
}
