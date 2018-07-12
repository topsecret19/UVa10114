import java.util.*;
public class Main {
	public static void main(String[] args) {
		int months,n,m;
		int counter=0;
		double down,loan,owe,monthlyPayment,value,d,lastD;
		Hashtable<Integer,Double> ht = new Hashtable<Integer,Double>();
		Scanner sc = new Scanner(System.in);
		months = sc.nextInt();
		while(months>0) {
			down= sc.nextDouble();
			loan=sc.nextDouble();
			n=sc.nextInt();
			owe=loan;
			monthlyPayment=loan/months;
			value=down+loan;
			for(int i=0; i<n; i++) {
				m=sc.nextInt();
				d=sc.nextDouble();
				ht.put(m, d);
			}
			d=ht.get(0);
			lastD=d;
			value=value-(value*d);
			for(int j=1; j<=months; j++) {
				if(ht.get(j)!=null) {
					d=ht.get(j);
					lastD=d;
					value=value-(value*d);
					owe=owe-monthlyPayment;
					counter++;
				}else {
					value=value-(value*lastD);
					owe=owe-monthlyPayment;
					counter++;
				}
				if(owe<value) {
					break;
				}
			}
			
			if(counter>1) {
				System.out.println(counter+" months");
				counter=0;
			}else {
				System.out.println(counter+" month");
				counter=0;
			}
			months=sc.nextInt();
		}
	}

}
