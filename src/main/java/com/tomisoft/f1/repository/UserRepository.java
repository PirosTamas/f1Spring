package com.tomisoft.f1.repository;

import com.tomisoft.f1.enity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);


    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.dailyVote = false WHERE u.id = ?1")
    void changeDailyVote(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.dailyVote = true WHERE u.username NOT LIKE 'admin'")
    void clearVote();
}
