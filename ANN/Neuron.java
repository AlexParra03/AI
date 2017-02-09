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
        
    protected abstract double feed(double[] inputs);
    protected abstract double[] weights();
    protected abstract double bias();

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
