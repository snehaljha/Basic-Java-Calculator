import java.util.Scanner;
import java.util.*;
import java.lang.Math;

public class stringcal {

	private double pi = Math.PI;
	private double e = Math.exp(1);
	//private String exp;

	public String calculate(String st) {
		st = replaceconstant(st);							//to calculate whole expression
		String res="0";
		if(st.indexOf("(")==-1 && st.indexOf(")")==-1){
			//System.out.println("1st if in calculate");
			res = ecal(st);
		}
		else if (st.indexOf("(")<st.indexOf(")") ){//&& (exp.split("(")).length == (exp.split(")")).length) {
			//System.out.println("2nd if in calculate");
			res = bcal(st);
		}
		else {
			res = "Invalid Input";
		}
		return res;
	}

	private String bcal(String exp) {									//for handling brackets in an expression
		int se = -1;
		int ee = -1;
		String substr;
		try {
			while(exp.indexOf("(")>=0){
				ee = exp.indexOf(")");
				se = exp.indexOf("(");
				for (int i=se+1; i<ee; i++) {
					if(exp.charAt(i)=='(')
						se=i;
				}
				if(se!=0 && (exp.charAt(se-1)=='n'||exp.charAt(se-1)=='g')){
					substr = exp.substring(se+1, ee);
					//if(substr.charAt(0)=='-')
						//return "error negative log";
					substr = ecal(substr);
					double x = Double.parseDouble(substr);
					if(exp.charAt(se-1)=='n'){
						x = Math.log(x);
						substr = String.valueOf(x);
						exp = exp.substring(0, se-2) + substr + exp.substring(ee+1);
					}
					else{
						x = Math.log(x)/Math.log(10);
						substr = String.valueOf(x);
						exp = exp.substring(0, se-3) + substr + exp.substring(ee+1);
					}
					continue;
				}
				substr = exp.substring(se+1, ee);
				substr = ecal(substr);
				exp = exp.substring(0,se) + substr + exp.substring(ee +1);
			}
			return ecal(exp);
		}catch(Exception ex){
			return "exception occured\n" + ex;
		}
	}


	private String ecal(String str) {
		if(str.length()<3 && str.indexOf("!")==-1){
			if(str.charAt(0)=='+')
				return str.substring(1);
			return str;
		}
		str = factorial(str);
		str = power(str);
		str = divide(str);
		str = multiply(str);
		str = sum(str);
		return str;
	}
	private String operators = "+-/*^!" ;
	private String power(String str){
		/*int l = str.length();
		if(l<3){
			if(str.charAt(0)=='+')
				return str.substring(1);
			return str;
		}*/
		while(str.indexOf('^')>0){
			int i, j, ioo = str.indexOf('^');
			double fn, sn, res;										//firts and second number
			for(i = ioo-1; i>=0; i--){
				if(operators.indexOf(str.charAt(i))>=0)
					break;
			}
			i++;
			fn = Double.parseDouble(str.substring(i,ioo));
			for(j = ioo+1; j<str.length(); j++){
				if(operators.indexOf(str.charAt(j))>=0)
					break;
			}
			j--;
			sn = Double.parseDouble(str.substring(ioo+1,j+1));
			res = Math.pow(fn,sn);
			if(i==0){
				str=String.valueOf(res) + str.substring(j+1);
			}
			else
				str = str.substring(0,i) + String.valueOf(res) + str.substring(j+1);
		}
		return str;
	}

	private String divide(String str) {

		while(str.indexOf('/')>0){
			int i, j, ioo = str.indexOf('/');
			double fn, sn, res;										//firts and second number
			for(i = ioo-1; i>=0; i--){
				if(operators.indexOf(str.charAt(i))>=0)
					break;
			}
			i++;
			fn = Double.parseDouble(str.substring(i,ioo));
			for(j = ioo+1; j<str.length(); j++){
				if(operators.indexOf(str.charAt(j))>=0)
					break;
			}
			j--;
			sn = Double.parseDouble(str.substring(ioo+1,j+1));
			res = fn/sn;
			if(i==0){
				str=String.valueOf(res) + str.substring(j+1);
			}
			else
				str = str.substring(0,i) + String.valueOf(res) + str.substring(j+1);
		}
		return str;
	}

	private String multiply(String str) {

		while(str.indexOf('*')>0){
			int i, j, ioo = str.indexOf('*');
			double fn, sn, res;										//firts and second number
			for(i = ioo-1; i>=0; i--){
				if(operators.indexOf(str.charAt(i))>=0)
					break;
			}
			i++;
			fn = Double.parseDouble(str.substring(i,ioo));
			for(j = ioo+1; j<str.length(); j++){
				if(operators.indexOf(str.charAt(j))>=0)
					break;
			}
			sn = Double.parseDouble(str.substring(ioo+1,j));
			res = fn*sn;
			if(i==0){
				str=String.valueOf(res) + str.substring(j);
			}
			else
				str = str.substring(0,i) + String.valueOf(res) + str.substring(j);
		}
		return str;
	}

	private String sum(String str) {

		/*IN COMMENTS IN COMMENTS IN COMMENTS
		while(str.indexOf("+")>0){
			int i, j, ioo = str.indexOf("+");
			double fn, sn, res;										//firts and second number
			for(i = ioo-1; i>=0; i--){
				if(operators.indexOf(str.charAt(i))>=0)
					break;
			}
			i++;
			fn = Double.parseDouble(str.substring(i,ioo));
			for(j = ioo+1; j<l; j++){
				if(operators.indexOf(str.charAt(j))>=0)
					break;
			}
			j--;
			sn = Double.valueOf(str.substring(ioo+1,j+1));
			res = fn+sn;
			if(i==0){
				str=String.valueOf(res) + str.substring(j+1);
			}
			else
				str = str.substring(0,i) + String.valueOf(res) + str.substring(j+1);
		}

		while(str.indexOf('-')>0){
			int i, j, ioo = str.indexOf('-');
			double fn, sn, res;										//firts and second number
			for(i = ioo-1; i>=0; i--){
				if(operators.indexOf(str.charAt(i))>=0)
					break;
			}
			i++;
			fn = Double.parseDouble(str.substring(i,ioo));
			for(j = ioo+1; j<l; j++){
				if(operators.indexOf(str.charAt(j))>=0)
					break;
			}
			j--;
			sn = Double.parseDouble(str.substring(ioo+1,j+1));
			res = fn-sn;
			if(i==0){
				str=String.valueOf(res) + str.substring(j+1);
			}
			else
				str = str.substring(0,i) + String.valueOf(res) + str.substring(j+1);
		}

		if(str.indexOf("+")==0)
			str=str.substring(1);
		if(str.indexOf("/")==0||str.indexOf("*")==0||str.indexOf("!")==0)
			return "Invalid Syntax";
			COMMENTS OVER COMMENTS OVER COMMENTS OVER*/

		double tmp1, tmp2;
		int index = 0;
		if(operators.indexOf(str.charAt(0))==1){
			index = 1;
		}

		int p1=0,p2=str.length();
		while(index<str.length()) {
			if(operators.indexOf(str.charAt(index))>=0){
				p1=index;
				int j;

				for(j = index+2; j<str.length(); j++){
					if(operators.indexOf(str.charAt(j))>=0){
						p2=j;
						break;
					}
				}
				tmp1 = Double.valueOf(str.substring(0,p1));
				tmp2 = Double.valueOf(str.substring(p1+1,p2));

				if(str.charAt(p1)=='+') {
					str = String.valueOf(tmp1+tmp2) + str.substring(p2);
				}
				else
					str = String.valueOf(tmp1-tmp2) + str.substring(p2);
				index=j-1;
			}
			index++;
		}
		return str;
	}

	private String replaceconstant(String exp) {
		while(exp.indexOf("e")!=-1){
			int i = exp.indexOf("e");
			if(i==0)
				exp = String.valueOf(e) + exp.substring(1);
			else
				exp = exp.substring(0,i) + String.valueOf(e) + exp.substring(i+1);
		}

		while(exp.indexOf("pi")!=-1) {
			int i = exp.indexOf("pi");
			exp = exp.substring(0,i) + String.valueOf(pi) + exp.substring(i+2);
		}
		return exp;
	}

	private String factorial(String str) {
		while(str.indexOf("!")>=0){
			int factorialsign = str.indexOf("!");
			int number = -1;
			for(int i = factorialsign-1; i>=0; i--) {
				if(operators.indexOf(str.charAt(i))>=0){
					number = i;
					break;
				}
			}
			number++;
			double val = Double.parseDouble(str.substring(number, factorialsign));
			double i;
			for(i=val-1.0; i>1.0; i--)
				val*=i;
			if(i<1.0&&i>0)
				val = val*(Math.pow((i/e),i)*Math.pow(pi*(2*i+1/3),0.5));
			if(i<0)
				val = Math.pow((val/e),val)*Math.pow(pi*(2*val+1/3),0.5);
			str = str.substring(0,number) + String.valueOf(val) + str.substring(factorialsign+1);
		}
		return str;
	}

	public static void main(String args[]) {
		stringcal sc = new stringcal();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter expression");
		String s = in.nextLine();
		String result = "0";
		result = sc.calculate(s);
		System.out.println(result);
	}
}

/*class mp {
	public static void main(String args[]) {
		stringcal sc = new stringcal();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter expression");
		String s = in.nextLine();
		String result = "0";
		result = sc.calculate(s);
		System.out.println(result);
	}
}*/
