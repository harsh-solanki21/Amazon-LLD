package Ecommerce;

import java.util.ArrayList;

public class Amazon {

    public ProductsCatalog productsCatalog;

    public Amazon() {
        productsCatalog = new ProductsCatalog();
    }

    public static void main(String[] args) {
        // -------Data generation code ---- START ------------------------------//

        // Creating Customer --> Harsh
        Customer Harsh = new Customer("Harsh Solanki","9876543201");

        // Creating Seller --> Daily Needs Groceries
        Seller dailyNeedsGrocery = new Seller("Daily Needs Groceries","9876543210");

        // Creating Seller --> Fashion Point
        Seller fashionPoint = new Seller("Fashion Point","9988776655");

        // Creating Seller --> Digi Electronics
        Seller digiElectronics = new Seller("Digi Electronics","9876598765");

        // Creating category --> Electronics
        Category electronics = new Category("Electronics");

        // Creating category --> Cosmetics
        Category cosmetics = new Category("Cosmetics");

        // Creating category --> Grocery
        Category grocery = new Category("Groceries");

        // Creating category --> Clothing
        Category clothing = new Category("Clothing");

        // -------Data generation code ---- END ------------------------------//

        Amazon ec = new Amazon();

        // Adding all the categories to Flipkart catalog
        ec.productsCatalog.addCategory(clothing);
        ec.productsCatalog.addCategory(grocery);
        ec.productsCatalog.addCategory(cosmetics);
        ec.productsCatalog.addCategory(electronics);

        // Seller Digi Electronics adding Mobile to ec catalog
        digiElectronics.registerProduct(ec.productsCatalog,
                new Product("Mobile","Latest Technology",10000.00,electronics,5));

        // Seller Digi Electronics adding Camera to ec catalog
        digiElectronics.registerProduct(ec.productsCatalog, //
                new Product("Camera","Advanced Technology",50000.00,electronics,10));

        // Seller FashionPoint adding Wearbles to ec catalog
        fashionPoint.registerProduct(ec.productsCatalog, //
                new Product("Mens Jackets","XL - Size",1000.00,clothing,10));

        fashionPoint.registerProduct(ec.productsCatalog, //
                new Product("Jackets","XL - Size",1000.00,clothing,10));

        // Seller FashionPoint adding Cosmetics to ec catalog
        fashionPoint.registerProduct(ec.productsCatalog, //
                new Product("Nail Paint","Red Color",500.00,cosmetics,25));

        // Seller dailyNeedsGrocery adding grocery to ec catalog
        dailyNeedsGrocery.registerProduct(ec.productsCatalog, //
                new Product("Sugar","Fine quality",40.00,grocery,1000));

        // Seller dailyNeedsGrocery adding grocery to ec catalog
        dailyNeedsGrocery.registerProduct(ec.productsCatalog, //
                new Product("Milk","100% Pure",50.00,grocery,250));

        dailyNeedsGrocery.registerProduct(ec.productsCatalog, //
                new Product("Toned Milk","Hygenic and Pure",45.00,grocery,250));

        dailyNeedsGrocery.registerProduct(ec.productsCatalog, //
                new Product("Milk Cream","Natural",145.00,grocery,100));


        // Customer searching for product --> milk
        ArrayList<Product> milkResults = ec.productsCatalog.searchProduct("Milk");
        //System.out.println(milkResults);

        // Customer searching for all the products in grocery
        ArrayList<Product> groceryProducts = ec.productsCatalog.searchCategory("Groceries");
        //System.out.println(groceryProducts);

        // Customer adding 10 packets of milk to cart
        Item milkTenPackets = new Item(milkResults.get(0),10);
        Harsh.addItemToCart(milkTenPackets);

        // Printing current cart status
        Harsh.printCartItems();

        // Customer searching for another product --> camera
        ArrayList<Product> cameraResults = ec.productsCatalog.searchProduct("CaMeRa");
        //System.out.println(cameraResults);

        // Customer adding 1 camera to cart
        Item oneCamera = new Item(cameraResults.get(0),1);
        Harsh.addItemToCart(oneCamera);

        // Printing current cart status
        Harsh.printCartItems();

        // Customer updating quantity of milk packets from 10 to 15
        Harsh.updateItemCount(milkTenPackets,15);

        // Printing current cart status
        Harsh.printCartItems();

        // Customer placing the order
        Harsh.placeOrder();

        // Customer cart is empty after checkout
        Harsh.printCartItems();

        // Printing the current Order of customer
        System.out.println(Harsh.getCurrentOrder());

        // Customer order is moved to shipment
        Shipment s = Harsh.getCurrentOrder().moveToShipment();

        // Printing the shipment details
        System.out.println(s);


    }

}
