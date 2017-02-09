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
public class OutputNeuron extends Neuron {

    
    private double[] synapses;
    private double bias;
    protected double output;
    
    protected OutputNeuron(int numOfSynapses){
        this.synapses = new double[numOfSynapses];
            for(int i=0; i< synapses.length; i++){
                synapses[i] = Neuron.random(Neuron.weightRange[0], Neuron.weightRange[1]);
            }
        this.bias = Neuron.random(Neuron.weightRange[0], Neuron.weightRange[1]);
    }
    
    protected void setWeights(double[] weights){
        if(weights.length == synapses.length){
            for(int i=0; i<weights.length; i++){
                synapses[i] = weights[i];
            }
        }else{
            System.out.println("Error: weights array needs to be size " + synapses.length);
        }
    }
    
    protected void setBias(double bias){
        this.bias = bias;
    }
    
    @Override
    protected double feed(double[] inputs) {
        if(inputs.length == synapses.length){
            for(int i=0; i<inputs.length; i++){
                this.sum += inputs[i]*synapses[i];
            }
            this.sum += bias;
            
        }else{
            //Error
            System.out.println("Error: Output Neuron -> feed()");
        }
        
        this.output = activate(this.sum);
        return this.output;
    }

    @Override
    protected double[] weights() {
        return this.synapses;
    }

    @Override
    protected double bias() {
        return this.bias;
    }

    
}
