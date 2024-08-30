package com.hemant;


import com.hemant.exceptions.BusException;
import com.hemant.model.Bus;
import com.hemant.model.Route;
import com.hemant.repository.BusRepo;
import com.hemant.repository.RouteRepo;
import com.hemant.service.BusServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class BusServiceTest {

    @Mock
    private BusRepo busRepo;

    @Mock
    private RouteRepo routeRepo;

    @InjectMocks
    private BusServiceImpl busService;


//    The MockitoAnnotations.openMocks(this); statement initializes mocks annotated with @Mock, @Spy,
//    @InjectMocks, and other Mockito annotations in the test class. This ensures that Mockito handles
//    the creation and injection of mock objects into your service or class under test.
    // in JUnit 5
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void AddBusTest() throws BusException {

        Route route=new Route();
        route.setRouteFrom("Dhanbad");
        route.setRouteTo("Ranchi");

        Bus bus = new Bus();
        bus.setRouteFrom("Dhanbad");
        bus.setRouteTo("Ranchi");

        when(routeRepo.findByRouteFromAndRouteTo("Dhanbad","Ranchi")).thenReturn(route);
        when(busRepo.save(any(Bus.class))).thenReturn(bus);

        Bus bus1 = busService.addBus(bus);

        assertEquals("Dhanbad", bus1.getRouteFrom());
        assertEquals("Ranchi",bus1.getRouteTo());




    }
}
