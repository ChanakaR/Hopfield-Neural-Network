/**
 * Description :
 *      Network is the class for neural network
 *      Class contains set of neurons
 *      User can feed input data into the network using activation function
 *
 * Created by inocer on 8/7/17.
 *
 */


public class Network {
    private Neuron[] neuron;
    private int[] output;
    public static final double lambda = 1.0;

    public Network(int[][] weight_matrix){
        neuron = new Neuron[weight_matrix[0].length];
        output = new int[weight_matrix[0].length];

        for(int i=0;i<weight_matrix[0].length;i++){
            neuron[i] = new Neuron(weight_matrix[i]);
        }
    }

    /*
     * function to detect whether a neuron fire an output or not
     * Hyperbolic tangent (tanh) is used as the threshold function
     */
    private int threshold(int k){
        double kk = k*lambda;
        double a = Math.exp(kk);
        double b = Math.exp(-kk);
        double tanh = (a-b)/(a+b);

        if(tanh >=0)
            return 1;
        else
            return 0;
    }

    /*
     * function to activate the network for a given input.
     */
    public void activation(int[] pattern){
        for(int i=0; i<4; i++){
            neuron[i].set_output_value(neuron[i].calculate_resulting_value(pattern));
            output[i] = threshold(neuron[i].get_output_value());
        }
    }


    public int[] get_output(){
        return this.output;
    }
}
