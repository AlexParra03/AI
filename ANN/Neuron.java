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
public abstract class Neuron {
    
    protected static double[] weightRange = {-1.0, 1.0}; 
    protected static Functions function = Functions.NONE;
    protected static double LearningRate = 0.05;

    protected double sum;
    
    public enum Functions{
            NONE,
            SIGMOID,
            HYPERBOLIC_TANGENT,
            BASIC_TREESHOLD,
            LINEAR
    }
        
    public abstract int numOfSynapses();
    protected abstract double feed(double[] inputs);
    protected abstract double[] weights();
    protected abstract double bias();
    protected abstract void setSynapse(int index, double weight);

    
    
    protected static void setWeightRange(double start, double end){
        if(start <= end){
            weightRange[0] = start;
            weightRange[1] = end;
        }else{
            System.out.println("Error, start weight can't be bigger than end weight");
        }
    }
    
    protected static double random(double start, double end){
        double size = end - start;
        double output = Math.random() * size;
        output += start;
        return output;
    }
    
    
    protected double activate(double x){
            switch(function){
                    case NONE:
                            return x;
                    case SIGMOID:
                            return 1/(1+ Math.pow(Math.E, -x ));
                    case HYPERBOLIC_TANGENT:
                            return (1- Math.pow(Math.E, -x))/(1+Math.pow(Math.E, -x) );
                    case BASIC_TREESHOLD:
                            return (x < 0.5) ? 0 : 1;
                    case LINEAR:
                            return x;
                    default: //error
                            return 0;
            }
    }
        
    
}
