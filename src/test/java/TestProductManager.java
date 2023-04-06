import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProductManager {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Ticket ticket1 = new Ticket(11, 1_100, "KRR", "MOW", 100);
    Ticket ticket2 = new Ticket(22, 1_200, "MOW", "KZN", 200);
    Ticket ticket3 = new Ticket(33, 1_400, "MOW", "KZN", 200);
    Ticket ticket4 = new Ticket(44, 1_300, "MOW", "KZN", 200);
    Ticket ticket5 = new Ticket(55, 1_500, "KZN", "MOW", 500);

    Ticket ticket6 = new Ticket(55, 1_700, "MOW", "KZN", 500);
    Ticket ticket7 = new Ticket(55, 2_500, "MOW", "KZN", 500);


    @BeforeEach
    public void setApp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
    }

    @Test
    public void findAll() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};
        Ticket[] actual = repo.getTickets();
    }

    @Test
    public void findMowKzn() {


        Ticket[] expected = {ticket2, ticket4, ticket3, ticket6, ticket7};
        Ticket[] actual = manager.findAll("MOW", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findNothing() {


        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("MOW", "KRR");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesStartAirport() {

        boolean expected = true;
        boolean actual = manager.matchesStart(ticket3, "MOW");
    }

    @Test
    public void mismatchStartAirport() {

        boolean expected = false;
        boolean actual = manager.matchesStart(ticket1, "MOW");
    }

    @Test
    public void matchesEndAirport() {

        boolean expected = true;
        boolean actual = manager.matchesEnd(ticket5, "MOW");
    }

    @Test
    public void mismatchEndAirport() {

        boolean expected = false;
        boolean actual = manager.matchesEnd(ticket2, "MOW");
    }


}
