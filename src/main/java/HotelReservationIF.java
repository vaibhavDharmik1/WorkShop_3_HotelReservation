import java.time.LocalDate;
import java.util.ArrayList;

public interface HotelReservationIF {

    public void addHotel(String hotelName, int rating, double weekDayRate, double weekendRate, double weekdayRewardCustomerRate, double weekendRewardCustomerRate);

    public int getHotelListSize();

    public void printHotelList();

    public ArrayList<Hotel> getHotelList();

    public int noOfWeekends(LocalDate startDate, LocalDate endDate);

    public String getCheapestHotel(LocalDate startDate, LocalDate endDate, String customerType);

    public String getBestRatedHotel(LocalDate startDate, LocalDate endDate);
}