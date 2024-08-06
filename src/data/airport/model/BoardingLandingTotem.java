package data.airport.model;

import java.util.LinkedList;
import java.util.List;

public class BoardingLandingTotem implements ITotem{
    private final BoardingTotem boardingTotem;
    private final LandingTotem landingTotem;

    public BoardingLandingTotem(BoardingTotem boardingTotem, LandingTotem landingTotem) {
        this.boardingTotem = boardingTotem;
        this.landingTotem = landingTotem;
    }

    @Override
    public List<FlightData> getTotemData() {
        List<FlightData> flightDataBoardingLanding = new LinkedList<>();
        flightDataBoardingLanding.addAll(boardingTotem.getTotemData());
        flightDataBoardingLanding.addAll(landingTotem.getTotemData());
        return flightDataBoardingLanding;
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
