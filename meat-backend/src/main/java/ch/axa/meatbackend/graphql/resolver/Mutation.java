package ch.axa.meatbackend.graphql.resolver;

import ch.axa.meatbackend.mongo.model.Name;
import ch.axa.meatbackend.service.NameService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

public class Mutation implements GraphQLMutationResolver {

    private final NameService nameService;

    public Mutation(NameService nameService) {
        this.nameService = nameService;
    }

    public Name createName(Name name) {
        return nameService.createName(name);
    }

    public Name editName(Name name) {
        return nameService.editName(name);
    }

    public boolean deleteName(String nameId) {
        return nameService.deleteName(nameId);
    }

    public Name copyName(String nameId) {
        return nameService.copyName(nameId);
    }

}
