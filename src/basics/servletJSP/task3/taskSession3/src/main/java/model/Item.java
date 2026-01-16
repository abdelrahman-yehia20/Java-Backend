package model;

public class Item {
	
	private int id;
    private String name;
    private int price;
    private double totalNumber;

    // 1️⃣ No-argument constructor (REQUIRED for ResultSet mapping)
    public Item() {
    }

    // 2️⃣ Parameterized constructor
    public Item(int id, String name, int price, double totalNumber) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalNumber = totalNumber;
    }

    // 3️⃣ Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(double totalNumber) {
        this.totalNumber = totalNumber;
    }

}
