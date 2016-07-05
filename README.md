Computer Graphics and Animation
===
Let's do Computer Graphics and then Animate them!

## Table of Contents
- [About this Repository](#about-this-repository)
- [Basic Math](#basic-math)
  - [Length of a vector](#length-of-a-vector)
  - [Trigonometry](#trigonometry)
  - [Dot-Product (or Scalar Product)](#dot-product-or-scalar-product)
  - [Cross Product](#cross-product)
- [OpenGL Basics](#opengl-basics)
  - [Vertex Buffer Object (VBO)](#vertex-buffer-object-vbo)
  - [Vertex Array Object (VAO)](#vertex-array-object-vao)

## About this Repository
This is my material I worked with for the course Computer Graphics and Animation at the Cologne University of Applied Sciences.  
This Repository contains some older assignments which were solved in 2013/14 with a different professor. I might add the newer assignments as I solve them.  
This file contains everything I learn for the exam and I may want to remember later on. Should there be a problem concerning privacy or copyright feel free to message me: mail [at] christianpoplawski.de.

## Basic Math

### Length of a vector
Given a sample vector:  
![](https://raw.githubusercontent.com/Plsr/cga/master/images_equations/vector_example.png)  
It's length is calculated via  
![](https://raw.githubusercontent.com/Plsr/cga/master/images_equations/vector_length_example.png)  
*Gentle reminder for myself: `||a||` is the [Euclidian norm](https://en.wikipedia.org/wiki/Norm_%28mathematics%29#Euclidean_norm)*

**Example:**  
Given a vector  
![](https://raw.githubusercontent.com/Plsr/cga/master/images_equations/vector_example_real.png)  
It's length is  
![](https://raw.githubusercontent.com/Plsr/cga/master/images_equations/vector_length_real.png)


### Trigonometry
For trigonometry, I'll have to switch over to the german naming because this is how I memorize this stuff since 10th grade (thanks, Franziska). First, the order in which I memorize is `sin`, `cos`, `tan`. The simple phrase to memorize the formulas is `GHAHGA`, pronounced "GAGA" (you know, like the [Queen Song](https://www.youtube.com/watch?v=azdwsXLmrHE)).  
Here is where the german naming kicks in:
```
G = Gegenkathete (Opposite)
A = Ankathete (Adjacent)
H = Hypotenuse
```
So memorizing the formulas is pretty easy: `sin = Gegenkathete / Hypotnuse`, `cos = Ankathete / Hypothenuse` and `tan = Gegenkathete / Ankathete`.  
Easy as pie. I'm totally listening to Queen now.

**Example:**
Let's say we have a ladder with the length of 5 Meters leaning on a wall. The foot of the ladder is 3 Meters away from the wall. Like any good craftsman we want to know at which angle it's leaned against the wall. We don't want that thing slipping when we're up there crafting things!
```
Science:
        /|
       / |
  5m  /  |
     /   |
    /    |
   /     |
  /      |
 /       |
/________|
  3m
```
We have the Adjacent and the Hypotenuse given here, so when we go back to our `GHAHGA` memory trick, thats the `AH` part, hence the we have to use `cos`. Lets get calculating:  
![](https://raw.githubusercontent.com/Plsr/cga/master/images_equations/cos_example.png)  
This seems to be a reasonable angle to work with.

*Sorry for the bad formatting in the equation. Example taken from [here](http://www.mathe-total.de/new-MS/sin-cos-tan-und-Saetze.pdf)*


### Dot-Product (or Scalar Product)
There are two formulas to calculate the dot product, the first and simpler one being  
![](https://raw.githubusercontent.com/Plsr/cga/master/images_equations/dot_product_simple.png)  
This equation returns a real value based on which we can draw some conclusions about the angle the two vectors form:  

```
If the dot product is >0, the vectors point in the same direction (angle <90°).
If the dot product is <0, the two vectors point in opposite directions (angle >90°).
If the dot product is = 0, the two vectors form a 90° angle (because cos(90) = 0).
```

The second formula is a little more complex, but it can be formed to calculate the angle the two vectors form  
![](https://raw.githubusercontent.com/Plsr/cga/master/images_equations/dot_product_complex.png)  

**Example:**  
Given two vectors  
![](https://raw.githubusercontent.com/Plsr/cga/master/images_equations/dot_product_example_vectors.png)  
what is the angle the two form?  
First, let's change the equation a little:  
![](https://raw.githubusercontent.com/Plsr/cga/master/images_equations/dot_product_formed.png)  
Now we can fill in our given values and calculate (I'm jumping over several steps here because we did all of this earlier):  
![](https://raw.githubusercontent.com/Plsr/cga/master/images_equations/dot_product_solved.png)  
*Example taken from [here](http://www.ghg-alsdorf.de/fachkonferenz/mathe/selbstdiagnose/skalarprodukt/test6.pdf)*

### Cross Product
The cross product returns a vector that is orthogonal to the two vectors its calculated with. The formula is  
![](https://raw.githubusercontent.com/Plsr/cga/master/images_equations/cross_product_formula.png)  
There are different ways to go about calculating it, personally I use the following:  
Given two vectors  
![](https://raw.githubusercontent.com/Plsr/cga/master/images_equations/cross_product_vectors.png)  
you write down the first two rows again, then start "crossing" from the 2nd line:  
![](https://raw.githubusercontent.com/Plsr/cga/master/images_equations/cross_product_matrix.png)  
This gives you the matrix for calculating.


## OpenGL Basics

### Vertex Buffer Object (VBO)
A buffer storing data that is needed for rendering. The data is stored directly on the GPU memory, not in the system memory, making it performant. This is merely memory allocation, it contains information on how much memory is needed, but not about how exactly vertex attributes are stored. Following are its core functions.  

**`int glGenBuffer();`**  
Generates a new VBO and returns its ID

**`glBindBuffer(int target, int bufferID);`**  
Use a previously created buffer as the active VBO.  
* `int target`: either  
  * `GL_ARRAY_BUFFER` if the buffer contains actual data or
  * `GL_ELEMENT_ARRAY_BUFFER` if the buffer contains indices into another VBO
* `int bufferID`: The ID of the buffer to be bound

**`glBufferData(int target, java.nio.ByteBuffer data, int usage)`**  
Upload Data to the active (speak: bound) VBO.
* `int target`: see `glBindBuffer();`
* `java.nio.ByteBuffer data`: Pointer to the first data element to be uploaded
* `int usage`: expected usage pattern (i.e. `GL_STATIC_DRAW`)

**`glDeleteBuffers(int bufferID)`**  
Delete a buffer.
* `int bufferID`: ID of the buffer to be deleted

### Vertex Array Object (VAO)
Describe how vertex attributes are stored in a vertex buffer objects (i.e. their properties).

**`int glGenVertexArrays();`**  
Generates a new VAO and returns its ID

**`glBindVertexArray(int vaoID);`**  
Use a previously created array as the active VAO.  
* `int vaoID`: The ID of the array to be bound

**`public static void glVertexAttribPointer(int index, int size, int type, boolean normalized, int stride, java.nio.ByteBuffer pointer)`**  
Specifies the location and organization of a vertex attribute array.  
* `int index`: the index of the generic vertex attribute to be modified (user specified)  
* `int size`: the number of values per vertex that are stored in the array (1 - 4)  
* `int type`: data type of each component in the array (i.e. `GL_FLOAT`, `GL_DOUBLE`, ...)
* `boolean normalized`: whether fixed-point data values should be normalized
* `int stride`:  the byte offset between consecutive generic vertex attributes
* `java.nio.ByteBuffer pointer`: memory address where data begins in the bound array

**`glDeleteVertexArrays(int vaoID);`**  
Delete an array.
* `int vaoID`: ID of the array to be deleted
