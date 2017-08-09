/**
 *
 * Description :
 *      Class to represent a Neuron
 *      Each Neuron has a weight vector which is related to the other connected (logically) neurons
 *
 * Created by inocer on 8/7/17.
 *
 */


public class Neuron {

    private int[] weight_vector;
    private int output_value;

    public Neuron(int[] weight_vector){
        this.weight_vector = weight_vector;
    }

    public int calculate_resulting_value(int[] input){
        int result = 0;
        for(int i=0;i<input.length;i++){
            if(input[i]==1){
                result += weight_vector[i];
            }
        }
        return result;
    }

    public void set_output_value(int output_value){
        this.output_value = output_value;
    }

    public int get_output_value(){
        return this.output_value;
    }
}
