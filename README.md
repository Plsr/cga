Computer Graphics and Animation
===
Let's do Computer Graphics and then Animate them!

## Table of Contents
- [About this Repository](#about-this-repository)
- [Basic Math](#basic-math)

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
