package com.tomisoft.f1.repository;

import com.tomisoft.f1.document.Driver;
import com.tomisoft.f1.document.Teams;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface DriverRepository extends ReactiveMongoRepository<Driver, String> {
}
