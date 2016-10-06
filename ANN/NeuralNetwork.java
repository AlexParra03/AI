package ANN;

public class NeuralNetwork {

	
	InputLayer inputLayer;
	HiddenLayer hiddenLayer;
	OutputLayer outputLayer;
	private double[] output;
	
	
	private Layer[] layers;
	
	
	public NeuralNetwork(int inputs, int[] hiddenNeurons, int outputs){
		inputLayer = new InputLayer(inputs);
		hiddenLayer = new HiddenLayer(hiddenNeurons, inputLayer);
		outputLayer = new OutputLayer(outputs, hiddenLayer);
		orderLayers();
	}
	
	public NeuralNetwork(int inputs, int hiddenNeurons, int outputs){
		inputLayer = new InputLayer(inputs);
		hiddenLayer = new HiddenLayer(hiddenNeurons, inputLayer);
		outputLayer = new OutputLayer(outputs, hiddenLayer);
		orderLayers();
	}
	
	private void orderLayers(){
		this.layers = new Layer[1 + hiddenLayer.getLayers().length + 1];
		this.layers[0] = inputLayer.getLayer();
		for(int i=0; i<hiddenLayer.getLayers().length; i++){
			this.layers[i+1] = hiddenLayer.getLayers()[i];
		}
		this.layers[layers.length-1] = outputLayer.getLayer();
		
	}
	
	public double[] feed1(double[] rawSignals){
		return outputLayer.processSignals( hiddenLayer.processSignals( inputLayer.processSignals(rawSignals) ) );
		
	}
	
	public double[] feed(double[] signals){
		processLayers(signals, 0);
		return this.output;
	}
	
	
	private void processLayers(double[] rawSignals ,int layer){
		if(layer > 0 && layer < layers.length-1){
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
		return signals;
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
