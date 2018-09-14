# Stairwell-Problem
Java Maven Stairwell Problem Api Solution

#Technical Task Outline
Create a program written in Java adhering to good coding practices.
The program will take the input by exposing a HTTP end point.
The program will respond with JSON response.
The content of the response will be the output as per the problem definition.

# Climbing Stairs
#### Problem
A stairwell has a number of flights of stairs separated by landings.
Each flight is a straight line of steps that you can climb without stopping. You can
stride more than one step at a time when climbing each flight.
It takes two strides to turn on the landing and start again on next flight of stairs.

As input, you are given an array listing the number of steps in each flight of stairs in the stairwell. You also
receive the number of steps you can cover with each stride (you could climb 2 steps per stride, or 3 steps per
stride if you were tall and fit).

The stairwell has between 1 and 30 flights inclusive. Each flight can have a maximum of 20 steps. You can
stride between 1 and 4 steps inclusive.

The solution will calculate the minimum number of strides necessary to get to the top of the stairwell.

#### Examples:
Input: {17}, StepsPerStride: 3, Returns: 6

A stairwell with a single flight of with 17 steps. In 5 strides, you've climbed 15 steps. You’ve two steps left to
reach top, which you can cover in 1 stride.

Input: {17, 17}, StepsPerStride: 3, Returns: 14

A similar stairwell, but with 2 flights separated by a landing. 6 strides to the landing, 2 strides to turn, and 6
more strides to get to the top.

Input: {4,9,8,11,7,20,14}, StepsPerStride: 2, Returns: 50


# API Endpoint
/api/stairwell/{flights}/{stride}

#### API Examples:
http://localhost:8080/api/stairwell/17,17/3

Status 200 OK

        {
            "Answer": 14
        }
        
http://localhost:8080/api/stairwell/17/3

Status 200 OK

        {
            "Answer": 6
        }

http://localhost:8080/api/stairwell/4,9,8,11,7,20,14/2

Status 200 OK

        {
            "Answer": 50
        }
