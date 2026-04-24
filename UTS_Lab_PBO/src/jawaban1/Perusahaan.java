package jawaban1;
import java.util.ArrayList;

public class Perusahaan {
    private ArrayList<Karyawan> daftarKaryawan;

    public Perusahaan() {
        daftarKaryawan = new ArrayList<>();
    }

    public void tambahKaryawan(Karyawan karyawan) {
        if (cariKaryawanBerdasarkanId(karyawan.getId()) != null) {
            System.out.println("Gagal: ID Karyawan sudah terdaftar.");
            return;
        }
        if (karyawan.getGaji() < 0) {
            System.out.println("Gagal: Gaji tidak boleh negatif.");
            return;
        }
        daftarKaryawan.add(karyawan);
        System.out.println("Karyawan berhasil ditambahkan.");
    }

    public void hapusKaryawan(String id) {
        Karyawan target = cariKaryawanBerdasarkanId(id);
        if (target != null) {
            daftarKaryawan.remove(target);
            System.out.println("Karyawan berhasil dihapus.");
        } else {
            System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
        }
    }

    public void ubahPosisi(String id, String posisiBaru) {
        Karyawan target = cariKaryawanBerdasarkanId(id);
        if (target != null) {
            target.setPosisi(posisiBaru);
            System.out.println("Posisi berhasil diubah.");
        } else {
            System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
        }
    }

    public void ubahGaji(String id, double gajiBaru) {
        if (gajiBaru < 0) {
            System.out.println("Gagal: Gaji tidak boleh negatif.");
            return;
        }
        Karyawan target = cariKaryawanBerdasarkanId(id);
        if (target != null) {
            target.setGaji(gajiBaru);
            System.out.println("Gaji berhasil diubah.");
        } else {
            System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
        }
    }

    public void tampilkanSemua() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Belum ada data karyawan.");
        } else {
            for (Karyawan k : daftarKaryawan) {
                System.out.println(k.toString());
            }
        }
    }

    // Metode internal untuk mencari referensi objek karyawan
    private Karyawan cariKaryawanBerdasarkanId(String id) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equals(id)) {
                return k;
            }
        }
        return null;
    }
}