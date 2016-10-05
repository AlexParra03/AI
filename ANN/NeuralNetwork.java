package ANN;

public class NeuralNetwork {

	InputLayer inputLayer;
	HiddenLayer hiddenLayer;
	OutputLayer outputLayer;
	
	public NeuralNetwork(int inputs, int[] hiddenNeurons, int outputs){
		inputLayer = new InputLayer(inputs);
		hiddenLayer = new HiddenLayer(hiddenNeurons, inputLayer);
		outputLayer = new OutputLayer(outputs, hiddenLayer);
	}
	
	public NeuralNetwork(int inputs, int hiddenNeurons, int outputs){
		inputLayer = new InputLayer(inputs);
		hiddenLayer = new HiddenLayer(hiddenNeurons, inputLayer);
		outputLayer = new OutputLayer(outputs, hiddenLayer);
	}
	
	protected double[] feed(double[] rawSignals){
		return outputLayer.processSignals( hiddenLayer.processSignals( inputLayer.processSignals(rawSignals) ) );
	}
	
	public void activationFunction(int id){
		Neuron.function = Neuron.FUNCTIONS[id];
	}
	
	public void print(double[] array){
		System.out.println();
		for(double output : array){
			System.out.print(output + " ");
		}
	}
	
	
	
}
