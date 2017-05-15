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
public class Tester {
    
    public static void main(String[] args){
        
        Neuron.setWeightRange(-2, 5);
        
        /*
        int[] structure = {2,3, 1};
        NeuralNetwork nn = new NeuralNetwork(structure);
        nn.printInfo();
        
        double[] inputs = {3, 2};
        
        double[][][] synapses = 
        {
            {      }, // Can't set weights for input layer
            {   {-2, 3, 2}, {-1, 2, 2}, {2, 1.5, 1} },
            {   {2, 4, 3, 2} }
                
        };
        
        nn.setSynapses(synapses);
        double[] output = nn.feedForward(inputs);
        System.out.println();
        
        for(double d : output){
            System.out.print(d + "  ");
        }
        System.out.println();

        nn.printInfo();
        
        */
        int[] structure2 = {3, 3, 2};
        NeuralNetwork n = new NeuralNetwork(structure2);
        double[][][] syn = 
        {
            {},
            { {2, 3, 1, 0}, { 4, 5, 6, 0}, { 2.5, 3.5, 4.5, 0} },
            { {4.2, 5, 7, 0}, {4.2, 5, 7, 0 } }
            
        };
        
        
        n.setSynapses(syn);
        n.printInfo();
        double[] inp = {2, 2, 2};
        double[] output  = {6, 5};
        n.train(inp, output);
        n.printInfo();
        
    }
}
