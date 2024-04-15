package pojos;

public class PojoHerokuappResponseBody {
    // 1- tum variable'lari private olarak olustur
    private int bookindid;
    private PojoHerokuappRequestBody booking;

    // 2- tum variable'lar icin getter ve setter metodlari olusturalim

    public int getBookindid() {
        return bookindid;
    }

    public void setBookindid(int bookindid) {
        this.bookindid = bookindid;
    }

    public PojoHerokuappRequestBody getBooking() {
        return booking;
    }

    public void setBooking(PojoHerokuappRequestBody booking) {
        this.booking = booking;
    }


    // 3- tum parametreleri kullanarak bir constructor olusturalim

    public PojoHerokuappResponseBody(int bookindid, PojoHerokuappRequestBody booking) {
        this.bookindid = bookindid;
        this.booking = booking;
    }


    // 4- default constructor yerine manuel olarak parametresiz bir constructor olusturalim

    public PojoHerokuappResponseBody() {
    }


    // 5- toString metodu olusturalim

    @Override
    public String toString() {
        return "PojoHerokuappResponseBody{" +
                "bookindid=" + bookindid +
                ", booking=" + booking +
                '}';
    }
}
