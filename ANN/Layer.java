package ANN;

public class Layer {

	private Neuron[] neurons;
	private Layer nextLayer;
	
	protected Layer(int numOfNeurons, int numOfInputs){
		neurons = new Neuron[numOfNeurons];
		for(int i=0; i<numOfNeurons; i++){
			neurons[i] = new Neuron(numOfInputs);
		}
	}
	
	
	protected Neuron[] getNeurons(){
		return neurons;
	}
	
	protected Neuron getNeuron(int index){
		if(index >= 0 && index < neurons.length){
			return neurons[index];
		}
		return null;
	}
	
	protected int numOfNeurons(){
		return neurons.length;
	}
	
	protected double[] getWeights(int xNeuron){
		if( (xNeuron >= 0)  && (xNeuron <neurons.length ) ){
			return neurons[xNeuron].getWeights();
		}
		return null; 
	}
	
	protected void print(){
		for(int i=0; i< neurons.length; i++){
			neurons[i].printWeights();
		}
	}
	
}
