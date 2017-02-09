/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
