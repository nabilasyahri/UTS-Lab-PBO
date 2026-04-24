package jawaban2;

public class Kendaraan {
    private String jenisKendaraan;
    private int durasiParkir;
    private double totalBiaya;

    public Kendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public void hitungBiaya(int durasi) {
        this.durasiParkir = durasi;
        kalkulasiBiaya();
    }

    public void hitungBiaya(int jamMasuk, int jamKeluar) {
        int durasi = jamKeluar - jamMasuk;
        if (durasi < 0) durasi += 24; // Handle jika lewat tengah malam
        this.durasiParkir = durasi;
        kalkulasiBiaya();
    }

    private void kalkulasiBiaya() {
        double tarifPerJam = 0;
        switch (jenisKendaraan.toLowerCase()) {
            case "motor": tarifPerJam = 2000; break;
            case "mobil": tarifPerJam = 5000; break;
            case "truk": tarifPerJam = 10000; break;
        }

        double biaya = durasiParkir * tarifPerJam;

        // Diskon 10% jika parkir lebih dari 5 jam
        if (durasiParkir > 5) {
            biaya = biaya * 0.9;
        }
        this.totalBiaya = biaya;
    }

    public void tampilkanRingkasan() {
        System.out.println("\n---- PARKING SUMMARY ----");
        String jenis = jenisKendaraan.substring(0, 1).toUpperCase() + jenisKendaraan.substring(1).toLowerCase();
        System.out.println("Vehicle Type  : " + jenis);
        System.out.println("Parking Time  : " + durasiParkir + " hour(s)");
        System.out.println("Total Fee     : Rp" + totalBiaya);
    }

    public double getTotalBiaya() { return totalBiaya; }
}