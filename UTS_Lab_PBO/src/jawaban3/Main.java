package jawaban3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LotreBoard game = new LotreBoard();

        System.out.println("Welcome to E-Lottery Gosok");
        game.generateBoard();
        game.displayBoard();

        boolean isPlaying = true;

        while (isPlaying) {
            System.out.print("\nMasukkan tebakan anda (baris dan kolom) : ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            boolean isSafe = game.guess(row, col);

            if (!isSafe) {
                System.out.println("BOOM! Anda menemukan bom! Permainan berakhir.");
                game.displayBoard();
                isPlaying = false;
            } else {
                if (game.isGameOver()) {
                    System.out.println("Selamat anda menang");
                    game.displayBoard();
                    isPlaying = false;
                } else {
                    game.displayBoard();
                }
            }
        }
        scanner.close();
    }
}