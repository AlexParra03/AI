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
    
    /*
    TODO set individial weights of synapses (including bias) for all layers except input layer
    @param synapses: 1st dimension is whole structure, 2nd dimension contains arrays of neurons, 3rd dimension has the individual values for weights
    -----------------
    [ [Neuron 1] [Neuron 2] [Neuron 3] ]  Layer 1 (input layer is ignored, all weights are 1.0)
    [ [Neuron 1] [Neuron 2] [Neuron 3] ]
    [ [Neuron 1] [Neuron 2] ... ]
    [ [Neuron 1] [Neuron 2] ... ]
    -------------------
    [Neuron X] = { Weight 1, Weight 2, ... , bias } 
    */
    public void setSynapses(double[][][] synapses){
        for(int i=1; i<this.layers.length; i++){
            Neuron[] neurons = this.layers[i].neurons();
            for(int j=0; j<neurons.length; j++){
                Neuron neuron = neurons[j];
                for(int k=0; k< neuron.numOfSynapses(); k++){
                    neuron.setSynapse(k, synapses[i][j][k]);
                    //System.out.println(i + " " + j + " " + k + " : " + synapses[i][j][k] );
                }
            }
        }
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
    
    public void train(double[] inputs, double[] desiredOutputs){
        double[] outputs = feedForward(inputs);
        double[] error = new double[outputs.length];
        for(int i=0; i<outputs.length; i++){
            error[i] = desiredOutputs[i] - outputs[i];
            OutputNeuron outputNeuron = (OutputNeuron) layers[layers.length-1].neuron(i);
            for(int weights = 0; weights < outputNeuron.numOfSynapses()-1; weights++){
                HiddenNeuron neuron = (HiddenNeuron) layers[layers.length-2].neuron(weights);
                outputNeuron.setSynapse(weights, neuron.derivative(neuron.sum, neuron.sum));
                recursiveBackpropagation(neuron.derivative(neuron.sum, neuron.sum), layers.length-2, weights);
            }
        }
        
     
        
    }
    
    
    private void recursiveBackpropagation(double chainRule, int currentLayer, int currentNeuron){
        if(currentLayer >= 1){
            return;
        }
        
        HiddenNeuron neuron = (HiddenNeuron) layers[currentLayer].neuron(currentNeuron);
        for(int i=0; i<neuron.numOfSynapses(); i++){
            HiddenNeuron prev = (HiddenNeuron) layers[currentLayer-1].neuron(i);
            neuron.setSynapse( i  , chainRule * prev.derivative(prev.sum, prev.sum) * Neuron.LearningRate);
            recursiveBackpropagation(chainRule * prev.derivative(prev.sum, prev.sum), currentLayer-1, i);
        }
    }
    
}
