public class Ticket implements Comparable<Ticket> {

    int id;
    int price;
    String startAirport;
    String endAirport;
    int period;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStartAirport() {
        return startAirport;
    }

    public void setStartAirport(String startAirport) {
        this.startAirport = startAirport;
    }

    public String getEndAirport() {
        return endAirport;
    }

    public void setEndAirport(String endAirport) {
        this.endAirport = endAirport;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Ticket(int id, int price, String startAirport, String endAirport, int period) {
        this.id = id;
        this.price = price;
        this.startAirport = startAirport;
        this.endAirport = endAirport;
        this.period = period;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price){
            return -1;
        } else if (this.price > o.price){
            return 1;
        } else {
            return 0;
        }
    }
}
