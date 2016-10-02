package ANN;


public class HiddenLayer {
	
	private Layer[] hiddenLayers;
	
	public HiddenLayer( int layers , int[] numOfNeurons, InputLayer inputLayer){
		
		if( (layers == numOfNeurons.length) && (layers > 0) ){
			
			hiddenLayers = new Layer[layers];
			
			initLayer(numOfNeurons[0], inputLayer);
			// Adding Extra layers
			for(int i= 1; i < layers; i++){
				addExtraLayers(numOfNeurons[i]);
			}

		}else{
			// Error
		}
	}
	
	public HiddenLayer(int numOfNeurons, InputLayer inputLayer){
		hiddenLayers = new Layer[1];
		initLayer(numOfNeurons, inputLayer);
	}
	
	// Create only the first layer based on the previous layer [Input Layer].
	private void initLayer(int numOfNeurons, InputLayer inputLayer){
		hiddenLayers[0] = new Layer(numOfNeurons, inputLayer.numOfNeurons() );
	}
	
	private void addExtraLayers(int numOfNeurons){
		for(int i=1; i<hiddenLayers.length; i++){
			hiddenLayers[i] = new Layer(numOfNeurons, numOfNeurons(i-1));
		}
	}
	
	public int numOfLayers(){
		return hiddenLayers.length;
	}
	
	public int numOfNeurons(int xLayer){
		if( (xLayer < hiddenLayers.length) || (xLayer >= 0) ){
			if(hiddenLayers != null){
				return hiddenLayers[xLayer].numOfNeurons();
			}
		}
		// Error
		return 0;
	}
	
	public void print(){
		System.out.printf("%n -- [HIDDEN LAYER/S] -- ");
		for(int i=0; i < hiddenLayers.length; i++){
			System.out.println();
			hiddenLayers[i].print();
		}
	}
}
