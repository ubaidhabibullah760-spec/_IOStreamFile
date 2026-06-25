package bagian3.kontak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator; // Tambahan untuk mempermudah penghapusan aman

public class BukuKontak {
    private ArrayList<Kontak> daftar = new ArrayList<>();
    private String namaBerkas;

    public BukuKontak(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    public void tambahKontak(Kontak kontak) {
        daftar.add(kontak);
    }

    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak ==");
        for (int i = 0; i < daftar.size(); i++) {
            Kontak k = daftar.get(i);
            System.out.println((i + 1) + ". " + k.info());
        }
    }

    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Kontak k : daftar) {
                penulis.println(k.keBaris());
            }
            System.out.println("Kontak disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    // No. 2: Menyesuaikan pemecahan baris menjadi tiga bagian
    public void muatDariBerkas() {
        daftar.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) { // Diubah dari 2 menjadi 3
                    daftar.add(new Kontak(bagian[0], bagian[1], bagian[2])); // Menyertakan bagian[2] sebagai email
                }
            }
            System.out.println("Kontak dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }

    // No. 1: Method cariKontak (Selaras dengan Kunci Jawaban)
    public void cariKontak(String nama) {
        for (Kontak k : daftar) {
            if (k.getNama().equals(nama)) {
                System.out.println("Ditemukan: " + k.info());
                return; // Keluar dari method jika ditemukan
            }
        }
        System.out.println("Kontak " + nama + " tidak ditemukan.");
    }

    // No. 3: Method hapusKontak (Menghapus berdasarkan nama & simpan otomatis)
    public void hapusKontak(String nama) {
        boolean ditemukan = false;
        Iterator<Kontak> iterator = daftar.iterator();
        
        while (iterator.hasNext()) {
            Kontak k = iterator.next();
            if (k.getNama().equals(nama)) {
                iterator.remove(); // Menghapus dari ArrayList secara aman
                ditemukan = true;
                System.out.println("Kontak " + nama + " berhasil dihapus.");
                break; // Hentikan pencarian setelah objek dihapus
            }
        }
        
        if (ditemukan) {
            simpanKeBerkas(); // Perubahan ikut tersimpan ke berkas
        } else {
            System.out.println("Gagal menghapus, kontak " + nama + " tidak ditemukan.");
        }
    }

    public int jumlahKontak() {
        return daftar.size();
    }
}