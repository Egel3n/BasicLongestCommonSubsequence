import java.util.*;

public class LongestCommonSubsequence {
    private static String[] array1;
    private static String[] array2;
    private static ArrayList<String> arrayList1;
    private static ArrayList<String> arrayList2;
    static void lcs(String str1, String str2){
        array1 = str1.split("");
        array2 = str2.split("");
        arrayList1 = new ArrayList<>(Arrays.asList(array1));
        arrayList2 = new ArrayList<>(Arrays.asList(array2));
        int[][] lcsArray = new int[arrayList1.size()+1][arrayList2.size()+1];
        for(int i=0;i<arrayList1.size();i++){
            for (int j=0;j<arrayList2.size();j++){
                if (Objects.equals(arrayList1.get(i),arrayList2.get(j))){
                    lcsArray[i+1][j+1] = lcsArray[i][j] + 1;
                }
                else{
                    lcsArray[i+1][j+1] = Math.max(lcsArray[i][j+1],lcsArray[i+1][j]);
                }
            }
        }
        ArrayList<String> lcs = new ArrayList<>();
        int row = arrayList1.size();
        int col = arrayList2.size();
        while(lcsArray[row][col] != 0){
            if(lcsArray[row][col]>lcsArray[row-1][col] && lcsArray[row][col]>lcsArray[row][col-1]){
                lcs.add(arrayList1.get(row-1));
                row = row-1;
                col = col-1;
            }
            else{
                if(lcsArray[row-1][col]>lcsArray[row][col-1]){
                    row-=1;
                }
                else{
                    col-=1;
                }
            }
        }
        Collections.reverse(lcs);
        System.out.println(lcs);
    }
}
