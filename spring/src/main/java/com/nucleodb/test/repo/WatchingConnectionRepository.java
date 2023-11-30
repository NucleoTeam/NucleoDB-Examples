package com.nucleodb.test.repo;

import com.nucleodb.spring.types.NDBConnRepository;
import com.nucleodb.test.domain.definitions.AnimeDE;
import com.nucleodb.test.domain.definitions.UserDE;
import com.nucleodb.test.domain.connections.WatchingConnection;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchingConnectionRepository extends NDBConnRepository<WatchingConnection, String, AnimeDE, UserDE>{
}
