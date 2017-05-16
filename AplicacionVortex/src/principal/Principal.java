package principal;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Dime una a�o: ");
		int a�o1=sc.nextInt();
		System.out.println("Dime una mes: ");
		int mes1=sc.nextInt();
		System.out.println("Dime una d�a: ");
		int dia1=sc.nextInt();
		
		System.out.println("Dime otro a�o: ");
		int a�o2=sc.nextInt();
		System.out.println("Dime otro mes: ");
		int mes2=sc.nextInt();
		System.out.println("Dime otro d�a: ");
		int dia2=sc.nextInt();
		
		GregorianCalendar fecha1=new GregorianCalendar(a�o1, mes1, dia1);
		GregorianCalendar fecha2=new GregorianCalendar(a�o2, mes2, dia2);
		
		long fechaMillis1=fecha1.getTimeInMillis();
		long fechaMillis2=fecha2.getTimeInMillis();
		long fechaMillis;
		
		if (fecha1.before(fecha2))
			fechaMillis=fechaMillis2-fechaMillis1;
		else
			fechaMillis=fechaMillis1-fechaMillis2;
		
		long dias=Math.round((double)fechaMillis/(3600*24*1000));
		
		if (dias > 20)
			System.out.println("Hay m�s de 20 d�as, exactamente " +dias); 
		else
			System.out.println("Hay menos de 20 d�as"); 

	}

}
