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
        
        
        int[] structure = {2,3, 1};
        NeuralNetwork nn = new NeuralNetwork(structure);
        nn.printInfo();
        
        double[] inputs = {3, 2};
        
        double[][][] synapses = 
        {
            {   {1, 1, 1},{2, 2, 2}   },
            {   {-2, -1, 2}, {-1, 2, 2}, {2, 1.5, 1} },
            {   {2, 4, 3, 2} }
                
        };
        
        nn.setSynapses(synapses);
        double[] output = nn.feedForward(inputs);
        System.out.println();
        
        for(double d : output){
            System.out.print(d + "  ");
        }

        
       
    }
}
