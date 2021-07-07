package Lab3;

import java.util.Optional;

public class Gate {
    RegisterOfIssuedCards register;

    public Gate(RegisterOfIssuedCards register) {
        this.register = register;
    }

    public void readCard(long id) {
        Optional<Card> card = register.getCardById(id);
        boolean isEnter = validate(card);
        if (!isEnter) {
            System.out.println("Access denied!");
        } else {
            System.out.println("Access allowed!");
        }
    }

    public boolean validate(Optional<Card> card) {
        Card newCard = card.get();

        if (!card.isPresent()) {
            return false;
        }

        if (newCard.isBlocked()) {
            register.saveOfLog(newCard, false);
            return false;
        }

        if (newCard.getTypeOfAccess() == CardUtil.dateExpire) {
            if (newCard.getDates()[0] == null && newCard.getDates()[1] == null) {
                throw new IllegalArgumentException("Card is not initialized!");
            }
        }

        if (newCard.getTypeOfCard() == CardUtil.charter) {
            System.out.print("Please check a document!");
        }

        return hasPasses(newCard);

    }

    public boolean hasPasses(Card card) {
        if (card.getTypeOfAccess() == CardUtil.byPasses) {
            return isCountNotEmpty(card);
        } else {
            return isDateValid(card);
        }
    }

    public boolean isCountNotEmpty(Card card) {
        if (card.getCountOfPasses() > 0) {
            card.setCountOfPasses(card.getCountOfPasses() - 1);
            register.saveOfLog(card, true);
            return true;
        } else {
            register.saveOfLog(card, false);
            return false;
        }
    }

    public boolean isDateValid(Card card) {
        if (card.getDates()[0].compareTo(CardUtil.currentDate) < 0 && card.getDates()[1].compareTo(CardUtil.currentDate) > 0) {
            register.saveOfLog(card, true);
            return true;
        } else {
            register.saveOfLog(card, false);
            return false;
        }

    }
}
