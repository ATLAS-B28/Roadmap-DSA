'''
. E-commerce Discount System
Create a class Product:
•	Instance variables: product_name, price
•	Class variable: discount_rate = 0.1 (10% discount on all products)
•	Methods:
1.	Constructor to initialize product details.
2.	final_price() → returns price after applying discount.
3.	A static method calculate_shipping(weight):
	Weight < 5 kg → shipping cost ₹50
	Weight ≥ 5 kg → shipping cost ₹100
Task:
•	Create 3 products and display their final price and shipping costs for given weights.
Make it menu driven later
'''
class Ecom:
    id = None
    product_name = None
    price = None
    weight = None
    discount_rate = 0.1 #10% of the price on all products
    #discount_rate = None
    __product_code = None

    def __init__(self, id, product_name, price, weight):
        self.id = id
        self.product_name = product_name
        self.price = price
        self.weight = weight
        self.__product_code = abs(hash(product_name))

    def final_price(self, shipping_price):#price - (10% * price) 
        discounted_price = self.price - (self.price * self.discount_rate)
        return round(discounted_price + shipping_price, 2)
    
    def __product_code_display(self):
        return f"Product code of {self.product_name}: {self.__product_code}"

    @staticmethod
    def calculate_shipping(weight):
        if weight < 5:
            return 50
        elif weight >= 5:
            return 100
        
    def __str__(self):
        return f"Product Name: {self.product_name}, Price: ₹{self.price}, Weight: {self.weight}kg"

products = {}  
print(f"Welcome to Ecommerce.\nEnter product id, name, price and weight get flat 10% discount on all purchases.\n")
start = input("Do you want to add a product? (y/n): ")
if start == 'y':
 while True:
     #here choice based if elif and give choices add, calculating for id, finding shipping cost and getting product code details
     for _ in range(1):
        print(f"-------------Product------------------")
        product_id = int(input("Enter the product id: "))
        product_name = input("Enter the product name: ")
        price = float(input("Enter the price: "))
        weight = float(input("Enter the weight of the product: "))
        product = Ecom(product_id, product_name, price, weight)
        products[product_id] = product
        print("Product created Successfully")
     cont = input(f"Do you want to continue? (y/n)\n: ")
     if cont.lower() != "y":
        break
else:
    print("Product creation process aborted.")  

print("-----------Product Details---------------------")
for product_id, product_details in products.items():
    print(f"Product Name: {product_id}")
    print(f"Product Name: {product_details}")
    print(f"Shipping Cost: ₹{product_details.calculate_shipping(product_details.weight):.2f}")
    shipping_price = product_details.calculate_shipping(product_details.weight)
    print(f"Final Price: ₹{product_details.final_price(shipping_price):.2f}")
    print(f"---------------------------------------------------------------\n")

print("-------------------------------------------")
product_id = int(input("Enter the product name to search product code for: "))
if product_id in products:
    admin_passcode = input("Enter the admin passcode: ")
    if admin_passcode == "admin":
        print(products[product_id]._Ecom__product_code_display())
    else:
        print("Invalid admin passcode")
else:
    print("Product not found")
        