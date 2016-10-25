# AI
Neural Netowks, Genetic Algoritms and more biological stuff.

How to use the library


// Creating a neural network: 3 neurons in input layer, 2 neurons in single hidden Layer, 1 output neuron
NeuralNetwork nn = new NeuralNetwork(3, 2, 1);

// 2 neurons in input layer, [4-4-3] neurons in hidden layers, 2 output neurons
NeuralNetwork nn2 = new NeuralNetwork(2, new int{4,4,3}, 2);

//Training:  {input (same size as input neurons)} {target output(same size as output neurons)}
 nn.train(new int{2.00000, 0.5000, 1.2000}, new int{1,0} );
 
double[] output =  nn.feed(new int{2.00000, 0.5000, 1.2000});

  
  
