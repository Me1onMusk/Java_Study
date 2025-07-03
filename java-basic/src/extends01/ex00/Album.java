package extends01.ex00;

public class Album extends Item{

    private String artist;

    // 생성자 //
    public Album(String name, int price, String artist) {
        super(name, price);
        this.artist = artist;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("- 아티스트: " + artist);
    }

    public int getPrice() {
        return super.getPrice();
    }
}
