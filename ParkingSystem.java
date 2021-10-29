package 停车系统;
import java.util.Scanner;
import java.util.ArrayList;

public class ParkingSystem implements Iparking {
	int Big,Medium,Small;

	@Override
	public boolean addCar(int carType) {
		   switch (carType){
           case 1:
               if(this.Big>0){
                   this.Big--;
                   return true;
               }
               break;
               
           case 2:
               if(this.Medium>0){
                   this.Medium--;
                   return true;
               }
               break;
               
           case 3:
               if(this.Small>0){
                   this.Small--;
                   return true;
               }
               break;
               
           default:
               return  false;
		   }
		return false;
	}
	
	static StringBuffer text=new StringBuffer("[null");
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(text);
	}

	public static void main(String[] args) throws Exception{
		IParams params =Iparking.parse();
		ParkingSystem ps= new ParkingSystem(params.getBig(), params.getMedium(), params.getSmall());
		ArrayList<Integer> plan=params.getPlanParking();
		for (Integer integer : plan) {
            if (ps.addCar(integer)) {
                text.append(",true");
            } else {
                text.append(",false");
            }
        }
        text.append("]");
		ps.print();

	    }

	ParkingSystem(int Big,int Medium,int Small){
        this.Big=Big;
        this.Medium=Medium;
        this.Small=Small;
	}
}