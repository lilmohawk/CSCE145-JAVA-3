import javax.swing.JOptionPane;
public class Cone {
	
	//static vars
	private static int totalCones=0,totalPrice=0;
	
	//instance var
	private int scoopCount, topCount,conePrice,conePlace;

	//properties for cone
	private String [] scoopFlavors;
	private String [] toppings;
	private String pane = "\n The ";
	String[] place = {"1st", "2nd", "3rd", "4th", "5th"};
	
	String scoopsNumber;
    String toppingList;

	//constructor for number
	public Cone(int num) {
		this();
		conePlace = num;
		setScoops();
		setTops();
		setPrice();
		addTotalPrice();
	}
	
	//default constructor
	public Cone(){
		scoopCount = 0;
		topCount = 0;
		conePrice = 0;
		conePlace = 0;
		addCone();
	}
	//adds to totalcones
	public static void addCone() {
		totalCones++;
	}
	//add to totalprice
	public int addTotalPrice(){
		return getPrice() + totalPrice;
	}
	
	//sets scoops
	public void setScoops() {
		boolean flip = true;
		while(flip) {
			scoopsNumber = JOptionPane.showInputDialog("How many scoops of Ice Cream for your " + place[conePlace] +" cone?");
			scoopCount = Integer.parseInt(scoopsNumber);
			
			//if scoopCount is not between 1 or 3, will loop to ask again
			if(1 <= scoopCount && scoopCount <= 3) {
				scoopFlavors= new String[scoopCount];
				
				//for loop to set each flavor of scoop
				for(int i = 0; i < scoopCount; i++){
					scoopFlavors[i]= JOptionPane.showInputDialog("Which flavors of Ice Cream would you like for the " +place[conePlace]+ " cone?");
				}
				
				flip = false;
				
			} else {
				JOptionPane.showMessageDialog(null, "Must order at least 1 scoop. No more than 3.");
			}
			
		}
		
	}
	
	//set toppings
	public void setTops() {
		boolean flip = true;
		while(flip) {
			toppingList = JOptionPane.showInputDialog("How many toppings would like for your " + place[conePlace] +" cone?");
			topCount = Integer.parseInt(toppingList);
			
			//if topCount is not between 0 or 2, will loop to ask again
			if( topCount >= 0 && topCount <= 2){ 
				toppings = new String[topCount];
				
				//for loop to set different toppings for cone
				for(int i = 0; i < topCount; i++) {
					toppings[i] = JOptionPane.showInputDialog("What toppings would you like for your " + place[conePlace] +" cone?");
				}
				
				flip = false;
				
			} else {
				JOptionPane.showMessageDialog(null, "Can't Order more than 2 toppings. Put 0 if you dont want one");
			}
			
		}
		
	}
	//sets price for cone
	public void setPrice(){
		//scoopCount-1 because its for extra scoops,if there's 2 scoops,one gets charged. 3 for init cone cost
		conePrice = (2*scoopCount - 2 ) + topCount +3;
		totalPrice += conePrice;
	}
	
	//get the Price of Cone Object
	public int getPrice(){
		return conePrice;
	}
	//get the Flavor of Cone Object
	public String getFlavor(int i){
		return scoopFlavors[i];
	}
	//get the topping of Cone Object 
	public String getTop(int i){
		return toppings[i];
	}
	//get totalcones of Cone class
	public static int getTotalCones(){
		return totalCones;
	}
	//get totalprice of Cone Class
	public static int getTotalPrice(){
		return totalPrice;
	}
	
	public String toString() {
		pane = pane + place[conePlace] + " cone has " + scoopCount + " scoops: \n";
		for(int i = 0; i < scoopCount; i++) {
			pane = pane + "--" + place[i]+ " scoop is "+ getFlavor(i) + " \n\n";
		}
		pane = pane + "It also has " + topCount + " toppings:" + " \n";
		for(int i = 0; i < topCount; i++) {
			pane = pane + "--" + place[i] + " topping is "+getTop(i) + " \n";
		}
		return pane;
	}
}