import java.util.ArrayList;
import java.util.List;

class Program {

  Sale sale;
  Controller controller;

  public void main(String[] args) {
    sale = new Sale();
    controller = new Controller();
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

  class Controller {
    public Item getItem(int id) {

      Product product = null;// InventoryHandler.getProduct(id);

      Item item = sale.getItem(product);
      

      Item newItem = null;

      if (item == null) {
        newItem = new Item(product);
      } 

      if(item != null) {
        item.incrementAmount();
      } 

      if(item == null){
        sale.addItem(newItem);
      }


      return newItem == null ? item : newItem;
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
