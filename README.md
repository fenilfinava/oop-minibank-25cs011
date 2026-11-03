# Object Oriented Programming (CEUE203) - MiniBank

Student ID: 25CS011  
Course: Object Oriented Programming (CEUE203)  

## Overview
This repository contains the weekly lab practicals (Part A) and the console-based MiniBank project (Part B) completed across the semester.

## Folder Structure
- `lab-01` to `lab-14`: Practice programs for each laboratory session.
- `Miniproject/src`: MiniBank banking application developed progressively lab-by-lab.
- `certificates/`: Coursera course completion certificates and verification links.

## Coursera Course Certificates

- **Student ID**: 25CS011  
- **Student Name**: Fenil Jagdishbhai Finava  
- **Specialization**: Core Java (LearnQuest)  
- **Combined Certificate Submission PDF**: [`certificates/25CS011_Fenil_CourseraCert.pdf`](certificates/25CS011_Fenil_CourseraCert.pdf)  

| No. | Course Name | Certificate | Public Verification URL |
|:---:|---|---|---|
| 1 | Introduction to Java | [`25cs011_corejava1.pdf`](certificates/25cs011_corejava1.pdf) | https://coursera.org/verify/545N25HARI49 |
| 2 | Introduction to Object-Oriented Programming with Java | [`25cs011_corejava2.pdf`](certificates/25cs011_corejava2.pdf) | https://coursera.org/verify/FWTVVYT8N0OX |
| 3 | Object-Oriented Hierarchies in Java | [`25cs011_corejava3.pdf`](certificates/25cs011_corejava3.pdf) | https://coursera.org/verify/G47ZMGXS8UYM |
| 4 | Java Class Library | [`25cs011_corejava4.pdf`](certificates/25cs011_corejava4.pdf) | https://coursera.org/verify/HS1ECQTID07C |
| ★ | **Core Java Specialization (All 4 Courses)** | [`25cs011_corejavafinal.pdf`](certificates/25cs011_corejavafinal.pdf) | https://coursera.org/verify/specialization/LRS1HHFQ7C9L |

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
