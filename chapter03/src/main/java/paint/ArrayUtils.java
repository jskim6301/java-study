package paint;

public class ArrayUtils {
	public static double[] intToDouble(int[] src) {
		double[] result = null;
		if(src==null) {
			return null;
		}
		
		int size = src.length;
		result = new double[size];
		for(int i=0;i<size;i++) {
			result[i] = src[i];
		}
		
		return result;
	}
	public static int[] doubleToInt(double[] src) {
		int[] result = null;
		if(src==null) {
			return null;
		}
		int size = src.length;
		result = new int[size];
		for(int i=0;i<size;i++) {
			result[i] = (int)src[i];
		}
		return result;
	}
	public static int[] concat(int[]s1,int[] s2) {
		
		int[] merge = new int[s1.length+s2.length];		
		int index = 0;
		
		for(int i=0;i<s1.length;i++) {
			merge[index++] = s1[i];
		}
		for(int i=s1.length;i<s2.length;i++) {
			merge[index++] = s2[i];
		}
		return merge;
		
		
	}
}
