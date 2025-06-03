import java.util.*;
public class maxlength{
    public static void main(String[]args){
        int pair[][]={{5,24},{39,60},{5,20},{27,40},{50,90}};

        Arrays.sort(pair, Comparator.comparingDouble(o  ->o[1]));

        int chainLen=1;
        int pairEnd=pair[0][1];
        for(int i=1; i<pair.length;i++){
            if(pair[i][0]>pairEnd){
                chainLen++;
                pairEnd=pair[i][1];
            }
        }
        System.out.println(chainLen);

    }

}