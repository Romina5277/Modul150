package ch.axa.meatbackend.services;

import ch.axa.meatbackend.cofig.TestNameConfig;
import ch.axa.meatbackend.mongo.model.Name;
import ch.axa.meatbackend.mongo.repository.NameRepository;
import ch.axa.meatbackend.service.NameService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestNameConfig.class})
public class NameServiceTest {

    @Autowired
    private NameService nameService;

    @Autowired
    private NameRepository nameRepository;

    @Test
    public void testCreation(){

        Mockito.reset(nameRepository);

        Name name = new Name();
        name.setVorname("Romina");
        name.setNachname("Ferrario");

        Name savedName = new Name();
        savedName.setId("37");
        savedName.setVorname("Romina");
        savedName.setNachname("Ferrario");

        Mockito.when(nameRepository.save(Mockito.any())).thenReturn(savedName);

        nameService.createName(name);

        Assert.assertEquals("37", savedName.getId());
        Assert.assertEquals("Romina", savedName.getVorname());
        Assert.assertEquals("Ferrario", savedName.getNachname());

        Mockito.verify(nameRepository, Mockito.times(1)).save(Mockito.any());

    }

    @Test
    public void testCopy(){

        Name name1 = new Name();
        name1.setId("1");
        name1.setVorname("Romina");
        name1.setNachname("Ferrario");

        Name name2 = new Name();
        name2.setId("2");
        name2.setVorname("Max");
        name2.setNachname("Muster");

        Name name3 = new Name();
        name3.setId("3");
        name3.setVorname("Hans-Peter");
        name3.setNachname("Bretschner");

        List<Name> namenOrginal = new ArrayList<>();
        namenOrginal.add(name1);
        namenOrginal.add(name2);
        namenOrginal.add(name3);

        namenOrginal.forEach(name -> System.out.println(name.getVorname()));

        Mockito.when(nameRepository.save(Mockito.any(Name.class))).thenAnswer(new Answer<Object>() {
            @Override
            public  Name answer(InvocationOnMock inovationOnMock) throws Throwable{
                Name name = inovationOnMock.getArgument(0);
                name.setId("9");
                return name;
            }
        });
        Mockito.when(nameRepository.findById(Mockito.anyString())).thenReturn(Optional.of(name1));
        nameService.copyName(name1.getId());

        namenOrginal.forEach(name -> System.out.println(name));
        Assert.assertEquals("Ferrario - COPY", name1.getNachname());


    }

    @Test
    public void testDelete(){
        List<Name> names = new ArrayList<>();

        Name name1 = new Name();
        name1.setId("1");
        name1.setVorname("Romina");
        name1.setNachname("Ferrario");

        Name name2 = new Name();
        name2.setId("2");
        name2.setVorname("Max");
        name2.setNachname("Muster");

        Name name3 = new Name();
        name3.setId("3");
        name3.setVorname("Hans-Peter");
        name3.setNachname("Bretschner");

        names.add(name1);
        names.add(name2);
        names.add(name3);

        Mockito.when(nameRepository.findById(Mockito.anyString())).thenReturn(Optional.ofNullable(name3));
        //Mockito.when(nameRepository.delete(Mockito.any())).thenCallRealMethod(removeName(names, name1));

    }

    private List<Name> removeName(List<Name> names, Name deleteName) {
        names.remove(deleteName);
        return names;
    }

}
