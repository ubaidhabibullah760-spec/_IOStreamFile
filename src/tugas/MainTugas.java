// Nama: [Isi Nama Anda di Sini]
// NPM:  [Isi NPM Anda di Sini]

package tugas;

public class MainTugas {
    public static void main(String[] args) {
        
        // 1. Menyimpan dan menampilkan daftar nama kategori (Array String ukuran tetap)
        System.out.println("=== KATEGORI TOKO ===");
        String[] kategori = {"Elektronik", "Pakaian", "Makanan & Minuman"};
        for (String k : kategori) {
            System.out.println("- " + k);
        }
        System.out.println();

        // 2. Membuat objek Gudang pertama dan menambah minimal 5 barang
        Gudang gudangUtama = new Gudang("barang.txt");
        
        gudangUtama.tambahBarang(new Barang("Laptop", 8500000, 10));
        gudangUtama.tambahBarang(new Barang("Mouse Wireless", 150000, 25));
        gudangUtama.tambahBarang(new Barang("Keyboard Mekanik", 450000, 15));
        gudangUtama.tambahBarang(new Barang("Monitor 24 Inch", 1750000, 8));
        gudangUtama.tambahBarang(new Barang("Headset Gaming", 350000, 12));

        // Menampilkan kondisi awal dan menyimpannya ke berkas teks
        gudangUtama.tampilkanSemua();
        gudangUtama.simpanKeBerkas();
        System.out.println();

        // 3. Membuat objek Gudang baru untuk pembuktian data tersimpan
        System.out.println("=== PENGUJIAN INSTANSI GUDANG BARU ===");
        Gudang gudangSerep = new Gudang("barang.txt");
        
        // Memuat berkas, menampilkan list, dan menghitung total nilai aset barang
        gudangSerep.muatDariBerkas();
        gudangSerep.tampilkanSemua();
        System.out.println("Total Nilai Persediaan Barang: Rp" + gudangSerep.totalNilai());
    }
}