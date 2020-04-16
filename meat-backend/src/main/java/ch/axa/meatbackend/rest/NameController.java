package ch.axa.meatbackend.rest;

import ch.axa.meatbackend.mongo.model.Name;
import ch.axa.meatbackend.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/name")
public class NameController {

    private NameService nameService;

    @Autowired
    public NameController(NameService nameService){
        this.nameService = nameService;
    }

    @GetMapping("/namen")
    @CrossOrigin(origins = "*")
    public List<Name> namen(){
        return nameService.findAll();
    }

}
