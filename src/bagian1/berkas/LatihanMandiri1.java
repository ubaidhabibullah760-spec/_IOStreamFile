package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiri1 {
    public static void main(String[] args) {
        
        System.out.println("=== JAWABAN NO. 1 ===");
        // 1. Buat objek File yang menunjuk laporan.txt
        File berkasLaporan = new File("laporan.txt");
        if (berkasLaporan.exists()) {
            System.out.println("Berkas ada, ukuran: " + berkasLaporan.length() + " byte");
        } else {
            System.out.println("Berkas laporan.txt tidak ditemukan.");
        }
        
        System.out.println("\n=== JAWABAN NO. 2 ===");
        // 2. Buat sebuah folder baru bernama arsip menggunakan method mkdir()
        File folderArsip = new File("arsip");
        if (folderArsip.mkdir()) {
            System.out.println("Pesan: Folder 'arsip' berhasil dibuat.");
        } else {
            System.out.println("Pesan: Folder 'arsip' gagal dibuat (atau sudah ada sebelumnya).");
        }
        
        System.out.println("\n=== JAWABAN NO. 3 ===");
        // 3. Buat objek File sementara.txt, buat berkasnya, lalu hapus kembali
        File berkasSementara = new File("sementara.txt");
        try {
            berkasSementara.createNewFile();
            System.out.println("Sebelum dihapus, ada? " + berkasSementara.exists());
            
            berkasSementara.delete();
            System.out.println("Sesudah dihapus, ada? " + berkasSementara.exists());
        } catch (IOException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }
    }
}