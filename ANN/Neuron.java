package ANN;

public class Neuron {

	private double[] synapses;
	private double bias;
	
	// Dictionary with all available functions
	protected static final String[] FUNCTIONS = {"sigmoid","hyperbolic tangent","basic treeshold","linear"};
	// Use this function to produce output
	protected static String function = FUNCTIONS[0];
	
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
	
	
	protected double activate(double x){
		switch(Neuron.function){
			case "sigmoid":
				return 1/(1+ Math.pow(Math.E, -x ));
			case "hyperbolic tangent":
				return (1- Math.pow(Math.E, -x))/(1+Math.pow(Math.E, -x) );
			case "basic treeshold":
				return (x < 0.5) ? 0 : 1;
			case "linear":
				return x;
			default: //error
				return 0;
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
		System.out.printf(" [ ");
		for(int i=0; i<synapses.length; i++){
			System.out.printf( " %.3f ", synapses[i]);
		}
		System.out.printf( " b:%.3f ] ", bias);
	}
}
