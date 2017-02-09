/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ANN;

/**
 *
 * @author Alex
 */
public class NeuralNetwork {
    
    protected Layer[] layers;
    
    
    /*
    @param networkStructure: number of neurons in each layer, [ Input -> Hidden -> Output ] or [ Input -> Output ]
    TODO: Create the whole network structure. Instanciate layers and neuros with the proper synapses based on the number of neurons in previous layers.
    */
    public NeuralNetwork(int[] networkStructure){
        int size = networkStructure.length;
        
        if(size < 2){
            System.out.println("Error: Can't instanciate a Neural Network with 1 or less Layers");
        }else if(size == 2){
            
            this.layers = new Layer[2];
            this.layers[0] = new InputLayer(networkStructure[0]);
            this.layers[1] = new OutputLayer(networkStructure[1], networkStructure[0]);
            
        }else{
            
            this.layers = new Layer[size];
            this.layers[0] = new InputLayer(networkStructure[0]);
            for(int i=1; i<size-1; i++){
                this.layers[i] = new HiddenLayer(networkStructure[i], networkStructure[i-1]);
            }
            this.layers[size-1] = new OutputLayer(networkStructure[size-1],networkStructure[size-2] );
        }
      
    }
    
    /*
    @param inputs: inputs being feed to the whole network
    @return outputs after being processed by the whole network
    TODO: Compute inputs layer by layer, and feed the output to the next layer. Then call the outputs which are only stored in Output Layers
    */
    public double[] feedForward(double[] inputs){
        feedRecursive(inputs, 0);
        OutputLayer outputLayer = (OutputLayer) this.layers[layers.length-1];
        return outputLayer.output();
    }
    
    /*
    TODO: Recursively feed current layer, and give outputs to the next layer for the whole network.
    */
    private void feedRecursive(double[] inputs, int layer){
        if(layer >= layers.length){
            return;
        }
        
        double[] outputs = this.layers[layer].feed(inputs);
        
        feedRecursive(outputs, layer+1);
    }
    
    public Layer layer(int index){
        if(index >=0 && index < layers.length){
            return layers[index];
        }
        return null;
    }
    
    // Prints the synapses of all the network
    public void printInfo(){
        
        for(int i=0; i<layers.length; i++){
            Layer layer = layers[i];
            System.out.printf( layer.getClass().getSimpleName() +" :");
            for(int j=0; j<layer.size(); j++ ){
                System.out.printf( " [");
                double[] weights = layer.neuron(j).weights();
                for(int k=0; k<weights.length; k++){
                    System.out.printf( "%.4f, ", weights[k]) ;
                }
                System.out.printf( "bias:%.4f] ", layer.neuron(j).bias() );
                
            }
            System.out.printf("%n");
        }
    }
    
}
