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
public class OutputLayer extends Layer {
    
    /*
    @param numOfNeurons: the number of neurons being created and stored in this layer
    @param numOfSynapses: synapses connected with the previous neuron, size needs to be the same number of neurons in the previous layer
    TODO: Create groups of Hidden Neurons and store them in this Hidden Layer
    */
    protected OutputLayer(int numOfNeurons, int numOfSynapses){
        this.neurons = new HiddenNeuron[numOfNeurons];
        for(int i=0; i<numOfNeurons; i++){
                neurons[i] = new HiddenNeuron(numOfSynapses);
        }
    }
    
    /*
    return activation signal of each output neuron which is stored only in each Output Neurons
    TODO Give outputs after the whole network has been processed
    */
    protected double[] output(){
        double[] outputs = new double[this.size()];
        
        for(int i=0; i<this.size(); i++){
            OutputNeuron neuron = (OutputNeuron) this.neurons[i];
            outputs[i] = neuron.output;
        }
        
        return outputs;
    }
}
