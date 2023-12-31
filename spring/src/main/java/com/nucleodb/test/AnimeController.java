package com.nucleodb.test;

import com.nucleodb.library.database.utils.Serializer;
import com.nucleodb.spring.events.DataEntryCreatedEvent;
import com.nucleodb.spring.events.DataEntryDeletedEvent;
import com.nucleodb.test.domain.tables.Anime;
import com.nucleodb.test.domain.definitions.AnimeDE;
import com.nucleodb.test.domain.tables.User;
import com.nucleodb.test.domain.definitions.UserDE;
import com.nucleodb.test.domain.connections.WatchingConnection;
import com.nucleodb.test.repo.AnimeDataRepository;
import com.nucleodb.test.repo.UserDataRepository;
import com.nucleodb.test.repo.WatchingConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class AnimeController{
  @Autowired
  AnimeDataRepository animeRepository;
  @Autowired
  WatchingConnectionRepository watchingConnectionRepository;
  @Autowired
  UserDataRepository userRepository;

  @GetMapping("/")
  public List<AnimeDE> test(){
    return animeRepository.findAll();
  }

  @GetMapping("/save/{name}")
  public AnimeDE saveTest(@PathVariable String name){
    return animeRepository.save(new AnimeDE(new Anime(name, 2.00f)));
  }

  @GetMapping("/user/delete/{name}")
  public void deleteUserTest(@PathVariable String name){
    UserDE byName = userRepository.getByName(name);
    if(byName!=null){
      userRepository.delete(byName);
    }
  }

  @GetMapping("/user/get/{name}")
  public UserDE getUserTest(@PathVariable String name){
    return userRepository.getByName(name);
  }

  @PostMapping("/user/save")
  public User saveUserTest(@RequestBody User user){
    return userRepository.save(new UserDE(user)).getData();
  }

  @GetMapping("/id")
  public Optional<AnimeDE> idTest(){
    return animeRepository.findById("47cc9cc8-9fd4-4e54-97da-071c5a75fce2");
  }

  @GetMapping("/query/{name}")
  public Anime queryTest(@PathVariable String name){
    return animeRepository.findByName(name);
  }

  @GetMapping("/delete/{name}")
  public void deleteQuery(@PathVariable String name){
    animeRepository.deleteByName(name);
  }

  @GetMapping("/query/{name}/{key}")
  public Set<AnimeDE> queryTest(@PathVariable String name, @PathVariable String key){
    return animeRepository.findByNameAndKey(name, key);
  }

  @GetMapping("/query")
  public Anime queryTest(){
    return animeRepository.findByName("test");
  }

  @GetMapping("/watch")
  public WatchingConnection getWatching(){
    UserDE firestar = userRepository.save(new UserDE(new User("Nathaniel Davidson", "firestar")));
    AnimeDE hellsingUltimate = animeRepository.save(new AnimeDE(new Anime("Hellsing Ultimate", 8.35f)));
    return watchingConnectionRepository.save(new WatchingConnection(firestar, hellsingUltimate));
  }

  @GetMapping("/watch/id/{id}")
  public Optional<WatchingConnection> get(@PathVariable String id){
    return watchingConnectionRepository.findById(id);
  }

  @GetMapping("/watch/from/{id}")
  public Set<WatchingConnection> getByFrom(@PathVariable String id){
    Optional<UserDE> byId = userRepository.findById(id);
    if(byId.isPresent()){
      return watchingConnectionRepository.getByFrom(byId.get());
    }
    return null;
  }
  @GetMapping("/watch/from/{id}/to")
  public Set<AnimeDE> getByFromReturnTo(@PathVariable String id){
    Optional<UserDE> byId = userRepository.findById(id);
    if(byId.isPresent()){
      return watchingConnectionRepository.getToByFrom(byId.get());
    }
    return null;
  }
  @GetMapping("/watch/to/{id}")
  public Set<WatchingConnection> getByTo(@PathVariable String id){
    Optional<AnimeDE> byId = animeRepository.findById(id);
    if(byId.isPresent()){
      return watchingConnectionRepository.getByTo(byId.get());
    }
    return null;
  }

  @EventListener
  public void animeCreatedEvent(DataEntryCreatedEvent<AnimeDE> animeCreated){
    Serializer.log("Anime created "+animeCreated.getDataEntry().getData().getName());
  }

  @EventListener
  public void userCreatedEvent(DataEntryCreatedEvent<UserDE> userCreated){
    Serializer.log("User created "+userCreated.getDataEntry().getData().getName());
    userRepository.delete(userCreated.getDataEntry());
  }

  @EventListener
  public void userDeletedEvent(DataEntryDeletedEvent<UserDE> userDeleted){
    Serializer.log("User deleted "+userDeleted.getDataEntry().getData().getName());
  }

  @GetMapping("/watch/to/{id}/from")
  public Set<UserDE> getByToReturnFrom(@PathVariable String id){
    Optional<AnimeDE> byId = animeRepository.findById(id);
    if(byId.isPresent()){
      return watchingConnectionRepository.getFromByTo(byId.get());
    }
    return null;
  }

}
