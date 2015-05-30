package hackerEarth;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author Aakansha Doshi
 *
 */
public class BrothersGuilt {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		String s1=br.readLine().trim();
		String s2=br.readLine().trim();
		String s3=br.readLine().trim();
		char c1[]=s1.toCharArray();
		char c2[]=s2.toCharArray();
		int lcs[][]=new int[s1.length()+1][s2.length()+1];
		String comm="";
		for(int i=0;i<=s1.length();i++)
		{
			for(int j=0;j<=s2.length();j++)
			{
			
				if(i==0|j==0)
					lcs[i][j]=0;
				else if((c1[i-1]==c2[j-1]))
				{
					lcs[i][j]=lcs[i-1][j-1]+1;
					
				}
				
				else
					lcs[i][j]=Math.max(lcs[i-1][j],lcs[i][j-1]);
				}
			
		}
		
		//System.out.println(lcs[s1.length()][s2.length()]);
		int i=s1.length();
		int j=s2.length();
		while(i>=1&&j>=1)
		{
			
				if(c1[i-1]==c2[j-1])
				{
					comm=c1[i-1]+comm;
					i--;
					j--;
				}
				else if(lcs[i][j-1]>lcs[i-1][j])
				{
					j--;
				}
				else
				{
					i--;
				}
		}
			comm=comm.trim();
			//System.out.println(comm.length());
		int len=comm.length();
		for(i=0,j=s3.length();j<=comm.length();i++,j++)
		{
			String sub=comm.substring(i,j);
			if(sub.equals(s3))
			{
				len--;
			}
		}
		
		System.out.println(len);
	}

}
