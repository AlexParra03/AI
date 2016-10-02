package ANN;

public class InputLayer {
	
	private Layer inputLayer;
	
	public InputLayer(int inputs){
		inputLayer = new Layer(inputs, 1);
	}
	
	public int numOfNeurons(){
		return inputLayer.numOfNeurons();
	}
	
	public void print(){
		System.out.printf("%n -- [INPUT LAYER] -- %n");
		inputLayer.print();
	}

	
}
