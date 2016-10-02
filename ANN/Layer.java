package ANN;

public class Layer {

	private Neuron[] neurons;
	
	public Layer(int numOfNeurons, int numOfInputs){
		neurons = new Neuron[numOfNeurons];
		for(int i=0; i<numOfNeurons; i++){
			neurons[i] = new Neuron(numOfInputs);
		}
	}
	
	public Neuron[] getNeurons(){
		return neurons;
	}
	
	public int numOfNeurons(){
		return neurons.length;
	}
	
	public double[] getWeights(int xNeuron){
		if( (xNeuron >= 0)  && (xNeuron <neurons.length ) ){
			return neurons[xNeuron].getWeights();
		}
		return null; 
	}
	
	public void print(){
		for(int i=0; i< neurons.length; i++){
			neurons[i].printWeights();
		}
	}
	
}
