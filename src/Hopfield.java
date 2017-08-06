/**
 * Created by inocer on 8/6/17.
 */
public class Hopfield {

    private int[][] weight_matrix;
    private int lattice_size;

    public Hopfield(int lattice_size){
        this.lattice_size= lattice_size;
        this.weight_matrix = new int[lattice_size][lattice_size];
    }

    public void train(int[] input,int size){
        this.initialize_weights();
        int[] input_bipolar = this.get_bipolar_representation(input,size);
        adjust_weights(input_bipolar);

    }

    private void initialize_weights(){
        for(int i=0;i<lattice_size;i++){
            for(int j=0;j<lattice_size;j++){
                weight_matrix[i][j] = 0;
            }
        }
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

    private void adjust_weights(int[] bipolar){
        for(int row =0;row<lattice_size;row++){
            for (int col=0;col<lattice_size;col++){
                this.weight_matrix[row][col] = bipolar[row]*bipolar[col];
            }
        }
        for(int i=0;i<lattice_size;i++){
            this.weight_matrix[i][i] = 0;
        }
    }

}
