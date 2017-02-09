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
public abstract class Layer {
    
    protected Neuron[] neurons;
    
    protected int size(){
        return neurons.length;
    }
 
    protected Neuron[] neurons(){
        return this.neurons;
    }
    
    protected Neuron neuron(int index){
        if(index >=0 && index < this.size()){
            return this.neurons[index];
        }
        return null;
    }
    
    /*
    @param inputs: array of inputs to feed each input neuron
    @return data after being processed by the neurons
    TODO: Process information by layers
    */
    protected double[] feed(double[] inputs){
        double[] output = new double[this.size()];
        for(int i=0; i<this.size(); i++){
            output[i] = this.neurons[i].feed(inputs);
        }
        
        return output;
    }
    
}
