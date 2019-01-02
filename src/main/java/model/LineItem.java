package model;

public class LineItem {


    Product product;
    int quantity;

    public LineItem(Product aProduct, int aQuantity)
    {
        product = aProduct;
        quantity = aQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
