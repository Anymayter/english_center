package com.toan.english_center.Repository;

import com.toan.english_center.Entity.TeachingContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachingContentRepository extends JpaRepository<TeachingContent, String> {
}