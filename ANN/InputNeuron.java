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
public class InputNeuron extends Neuron {

    @Override
    protected double feed(double[] inputs) {
        for(int i=0; i<inputs.length; i++){
           this.sum += inputs[i]; 
        }
        return this.sum;
    }

    @Override
    protected double[] weights() {
        double[] noWeights = {1.0};
        return noWeights;
    }

    @Override
    protected double bias() {
        return 0;
    }

    @Override
    protected void setSynapse(int index, double weight) {
        System.out.println("Error: can not set weights for input neuron");
    }
    
    @Override
    public int numOfSynapses() {
        return 1;
    }
    
    
}
