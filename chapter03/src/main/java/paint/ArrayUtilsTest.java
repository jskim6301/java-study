package paint;

public class ArrayUtilsTest {

	public static void main(String[] args) {
		int[] a1 = {10,20,30,40,50};
		double[] a2 = {10.0,20.0,30.0,40.0,50.0};
		//ArrayUtils au = new ArrayUtils();
		//double[] d1 = au.intToDouble(a1);
		
//		double[] d1 = ArrayUtils.intToDouble(a1);
//		int[] d2 = ArrayUtils.doubleToInt(a2);
//		for(int i = 0;i<d1.length;i++) {
//			System.out.print(d1[i]+" ");
//		}
//		System.out.println();
//		for(int i = 0;i<d2.length;i++) {
//			System.out.print(d2[i]+" ");
//		}
		//int[] s1 = {10,20,30,40,50};
		int[] s1 = {10,20,30};
		int[] s2 = {60,70,80,90,100};
		int[] res = ArrayUtils.concat(s1,s2);
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]+" ");
		}
		
	}

	

}
