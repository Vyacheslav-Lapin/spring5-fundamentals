package ioc;

import lab.SimpleCountry;
import lab.ioc.Person;
import lab.ioc.UsualPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
class SpringTCFAppTest {

    @Autowired
    private Person person;

    private UsualPerson expectedPerson;


    @BeforeEach
    void setUp() throws Exception {
        expectedPerson = getExpectedPerson();
    }

    @Test
    void testInitPerson() {
        assertEquals(expectedPerson, person);
        System.out.println(person);
    }

    private UsualPerson getExpectedPerson() {
        return new UsualPerson(
                0,
                "John Smith",
                new SimpleCountry(1, "Russia","RU"),
                35,
                1.78F,
                true,
                Arrays.asList("asd@asd.ru", "+7-234-456-67-89"));
    }

}
