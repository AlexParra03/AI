package ANN;

public class OutputLayer {

	private Layer outputLayer;
	private HiddenLayer hiddenLayer;
	
	protected OutputLayer(int numOfOutputs, HiddenLayer hiddenLayer){
		this.hiddenLayer = hiddenLayer;
		outputLayer = new Layer(numOfOutputs,  hiddenLayer.numOfNeurons( hiddenLayer.numOfLayers()-1 ));	
	}
	
	protected HiddenLayer getHiddenLayer(){
		return hiddenLayer;
	}
	
	
	
	protected Layer getLayer(){
		return outputLayer;
	}
	
	protected void print(){
		System.out.printf("%n -- [OUTPUT LAYER] -- %n");
		outputLayer.print();
	}
}
