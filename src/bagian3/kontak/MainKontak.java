package bagian3.kontak;

public class MainKontak {
    public static void main(String[] args) {
        // Membuat objek pengelola dan mengisinya (ditambahkan parameter email)
        BukuKontak buku = new BukuKontak("kontak.txt");
        buku.tambahKontak(new Kontak("Andi", "0811111", "andi@email.com"));
        buku.tambahKontak(new Kontak("Budi", "0822222", "budi@email.com"));
        buku.tambahKontak(new Kontak("Citra", "0833333", "citra@email.com"));

        buku.tampilkanSemua();
        buku.simpanKeBerkas();

        System.out.println();

        // --- UJI COBA METHOD BARU ---
        
        System.out.println("=== Pengujian cariKontak ===");
        buku.cariKontak("Budi"); // Sesuai contoh kunci jawaban
        buku.cariKontak("Dedi"); // Contoh uji coba jika tidak ada
        
        System.out.println();
        
        System.out.println("=== Pengujian hapusKontak ===");
        buku.hapusKontak("Budi"); // Menghapus kontak "Budi"
        
        System.out.println();

        // Objek baru yang kosong, lalu memuat dari berkas untuk membuktikan perubahan tersimpan
        BukuKontak bukuLain = new BukuKontak("kontak.txt");
        bukuLain.muatDariBerkas(); // Memuat isi berkas dengan format 3 kolom baru
        bukuLain.tampilkanSemua();
        System.out.println("Jumlah kontak setelah dihapus: " + bukuLain.jumlahKontak()); // Output harusnya sisa 2
    }
}