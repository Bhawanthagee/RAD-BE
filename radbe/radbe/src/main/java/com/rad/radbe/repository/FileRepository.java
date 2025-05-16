package com.rad.radbe.repository;

import com.rad.radbe.entity.FileEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Integer> {
    @Modifying
    @Transactional
    @Query(value = """
                UPDATE files
                SET status = :status
                WHERE id = :id
            """,nativeQuery = true)
    void verify(String status,Integer id);
}
