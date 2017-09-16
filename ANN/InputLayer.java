
package ANN;

/**
 *
 * @author Alex
 */
public class InputLayer extends Layer {

    protected InputLayer(int numOfNeurons){
        this.neurons = new InputNeuron[numOfNeurons];
        for(int i=0; i<numOfNeurons; i++){
            this.neurons[i] = new InputNeuron();
        }
    }



    
}
