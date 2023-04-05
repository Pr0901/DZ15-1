import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProductRepository {

    ProductRepository repo = new ProductRepository();
    Ticket ticket1 = new Ticket(11, 1_100, "KRR", "MOW", 100);
    Ticket ticket2 = new Ticket(22, 1_200, "SPG", "MOW", 200);
    Ticket ticket3 = new Ticket(33, 1_300, "MOW", "KZN", 300);
    Ticket ticket4 = new Ticket(44, 1_400, "KZN", "MOW", 400);
    Ticket ticket5 = new Ticket(55, 1_500, "NVR", "KRR", 500);


    @BeforeEach
    public void setApp() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
    }


    @Test
    public void findAll() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.findAll();
    }

    @Test
    public void removeById() {
        repo.removeById(44);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket5};
        Ticket[] actual = repo.findAll();
    }



}

