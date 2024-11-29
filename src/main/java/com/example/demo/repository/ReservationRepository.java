package com.example.demo.repository;

import com.example.demo.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByUserIdAndStatus(Long userId, String status);

    @Query(name = "Reservation.FIND_ALL_BY_USER_ID")
    List<Reservation> findByUserId(Long userId);
}
