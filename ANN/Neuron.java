package ANN;

public class Neuron {

	private double[] synapses;
	private double bias;
	
	// Dictionary with all available functions
	public static final String[] FUNCTIONS = {"sigmoid","hyperbolic tangent","basic treeshold","linear"};
	// Use this function to produce output
	public static String function = FUNCTIONS[0];
	
	public Neuron(int numOfSynapses){
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
	
	
	public double feedSignals(double[] inputs){
		double signal = 0;
		for(int i=0; i<inputs.length; i++){
			signal += inputs[i]*synapses[i];
		}
		signal += bias;
		
		return activate(signal);
	}
	
	public double activate(double x){
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
}
