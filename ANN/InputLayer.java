package ANN;

public class InputLayer {
	
	private Layer inputLayer;
	
	protected InputLayer(int inputs){
		inputLayer = new Layer(inputs, 1);
	}
	
	
	
	protected int numOfNeurons(){
		return inputLayer.numOfNeurons();
	}
	
	protected void print(){
		System.out.printf("%n -- [INPUT LAYER] -- %n");
		inputLayer.print();
	}
	
	protected Layer getLayer(){
		return inputLayer;
	}

	
}
