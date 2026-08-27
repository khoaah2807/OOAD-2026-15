package OOAD;

abstract class Animal {
    protected String ten;
    protected String mauLong;

    public Animal(String ten, String mauLong) {
        this.ten = ten;
        this.mauLong = mauLong;
    }

    public String getTen() {
        return ten;
    }

    public String getMauLong() {
        return mauLong;
    }
    public abstract String loaiAnimal();

    public String toString() {
        return loaiAnimal() + " " + ten + " màu " + mauLong;
    }
}
