package ch.axa.meatbackend.mongo.repository;

import ch.axa.meatbackend.mongo.model.Name;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface NameRepository extends MongoRepository<Name, String> {

    Name findFirstBy(String id);
    Optional<Name> findById(String id);
    List<Name> findByVorname(String vorname);
    List<Name> findByNachname(String nachname);
}
