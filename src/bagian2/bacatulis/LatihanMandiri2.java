package bagian2.bacatulis;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LatihanMandiri2 {
    public static void main(String[] args) {
        
        System.out.println("=== JAWABAN NO. 1 (Tulis lalu baca nama hari) ===");
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        
        // Menulis 5 hari pertama
        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt"))) {
            for (String h : hari) {
                penulis.println(h);
            }
        } catch (IOException e) {
            System.out.println("Gagal menulis: " + e.getMessage());
        }
        
        // Membaca dan menampilkan ke layar
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }

        System.out.println("\n=== JAWABAN NO. 2 (Append 2 hari & tampilkan seluruhnya) ===");
        // Menambahkan (append) Sabtu dan Minggu
        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt", true))) {
            penulis.println("Sabtu");
            penulis.println("Minggu");
        } catch (IOException e) {
            System.out.println("Gagal menambah data: " + e.getMessage());
        }

        // Membaca kembali seluruh isi berkas setelah di-append
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }

        System.out.println("\n=== JAWABAN NO. 3 (Hitung jumlah baris) ===");
        int jumlah = 0;
        
        // Menghitung jumlah baris yang ada di dalam berkas hari.txt
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            while (pembaca.readLine() != null) {
                jumlah++;
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }
        System.out.println("Jumlah baris: " + jumlah);
    }
}