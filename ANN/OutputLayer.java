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
	
	protected double[] processSignals(double[] rawSignals){
		double[] signals = new double[outputLayer.numOfNeurons()];
		
		for(int i=0; i < outputLayer.numOfNeurons(); i++){
			signals[i] = outputLayer.getNeuron(i).feedSignals(rawSignals);
		}
		
		return signals;
	}
	
	
	
	protected Layer getLayer(){
		return outputLayer;
	}
	
	protected void print(){
		System.out.printf("%n -- [OUTPUT LAYER] -- %n");
		outputLayer.print();
	}
}
