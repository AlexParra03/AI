package ANN;

public class InputLayer {
	
	private Layer inputLayer;
	
	protected InputLayer(int inputs){
		inputLayer = new Layer(inputs, 1);
	}
	
	protected double[] feedSignals(double[] rawSignals, OutputLayer outputLayer){
		// Feeding signals. Output Layer <--- Hidden Layer/s --- Input Layer
		return outputLayer.processSignals( outputLayer.getHiddenLayer().processSignals( processSignals(rawSignals) ) );

	}
	
	protected void train(double[] inputs, double[] targetOutput, OutputLayer outputLayer){

	}
	
	private double[] processSignals(double[] rawSignals){
		double[] signals = new double[rawSignals.length];
		if(rawSignals.length == inputLayer.numOfNeurons()){
			for(int i=0; i < inputLayer.numOfNeurons(); i++){
				double[] individualSignal = {rawSignals[i]};
				signals[i] = inputLayer.getNeuron(i).feedSignals(individualSignal);
			}
			return signals;
		}else{
			return null;
		}
	}
	
	protected int numOfNeurons(){
		return inputLayer.numOfNeurons();
	}
	
	protected void print(){
		System.out.printf("%n -- [INPUT LAYER] -- %n");
		inputLayer.print();
	}

	
}
