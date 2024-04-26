package com.example.repository;

import com.example.entity.FileData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FileDataRepository extends MongoRepository<FileData,String> {
    Optional<FileData> findByName(String fileName);
}
