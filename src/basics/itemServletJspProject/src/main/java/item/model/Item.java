package item.model;

public class Item {
	private Long id;
    private String name;
    private double price;
    private int totalNumber;
    private int deleted;
    private ItemDetails itemDetails;
    
    
    

	public Item() {
    	
    }
    
    public Item( String name, double price, int totalNumber) {
		super();
		this.name = name;
		this.price = price;
		this.totalNumber = totalNumber;
	}
    
	public Item(Long id, String name, double price, int totalNumber) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.totalNumber = totalNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	
	public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
    
    public ItemDetails getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(ItemDetails itemDetails) {
		this.itemDetails = itemDetails;
	}

    

}
