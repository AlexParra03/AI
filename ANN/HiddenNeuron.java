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
public class HiddenNeuron extends Neuron {
    
    private double[] synapses;
    private double bias;
    
    protected HiddenNeuron(int numOfSynapses){
        this.synapses = new double[numOfSynapses];
            for(int i=0; i< synapses.length; i++){
                synapses[i] = Neuron.random(Neuron.weightRange[0], Neuron.weightRange[1]);
            }
        this.bias = Neuron.random(Neuron.weightRange[0], Neuron.weightRange[1]);
    }
    
        /*
    @param index: index of the Nth synapses for this neuron, bias is counted as the last synapse
    @param weight: new weight for the synapse
    TODO: Set individually the weights for the given synapse
    */
    @Override
    protected void setSynapse(int index, double weight){
        if(index >= 0 && index < synapses.length+1){
            if(index == synapses.length){ // setting the bias as the last index
                this.bias = weight;
            }else{
                this.synapses[index] = weight;
            }
        }else{
            System.out.println("Error: can set synapse weight, invalid index");
        }
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
            System.out.println("Error: Hidden Neuron -> feed()");
        }
        
        return activate(this.sum);
    }

    @Override
    protected double[] weights() {
        return this.synapses;
    }

    @Override
    protected double bias() {
        return this.bias;
    }
    
    @Override
    public int numOfSynapses() {
        //Synapses and bias
        return this.synapses.length + 1;
    }
    
}
