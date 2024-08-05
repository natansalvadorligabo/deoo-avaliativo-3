package data.airport.model;

import data.airport.states.Arriving;
import data.airport.states.TakingOff;

import java.util.LinkedList;
import java.util.List;

public class TotemData {
    private FlightDataCollection flightDataCollection;
    private List<FlightData> flightDataBoarding;
    private List<FlightData> flightDataLanding;

    public TotemData(FlightDataCollection flightDataCollection) {
        this.flightDataCollection = flightDataCollection;
        flightDataBoarding = new LinkedList<>();
        flightDataLanding = new LinkedList<>();
        // create more datasets...
    }

    public List<FlightData> getAllFlightsBoarding() {
        for (FlightData flight : flightDataCollection.allFlights()){
            if(flight.getState().equals(TakingOff.getInstance())){
                flightDataBoarding.add(flight);
            }
        }

        return flightDataBoarding;
    }

    public List<FlightData> getAllFlightsLanding() {
        for (FlightData flight : flightDataCollection.allFlights()){
            if(flight.getState().equals(Arriving.getInstance())){
                flightDataLanding.add(flight);
            }
        }

        return flightDataLanding;
    }

    // create more methods...
}