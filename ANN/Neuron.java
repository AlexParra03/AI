package ANN;

public class Neuron {

	private double[] synapses;
	private double bias;
	
	protected static Functions function = Functions.SIGMOID;
	protected static double LearningRate = 0.1;
	
	
	public enum Functions{
		SIGMOID,
		HYPERBOLIC_TANGENT,
		BASIC_TREESHOLD,
		LINEAR
	}
	
	
	protected Neuron(int numOfSynapses){
		synapses = new double[numOfSynapses];
		initsynapses();
	}
	
	// Creating synapses with random weights from 0 to .999
	private void initsynapses(){
		for(int i=0; i< synapses.length; i++){
			synapses[i] = Math.random();
		}
		bias = Math.random();
		
	}
	
	
	protected double feedSignals(double[] inputs){
		double signal = 0;
		for(int i=0; i<inputs.length; i++){
			signal += inputs[i]*synapses[i];
		}
		signal += bias;
		
		return activate(signal);
	}
	
	
	private double activate(double x){
		switch(function){
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
	
	protected void train(double inputs[], double targetOutput, double currentOutput){
		for(int i=0; i<synapses.length; i++){
			synapses[i] *= Neuron.LearningRate * (targetOutput - currentOutput) * inputs[i]; 
		}
		
	}
	
	
	protected double[] getWeights(){
		double[] weightsAndBias = new double[synapses.length+1]; 
		for(int i=0; i<synapses.length; i++){
			weightsAndBias[i] = synapses[i];
		}
		weightsAndBias[weightsAndBias.length-1] = bias;
		return weightsAndBias;
	}
	
	protected void printWeights(){
		System.out.printf(" [");
		for(int i=0; i<synapses.length; i++){
			System.out.printf( " %.3f ", synapses[i]);
		}
		System.out.printf( " b:%.3f] ", bias);
	}
}
