Computer Graphics and Animation
===
Let's do Computer Graphics and then Animate them!

## Table of Contents
- [About this Repository](#about-this-repository)
- [Basci Math}(#basic-math)]

## About this Repository
This is my material I worked with for the course Computer Graphics and Animation at the Cologne University of Applied Sciences.  
This Repository contains some older assignments which were solved in 2013/14 with a different professor. I might add the newer assignments as I solve them.  
This file contains everything I learn for the exam and I may want to remember later on. Should there be a problem concerning privacy or copyright feel free to message me: mail [at] christianpoplawski.de.

## Basic Math

### Length of a vector
Given a sample vector:  
![](http://www.sciweavers.org/tex2img.php?eq=%20%5Coverrightarrow%7Ba%7D%20%20%3D%20%0A%5Cleft%28%0A%20%20%5Cbegin%7Barray%7D%7Bc%7D%0A%20%20%20x%20%26%20y%20%26%20z%20%0A%20%20%5Cend%7Barray%7D%20%5Cright%29&bc=White&fc=Black&im=jpg&fs=12&ff=arev&edit=0)  
It's length is calculated via  
![](http://www.sciweavers.org/tex2img.php?eq=%7C%7C%20%5Coverrightarrow%7Ba%7D%20%7C%7C%20%3D%20%20%5Csqrt%7B%20x%5E%7B2%7D%20%2B%20y%5E%7B2%7D%20%2B%20z%5E%7B2%7D%7D%20&bc=White&fc=Black&im=jpg&fs=12&ff=arev&edit=0)  
*Gentle reminder for myself: `||a||` is the [Euclidian norm](https://en.wikipedia.org/wiki/Norm_%28mathematics%29#Euclidean_norm)*

**Example:**  
Given a vector  
![](http://www.sciweavers.org/tex2img.php?eq=%20%5Coverrightarrow%7Ba%7D%20%20%3D%20%5Cleft%28%0A%5Cbegin%7Barray%7D%7Bc%7D%0A3%20%26%205%20%26%209%0A%5Cend%7Barray%7D%20%5Cright%29&bc=White&fc=Black&im=jpg&fs=12&ff=arev&edit=0)  
It's length is  
![](http://www.sciweavers.org/tex2img.php?eq=%7C%7C%20%5Coverrightarrow%7Ba%7D%20%20%7C%7C%20%3D%20%20%5Csqrt%7B%203%5E%7B2%7D%20%2B%205%5E%7B2%7D%20%2B%209%5E%7B2%7D%7D%20%5C%5C%5CLeftrightarrow%20%7C%7C%20%5Coverrightarrow%7Ba%7D%20%20%7C%7C%20%3D%20%20%5Csqrt%7B%209%20%2B%2025%20%2B%2081%7D%5C%5C%0A%5CLeftrightarrow%20%7C%7C%20%5Coverrightarrow%7Ba%7D%20%20%7C%7C%20%3D%20%20%5Csqrt%7B%20115%20%7D%20%5C%5C%0A%5CLeftrightarrow%20%7C%7C%20%5Coverrightarrow%7Ba%7D%20%20%7C%7C%20%3D%20%2010.72%20&bc=White&fc=Black&im=jpg&fs=12&ff=arev&edit=0)

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
![](http://www.sciweavers.org/tex2img.php?eq=%5Ccos%28%20%5Calpha%20%29%20%3D%20%20%5Cfrac%7B3%7D%7B5%7D%20%5C%5C%0A%5CLeftrightarrow%20%5Ccos%28%20%5Calpha%20%29%20%3D%20%200.6%20%20%20%7C%20%20%5Ccos%5E%7B-1%7D%20%5C%5C%0A%5Calpha%20%3D%2053%2C13%20%5Ctextdegree&bc=White&fc=Black&im=jpg&fs=12&ff=arev&edit=0)  
This seems to be a reasonable angle to work with.

*Sorry for the bad formatting in the equation. Example taken from [here](http://www.mathe-total.de/new-MS/sin-cos-tan-und-Saetze.pdf)*
