package midtsemesterforelesning;

public class GoldLoyaltuStatus implements HotelLoyaltyStatus {
    @Override
    public String welcomeGift() {
        return "Gratis frokost, ekstra oppgradering";
    }
}
