package library

class Perpustakaan {
    private val daftarBuku = mutableListOf<Buku>()
    private val daftarAnggota = mutableListOf<Anggota>()
    private val daftarPeminjaman = mutableListOf<Peminjaman>()

    fun tambahBuku(buku: Buku) {
        daftarBuku.add(buku)
        println("Buku '${buku.judul}' telah ditambahkan.")
    }

    fun hapusBuku(id: Int) {
        val buku = daftarBuku.find { it.id == id }
        if (buku != null) {
            daftarBuku.remove(buku)
            println("Buku '${buku.judul}' telah dihapus.")
        } else {
            println("Buku dengan ID $id tidak ditemukan.")
        }
    }//rio

    fun lihatDaftarBuku() {
        if (daftarBuku.isNotEmpty()) {
            println("Daftar Buku:")
            daftarBuku.forEach { println("ID: ${it.id}, Judul: ${it.judul}, Penulis: ${it.penulis}") }
        } else {
            println("Tidak ada buku dalam daftar.")
        }
    }

    fun tambahAnggota(anggota: Anggota) {
        daftarAnggota.add(anggota)
        println("Anggota '${anggota.nama}' telah ditambahkan.")
    }//vivi

    fun hapusAnggota(id: Int) {
        val anggota = daftarAnggota.find { it.id == id }//untuk mencari anggota dalam daftar anggota yang memiliki id yang sama dengan parameter yang diberikan
        if (anggota != null) {
            daftarAnggota.remove(anggota)
            println("Anggota '${anggota.nama}' telah dihapus.")
        } else {
            println("Anggota dengan ID $id tidak ditemukan.")
        }
    }

    fun lihatDaftarAnggota() {
        if (daftarAnggota.size>0) {//dengan memeriksa ukuran dari daftar anggota
            println("Daftar Anggota:")
            daftarAnggota.forEach { println("ID: ${it.id}, Nama: ${it.nama}, Alamat: ${it.alamat}") }
        } else {
            println("Tidak ada anggota dalam daftar.")
        }
    }//aida

    fun pinjamBuku(bukuId: Int, anggotaId: Int, tanggalPinjam: String) {
        val buku = daftarBuku.find { it.id == bukuId }
        val anggota = daftarAnggota.find { it.id == anggotaId }
        if (buku != null && anggota != null) {
            val peminjaman = Peminjaman(buku, anggota, tanggalPinjam)
            daftarPeminjaman.add(peminjaman)
            println("Buku '${buku.judul}' dipinjam oleh anggota '${anggota.nama}' pada tanggal $tanggalPinjam.")
        } else {
            println("Buku atau Anggota tidak ditemukan.")
        }
    }

    fun kembalikanBuku(bukuId: Int, anggotaId: Int) {
        val peminjaman = daftarPeminjaman.find { it.buku.id == bukuId && it.anggota.id == anggotaId }
        if (peminjaman != null) {
            daftarPeminjaman.remove(peminjaman)
            println("Buku '${peminjaman.buku.judul}' telah dikembalikan oleh anggota '${peminjaman.anggota.nama}'.")
        } else {
            println("Peminjaman tidak ditemukan.")
        }
    }

    fun lihatDaftarPeminjaman() {
        if (daftarPeminjaman.size>0) {
            println("Daftar Peminjaman:")
            daftarPeminjaman.forEach {
                println("Buku: ${it.buku.judul}, Dipinjam oleh: ${it.anggota.nama}, Tanggal Pinjam: ${it.tanggalPinjam}")
            }
        } else {
            println("Tidak ada peminjaman dalam daftar.")
        }
    }
}