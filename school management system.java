import java.util.Scanner; 
class Student { 
int id; 
String name; 
boolean attendance; 
double marks; 
public Student(int id, String name) { 
this.id = id; 
this.name = name; 
this.attendance = false; 
this.marks = 0.0; 
} 
public void displayStudent() { 
System.out.println("ID: " + id + ", Name: " + name + ", 
Attendance: " + (attendance ? "Present" : "Absent") + ", Marks: " + 
marks); 
} 
} 
public class SchoolManagementSystem 
10 
{ 
static final int MAX_STUDENTS = 100; 
static Student[] students = new Student[MAX_STUDENTS]; 
static int studentCount = 0; 
static Scanner scanner = new Scanner(System.in); 
static final String ADMIN_EMAIL = "admin@school.com"; 
static final String ADMIN_PASSWORD = "admin123"; 
public static void main(String[] args) 
{ 
if (login()) { 
int choice; 
do { 
System.out.println("\n==== School Management System 
===="); 
System.out.println("1. Enroll Student"); 
System.out.println("2. Mark Attendance"); 
System.out.println("3. Enter Marks"); 
System.out.println("4. View All Students"); 
System.out.println("5. Exit"); 
System.out.print("Enter your choice: "); 
choice = scanner.nextInt(); 
switch (choice) 
11 
{ 
case 1: enrollStudent(); break; 
case 2: markAttendance(); break; 
case 3: enterMarks(); break; 
case 4: viewAllStudents(); break; 
case 5: System.out.println("Exiting..."); break; 
default: System.out.println("Invalid choice. Please try 
again."); 
} 
} 
while (choice != 5); 
} 
else { 
} 
} 
System.out.println("Invalid login credentials. Exiting..."); 
public static boolean login() 
{ 
System.out.print("Enter Admin Email: "); 
String email = scanner.next(); 
System.out.print("Enter Admin Password: "); 
String password = scanner.next(); 
12 
return ADMIN_EMAIL.equals(email) && 
ADMIN_PASSWORD.equals(password); 
} 
public static void enrollStudent() 
{ 
if (studentCount >= MAX_STUDENTS) 
{ 
System.out.println("Cannot enroll more students. Capacity 
reached."); 
return; 
} 
System.out.print("Enter Student ID: "); 
int id = scanner.nextInt(); 
scanner.nextLine(); // Consume newline 
System.out.print("Enter Student Name: "); 
String name = scanner.nextLine(); 
students[studentCount++] = new Student(id, name); 
System.out.println("Student enrolled successfully!"); 
} 
public static void markAttendance() 
{ 
13 
System.out.print("Enter Student ID to mark attendance: "); 
int id = scanner.nextInt(); 
boolean found = false; 
for (int i = 0; i < studentCount; i++) 
{ 
if (students[i].id == id) 
{ 
System.out.print("Mark present (1) or absent (0): "); 
students[i].attendance = scanner.nextInt() == 1; 
System.out.println("Attendance updated for " + 
students[i].name); 
found = true; 
break; 
} 
} 
if (!found) { 
System.out.println("Student not found."); 
} 
} 
public static void enterMarks() 
{ 
14 
System.out.print("Enter Student ID to enter marks: "); 
int id = scanner.nextInt(); 
boolean found = false; 
for (int i = 0; i < studentCount; i++) { 
if (students[i].id == id) 
{ 
System.out.print("Enter marks for " + students[i].name + ": 
"); students[i].marks = scanner.nextDouble(); 
System.out.println("Marks updated for " + 
students[i].name); found = true; 
break; 
} 
} 
if (!found) 
{ 
System.out.println("Student not found."); 
} 
} 
public static void viewAllStudents() { 
if (studentCount == 0) 
{ 
System.out.println("No students enrolled."); 
return; 
15 
} 
System.out.println("\nList of Enrolled Students:"); 
for (int i = 0; i < studentCount; i++) { 
students[i].displayStudent(); 
} 
} 
}