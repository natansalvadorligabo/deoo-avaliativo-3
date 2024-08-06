package data.airport.model;

import data.airport.states.Arriving;

import java.util.LinkedList;
import java.util.List;

public class LandingTotem implements ITotem{
    private final FlightDataCollection flightDataCollection;

    public LandingTotem(FlightDataCollection flightDataCollection) {
        this.flightDataCollection = flightDataCollection;
    }

    @Override
    public List<FlightData> getTotemData() {
        List<FlightData> flightDataLanding = new LinkedList<>();
        for (FlightData flight : flightDataCollection.allFlights()){
            if(flight.getState().equals(Arriving.getInstance())){
                flightDataLanding.add(flight);
            }
        }

        return flightDataLanding;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (FlightData flight : getTotemData()){
            stringBuilder.append(flight.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
