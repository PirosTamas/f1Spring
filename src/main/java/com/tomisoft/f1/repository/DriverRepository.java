package com.tomisoft.f1.repository;

import com.tomisoft.f1.enity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query("SELECT d FROM Driver  d WHERE d.id = ?1")
    Optional<Driver> findById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Driver d SET d.votes = d.votes + 1 WHERE d.id = ?1")
    void increaseVote(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Driver d SET d.votes = 0")
    void clearVote();



}
