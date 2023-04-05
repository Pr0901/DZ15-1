public class ProductManager {

    private ProductRepository repo;
    Ticket[] tickets = new Ticket[0];

    public ProductManager(ProductRepository repo) {

        this.repo = repo;
    }

    public void add(Ticket ticket) {

        repo.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {



        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : repo.findAll()) {
            if (ticket.getStartAirport() == from && ticket.getEndAirport() == to) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
        return tickets;
    }


//    public boolean matches(Ticket product, String search) {
//        if (product.getName().contains(search)) {
//            return true;
//        } else {
//            return false;
//        }
//
//    }


}
