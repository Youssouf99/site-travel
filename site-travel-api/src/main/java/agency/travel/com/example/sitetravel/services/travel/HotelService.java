package agency.travel.com.example.sitetravel.services.travel;

import agency.travel.com.example.sitetravel.dtos.HotelDto;

import java.time.LocalDate;
import java.util.List;

public interface HotelService {
    List<HotelDto> getAllHotels();

    HotelDto getHotelById(Long id);

    HotelDto createHotel(HotelDto hotelDto);

    HotelDto updateHotel(Long id, HotelDto hotelDTO);

    void deleteHotel(Long id);

    List<HotelDto> searchHotels(String city, LocalDate checkInDate, LocalDate checkOutDate);

    List<HotelDto> searchHotelsByCity(String city);

    List<HotelDto> searchHotelsByDateRange(LocalDate startDate, LocalDate endDate);

    List<HotelDto> searchHotelsByPriceRange(double minPrice, double maxPrice);
}
