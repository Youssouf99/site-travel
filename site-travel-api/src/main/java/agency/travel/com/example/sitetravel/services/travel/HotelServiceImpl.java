package agency.travel.com.example.sitetravel.services.travel;

import agency.travel.com.example.sitetravel.dtos.HotelDto;
import agency.travel.com.example.sitetravel.entities.Hotel;
import agency.travel.com.example.sitetravel.exceptions.NotFoundException;
import agency.travel.com.example.sitetravel.mappers.TravelMapper;
import agency.travel.com.example.sitetravel.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {


    private final HotelRepository hotelRepository;
    private final TravelMapper travelMapper;

    public HotelServiceImpl(HotelRepository hotelRepository, TravelMapper travelMapper) {
        this.hotelRepository = hotelRepository;
        this.travelMapper = travelMapper;
    }


    @Override
    public List<HotelDto> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return travelMapper.toHotelDtos(hotels);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hotel not found with id: " + id));
        return travelMapper.toHotelDto(hotel);
    }

    @Override
    public HotelDto createHotel(HotelDto hotelDto) {
        Hotel hotel = travelMapper.toHotel(hotelDto);
        hotel = hotelRepository.save(hotel);
        return travelMapper.toHotelDto(hotel);
    }

    @Override
    public HotelDto updateHotel(Long id, HotelDto hotelDTO) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hotel not found with id: " + id));
        travelMapper.updateHotelFromHotelDto(hotelDTO, hotel);

        hotelRepository.save(hotel);
        return travelMapper.toHotelDto(hotel);
    }

    @Override
    public void deleteHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hotel not found with id: " + id));
        hotelRepository.delete(hotel);
    }



    @Override
    public List<HotelDto> searchHotels(String city, LocalDate checkInDate, LocalDate checkOutDate) {
        List<Hotel> hotels = hotelRepository.findByCityAndStartDateBeforeAndEndDateAfter(city, checkOutDate, checkInDate);
        return hotels.stream()
                .map(travelMapper::toHotelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<HotelDto> searchHotelsByCity(String city) {
        List<Hotel> hotels = hotelRepository.findByCity(city);
        return travelMapper.toHotelDtos(hotels);
    }

    @Override
    public List<HotelDto> searchHotelsByDateRange(LocalDate startDate, LocalDate endDate) {
        List<Hotel> hotels = hotelRepository.findByStartDateBetween(startDate, endDate);
        return travelMapper.toHotelDtos(hotels);
    }

    @Override
    public List<HotelDto> searchHotelsByPriceRange(double minPrice, double maxPrice) {
        List<Hotel> hotels = hotelRepository.findByPriceBetween(minPrice, maxPrice);
        return travelMapper.toHotelDtos(hotels);
    }


}
