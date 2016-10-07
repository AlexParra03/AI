package ANN;


public class HiddenLayer {
	
	private Layer[] hiddenLayers;
	private double[] outputSignal;
	
	protected HiddenLayer( int[] numOfNeurons, InputLayer inputLayer){
		
		if(  numOfNeurons.length > 0){
			// Creating Layers based on the neurons array size
			hiddenLayers = new Layer[numOfNeurons.length];
			initLayer(numOfNeurons[0], inputLayer);
			addExtraLayers(numOfNeurons);

		}else{
			// Error
		}
	}
	
	protected HiddenLayer(int numOfNeurons, InputLayer inputLayer){
		hiddenLayers = new Layer[1];
		initLayer(numOfNeurons, inputLayer);
	}
	
	// Create only the first layer based on the previous layer [Input Layer].
	private void initLayer(int numOfNeurons, InputLayer inputLayer){
		hiddenLayers[0] = new Layer(numOfNeurons, inputLayer.numOfNeurons() );
	}
	
	private void addExtraLayers(int[] numOfNeurons){
		for(int i=1; i<hiddenLayers.length; i++){
			hiddenLayers[i] = new Layer(numOfNeurons[i], numOfNeurons(i-1));
		}
	}
	
	
	protected int numOfLayers(){
		return hiddenLayers.length;
	}
	
	protected int numOfNeurons(int xLayer){
		if( (xLayer < hiddenLayers.length) || (xLayer >= 0) ){
			if(hiddenLayers != null){
				return hiddenLayers[xLayer].numOfNeurons();
			}
		}
		// Error
		return 0;
	}
	
	protected void print(){
		System.out.printf("%n -- [HIDDEN LAYER/S] -- ");
		for(int i=0; i < hiddenLayers.length; i++){
			System.out.println();
			hiddenLayers[i].print();
		}
	}
	
	protected Layer[] getLayers(){
		return hiddenLayers;
	}
}
