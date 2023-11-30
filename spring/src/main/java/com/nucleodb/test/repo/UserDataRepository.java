package com.nucleodb.test.repo;

import com.nucleodb.spring.types.NDBDataRepository;
import com.nucleodb.test.domain.definitions.UserDE;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends NDBDataRepository<UserDE, String>{
}
