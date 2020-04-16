package ch.axa.meatbackend.graphql.resolver;

import ch.axa.meatbackend.mongo.model.Name;
import ch.axa.meatbackend.service.NameService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class Query  implements GraphQLQueryResolver {

    @Autowired
    private NameService nameService;

    public Query(NameService nameService) {
        this.nameService = nameService;
    }

    public List<Name> getNamen() {
        return nameService.findAll();
    }

    public Optional<Name> getName(String nameId) {
        return nameService.findById(nameId);
    }

}
