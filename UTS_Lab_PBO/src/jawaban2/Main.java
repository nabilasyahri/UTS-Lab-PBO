package jawaban2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean lanjut = true;

        int totalKendaraan = 0;
        double totalSemuaBiaya = 0;

        System.out.println("======== Welcome to ParkingChan ========");

        while (lanjut) {
            System.out.print("\nEnter vehicle type (Motor/Mobil/Truk) : ");
            String jenis = scanner.next();
            Kendaraan kendaraan = new Kendaraan(jenis);

            System.out.print("Enter Duration (Manual/Time): ");
            String tipeInput = scanner.next();

            if (tipeInput.equalsIgnoreCase("Manual")) {
                System.out.print("Enter Duration (in hour): ");
                int durasi = scanner.nextInt();
                kendaraan.hitungBiaya(durasi);
            } else if (tipeInput.equalsIgnoreCase("Time")) {
                System.out.print("Enter entry time : ");
                int masuk = scanner.nextInt();
                System.out.print("Enter exit time  : ");
                int keluar = scanner.nextInt();
                kendaraan.hitungBiaya(masuk, keluar);
            }

            kendaraan.tampilkanRingkasan();
            totalKendaraan++;
            totalSemuaBiaya += kendaraan.getTotalBiaya();

            System.out.print("\nAdd another vehicle? (y/n): ");
            String pilihan = scanner.next();
            if (pilihan.equalsIgnoreCase("n")) {
                lanjut = false;
            }
        }

        System.out.println("\n======== FINAL REPORT ========");
        System.out.println("Total Vehicle Final     : " + totalKendaraan);
        System.out.println("Total Parking Fees Final: Rp" + totalSemuaBiaya);
        System.out.println("Thank You.....");

        scanner.close();
    }
}