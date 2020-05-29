package Lab3;

public class Lab3 {
    public static void main(String[] args) {
        RegisterOfIssuedCards register = new RegisterOfIssuedCards();
        Gate gate = new Gate(register);
        // Create new cards
        Card card1 = register.createNewCard(1, CardUtil.charter,  CardUtil.byPasses);
        card1.setCountOfPasses(3);
        Card card2 = register.createNewCard(2, CardUtil.vip,  CardUtil.byPasses);

        Card card3 = register.createNewCard(3, CardUtil.standard,  CardUtil.dateExpire);
        Card card4 = register.createNewCard(4, CardUtil.standard,  CardUtil.dateExpire);

        gate.readCard(card2.getId());

    }
}
