import java.util.Arrays;

public class ProductManager {

    private ProductRepository repo;


    public ProductManager(ProductRepository repo) {

        this.repo = repo;
    }

    public void add(Ticket ticket) {

        repo.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {

        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matchesStart(ticket, from) && matchesEnd(ticket, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        TicketPriceComparator priceComparator = new TicketPriceComparator();

        Arrays.sort(result, priceComparator);

        return result;
    }


    public boolean matchesStart(Ticket ticket, String from) {
        if (ticket.getStartAirport().contains(from)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchesEnd(Ticket ticket, String to) {
        if (ticket.getEndAirport().contains(to)) {
            return true;
        } else {
            return false;
        }
    }


}
