import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProductManager {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Ticket ticket1 = new Ticket(11, 1_100, "KRR", "MOW", 100);
    Ticket ticket2 = new Ticket(22, 1_200, "SPG", "MOW", 200);
    Ticket ticket3 = new Ticket(33, 1_300, "MOW", "KZN", 300);
    Ticket ticket4 = new Ticket(44, 1_400, "MOW", "KZN", 400);
    Ticket ticket5 = new Ticket(55, 1_500, "NVR", "KRR", 500);


    @BeforeEach
    public void setApp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    public void findAll() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.getTickets();
    }

    @Test
    public void findMowKzn(){


        Ticket[] expected = {ticket3, ticket4};
        Ticket[] actual = manager.findAll("MOW", "KZN");

        Assertions.assertArrayEquals(expected,actual);
    }




}
