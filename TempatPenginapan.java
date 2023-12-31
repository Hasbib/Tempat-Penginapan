import java.util.ArrayList;
import java.util.Scanner;

public class TempatPenginapan {

	static ArrayList<Integer> nomer = new ArrayList<>();
	static ArrayList<String> dekorasi = new ArrayList<String>();
	static ArrayList<String> name = new ArrayList<String>();
	static ArrayList<String> room = new ArrayList<String>();
	static ArrayList<Integer> stay = new ArrayList<>();
	static ArrayList<Integer> price = new ArrayList<>();
	static ArrayList<Number> voucer = new ArrayList<>();
	static ArrayList<Number> uang = new ArrayList<>();
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) 
	{
		boolean ulangmenu = true;
		while (ulangmenu) 
		{
			System.out.println();
			System.out.println("===| PROGRAM TEMPAT PENGINAPAN |===");
			System.out.println();
			System.out.println("[1] Disusun");
			System.out.println("[2] Lihat Daftar Kamar");
			System.out.println("[3] Pesan Kamar");
			System.out.println("[4] Tambah Dekorasi");
			System.out.println("[5] Hapus Dekorasi");
			System.out.println("[6] Cetak Tagihan");
			System.out.println("[7] Keluar");
			System.out.print("PILIH MENU> ");
			int pilihmenu = keyboard.nextInt();
			switch (pilihmenu) {
				case 1:
					disusun();
					break;
				case 2:
					lihatdaftarkamar();
					break;
				case 3:
					pesankamar();
					break;
				case 4:
					tambahdekorasi();
					break;
				case 5:
					hapusdekorasi();
					break;
				case 6:
					cetaktagihan();
					break;
				case 7:
					System.out.println("Terimakasih telah menggunakan program ini");
					System.exit(0);
				default:
					System.out.println("Tidak memilih");
			}
		}
	}

	public static void kembalikemenu() 
	{
		System.out.println("Apakah anda ingin kembali ke menu awal? y/n");
		char kembali = keyboard.next().charAt(0);
		if (kembali == 'y' | kembali == 'y') {
		} else {
			System.out.println("Apakah anda ingin keluar dari program ini? y/n");
			char keluar = keyboard.next().charAt(0);
			if (keluar == 'y' | keluar == 'y') {
				System.exit(0);
			}
		}
	}

	public static void disusun() 
	{
		System.out.println();
		System.out.println("-------------| Disusun Oleh |-------------");
		System.out.println();
		System.out.println("==|Fivi Aulia Rahma Anwar	V4522025|==");
		System.out.println("==|Gusnanto Raply Juseptyan	V3422027|==");
		System.out.println("==|Gustia Syafi Sutarno		V3422028|==");
		System.out.println("==|Habib Shohiburrotib		V3422029|==");
		System.out.println();
		kembalikemenu();
	}

	public static void lihatdaftarkamar() 
	{
		System.out.println();
		System.out.println("---------------| Daftar Kamar |---------------");
		System.out.println();
		System.out.println("1. Economi Room			100.000/malam");
		System.out.println("2. Deluxe Room 			150.000/malam");
		System.out.println("3. Standar Room			250.000/malam");
		System.out.println("4. Suite Room			350.000/malam");
		System.out.println("5. Presidential Room		500.000/malam");
		System.out.println();
		kembalikemenu();
	}

	public static void pesankamar() 
	{
		String kamar = "";
		int tarif = 0;
		double diskon = 0;

		System.out.println();
		System.out.println("--------| Pesan Kamar |--------");
		System.out.println();
		System.out.print("Nama Pemesan: ");
		String nama = keyboard.nextLine();
		keyboard.nextLine();
		System.out.print("Jenis Kamar: ");
		int jenis = keyboard.nextInt();
		System.out.print("Lama Menginap: ");
		int lama = keyboard.nextInt();
		System.out.println();
		System.out.println("-----Status Pelanggan-----");
		System.out.println();
		System.out.println("1. Member");
		System.out.println("2. Non Member");
		System.out.print("Pilih Status Pelanggan: ");
		int status = keyboard.nextInt();
		if (jenis == 1) {
			tarif = lama * 100000;
			kamar = "Economi Room";
		} else {
			if (jenis == 2) {
				tarif = lama * 150000;
				kamar = "Standar Room";
			} else {
				if (jenis == 3) {
					tarif = lama * 250000;
					kamar = "Deluxe Room";
				} else {
					if (jenis == 4) {
						tarif = lama * 350000;
						kamar = "Suite Room";
					} else {
						if (jenis == 5) {
							tarif = lama * 500000;
							kamar = "Presidential Room";
						}
					}
				}
			}
		}

		if (status == 1) 
		{
			if (lama >= 1 && lama <= 7) {
				diskon = 0.10 * lama;
			} else if (lama > 7) {
				diskon = 0.30 * lama;
			} else if (status == 2) {
				if (lama > 7) {
					diskon = 0.15 * lama;
				}
			}
		}
		double bayar = tarif - diskon;

		name.add(nama);
		room.add(kamar);
		stay.add(lama);
		price.add(tarif);
		voucer.add(diskon);
		uang.add(bayar);

		System.out.println();
		kembalikemenu();
	}

	public static void tambahdekorasi()
	{
		char ulang;
		System.out.println();
		System.out.println("--------| Tambah Dekorasi |--------");
		do {
			System.out.println("Masukkan Angka: ");
			int angka = keyboard.nextInt();
			nomer.add(angka);
			keyboard.nextLine();
			System.out.println("Dekorasi apa yang ingin ditambahkan? ");
			String tambah = keyboard.nextLine();
			dekorasi.add(tambah);
			System.out.println("Apakah anda ingin menambahkan dekorasi lagi? y/n ");
			ulang = keyboard.next().charAt(0);
		} while (ulang == 'y');
		System.out.println();
		kembalikemenu();
	}

	public static void hapusdekorasi() 
	{
		System.out.println();
		int size = dekorasi.size();
		System.out.println("--------| Hapus Dekorasi |--------");
		for (int i = 0; i < dekorasi.size(); i++) {
			System.out.println("[" + (i + 1) + "] " + dekorasi.get(i));
		}
		System.out.println("Masukkan Nomor yang ingin dihapus");
		int nomor = Integer.valueOf(keyboard.nextInt());
		dekorasi.remove((nomor - 1));
		nomer.remove((nomor - 1));
		if (dekorasi.size() != size) {
			System.out.println("Dekorasi Berhasil Dihapus!");
		} else {
			System.out.println("Dekorasi Tidak Berhasil Dihapus!");
		}
		System.out.println();
		kembalikemenu();
	}

	public static void cetaktagihan() 
	{
		System.out.println();
		System.out.println("===========| Total Tagihan |===========");
		System.out.println();
		System.out.println("Nama Pemesan: " + name);
		System.out.println("Jenis kamar: " + room);
		System.out.println("Lama Menginap: " + stay);
		System.out.println("Dekorasi Tambahan: " + dekorasi);
		System.out.println("Tarif Penginapan: " + price);
		System.out.println("Diskon Penginapan: " + voucer);
		System.out.println("Nominal Yang Harus Dibayar: " + uang);
		System.out.println("======================================");
		System.out.println();
		kembalikemenu();
	}
}