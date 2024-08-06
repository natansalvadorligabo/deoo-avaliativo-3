package data.airport.model;

import data.airport.states.TakingOff;

import java.util.LinkedList;
import java.util.List;

public class BoardingTotem implements ITotem{
    private final FlightDataCollection flightDataCollection;

    public BoardingTotem(FlightDataCollection flightDataCollection) {
        this.flightDataCollection = flightDataCollection;
    }

    @Override
    public List<FlightData> getTotemData() {
        List<FlightData> flightDataBoarding = new LinkedList<>();
        for (FlightData flight : flightDataCollection.allFlights()){
            if(flight.getState().equals(TakingOff.getInstance())){
                flightDataBoarding.add(flight);
            }
        }

        return flightDataBoarding;
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
