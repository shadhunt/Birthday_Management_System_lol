import java.util.Random;


public class TestAssignOrganizer {

	public static int[] randomAssign(int amount)
	{
		int memberOrganizer[]=new int[amount];
		for(int n=0;n<amount;n++)
		{
			System.out.println("n="+n);
			Random random=new Random();
			int organizerID=random.nextInt(amount);
			System.out.println("organizerID:"+organizerID);
			boolean hasSameValue=false;
			for(int m=0;m<n;m++)
			{
				if(memberOrganizer[m]==organizerID)
				{
					n--;
					hasSameValue=true;
					System.out.println("m:"+m+" value same:"+organizerID);
					break;
				}
			}
			if(!hasSameValue)
			{
				memberOrganizer[n]=organizerID;
				System.out.println("assigned:"+n+" "+organizerID);
			}
			
		}
		return memberOrganizer;
				
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int memberOrganizer[] = new int[30];
		memberOrganizer=randomAssign(30);
		System.out.println("end randome Assign");
		for(int n=0;n<memberOrganizer.length;n++)
		{
			System.out.println("n="+n+" m="+memberOrganizer[n]);
		}
		System.out.println("=======================================");
//		for(int n=0;n<memberOrganizer.length;n++)
//		{
//			int temp;
//			for(int m=0;m<memberOrganizer.length-n-1;m++)
//			{
//				if(memberOrganizer[m]>memberOrganizer[m+1])
//				{
//					temp=memberOrganizer[m];
//					memberOrganizer[m]=memberOrganizer[m+1];
//					memberOrganizer[m+1]=temp;
//				}
//			}
//		}
		for(int n=0;n<memberOrganizer.length;n++)
		{
			System.out.println("n="+n+" m="+memberOrganizer[n]);
		}
	}

}
