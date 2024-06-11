package com.CSC_340_PROJECT4.Project4.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantOwnerRepository extends JpaRepository<RestaurantOwner, Integer> {
    Optional<RestaurantOwner> findByUsername(String username);
}
