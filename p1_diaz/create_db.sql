create table if not exists Physician
	(physicianID	int,
     `name`	varchar(40),
     `position`	varchar(40) check (`position` in ('Intern', 'Surgeon', 'Senior', 'Chief of Medicine', 'Resident', 'Psychiatrist')),
     ssn	int,
     primary key (physicianID)
     );
     
create table if not exists Department
	(deptID	int,
     `name`	varchar(40) check (`name` in ('General Medicine', 'Surgery', 'Psychiatry')),
     headID	int,
     primary key (deptID),
     foreign key (headID) references Physician(physicianID)
		on delete set null 
	);
    
create table if not exists AffiliatedWith
	(physicianID	int,
     departmentID	int,
     primary key (physicianID, departmentID),
     foreign key (physicianID) references Physician(physicianID)
		on delete cascade,
	 foreign key (departmentID) references Department(deptID)
		on delete cascade
	);
    
create table if not exists `Procedure`
	(procID	int,
     `name`	varchar(40),
     cost	real,
     primary key (procID)
	);
    
create table if not exists Patient
	(patientID	int,
     ssn	int,
     `name`	varchar(40),
     address	varchar(100),
     dob	date,
     phone	varchar(16),
     insuranceNumber	int,
     primaryPhysID	int,
     primary key (patientID),
     foreign key (primaryPhysID) references Physician(physicianID)
		on delete set null
	);
    
create table if not exists Nurse
	(nurseID	int,
     `name`	varchar(40),
     `position`	varchar(40) check (`position` in ('Head Nurse', 'Nurse')),
     ssn	int,
     primary key (nurseID)
	);
    
create table if not exists Medication
	(medID	int,
     `name`	varchar(40),
     primary key (medID)
	);
    
create table if not exists Prescribes
	(physicianID	int,
     patientID	int,
     medicationID	int,
     prescribedDate	date,
     dose	varchar(40),
     primary key (physicianID, patientID, medicationID, prescribedDate),
     foreign key (physicianID) references Physician(physicianID)
		on delete cascade,
	 foreign key (patientID) references Patient(patientID)
		on delete cascade,
	 foreign key (medicationID) references Medication(medID)
		on delete cascade
	);
    
create table if not exists Room
	(roomID	int,
	 roomType	varchar(40) check (roomType in ('Single', 'Double')),
     primary key (roomID)
	);
    
create table if not exists Stay
	(stayID	int,
     patientID	int,
     roomID	int,
     startDate	date,
     endDate	date,
	 primary key (stayID),
     foreign key (patientID) references Patient(patientID)
		on delete cascade,
	foreign key (roomID) references Room(roomID)
		on delete set null
	);
    
create table if not exists Undergoes
	(patientID	int,
     procedureID	int,
     stayID	int,
     procDate	date,
     physicianID	int,
     nurseID	int,
     primary key (patientID, procedureID, stayID, procDate),
     foreign key (patientID) references Patient(patientID)
		on delete cascade,
	 foreign key (procedureID) references `Procedure`(procID)
		on delete cascade,
	 foreign key (stayID) references Stay(stayID)
		on delete cascade,
	 foreign key (physicianID) references Physician(physicianID)
		on delete set null,
	 foreign key (nurseID) references Nurse(nurseID)
		on delete set null
	);
    
create table if not exists OnCall
	(nurseID	int,
     startDate	date,
     endDate	date,
     primary key (nurseID, startDate, endDate),
     foreign key (nurseID) references Nurse(nurseID)
		on delete cascade
	);
    
create table if not exists Appointment
	(appID	int,
     patientID	int,
     nurseID	int,
     physicianID	int,
     startDateTime	datetime,
     endDateTime	datetime,
     primary key (appID),
     foreign key (patientID) references Patient(patientID)
		on delete cascade,
     foreign key (nurseID) references Nurse(nurseID)
		on delete set null,
     foreign key (physicianID) references Physician(physicianID)
		on delete set null
	);