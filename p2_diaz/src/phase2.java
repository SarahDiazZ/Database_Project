import java.sql.*;
import java.util.Scanner;

public class phase2 {
    public static void main (String[] args) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/Hospital_Data";
        String username = "root";
        String password = "ChickenNuggets3233";

        System.out.println("Connecting to database...");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            System.out.println("Database connected!\n");

            System.out.println();
            System.out.println("Task 1");
            //Task 1
            Scanner s = new Scanner(System.in);
            System.out.print("Enter a procedure name: ");
            String procedure = s.nextLine();

            resultSet = statement.executeQuery("select Ph.physicianID, Ph.name, Ph.position, Ph.ssn from `Procedure` P, Physician Ph, Undergoes U where Ph.physicianID = U.physicianID and U.procedureID = P.procID and P.name = '" + procedure + "';");
            
            while (resultSet.next()) {
                System.out.println("physicianID: " + resultSet.getInt(1) + ", " + "name: " + resultSet.getString(2) + ", " + "position: " + resultSet.getString(3) + ", " + "ssn: " + resultSet.getInt(4));
            } //End while

            System.out.println();
            System.out.println("Task 2");

            //Task 2
            resultSet = statement.executeQuery("select P.name, Ph.name, N.name, A.startDateTime, A.endDateTime, P.primaryPhysID from Appointment A, Patient P, Nurse N, Physician Ph where A.nurseID = N.nurseID and A.patientID = P.patientID and A.physicianID = Ph.physicianID and P.primaryPhysID != A.physicianID; ");

            while (resultSet.next()) {
                System.out.println("patient_name: " + resultSet.getString(1) + ", " + "physician_name: " + resultSet.getString(2) + ", " + "nurse_name: " + resultSet.getString(3) + ", " + "start_datetime: " + resultSet.getTime(4) + ", " + "end_datetime: " + resultSet.getTime(5) + ", " + "primary_physician: " + resultSet.getString(6));
            }

            System.out.println();
            System.out.println("Task3:");
            //Task 3
            System.out.print("Enter cost of procedure: ");
            String cost = s.nextLine();

            resultSet = statement.executeQuery("select P.patientID, P.name, P.address, P.dob, P.phone, P.insuranceNumber, P.primaryPhysID from Patient P, Undergoes U, `Procedure` Pr where U.patientID = P.patientID and U.procedureID = Pr.procID and Pr.cost > " + cost + ";");

            while (resultSet.next()) {
                System.out.println("patientID: " + resultSet.getInt(1) + ", " + "name: " + resultSet.getString(2) + ", " + "address: " + resultSet.getString(3) + ", " + "dob: " + resultSet.getDate(4) + ", " + "phone: " + resultSet.getString(5) + ", " + "insuranceNumber: " + resultSet.getInt(6) + ", " + "primaryPhysID: " + resultSet.getInt(7));
            }

            System.out.println();
            System.out.println("Task4");

            //Task 4
            System.out.print("Enter Department Name: ");
            String dept = s.nextLine();

            resultSet = statement.executeQuery("select P.patientID, P.ssn, P.name, P.address, P.dob, P.phone, P.insuranceNumber, P.primaryPhysID from Department D, Patient P, Physician Ph where Ph.physicianID = P.primaryPhysID and Ph.physicianID = D.headID and D.name = '" + dept + "';");

            while (resultSet.next()) {
                System.out.println("patientID: " + resultSet.getInt(1) + ", " + "ssn: " + resultSet.getInt(2) + ", " + "name: " + resultSet.getString(3) + ", " + "address: " + resultSet.getString(4) + ", " + "dob: " + resultSet.getDate(5) + ", " + "phone: " + resultSet.getString(6) + ", " + "insuranceNumber: " + resultSet.getInt(7) + ", " + "primaryPhysID: " + resultSet.getInt(8));
            }

            System.out.println();
            System.out.println("Task 5");

            //Task 5
            System.out.print("Enter Medication Name: ");
            String meds = s.nextLine();

            resultSet = statement.executeQuery("select P.name, Ph.name, Pr.prescribedDate from Patient P, Prescribes Pr, Physician Ph, Medication M where Pr.physicianID = Ph.physicianID and Pr.patientID = P.patientID and Pr.medicationID = M.medID and M.name = '" + meds + "';");

            while (resultSet.next()) {
                System.out.println("patient_name: " + resultSet.getString(1) + ", " + "physician_name: " + resultSet.getString(2) + ", " + "prescribed_date: " + resultSet.getDate(3));
            }

            System.out.println();
            System.out.println("Task 6");

            //Task 6
            System.out.print("Enter a Date: ");
            String date = s.nextLine();

            resultSet = statement.executeQuery("select N.nurseID, N.name, N.position, N.ssn, O.startDate, O.endDate from Nurse N, OnCall O where N.nurseID = O.nurseID and '" + date + "'between O.startDate and O.endDate;");

            while (resultSet.next()) {
                System.out.println("nurseID: " + resultSet.getInt(1) + ", " + "name: " + resultSet.getString(2) + ", " + "position: " + resultSet.getString(3) + ", " + "ssn: " + resultSet.getInt(4) + ", " + "on_call_start_date: " + resultSet.getDate(5) + ", " + "on_call_end_date: " + resultSet.getDate(6));
            }

            System.out.println();
            System.out.println("Task 7");

            //Task 7
            System.out.println("Enter a Stay Date: ");
            String sDate = s.nextLine();

            resultSet = statement.executeQuery("select R.roomID, P.name, S.startDate, S.endDate from Patient P, Stay S, Room R where S.patientID = P.patientID and S.roomID = R.roomID and '" + sDate + "'between S.startDate and S.endDate;");

            while (resultSet.next()) {
                System.out.println("RoomID: " + resultSet.getInt(1) + "\n" + "Patient: " + resultSet.getString(2) + ", " + "Stay Start Date: " + resultSet.getDate(3) + ", " + "Stay End Date: " + resultSet.getDate(4) + "\n\n");
            }

            System.out.println();
            System.out.println("Task 8");

            //Task 8
            System.out.println("Enter a Department Name");
            String deptAFW = s.nextLine();

            resultSet = statement.executeQuery("select P.patientID, P.ssn, P.name, P.address, P.dob, P.phone, P.insuranceNumber, P.primaryPhysID, Ph.physicianID, Ph.name, Ph.position, Ph.ssn, A.appID from Appointment A, Patient P, Physician Ph, Department D, AffiliatedWith Aw where A.physicianID = Aw.physicianID and A.patientID = P.patientID and A.physicianID = Ph.physicianID and Aw.physicianID = Ph.physicianID and Aw.departmentID = D.deptID and D.name = '" + deptAFW + "';");

            while (resultSet.next()) {
                System.out.println("patientID: " + resultSet.getInt(1) + ", " + "patient_ssn: " + resultSet.getInt(2) + ", " + "patient_name: " + resultSet.getString(3) + ", " + "patient_address: " + resultSet.getString(4) + ", " + "patient_dob: " + resultSet.getDate(5) + ", " + "patient_phone: " + resultSet.getString(6) + ", " + "patient_insuranceNumber: " + resultSet.getInt(7) + ", " + "patient_primaryPhysID: " + resultSet.getInt(8) + ", " + "physicianID: " + resultSet.getInt(9) + ", " + "physician_name: " + resultSet.getString(10) + ", " + "physician_position: " + resultSet.getString(11) + ", " + "physician_ssn: " + resultSet.getInt(12));
            }
        } //End try

        catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    } //End main
} //End class