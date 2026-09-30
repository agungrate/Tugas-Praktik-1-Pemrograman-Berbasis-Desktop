import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // =========================
        // DATA MENU
        // =========================

        Menu[] daftarMenu = new Menu[8];

        daftarMenu[0] = new Menu();
        daftarMenu[0].nama = "Nasi Padang";
        daftarMenu[0].harga = 25000;
        daftarMenu[0].kategori = "Makanan";

        daftarMenu[1] = new Menu();
        daftarMenu[1].nama = "Nasi Goreng";
        daftarMenu[1].harga = 20000;
        daftarMenu[1].kategori = "Makanan";

        daftarMenu[2] = new Menu();
        daftarMenu[2].nama = "Mie Ayam";
        daftarMenu[2].harga = 18000;
        daftarMenu[2].kategori = "Makanan";

        daftarMenu[3] = new Menu();
        daftarMenu[3].nama = "Ayam Bakar";
        daftarMenu[3].harga = 30000;
        daftarMenu[3].kategori = "Makanan";

        daftarMenu[4] = new Menu();
        daftarMenu[4].nama = "Es Teh";
        daftarMenu[4].harga = 5000;
        daftarMenu[4].kategori = "Minuman";

        daftarMenu[5] = new Menu();
        daftarMenu[5].nama = "Es Jeruk";
        daftarMenu[5].harga = 8000;
        daftarMenu[5].kategori = "Minuman";

        daftarMenu[6] = new Menu();
        daftarMenu[6].nama = "Kopi";
        daftarMenu[6].harga = 10000;
        daftarMenu[6].kategori = "Minuman";

        daftarMenu[7] = new Menu();
        daftarMenu[7].nama = "Jus Alpukat";
        daftarMenu[7].harga = 15000;
        daftarMenu[7].kategori = "Minuman";


        // =========================
        // TAMPILKAN MENU
        // =========================

        tampilkanMenu(daftarMenu);


        // =========================
        // VARIABEL PESANAN
        // =========================

        String pesanan1;
        String pesanan2 = "";
        String pesanan3 = "";
        String pesanan4 = "";

        int jumlah1;
        int jumlah2 = 0;
        int jumlah3 = 0;
        int jumlah4 = 0;

        int harga1 = 0;
        int harga2 = 0;
        int harga3 = 0;
        int harga4 = 0;

        int subtotal1;
        int subtotal2 = 0;
        int subtotal3 = 0;
        int subtotal4 = 0;


        // =========================
        // PESANAN 1
        // =========================

        System.out.println();
        System.out.print("Masukkan nama menu yang ingin dipesan: ");
        pesanan1 = input.nextLine();

        System.out.print("Masukkan jumlah: ");
        jumlah1 = input.nextInt();

        harga1 = cariHarga(pesanan1, daftarMenu);

        subtotal1 = harga1 * jumlah1;


        // =========================
        // PESANAN 2
        // =========================

        input.nextLine();

        System.out.print("Apakah ingin menambah pesanan? (y/n): ");
        String tambahPesanan = input.nextLine();

        if (tambahPesanan.equalsIgnoreCase("y")) {

            System.out.print("Masukkan nama menu yang ingin dipesan: ");
            pesanan2 = input.nextLine();

            harga2 = cariHarga(pesanan2, daftarMenu);

            System.out.print("Masukkan jumlah: ");
            jumlah2 = input.nextInt();

            subtotal2 = harga2 * jumlah2;


            // =========================
            // PESANAN 3
            // =========================

            input.nextLine();

            System.out.print("Apakah ingin menambah pesanan? (y/n): ");
            String tambahPesanan3 = input.nextLine();

            if (tambahPesanan3.equalsIgnoreCase("y")) {

                System.out.print("Masukkan nama menu yang ingin dipesan: ");
                pesanan3 = input.nextLine();

                harga3 = cariHarga(pesanan3, daftarMenu);

                System.out.print("Masukkan jumlah: ");
                jumlah3 = input.nextInt();

                subtotal3 = harga3 * jumlah3;


                // =========================
                // PESANAN 4
                // =========================

                input.nextLine();

                System.out.print("Apakah ingin menambah pesanan? (y/n): ");
                String tambahPesanan4 = input.nextLine();

                if (tambahPesanan4.equalsIgnoreCase("y")) {

                    System.out.print("Masukkan nama menu yang ingin dipesan: ");
                    pesanan4 = input.nextLine();

                    harga4 = cariHarga(pesanan4, daftarMenu);

                    System.out.print("Masukkan jumlah: ");
                    jumlah4 = input.nextInt();

                    subtotal4 = harga4 * jumlah4;
                }
            }
        }


        // =========================
        // HITUNG TOTAL
        // =========================

        int totalPesanan = hitungTotal(
                subtotal1,
                subtotal2,
                subtotal3,
                subtotal4
        );

        int totalSebelumPromo = totalPesanan;


        // =========================
        // PROMO BUY ONE GET ONE
        // =========================

        int jumlahGratis = 0;
        String namaPromo = "";

        if (totalPesanan > 50000) {

            if (pesanan1.equals("Es Teh") && jumlah1 >= 2) {

                jumlahGratis = 1;
                namaPromo = "Es Teh";

            } else if (pesanan2.equals("Es Teh") && jumlah2 >= 2) {

                jumlahGratis = 1;
                namaPromo = "Es Teh";

            } else if (pesanan3.equals("Es Teh") && jumlah3 >= 2) {

                jumlahGratis = 1;
                namaPromo = "Es Teh";

            } else if (pesanan4.equals("Es Teh") && jumlah4 >= 2) {

                jumlahGratis = 1;
                namaPromo = "Es Teh";
            }


            if (jumlahGratis > 0) {

                totalPesanan =
                        totalPesanan - daftarMenu[4].harga;
            }
        }


        // =========================
        // DISKON
        // =========================

        int diskon = 0;

        if (totalPesanan > 100000) {

            diskon = totalPesanan * 10 / 100;
        }

        int totalSetelahDiskon =
                totalPesanan - diskon;


        // =========================
        // PAJAK DAN PELAYANAN
        // =========================

        int pajak =
                totalSetelahDiskon * 10 / 100;

        int biayaPelayanan = 20000;

        int totalAkhir =
                totalSetelahDiskon
                + pajak
                + biayaPelayanan;


        // =========================
        // CETAK STRUK
        // =========================

        cetakStruk(
                pesanan1,
                jumlah1,
                harga1,
                subtotal1,

                pesanan2,
                jumlah2,
                harga2,
                subtotal2,

                pesanan3,
                jumlah3,
                harga3,
                subtotal3,

                pesanan4,
                jumlah4,
                harga4,
                subtotal4,

                totalSebelumPromo,
                totalPesanan,
                jumlahGratis,
                namaPromo,
                diskon,
                totalSetelahDiskon,
                pajak,
                biayaPelayanan,
                totalAkhir
        );

        input.close();
    }


    // =========================
    // METHOD TAMPILKAN MENU
    // =========================

    static void tampilkanMenu(Menu[] daftarMenu) {

        System.out.println("================================");
        System.out.println("       DAFTAR MENU RESTORAN");
        System.out.println("================================");

        System.out.println();
        System.out.println("=== MENU MAKANAN ===");

        System.out.println(
                "1. " + daftarMenu[0].nama
                + " - Rp" + daftarMenu[0].harga
        );

        System.out.println(
                "2. " + daftarMenu[1].nama
                + " - Rp" + daftarMenu[1].harga
        );

        System.out.println(
                "3. " + daftarMenu[2].nama
                + " - Rp" + daftarMenu[2].harga
        );

        System.out.println(
                "4. " + daftarMenu[3].nama
                + " - Rp" + daftarMenu[3].harga
        );


        System.out.println();
        System.out.println("=== MENU MINUMAN ===");

        System.out.println(
                "5. " + daftarMenu[4].nama
                + " - Rp" + daftarMenu[4].harga
        );

        System.out.println(
                "6. " + daftarMenu[5].nama
                + " - Rp" + daftarMenu[5].harga
        );

        System.out.println(
                "7. " + daftarMenu[6].nama
                + " - Rp" + daftarMenu[6].harga
        );

        System.out.println(
                "8. " + daftarMenu[7].nama
                + " - Rp" + daftarMenu[7].harga
        );
    }


    // =========================
    // METHOD MENCARI HARGA
    // =========================

    static int cariHarga(
            String namaMenu,
            Menu[] daftarMenu) {

        int harga = 0;

        if (namaMenu.equals(daftarMenu[0].nama)) {

            harga = daftarMenu[0].harga;

        } else if (namaMenu.equals(daftarMenu[1].nama)) {

            harga = daftarMenu[1].harga;

        } else if (namaMenu.equals(daftarMenu[2].nama)) {

            harga = daftarMenu[2].harga;

        } else if (namaMenu.equals(daftarMenu[3].nama)) {

            harga = daftarMenu[3].harga;

        } else if (namaMenu.equals(daftarMenu[4].nama)) {

            harga = daftarMenu[4].harga;

        } else if (namaMenu.equals(daftarMenu[5].nama)) {

            harga = daftarMenu[5].harga;

        } else if (namaMenu.equals(daftarMenu[6].nama)) {

            harga = daftarMenu[6].harga;

        } else if (namaMenu.equals(daftarMenu[7].nama)) {

            harga = daftarMenu[7].harga;

        } else {

            System.out.println("Menu tidak ditemukan.");
        }

        return harga;
    }


    // =========================
    // METHOD HITUNG TOTAL
    // =========================

    static int hitungTotal(
            int subtotal1,
            int subtotal2,
            int subtotal3,
            int subtotal4) {

        return subtotal1
                + subtotal2
                + subtotal3
                + subtotal4;
    }


    // =========================
    // METHOD SWITCH-CASE
    // =========================

    static String cekKategori(String namaMenu) {

        switch (namaMenu) {

            case "Nasi Padang":
            case "Nasi Goreng":
            case "Mie Ayam":
            case "Ayam Bakar":
                return "Makanan";

            case "Es Teh":
            case "Es Jeruk":
            case "Kopi":
            case "Jus Alpukat":
                return "Minuman";

            default:
                return "Tidak diketahui";
        }
    }


    // =========================
    // METHOD CETAK STRUK
    // =========================

    static void cetakStruk(
            String pesanan1,
            int jumlah1,
            int harga1,
            int subtotal1,

            String pesanan2,
            int jumlah2,
            int harga2,
            int subtotal2,

            String pesanan3,
            int jumlah3,
            int harga3,
            int subtotal3,

            String pesanan4,
            int jumlah4,
            int harga4,
            int subtotal4,

            int totalSebelumPromo,
            int totalPesanan,
            int jumlahGratis,
            String namaPromo,
            int diskon,
            int totalSetelahDiskon,
            int pajak,
            int biayaPelayanan,
            int totalAkhir) {


        System.out.println();
        System.out.println("================================");
        System.out.println("             STRUK");
        System.out.println("================================");


        // PESANAN 1

        System.out.println();
        System.out.println("Pesanan 1 : " + pesanan1);
        System.out.println(
                "Kategori  : " + cekKategori(pesanan1)
        );
        System.out.println("Jumlah    : " + jumlah1);
        System.out.println("Harga     : Rp" + harga1);
        System.out.println("Subtotal  : Rp" + subtotal1);


        // PESANAN 2

        if (!pesanan2.equals("")) {

            System.out.println();
            System.out.println("Pesanan 2 : " + pesanan2);
            System.out.println(
                    "Kategori  : " + cekKategori(pesanan2)
            );
            System.out.println("Jumlah    : " + jumlah2);
            System.out.println("Harga     : Rp" + harga2);
            System.out.println("Subtotal  : Rp" + subtotal2);
        }


        // PESANAN 3

        if (!pesanan3.equals("")) {

            System.out.println();
            System.out.println("Pesanan 3 : " + pesanan3);
            System.out.println(
                    "Kategori  : " + cekKategori(pesanan3)
            );
            System.out.println("Jumlah    : " + jumlah3);
            System.out.println("Harga     : Rp" + harga3);
            System.out.println("Subtotal  : Rp" + subtotal3);
        }


        // PESANAN 4

        if (!pesanan4.equals("")) {

            System.out.println();
            System.out.println("Pesanan 4 : " + pesanan4);
            System.out.println(
                    "Kategori  : " + cekKategori(pesanan4)
            );
            System.out.println("Jumlah    : " + jumlah4);
            System.out.println("Harga     : Rp" + harga4);
            System.out.println("Subtotal  : Rp" + subtotal4);
        }


        // RINGKASAN BIAYA

        System.out.println();
        System.out.println("--------------------------------");
        System.out.println(
                "Total sebelum promo : Rp"
                + totalSebelumPromo
        );


        if (jumlahGratis > 0) {

            System.out.println(
                    "Promo : Beli 1 Gratis 1 "
                    + namaPromo
            );

            System.out.println(
                    "Jumlah gratis : "
                    + jumlahGratis
            );

        } else {

            System.out.println("Promo : Tidak ada");
        }


        System.out.println(
                "Total setelah promo : Rp"
                + totalPesanan
        );

        System.out.println(
                "Diskon 10% : Rp"
                + diskon
        );

        System.out.println(
                "Total setelah diskon : Rp"
                + totalSetelahDiskon
        );

        System.out.println(
                "Pajak 10% : Rp"
                + pajak
        );

        System.out.println(
                "Biaya pelayanan : Rp"
                + biayaPelayanan
        );

        System.out.println("--------------------------------");

        System.out.println(
                "TOTAL AKHIR : Rp"
                + totalAkhir
        );

        System.out.println("================================");
    }
}