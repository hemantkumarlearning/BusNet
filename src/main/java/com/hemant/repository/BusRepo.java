package com.hemant.repository;

import com.hemant.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusRepo extends JpaRepository<Bus,Integer> {

    @Query("select b from Bus b where b.routeFrom =?1 and b.routeTo = ?2")
    public List<Bus> getBusByRoute(String routeFrom, String routeTo);

    public List<Bus> findByBusType(String busType);
}
