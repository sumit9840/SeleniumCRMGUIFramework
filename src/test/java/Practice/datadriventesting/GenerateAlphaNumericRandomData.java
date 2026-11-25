package Practice.datadriventesting;

public class GenerateAlphaNumericRandomData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=20;
		//choose a character random from this string
		String AlphaNumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		 //create StringBuffer size of AlphaNumericString
		StringBuffer sb=new StringBuffer(n);
		
		for(int i=0;i<n;i++) {
			int index= (int)(AlphaNumericString.length()*Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		System.out.println(sb);

	}

}
