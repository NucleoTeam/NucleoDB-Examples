package com.nucleodb.test.repo;

import com.nucleodb.spring.types.NDBDataRepository;
import com.nucleodb.test.domain.definitions.AnimeDE;
import com.nucleodb.test.domain.tables.Anime;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AnimeDataRepository extends NDBDataRepository<AnimeDE, String>{
  Set<AnimeDE> findByNameAndKey(String name, String key);
  Anime findByName(String name);
  void deleteByName(String name);
}
