import javax.swing.JOptionPane;
public class Program3CampbellMarcus {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flip = true;
		
		JOptionPane.showMessageDialog(null, "Cone = $3 + $2 per extra scoop + $1 per topping");
			
		while(flip) {
			String s = JOptionPane.showInputDialog("How many cones? Order at least 1 cone. Maximum order is 5");
			int coneCount = Integer.parseInt(s);
					
			//if coneCount is not between 1 or 5, will loop to ask again
			if(coneCount >= 1 && coneCount <= 5) {
				Cone[] cones=new Cone[coneCount];
				
				for(int i= 0; i < coneCount; i++) {
					cones[i] = new Cone(i);	
				}		
				
				for(int i= 0; i < coneCount; i++) {
					JOptionPane.showMessageDialog(null, cones[i].toString());
					JOptionPane.showMessageDialog(null, "The " + cones[i].place[i] + " cone price is $" + cones[i].getPrice() + " dollars");
				}
				
				JOptionPane.showMessageDialog(null,"You order has "+Cone.getTotalCones()+" cones with for a total of $" +  Cone.getTotalPrice()+" dollars");
				
				flip = false;
			}else {
				JOptionPane.showMessageDialog(null, "Minimum Order is 1 and Maximum is 5");
			}	
			
		}
		
	}

}
