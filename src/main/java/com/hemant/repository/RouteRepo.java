package com.hemant.repository;

import com.hemant.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepo extends JpaRepository<Route,Integer> {

    public Route findByRouteFromAndRouteTo(String from,String to);
}
