public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        int selectedMap = game.menu();
        game.createMap(selectedMap);
    }
}
