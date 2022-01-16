import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class HotelReservationTest {

    @Test
    public void givenHotelList_WhenAdded_shouldReturnProperHotelName(){
        HotelReservationIF hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 110,90,110,50);
        String hotelName = hotelReservation.getHotelList().get(0).getHotelName();
        Assertions.assertEquals("Bridgewood", hotelName);
    }
    @Test
    public void givenHotelList_WhenAdded_shouldReturnProperHotelRating(){
        HotelReservationIF hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 150,50,110,50);
        int hotelRating = hotelReservation.getHotelList().get(0).getRating();
        Assertions.assertEquals(4, hotelRating);
    }
    @Test
    public void givenHotelList_WhenAdded_shouldReturnWeekDayRate(){
        HotelReservationIF hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 150,50,110,50);
        int weekDayRate = (int) hotelReservation.getHotelList().get(0).getWeekDayRate();
        Assertions.assertEquals(150, weekDayRate);
    }
    @Test
    public void givenHotelList_WhenAdded_shouldReturnWeekendRate(){
        HotelReservationIF hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 220,150,110,50);
        int weekendRate = (int) hotelReservation.getHotelList().get(0).getWeekendRate();
        Assertions.assertEquals(150, weekendRate);
    }
    @Test
    public void givenHotelList_WhenAdded_shouldReturnWeekDayRewardRate(){
        HotelReservationIF hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 150,50,110,50);
        int weekdayRewardRate = (int) hotelReservation.getHotelList().get(0).getWeekdayRewardCustomerRate();
        Assertions.assertEquals(110, weekdayRewardRate);
    }
    @Test
    public void givenHotelList_WhenAdded_shouldReturnWeekendRewardRate(){
        HotelReservationIF hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Bridgewood", 4, 220,150,110,50);
        int weekendRewardRate = (int) hotelReservation.getHotelList().get(0).getWeekendRewardCustomerRate();
        Assertions.assertEquals(50, weekendRewardRate);
    }
    @Test
    public void givenHotelDetails_WhenSizeMatches_ShoulReturnTrue()
    {
        HotelReservationIF hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110,90,80,80);
        hotelReservation.addHotel("Bridgewood", 4, 150,50,110,50);
        hotelReservation.addHotel("Ridgewood", 5, 220,150,100,140);
        int hotelListSize = hotelReservation.getHotelListSize();
        Assertions.assertEquals(3, hotelListSize);
    }
    @Test
    public void givenHotelDetails_shouldReturnCheapestHotel(){

        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90,80,80);
        hotelReservation.addHotel("Bridgewood", 4, 160, 50,110,50);
        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
        String hotelName = hotelReservation.getCheapestHotel(startDate, endDate,"reward");
        Assertions.assertEquals("Bridgewood", hotelName);
    }
    @Test
    public void givenHotelDetails_shouldReturnBestRatedHotel(){

        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 3, 110, 90,80,80);
        hotelReservation.addHotel("Bridgewood", 4, 160, 50,110,50);
        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
        String hotelName = hotelReservation.getBestRatedHotel(startDate, endDate);
        Assertions.assertEquals("Bridgewood", hotelName);
    }
    @Test
    public void givenHotelDetails_WhenNull_ShouldThrowHotelReservationException() {


        try {
            HotelReservation hotelReservation = new HotelReservation();
            hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
            hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
            hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);
            LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
            LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
            hotelReservation.getCheapestHotel(startDate, endDate,null);
        }
        catch(HotelReservationException e){
            Assertions.assertEquals(HotelReservationException.ExceptionType.ENTERED_NULL, e.type);
            e.printStackTrace();
        }
    }
    @Test
    public void givenHotelDetails_WhenEmpty_ShouldThrowHotelReservationException() {


        try {
            HotelReservation hotelReservation = new HotelReservation();
            hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
            hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
            hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);
            LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
            LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
            hotelReservation.getCheapestHotel(startDate, endDate,"");
        }
        catch(HotelReservationException e){
            Assertions.assertEquals(HotelReservationException.ExceptionType.ENTERED_EMPTY, e.type);
            e.printStackTrace();
        }

    }
}