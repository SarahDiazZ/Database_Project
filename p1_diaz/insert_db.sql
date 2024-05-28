SET SQL_SAFE_UPDATES = 0;

delete from Physician;
delete from Department;
delete from AffiliatedWith;
delete from `Procedure`;
delete from Patient;
delete from Nurse;
delete from Medication;
delete from Prescribes;
delete from Room;
delete from Stay;
delete from Undergoes;
delete from OnCall;
delete from Appointment;

insert into Physician values (1111, "Meeperson Diaz", "Psychiatrist", 678901234);
insert into Physician values (2222, "Tobey Maguire", "Chief of Medicine", 789012345);
insert into Physician values (3333, "Taylor Swift", "Surgeon", 890123456);
insert into Physician values (4444, "Andrew Garfield", "Senior", 901234567);
insert into Physician values (5555, "Tom Holland", "Resident", 012345678);

insert into Department values (1212, "General Medicine", 2222);
insert into Department values (2121, "Surgery", 3333);
insert into Department values (3232, "Psychiatry", 1111);

insert into AffiliatedWith values (1111, 3232);
insert into AffiliatedWith values (3333, 2121);
insert into AffiliatedWith values (2222, 1212);

insert into `Procedure` values (10, "Biopsy", 600.0);
insert into `Procedure` values (11, "Appendectomy", 1500.0);
insert into `Procedure` values (12, "X-rays", 1000.0);

insert into Patient values (2020, 678102345, "Ben Parker", "5540 College Drive", "1984-03-30", "575-998-0228", 12345, 2222);
insert into Patient values (2121, 283219093, "Eddie Brock", "9819 Baron Lane", "1990-02-01", "915-659-4421", 38291, 1111);
insert into Patient values (3030, 827087392, "Mary Jane Watson", "7462 Nordstrom Drive", "2001-09-15", "714-463-7432", 63819, 4444);

insert into Nurse values (4455, "Gwen Stacy", "Nurse", 781632740);
insert into Nurse values (5566, "Harry Osborn", "Nurse", 283907843);
insert into Nurse values (6677, "Rosalie Octavius", "Head Nurse", 381749465);

insert into Medication values (20, "Zoloft");
insert into Medication values (21, "Acetaminophen");
insert into Medication values (22, "Amoxicillin");

insert into Prescribes values (2222, 2020, 22, "2024-01-24", "15mg/day");
insert into Prescribes values (1111, 2121, 20, "2023-10-29", "20mg/day");
insert into Prescribes values (4444, 3030, 21, "2023-08-16", "300mg/day");

insert into Room values (1, "Single");
insert into Room values (2, "Double");
insert into Room values (3, "Single");

insert into Stay values (30, 2020, 1, "2024-01-23", "2024-01-25");
insert into Stay values (31, 2121, 1, "2023-10-27", "2023-11-01");
insert into Stay values (32, 3030, 2, "2023-08-16", "2023-08-17");
insert into Stay values (33, 2020, 2, "2023-08-19", "2023-08-24");


insert into Undergoes values (2020, 10, 30, "2024-01-24", 2222, 6677);
insert into Undergoes values (2121, 12, 31, "2023-10-28", 1111, 5566);
insert into Undergoes values (3030, 11, 32, "2023-08-17", 4444, 4455);

insert into OnCall values (4455, "2023-12-24", "2024-01-01");
insert into OnCall values (5566, "2024-01-02", "2024-02-02");
insert into OnCall values (6677, "2024-02-17", "2024-02-28");

insert into Appointment values (999, 2020, 4455, 2222, "2024-02-01 15:00", "2024-02-01 16:30");
insert into Appointment values (998, 2121, 5566, 1111, "2023-11-10 13:30", "2023-11-10 15:30");
insert into Appointment values (997, 3030, 6677, 4444, "2023-09-20 09:45", "2023-09-20 10:30");
insert into Appointment values (996, 2020, 6677, 2222, "2023-10-31 09:00", "2023-10-31 10:00");
insert into Appointment values (995, 3030, 6677, 1111, "2023-12-09 13:00", "2023-12-09 14:00");