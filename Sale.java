import java.util.ArrayList;
import java.util.List;

class Program {

  Sale sale;
  Controller controller;
  InventoryHandler inventoryHandler;

  public void main(String[] args) {
    sale = new Sale();
    controller = new Controller();
    inventoryHandler = new InventoryHandler();
  }

  class Item {
    Product product;
    int amount;

    Item(Product product) {
      this.product = product;
      sale.addItem(this);
    }

    public void incrementAmount() {
      this.amount++;
    }
  }

  class View {
    //Make it run 20 times per second on another thread




    public void renderCart(){
      for(Item item : sale.items){
        System.out.println(item.product.name + " " + item.amount);
      }
    }


    public void onScan(int id){
      controller.getItem(id);
      renderCart();
    }
  }


  
  class InventoryHandler{
    public Product getProduct(int id){
      if(id == 1){
        return new Product(1, "Apple", 10);
      }
      if(id == 2){
        return new Product(2, "Banana", 20);
      }
      if(id == 3){
        return new Product(3, "Orange", 30);
      }
      return null;
    }
  }

  class Controller {
    public boolean getItem(int id) {

      Product product = inventoryHandler.getProduct(id);

      if(product == null){
        return false;
      }

      Item item = sale.getItem(product);
      

      Item newItem = null;

      if (item == null) {
        newItem = new Item(product);
        sale.addItem(newItem);
      } 

      if(item != null) {
        item.incrementAmount();
      } 


      return true;
    }

  }

  class Sale{
    List<Item> items = new ArrayList<Item>();
   
   
     public void addItem(Item item){
       items.add(item);
     }
   
     public Item getItem(Product product){
       for(Item item : this.items){
         if(item.product.equals(product)){
           return item;
         }
       }
       return null;
     }
   }

  class Product {
    int id;
    String name;
    int price;

    Product(int id, String name, int price) {
      this.id = id;
      this.name = name;
      this.price = price;
    }
  }
}
