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
	
}
