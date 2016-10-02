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
	
	public double[] feed(double[] inputs){
		return inputLayer.feedSignals(inputs, outputLayer);
	}
}
