package midtsemesterforelesning;

public class SilverLoyaltyStatus implements HotelLoyaltyStatus {
    @Override
    public String welcomeGift() {
        return "Vinflaske på rommet";
    }
}
