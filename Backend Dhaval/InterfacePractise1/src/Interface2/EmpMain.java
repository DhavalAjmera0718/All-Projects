package Interface2;

public class EmpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EmpImpli emp = new EmpImpli();
		emp.EmpData();
		
/*-----------------------------------------Using Refferance Of Interface --------------------------------------------------------------------------------*/
		System.out.println("--------------------------------------------------");
		EmpService emp2 = new EmpImpli();
		emp2.EmpData();
		
		
/*-----------------------------------------Usnging Anonymous Class--------------------------------------------------------------------------------*/

		System.out.println("--------------------------------------------------------");
		EmpService emp3 = new EmpService() {
			
			@Override
			public void EmpData() {
				// TODO Auto-generated method stub
				System.out.println("Hello I am From Anonymous Class..........");
			}
		};
		emp3.EmpData();
/*------------------------------------------------Lambada Function Without Perameter-------------------------------------------------------------------------*/
		System.out.println("--------------------------------------------------------");
		EmpService emp4 =()->System.out.println("Hey I am lambda Function Without using Perameter......");
		emp4.EmpData();
		
/*---------------------------------------------Lambada Function With Perameter----------------------------------------------------------------------------*/

		System.out.println("--------------------------------------------------------");
		LambdaUsingParameter l1 = (int a , int b)->{System.out.println(a+b);};
		l1.Addition(1000, 2000);
		
		
		
		
/*-------------------------------------------------------------------------------------------------------------------------*/
		
		
		
	}

}
