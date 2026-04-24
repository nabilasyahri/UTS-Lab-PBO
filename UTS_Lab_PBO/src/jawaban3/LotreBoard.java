package jawaban3;
import java.util.Random;

public class LotreBoard {
    private char[][] board;
    private boolean[][] revealed;
    private int[][] data;
    private int safeCount;
    private final int MAX_SAFE = 18;

    public LotreBoard() {
        board = new char[4][5];
        revealed = new boolean[4][5];
        data = new int[4][5];
        safeCount = 0;
    }

    public void generateBoard() {
        // Inisialisasi awal papan (semua kotak tertutup '*')
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = '*';
                data[i][j] = 0; // 0 = aman
                revealed[i][j] = false;
            }
        }

        // Tanam 2 bom secara acak
        Random rand = new Random();
        int bombsPlaced = 0;
        while (bombsPlaced < 2) {
            int r = rand.nextInt(4);
            int c = rand.nextInt(5);
            if (data[r][c] != 1) { // Jika belum ada bom
                data[r][c] = 1; // 1 = bom
                bombsPlaced++;
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public boolean guess(int row, int col) {
        if (row < 0 || row >= 4 || col < 0 || col >= 5) {
            System.out.println("Input di luar batas papan!");
            return true;
        }

        if (revealed[row][col]) {
            System.out.println("Kotak telah dibuka sebelumnya!");
            return true;
        }

        revealed[row][col] = true;

        if (data[row][col] == 1) {
            board[row][col] = 'X'; // Menandakan bom kena
            return false;
        } else {
            board[row][col] = '0'; // Sesuai referensi gambar, menggunakan '0' untuk aman
            safeCount++;
            System.out.println("Kotak Aman");
            return true;
        }
    }

    public boolean isGameOver() {
        return safeCount == MAX_SAFE;
    }
}