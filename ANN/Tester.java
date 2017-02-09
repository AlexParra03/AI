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
        int[] structure = {3,4,3,2,3};
        NeuralNetwork nn = new NeuralNetwork(structure);
        nn.printInfo();
       
    }
}
