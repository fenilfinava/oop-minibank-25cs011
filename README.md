# Object Oriented Programming (CEUE203) - MiniBank

Student ID: 25CS011  
Course: Object Oriented Programming (CEUE203)  

## Overview
This repository contains the weekly lab practicals (Part A) and the console-based MiniBank project (Part B) completed across the semester.

## Folder Structure
- `lab-01` to `lab-14`: Practice programs for each laboratory session.
- `Miniproject/src`: MiniBank banking application developed progressively lab-by-lab.

## How to Compile and Run

### 1. Practice Programs (Part A)
Go into any lab directory and compile the java files:
```bash
cd lab-01/Practical-1
javac VendingMachine.java
java VendingMachine
```

### 2. MiniBank Application (Part B)
To compile and run the full MiniBank application:
```bash
cd Miniproject/src
javac exception/*.java model/annotation/*.java model/*.java util/*.java service/*.java repository/*.java MiniBank.java
java MiniBank
```

To run the automated tests:
```bash
java MiniBank --test
```
