package com.nucleodb.test.repo;

import com.nucleodb.spring.types.NDBDataRepository;
import com.nucleodb.test.domain.definitions.AnimeDE;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AnimeDataRepository extends NDBDataRepository<AnimeDE, String>{
  Set<AnimeDE> findByName(String key);
}
