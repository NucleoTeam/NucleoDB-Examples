package com.nucleodb.test.repo;

import com.nucleodb.spring.types.NDBDataRepository;
import com.nucleodb.test.domain.definitions.UserDE;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDataRepository extends NDBDataRepository<UserDE, String>{
  void deleteByTableName();
  void getDistinctBy();
  Optional<UserDE> getByName(String name);
  void findByKeyNot(String h, String g);
}
