package com.example.repository;

import com.example.entity.ImageData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StorageRepository extends MongoRepository<ImageData,String> {

    Optional<ImageData> findByName(String fileName);
}
