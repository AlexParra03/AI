package ANN;

public class OutputLayer {

	private Layer outputLayer;
	
	public OutputLayer(int numOfOutputs, HiddenLayer hiddenLayer){
		
		outputLayer = new Layer(numOfOutputs,  hiddenLayer.numOfNeurons( hiddenLayer.numOfLayers()-1 ));
		
	}
	
	public void print(){
		System.out.printf("%n -- [OUTPUT LAYER] -- %n");
		outputLayer.print();
	}
}
