# AI
Neural Netowks, Genetic Algoritms and more biological stuff.

How to use the library

Creating a neural network:

Neural Network Structure: int[] structure (bigger than 1 layer).
Ex.

int[] structure = 
{3, 4, 3, 2}
3 Neurons on Input Layer
4 Neurons on 1st Hidden Layer
3 Neurons on 2nd Hidden Layer
2 Neurons on Output Layer

or

{3, 1}
3 Neurons on Input Layer
1 Neuron on Output Layer

etc.

NeuralNetwork net = new NeuralNetwork(structure);

Array of inputs can be of any size
double[] inputs = {ex, ex, ex};

Outputs are of the same size as output neurons
double[] outputs = net.feedForward(inputs);
  
  
