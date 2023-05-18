package com.shoppingmallserver.Image;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDataRepository extends JpaRepository<FileDataEntity, Long> {

    Optional<FileDataEntity> findByName(String fileName);
}