package Interface;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*StudentImpli st1 = new StudentImpli();
		System.out.println(st1.ShowData()); */
/*--------------------------------------------Using Interface Refreance------------------------------------------------------------------------------------*/
	/*	
		System.out.println("-----------------------------------------------");
		
		StudentServices st2 = new StudentImpli();
		st2.ShowData();
		System.out.println(st2.ShowData());
*/
/*--------------------------------------------Using Anonymous Class------------------------------------------------------------------------------------*/
	/*	
		System.out.println("-----------------------------------------------");
		
		StudentServices st3 = new StudentServices() {
			
			@Override
			public String ShowData() {
				// TODO Auto-generated method stub
				return "Hello I am Method From Interface Using Anonymous Class.";
				
			}
		};
		System.out.println(st3.ShowData());
*/
/*--------------------------------------------Using LAMBDA Function------------------------------------------------------------------------------------*/
		
		/*System.out.println("-----------------------------------------------");
		StudentServices st4=()->{return "Lembda";};
		System.out.println(st4.ShowData());
	*/

/*--------------------------------------------Using LAMBDA Function With Perameter------------------------------------------------------------------------------------*/

		
		System.out.println("---------------------------------------------------------");
		StudentServices st5 =(int a , int b)->{System.out.println(a+b);};
		st5.Addition(100, 2000);
	
	}
}
