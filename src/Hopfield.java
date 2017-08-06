/**
 * Created by inocer on 8/6/17.
 */
public class Hopfield {

    private int[] bipolar_version;


    public void train(){

    }

    private int[] get_bipolar_representation(int[] input,int n){
        int[] bipolar = new int[n];
        for (int i=0;i<n;i++){
            if(input[i] == 0){
                bipolar[i] = -1;
            }else{
                bipolar[i] = input[i];
            }
        }
        return bipolar;
    }

}
