package com.INGRES.INGRES.Repository;

import com.INGRES.INGRES.DTOs.OutputRequestTemp;
import com.INGRES.INGRES.DTOs.OutputResponseTemp;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngresMongoDb extends MongoRepository<OutputRequestTemp, ObjectId> {

    OutputRequestTemp findById(String s);
}
