import java.util.Stack;


public class Postfix {
	
	static int evaluate (String exp) {
		Stack<Integer> s=new Stack<>();
		int num=Integer.valueOf(exp.charAt(0)-48);
		for(int i=1;i<exp.length();i++) {
			System.out.println(s);
			if(exp.charAt(i)==' ') {
				s.push(Integer.valueOf(exp.charAt(i)-48));
				num=0;
			}
			else if(Character.isDigit(exp.charAt(i))) {
				num=num*10+(Integer.valueOf(exp.charAt(i)-48));
			}
			else {
				int a=s.pop();
				int b=s.pop();
				int res=calc(a,b,exp.charAt(i));
				System.out.println("calc "+a+" "+b+ " "+res);
				s.push(res);
			}
		}
		return s.pop();
		
	}

	public static void main(String[] args) {
			String s="12 3 / 4 +";
			System.out.println(evaluate(s));

	}
	
	private static int calc(int a, int b, char e) {
		switch(e){
		case '*': return a*b;
		case '+':return a+b;
		case '/':return b/a;
		case '-':return b-a;
		default :return 0;
		}
	}

}
