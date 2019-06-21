package android.example.com.imhungry.Model;

public class Food {
    private String name,description,price,discount,menuId,image;

    public Food() {
    }

    public Food(String name, String description, String price, String discount, String menuId, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.menuId = menuId;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
