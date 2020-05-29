package Lab3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class RegisterOfIssuedCards {
    private List<Card> listOfCards = new ArrayList<>();
    private List<CardLog> listOfLogs = new ArrayList<>();


    public Card createNewCard(long id, String typeOfCard, String typeOfAccess) {
        Card card = new Card(id, typeOfCard, false, typeOfAccess);
        listOfCards.add(card);
        return card;
    }

    public void setCountOfPass(Card card, int count){
        if (card.getTypeOfAccess() == CardUtil.byPasses) {
            card.setCountOfPasses(count);
        } else {
            throw new IllegalArgumentException("Doesn't match type of card!");
        }
    }

    public void setDateExpire(Card card, Date start, Date end){
        if (card.getTypeOfAccess() == CardUtil.dateExpire) {
            card.setDates(new Date[]{start, end});
        } else {
            throw new IllegalArgumentException("Doesn't match type of card!");
        }
    }



    public Optional<Card> getCardById(long id) {
        return listOfCards.stream().filter(s -> s.getId() == id).findFirst();
    }

    public boolean blockCardById(long id) {
        Optional<Card> card = getCardById(id);
        if (card.isPresent()) {
            card.get().setBlocked(true);
            return true;
        }
        return false;
    }

    public boolean saveOfLog(Card card, boolean pass) {
        CardLog log = new CardLog(card.getId(), pass, card.getTypeOfCard());
        return listOfLogs.add(log);
    }

    public List<CardLog> getAllLogs(){
       return listOfLogs;
    }

    public List<CardLog> getLogsByType(String type){
        return listOfLogs.stream().filter(s -> s.getTypeOfCard() == type).collect(toList());
    }

    public List<CardLog> getLogsById(long id){
        return listOfLogs.stream().filter(s -> s.getId() == id).collect(toList());
    }

}
