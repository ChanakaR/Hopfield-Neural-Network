import sun.nio.ch.Net;

/**
 * Created by inocer on 8/8/17.
 */
public class Main {
    public static void main(String[] args) {
        int lattice_size = 4;
        Hopfield hopfield = new Hopfield(lattice_size);
        int[] train_data = {0,1,0,1};
        hopfield.train(train_data,train_data.length);
        int[][] weight_matrix = hopfield.get_weight_matrix();

        for(int i=0;i<lattice_size;i++){
            for(int j=0;j<lattice_size;j++){
                System.out.print(weight_matrix[i][j] + " ");
            }
            System.out.println("");
        }

        Network network = new Network(weight_matrix);

        int[] test_data = {0,1,0,1};

        network.activation(test_data);
        int[] output = network.get_output();

        for(int k=0;k<lattice_size;k++){
            System.out.print(output[k] + " ");
        }
    }
}
