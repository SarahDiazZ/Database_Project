# Phase 1: Database Creation and Data Insertion

This phase focuses on creating the database schema and inserting initial data.

## Table of Contents
1. [Introduction](https://github.com/SarahDiazZ/Database_Project/tree/main/p1_diaz#introduction)
2. [Database Schema](https://github.com/SarahDiazZ/Database_Project/tree/main/p1_diaz#database-schema)
3. Data Insertion (link)
4. Files (link)
5. Setup and Installation (link)
6. Usage (link)

## Introduction
In Phase 1, I created the database schema and inserted initial data. This sets the foundation for the subsequent phases of the project

## Database Schema
### Physician Table
The **'Physician'** table stores information about each physician. It includes the following columns:
* **PhysicianID:** A unique identifier for each physician (Primary Key).
* **Name:** The name of the phyisician. 
* **Position:** The position or job title of the physician (e.g., 'Intern', 'Surgeon', 'Senior', 'Chief of Medicine', 'Resident', 'Psychiatrist').
* **SSN:** The social security number of the physician.

### Department Table
The **'Department'** table stores information about each department. It includes the following columns:
* **DepartmentID:** A unique identifier for each department (Primary Key).
* **Name:** The name of each department (e.g., 'General Medicine', 'Surgery', 'Psychiatry').
* **HeadID:** The ID of the physician who is the head of the department (Foreign key referencing `PhysicianID` in the `Physician` table)

* **AffiliatedWith Table:**
* **Procedure Table:**
* **Patient Table:**
* **Nurse Table:**
* **Medication Table:**
* **Prescribes Table:**
* **Room Table:**
* **Stay Table:**
* **Undergoes Table:**
* **OnCall Table:**
* **Appointment Table:**