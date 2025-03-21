package com.toan.english_center.Repository;

import com.toan.english_center.Entity.TeachingContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeachingContentRepository extends JpaRepository<TeachingContent, String> {
//    List<TeachingContent> findAll();
//    TeachingContent findByTcId(String tcId);
//    TeachingContent save(TeachingContent teacher);
//    void deleteByTcId(String tcId);
//    Optional<TeachingContent> findById(String tcId);
}
