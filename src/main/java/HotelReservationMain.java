import java.time.LocalDate;
import java.time.Month;

public class HotelReservationMain {
    public static void main(String[] args) {

        System.out.println(" Welcome To Hotel Reservation");
        HotelReservationIF hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110,90,80,80);
        hotelReservation.addHotel("Bridgewood", 4, 150,50,110,50);
        hotelReservation.addHotel("Ridgewood", 5, 220,150,100,40);
        hotelReservation.printHotelList();
        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
        hotelReservation.getCheapestHotel(startDate, endDate,"reward");
        hotelReservation.getCheapestHotel(startDate, endDate,"regular");
        hotelReservation.getBestRatedHotel(startDate, endDate);
    }
}