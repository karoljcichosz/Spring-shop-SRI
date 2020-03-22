package pl.karolcichosz.sri.dto;

import java.io.Serializable;

import pl.karolcichosz.sri.model.Product;

public class OrderItem implements Serializable {
	private Product product;
	private Integer amount;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
