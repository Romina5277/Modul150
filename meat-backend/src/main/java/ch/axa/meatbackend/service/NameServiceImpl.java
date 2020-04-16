package ch.axa.meatbackend.service;

import ch.axa.meatbackend.mongo.repository.NameRepository;
import ch.axa.meatbackend.mongo.model.Name;

import java.util.List;
import java.util.Optional;

public class NameServiceImpl implements NameService{

    private final NameRepository nameRepository;

    public NameServiceImpl(NameRepository nameRepository){
        this.nameRepository = nameRepository;
    }

    @Override
    public Name save(Name name) {
        return nameRepository.save(name);
    }

    @Override
    public List<Name> findAll() {
        return nameRepository.findAll();
    }

    @Override
    public Optional<Name> findById(String id) {
        return nameRepository.findById(id);
    }

    @Override
    public List<Name> findByVorname(String vorname) {
        return nameRepository.findByVorname(vorname);
    }

    @Override
    public List<Name> findByNachname(String nachname) {
        return nameRepository.findByNachname(nachname);
    }

    @Override
    public Name createName(Name name) {
        name.setId(null);
        return nameRepository.save(name);
    }

    @Override
    public Name editName(Name newName) {
        return nameRepository.findById(newName.getId()).map(oldName -> nameRepository.save(newName)).orElse(null);
    }

    @Override
    public boolean deleteName(String nameId) {
        return nameRepository.findById(nameId).map(name -> {
            nameRepository.delete(name);
            return true;
        }).orElse(false);
    }

    @Override
    public Name copyName(String nameId) {
        return nameRepository.findById(nameId).map(name -> copyName(name)).orElse(null);
    }

    @Override
    public Name copyName(Name name) {
        name.setId(null);
        name.setNachname(name.getNachname() + " - COPY");
        return nameRepository.save(name);
    }
}
