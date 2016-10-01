package ANN;

public class InputLayer {
	private Layer inputLayer;
	
	public InputLayer(int inputs){
		inputLayer = new Layer(inputs, 1);
	}
	
}
