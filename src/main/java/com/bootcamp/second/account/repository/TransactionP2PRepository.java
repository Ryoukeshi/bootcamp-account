package com.bootcamp.second.account.repository;

import com.bootcamp.second.account.model.TransactionP2P;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionP2PRepository extends ReactiveMongoRepository<TransactionP2P, String> {

}
