package main

import library.Buku
import library.Anggota
import library.Perpustakaan

fun main() {
    val perpustakaan = Perpustakaan()

    while (true) {
        println("\n==== Menu Perpustakaan ====")
        println("1. Tambah Buku")
        println("2. Hapus Buku")
        println("3. Lihat Daftar Buku")
        println("4. Tambah Anggota")
        println("5. Hapus Anggota")
        println("6. Lihat Daftar Anggota")
        println("7. Pinjam Buku")
        println("8. Kembalikan Buku")
        println("9. Lihat Daftar Peminjaman")
        println("0. Keluar")
        print("Pilih menu: ")

        val pilihan = readLine()?.toIntOrNull()

        when (pilihan) {
            1 -> {
                print("Masukkan ID Buku: ")
                val id = readLine()?.toIntOrNull() ?: 0
                print("Masukkan Judul Buku: ")
                val judul = readLine() ?: ""
                print("Masukkan Penulis Buku: ")
                val penulis = readLine() ?: ""
                perpustakaan.tambahBuku(Buku(id, judul, penulis))
            }
            2 -> {
                print("Masukkan ID Buku yang akan dihapus: ")
                val id = readLine()?.toIntOrNull() ?: 0
                perpustakaan.hapusBuku(id)
            }
            3 -> {
                perpustakaan.lihatDaftarBuku()
            }
            4 -> {
                print("Masukkan ID Anggota: ")
                val id = readLine()?.toIntOrNull() ?: 0
                print("Masukkan Nama Anggota: ")
                val nama = readLine() ?: ""
                print("Masukkan Alamat Anggota: ")
                val alamat = readLine() ?: ""
                perpustakaan.tambahAnggota(Anggota(id, nama, alamat))
            }
            5 -> {
                print("Masukkan ID Anggota yang akan dihapus: ")
                val id = readLine()?.toIntOrNull() ?: 0
                perpustakaan.hapusAnggota(id)
            }
            6 -> {
                perpustakaan.lihatDaftarAnggota()
            }
            7 -> {
                print("Masukkan ID Buku yang akan dipinjam: ")
                val bukuId = readLine()?.toIntOrNull() ?: 0
                print("Masukkan ID Anggota yang meminjam: ")
                val anggotaId = readLine()?.toIntOrNull() ?: 0
                print("Masukkan Tanggal Pinjam (YYYY-MM-DD): ")
                val tanggalPinjam = readLine() ?: ""
                perpustakaan.pinjamBuku(bukuId, anggotaId, tanggalPinjam)
            }
            8 -> {
                print("Masukkan ID Buku yang akan dikembalikan: ")
                val bukuId = readLine()?.toIntOrNull() ?: 0
                print("Masukkan ID Anggota yang mengembalikan: ")
                val anggotaId = readLine()?.toIntOrNull() ?: 0
                perpustakaan.kembalikanBuku(bukuId, anggotaId)
            }
            9 -> {
                perpustakaan.lihatDaftarPeminjaman()
            }
            0 -> {
                println("Terima kasih! Sampai jumpa lagi.")
                break
            }
            else -> {
                println("Pilihan tidak valid. Silakan coba lagi.")
            }
        }
    }
}