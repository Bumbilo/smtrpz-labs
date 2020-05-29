package Lab3;

public class CardLog {
    private final long id;
    private final boolean pass;
    private final String typeOfCard;

    public CardLog(long id, boolean pass, String typeOfCard) {
        this.id = id;
        this.pass = pass;
        this.typeOfCard = typeOfCard;
    }

    public String getTypeOfCard() {
        return typeOfCard;
    }

    public long getId() {
        return id;
    }
}
