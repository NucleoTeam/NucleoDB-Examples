package com.nucleodb.test.domain.connections;

import com.nucleodb.library.database.tables.annotation.Conn;
import com.nucleodb.library.database.tables.connection.Connection;
import com.nucleodb.test.domain.definitions.AnimeDE;
import com.nucleodb.test.domain.definitions.UserDE;

import java.util.Map;

@Conn("WATCHING")
public class WatchingConnection extends Connection<AnimeDE, UserDE>{
  public WatchingConnection() {
  }

  public WatchingConnection(UserDE from, AnimeDE to) {
    super(from, to);
  }

  public WatchingConnection(UserDE from, AnimeDE to, Map<String, String> metadata) {
    super(from, to, metadata);
  }
}
