package agency.travel.com.example.sitetravel.services.travel;


import agency.travel.com.example.sitetravel.dtos.*;
import agency.travel.com.example.sitetravel.entities.Activity;
import agency.travel.com.example.sitetravel.entities.Flight;
import agency.travel.com.example.sitetravel.entities.Hotel;
import agency.travel.com.example.sitetravel.entities.Travel;
import agency.travel.com.example.sitetravel.exceptions.NotFoundException;
import agency.travel.com.example.sitetravel.mappers.TravelMapper;
import agency.travel.com.example.sitetravel.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TravelServiceImpl implements TravelService {
    private final TravelRepository travelRepository;
    private final TravelMapper travelMapper;


    @Autowired
    public TravelServiceImpl(TravelRepository travelRepository, TravelMapper travelMapper) {
        this.travelRepository = travelRepository;
        this.travelMapper = travelMapper;
    }


    @Override
    public List<TravelDetailDto> getAllTravels(){
        return travelRepository.findAll().stream().map(travelMapper::toTravelDetailDto).collect(Collectors.toList());
    }



    public void delete(Long id) {
        travelRepository.deleteById(id);
    }

    @Override
    public Travel findById(Long travelId) {
        return travelRepository.findById(travelId)
                .orElseThrow(() -> new NotFoundException("Travel not found with id: " + travelId));
    }

    @Override
    public List<Travel> findAllById(List<Long> travelIds) {
        return travelRepository.findAllById(travelIds);
    }


}
