package com.nucleodb.test.domain.definitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nucleodb.library.database.modifications.Create;
import com.nucleodb.library.database.tables.table.DataEntry;
import com.nucleodb.test.domain.tables.User;

public class UserDE extends DataEntry<User>{
  public UserDE(User obj) {
    super(obj);
  }

  public UserDE(Create create) throws ClassNotFoundException, JsonProcessingException {
    super(create);
  }

  public UserDE() {
  }

  public UserDE(String key) {
    super(key);
  }
}
