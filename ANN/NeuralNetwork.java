package ANN;

public class NeuralNetwork {

	
	InputLayer inputLayer;
	HiddenLayer hiddenLayer;
	OutputLayer outputLayer;
	private double[] output;
	private double[][] signals;
	
	private Layer[] layers;
	
	
	public NeuralNetwork(int inputs, int[] hiddenNeurons, int outputs){
		inputLayer = new InputLayer(inputs);
		hiddenLayer = new HiddenLayer(hiddenNeurons, inputLayer);
		outputLayer = new OutputLayer(outputs, hiddenLayer);
		initLayers();
	}
	
	public NeuralNetwork(int inputs, int hiddenNeurons, int outputs){
		inputLayer = new InputLayer(inputs);
		hiddenLayer = new HiddenLayer(hiddenNeurons, inputLayer);
		outputLayer = new OutputLayer(outputs, hiddenLayer);
		initLayers();
	}
	
	private void initLayers(){
		this.layers = new Layer[1 + hiddenLayer.getLayers().length + 1];
		this.layers[0] = inputLayer.getLayer();
		for(int i=0; i<hiddenLayer.getLayers().length; i++){
			this.layers[i+1] = hiddenLayer.getLayers()[i];
		}
		this.layers[layers.length-1] = outputLayer.getLayer();
		
		int maxNeurons = 0;
		for(int i=0; i<layers.length; i++){
			if(maxNeurons < layers[i].numOfNeurons()){
				maxNeurons = layers[i].numOfNeurons();
			}
		}
		signals = new double[layers.length][maxNeurons];
	}
	
	public double[] feed(double[] signals){
		if(signals.length == layers[0].numOfNeurons()){
			processLayers(signals, 0);
		}else{
			//Error, there needs to be 1 signal per input neuron
		}
		
		return this.output;
	}
	
	
	private void processLayers(double[] rawSignals ,int layer){
		if(layer >= 0 && layer < layers.length-1){
			processLayers( processLayer(rawSignals, layer), layer+1);
		}else if(layer == layers.length-1){
			this.output =  processLayer(rawSignals, layer);
		}
	}
	
	private double[] processLayer(double[] rawSignals ,int layer){
		double[] signals = new double[layers[layer].numOfNeurons()];
		if(layer == 0 ){ // Input layer processed (each neuron does not recive all signals, one neuron per input).
			for(int i=0; i<layers[layer].numOfNeurons(); i++ ){
				double[] individualSignal = {rawSignals[i]};
				signals[i] = layers[layer].getNeuron(i).feedSignals(individualSignal);
			}
		}else if(layer >= 1 && layer < layers.length){
			for(int i=0; i<layers[layer].numOfNeurons(); i++ ){
				signals[i] = layers[layer].getNeuron(i).feedSignals(rawSignals);
			}
		}else{
			//error
		}
		//Saving outputs of each layer into global array for training.
		this.signals[layer] = signals;
		return signals;
	}
	
	private double average(double[] sets){
		double average = 0;
		for(double set : sets){
			average += set;
		}
		average = average / sets.length;
		return average;
	}
	
	public void train(double[] inputs, double[] targetOutputs){
		double[] currentOutputs = feed(inputs);
		double output = average(targetOutputs);
		double target = average(currentOutputs);
		
		// training first layer, input layer
		for(int i=0; i < layers[0].numOfNeurons(); i++){
			double[] individualInput = {inputs[i]};
			layers[0].getNeuron(i).train(individualInput, target, output); //Train
		}
		
		
		//training rest of the network
		for(int i=1; i<layers.length; i++){
			for(int j=0; j<layers[i].numOfNeurons(); j++){
				layers[i].getNeuron(j).train(this.signals[i], target, output);
			}
		}
	}
	
	
	public void printWeights(){
		for(Layer layer : layers){
			System.out.println();
			for(Neuron neuron : layer.getNeurons()){
				neuron.printWeights();
			}
		}
	}
	
	public void print(double[] array){
		System.out.println();
		if(array != null){
			for(double output : array){
				System.out.print(output + " ");
			}
		}
	}
	
	
	
}
