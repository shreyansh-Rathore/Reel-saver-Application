package com.savereel.reelsaver.Repository;

import com.savereel.reelsaver.Entity.Reel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReelsRepository extends JpaRepository<Reel, Long> {
}
