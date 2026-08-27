package OOAD;

import java.util.Random;

public class AppMain {
    public static void main(String[] args) {
        String[] danhSachTen = {"Tom", "Jerry", "Milu", "Kitty", "Aka", "Bickey", "Lucky", "Mun", "Zin", "Zip"};
        String[] danhSachMau = {"xám", "trắng", "đen", "vàng", "nâu"};

        Random rand = new Random();
        Animal[] dsConVat = new Animal[10];
        for (int i = 0; i < 10; i++) {
            String ten = danhSachTen[rand.nextInt(danhSachTen.length)];
            String mau = danhSachMau[rand.nextInt(danhSachMau.length)];

            if (rand.nextBoolean()) {
                dsConVat[i] = new Cat(ten, mau);
            } else {
                dsConVat[i] = new Dog(ten, mau);
            }
        }
        for (int i = 0; i < dsConVat.length; i++) {
            System.out.println((i + 1) + ". " + dsConVat[i]);
        }
    }
}


