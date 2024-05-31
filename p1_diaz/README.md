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
The `Physician` table stores information about each physician. It includes the following columns:
* **PhysicianID:** A unique identifier for each physician (Primary Key).
* **Name:** The name of the phyisician. 
* **Position:** The position or job title of the physician (e.g., 'Intern', 'Surgeon', 'Senior', 'Chief of Medicine', 'Resident', 'Psychiatrist').
* **SSN:** The social security number of the physician.

### Department Table
The `Department` table stores information about each department. It includes the following columns:
* **DepartmentID:** A unique identifier for each department (Primary Key).
* **Name:** The name of each department (e.g., 'General Medicine', 'Surgery', 'Psychiatry').
* **HeadID:** The ID of the physician who is the head of the department (Foreign key referencing `PhysicianID` in the `Physician` table).

### AffiliatedWith Table
The `AffiliatedWith` table stores information about which department each physician is affiliated with. It includes the following columns:
* **PhysicianID:** A unique identifier for each physician (Primary and Foreign Key referecing `PhysicianID` in the `Physician` table).
* **DepartmentID:** A unique identifier for each department (Primary and Foreign Key referencing `DepartmentID` in the `Department` table).

### Procedure Table
The `Procedure` table stores information about each procedure. It includes the following columns:
* **ProcedureID:** A unique identifier for each procedure (Primary Key).
* **Name:** The name of each procedure.
* **Cost:** The cost of each procedure. 

### Patient Table
The `Patient` table stores information about each patient. It includes the following columns:
* **PatientID:** A unique identifier for each patient (Primary Key).
* **SSN:** The social security number of the patient.
* **Name:** The name of the patient.
* **Address:** The home address of the patient.
* **DOB:** The date of birth of the patient.
* **Phone:** The phone number of the patient.
* **InsuranceNumber:** The insurance number of the patient.
* **PrimaryPhysicianID:** The `PhysicianID` of their primary care physician (Foreign Key referencing `PhysicianID` in the `Physician` table). 

### Nurse Table
The `Nurse` table stores information about each nurse. It includes the following columns:
* **NurseID:** A unique idenfitier for each nurse (Primary Key).
* **Name:** The name of the nurse.
* **Position:** The position or job title of the nurse (e.g., 'Head Nurse', 'Nurse').
* **SSN:** The social security number of the nurse.

### Medication Table
The `Medication` table stores information about each mediciation. It includes the following columns:
* **MedicationID:** A unique identifier for each medication (Primary Key).
* **Name:** The name of the medication.

### Prescribes Table
The `Prescribes` table stores information about each medication that has been prescribed. It includes the following columns:
* **PhysicianID:** A unique identifier for each physician (Primary and Foreign Key referencing `PhysicianID` in the `Physician` table).
* **PatientID:** A unique identifier for each patient (Primary and Foregin Key referecing `PatientID` in the `Patient` table).
* **MedicationID:** A unique identifier for each medication (Primary and Foreign Key referencing `MedicationID` in the `Medication` table).
* **PrescribedDate:** The date the medication was prescribed (Primary Key).
* **Dose:** The dose of a medication.

### Room Table
The `Room` table stores information about each room. It includes the following columns:
* **RoomID:** A unique identifier for each room (Primary Key).
* **RoomType:** The type of room (e.g., 'Single', 'Double').

### Stay Table
The `Stay` table stores information about each stay. It includes the following columns:
* **StayID:** A unique identifier for each stay (Primary Key).
* **PatientID:** The ID of the patient (Foreign Key referencing `PatientID` in the `Patient` table).
* **RoomID:** The ID of the room (Foreign Key referecing `RoomID` in the `Room` table).
* **StartDate:** The start date of a stay.
* **EndDate:** The end date of a stay.

### Undergoes Table
The `Undergoes` table stores information about each procedure a patient undergoes. It includes the following columns:
* **PatientID:** A unique identifier for each patient (Primary and Foreign Key referencing `PatientID` in the `Patient` table).
* **ProcedureID:** A unique identifier for each procedure (Primary and Foreign Key referencing `ProcedureID` in the `Procedure` table).
* **StayID:** A unique identifier for each stay (Primary and Foreign Key referencing `StayID` in the `Stay` table).

### OnCall Table
The `OnCall` table stores information about the nurses that are OnCall. It includes the following columns:
* **NurseID:** A unique identifier for each nurse (Primary and Foreign Key referencing `NurseID` in the `Nurse` table).
* **StartDate:** The start date of the on-call period (Primary Key).
* **EndDate:** The end date of the on-call period (Primary Key).

### Appointment Table
The `Appointment` table stores information about each appointment a patient has. It includes the following columns:
* **AppointmentID:** A unique identifier for each appointment made (Primary Key).
* **PatientID:** The ID of the patient (Foreign Key referencing `PatientID` in the `Patient` table).
* **NurseID:** The ID of the nurse (Foreign Key referencing `NurseID` in the `Nurse` table).
* **PhysicianID:** The ID of the physician (Foreign Key referencing `PhysicianID` in the `Nurse` table).
* **StartDateTime:** The start date and time of the appointment.
* **EndDateTime:** The end date and time of the appointment.