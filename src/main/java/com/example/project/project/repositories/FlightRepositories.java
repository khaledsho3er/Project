package com.example.project.project.repositories;
import java.util.List;
import com.example.project.project.Models.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component

public interface FlightRepositories extends JpaRepository<Flights,String> {

    @Query("SELECT f FROM Flights f WHERE f.depature_city LIKE %:departureCity% AND f.arrival_city LIKE %:arrivalCity% AND f.departure_date LIKE %:departureDate% AND f.flight_type LIKE %:flightType%")
    List<Flights> findByDepature_cityAndArrival_cityAndDeparture_dateAndFlight_type(
        @Param("departureCity") String departureCity, 
        @Param("arrivalCity") String arrivalCity,
        @Param("departureDate") String departure_date, 
        @Param("flightType") String flight_type);

    // @Query("SELECT * FROM Flights f WHERE f.arrival_city LIKE %:search%")
    // List<Flights> searchMyPostsJpql(String search);

    // List<Flights> findByDeparture_city(String search);
    
   
    
   
}
