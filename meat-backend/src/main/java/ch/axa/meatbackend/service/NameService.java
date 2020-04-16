package ch.axa.meatbackend.service;

import ch.axa.meatbackend.mongo.model.Name;

import java.util.List;
import java.util.Optional;

public interface NameService {

    Name save(Name name);
    List<Name> findAll();
    Optional<Name> findById(String id);
    List<Name> findByVorname(String vorname);
    List<Name> findByNachname(String nachname);
    Name createName(Name name);
    Name editName(Name newName);
    boolean deleteName(String nameId);
    Name copyName(String nameId);
    Name copyName(Name name);

}
