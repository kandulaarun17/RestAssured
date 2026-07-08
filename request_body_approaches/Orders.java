package request_body_approaches;

public class Orders {
	private int OrderId;
	private String name;
	private String location;

	public void setOrderId(int OrderId) {
		this.OrderId = OrderId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getOrderId() {
		return OrderId;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}
}
