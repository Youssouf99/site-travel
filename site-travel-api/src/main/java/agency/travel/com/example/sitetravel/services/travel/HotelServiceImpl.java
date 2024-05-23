package agency.travel.com.example.sitetravel.services.travel;

import agency.travel.com.example.sitetravel.dtos.HotelDto;
import agency.travel.com.example.sitetravel.entities.Hotel;
import agency.travel.com.example.sitetravel.exceptions.NotFoundException;
import agency.travel.com.example.sitetravel.mappers.HotelMapper;
import agency.travel.com.example.sitetravel.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {


    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    public HotelServiceImpl(HotelRepository hotelRepository, HotelMapper hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
    }


    @Override
    public List<HotelDto> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotelMapper.toHotelDtos(hotels);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hotel not found with id: " + id));
        return hotelMapper.toHotelDto(hotel);
    }

    @Override
    public HotelDto createHotel(HotelDto hotelDto) {
        Hotel hotel = hotelMapper.toHotel(hotelDto);
        hotel = hotelRepository.save(hotel);
        return hotelMapper.toHotelDto(hotel);
    }

    @Override
    public HotelDto updateHotel(Long id, HotelDto hotelDTO) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hotel not found with id: " + id));
        hotelMapper.updateHotelFromHotelDto(hotelDTO, hotel);

        hotelRepository.save(hotel);
        return hotelMapper.toHotelDto(hotel);
    }

    @Override
    public void deleteHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hotel not found with id: " + id));
        hotelRepository.delete(hotel);
    }




    @Override
    public List<HotelDto> searchHotelsByDateRange(LocalDate startDate, LocalDate endDate) {
        List<Hotel> hotels = hotelRepository.findByStartDateBetween(startDate, endDate);
        return hotelMapper.toHotelDtos(hotels);
    }

    @Override
    public List<HotelDto> searchHotelsByPriceRange(double minPrice, double maxPrice) {
        List<Hotel> hotels = hotelRepository.findByPriceBetween(minPrice, maxPrice);
        return hotelMapper.toHotelDtos(hotels);
    }


}
