package Lab3;

import java.util.Date;

public class Card {
    private final long id;
    private final String typeOfCard;
    private boolean isBlocked;
    private final String typeOfAccess;
    private int countOfPasses;
    private Date[] dates = new Date[2];

    public Card(long id, String typeOfCard, boolean isBlocked, String typeOfAccess) {
        this.id = id;
        this.typeOfCard = typeOfCard;
        this.isBlocked = isBlocked;
        this.typeOfAccess = typeOfAccess;
    }


    public long getId() {
        return id;
    }

    public String getTypeOfCard() {
        return typeOfCard;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean value){
        isBlocked = value;
    }

    public String getTypeOfAccess() {
        return typeOfAccess;
    }

    public int getCountOfPasses() {
        return countOfPasses;
    }

    public void setCountOfPasses(int countOfPasses) {
        this.countOfPasses = countOfPasses;
    }

    public Date[] getDates() {
        return dates;
    }

    public void setDates(Date[] dates) {
        this.dates = dates;
    }
}
