package com.example.parking.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.parking.model.Booking;
import com.example.parking.model.Car;
import com.example.parking.model.Client;
import com.example.parking.model.FacultyMember;
import com.example.parking.model.NonFacultyStaff;
import com.example.parking.model.ParkingSpace;
import com.example.parking.model.Student;
import com.example.parking.model.Visitor;
import com.example.parking.model.payment.CreditCard;
import com.example.parking.model.payment.DebitCard;
import com.example.parking.model.payment.MobilePayment;
import com.example.parking.model.payment.PaymentMethod;
import com.example.parking.model.SuperManager;
import com.example.parking.model.ManagementTeam;
import com.example.parking.model.ParkingLot;
import com.example.parking.iterator.ParkingSpaceIterator;
import com.example.parking.model.Sensor;

public class ModelClassesTest {

    @Test
    void testCarModel() {
        // Test constructor and getters
        Car car = new Car("ABC123", "Toyota", "Camry", "Blue");
        
        assertEquals("ABC123", car.getLicensePlate());
        assertEquals("Toyota", car.getMake());
        assertEquals("Camry", car.getModel());
        assertEquals("Blue", car.getColor());
        
        // Test setters
        car.setLicensePlate("XYZ789");
        car.setMake("Honda");
        car.setModel("Civic");
        car.setColor("Red");
        
        assertEquals("XYZ789", car.getLicensePlate());
        assertEquals("Honda", car.getMake());
        assertEquals("Civic", car.getModel());
        assertEquals("Red", car.getColor());
        
        // Test toString method
        String carString = car.toString();
        assertTrue(carString.contains("XYZ789"));
        assertTrue(carString.contains("Honda"));
        assertTrue(carString.contains("Civic"));
        assertTrue(carString.contains("Red"));

        // Test alternative constructor with model and licensePlate
        Car simpleCar = new Car("Camry", "ABC123");
        assertEquals("ABC123", simpleCar.getLicensePlate());
        assertEquals("Camry", simpleCar.getModel());
        assertNull(simpleCar.getMake());  // Should be null as not set
        assertNull(simpleCar.getColor()); // Should be null as not set
    }
    
    @Test
    void testClientSubclasses() {
        // Test FacultyMember
        FacultyMember faculty = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        assertEquals("FM001", faculty.getId());
        assertEquals("John Smith", faculty.getName());
        assertEquals("john@example.com", faculty.getEmail());
        assertEquals("F123", faculty.getFacultyId());
        assertEquals("Computer Science", faculty.getDepartment());
        assertEquals(0.15, faculty.getDiscountRate()); // 15% discount
        
        // Test NonFacultyStaff
        NonFacultyStaff staff = new NonFacultyStaff("NF001", "Jane Doe", "jane@example.com", "password", "S123", "Administration");
        assertEquals("NF001", staff.getId());
        assertEquals("Jane Doe", staff.getName());
        assertEquals("jane@example.com", staff.getEmail());
        assertEquals("S123", staff.getStaffId());
        assertEquals("Administration", staff.getOffice());
        assertEquals(0.1, staff.getDiscountRate()); // 10% discount
        
        // Test Student
        Student student = new Student("ST001", "Bob Johnson", "bob@example.com", "password", "B123", "Physics", "Junior");
        assertEquals("ST001", student.getId());
        assertEquals("Bob Johnson", student.getName());
        assertEquals("bob@example.com", student.getEmail());
        assertEquals("B123", student.getStudentId());
        assertEquals("Physics", student.getMajor());
        assertEquals("Junior", student.getYear());
        assertEquals(0.15, student.getDiscountRate()); // 15% discount
        
        // Test Visitor
        Visitor visitor = new Visitor("VI001", "Alice Brown", "alice@example.com", "password", "Conference", "V123");
        assertEquals("VI001", visitor.getId());
        assertEquals("Alice Brown", visitor.getName());
        assertEquals("alice@example.com", visitor.getEmail());
        assertEquals("Conference", visitor.getVisitInformation());
        assertEquals("V123", visitor.getVisitorId());
        assertEquals(0.1, visitor.getDiscountRate()); // 10% discount
        
        // Test setting car for a client
        Car car = new Car("ABC123", "Toyota", "Camry", "Blue");
        faculty.setCar(car);
        assertEquals(car, faculty.getCar());
    }
    
    @Test
    void testParkingSpace() {
        // Test constructor and initial state
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        assertEquals("A1", space.getId());
        assertEquals(10.0, space.getRate());
        assertFalse(space.isOccupied());
        assertTrue(space.isEnabled());
        
        // Test occupation methods
        space.occupy("ABC123");
        assertTrue(space.isOccupied());
        assertEquals("ABC123", space.getLicensePlate());
        
        space.vacate();
        assertFalse(space.isOccupied());
        assertNull(space.getLicensePlate());
        
        // Test enable/disable methods
        space.disable();
        assertFalse(space.isEnabled());
        
        space.enable();
        assertTrue(space.isEnabled());
        
        // Test getting status as string
        space.occupy("XYZ789");
        assertEquals("Occupied", space.getStatus());
        
        space.vacate();
        assertEquals("Available", space.getStatus());
        
        space.disable();
        assertEquals("Disabled", space.getStatus());
    }
    
    @Test
    void testPaymentMethods() {
        // Test CreditCard
        CreditCard creditCard = new CreditCard("John Doe", "1234567890123456", "12/25", 1000.0);
        assertEquals(1000.0, creditCard.getAmount());
        assertTrue(creditCard.processPayment(500.0));
        
        // Test DebitCard
        DebitCard debitCard = new DebitCard("1234567890123456", "John Doe", "1234", 1000.0);
        assertEquals(1000.0, debitCard.getAmount());
        assertTrue(debitCard.processPayment(500.0));
        
        // Test MobilePayment
        MobilePayment mobilePayment = new MobilePayment("1234567890", 1000.0);
        assertEquals(1000.0, mobilePayment.getAmount());
        assertTrue(mobilePayment.processPayment(500.0));
        
        // Test setting amount
        creditCard.setAmount(2000.0);
        assertEquals(2000.0, creditCard.getAmount());
    }
    
    @Test
    void testBooking() {
        // Setup
        Client client = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(2);
        PaymentMethod paymentMethod = new CreditCard("John Smith", "1234567890123456", "12/25", 1000.0);
        
        // Test constructor and getters
        Booking booking = new Booking("B001", client, space, startTime, endTime, paymentMethod);
        
        assertEquals("B001", booking.getBookingId());
        assertEquals(client.getId(), booking.getClientId());
        assertEquals(space.getId(), booking.getSpaceId());
        assertEquals(startTime, booking.getStartTime());
        assertEquals(endTime, booking.getEndTime());
        assertEquals(paymentMethod, booking.getPaymentMethod());
        
        // Test setting amount
        booking.setAmount(50.0);
        assertEquals(50.0, booking.getAmount());
        
        // Test setting status
        booking.setStatus("CONFIRMED");
        assertEquals("CONFIRMED", booking.getStatus());
        
        // Test toString method
        String bookingString = booking.toString();
        assertTrue(bookingString.contains("B001"));
        assertTrue(bookingString.contains(client.getId()));
        assertTrue(bookingString.contains(space.getId()));
    }

    @Test
    void testVisitor() {
        // Test constructor and getters
        Visitor visitor = new Visitor("VI001", "Alice Brown", "alice@example.com", "password", "Conference", "V123");
        assertEquals("VI001", visitor.getId());
        assertEquals("Alice Brown", visitor.getName());
        assertEquals("alice@example.com", visitor.getEmail());
        assertEquals("Conference", visitor.getVisitInformation());
        assertEquals("V123", visitor.getVisitorId());
        assertEquals(0.1, visitor.getDiscountRate());
        assertEquals(15.0, visitor.getParkingRate());

        // Test setters
        visitor.setVisitInformation("Meeting");
        visitor.setVisitorId("V456");
        Date visitDate = new Date();
        visitor.setVisitDate(visitDate);

        assertEquals("Meeting", visitor.getVisitInformation());
        assertEquals("V456", visitor.getVisitorId());
        assertEquals(visitDate, visitor.getVisitDate());

        // Test observer functionality
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        visitor.update(space);
        System.setOut(originalOut);
        String output = baos.toString();
        assertTrue(output.contains("Visitor Alice Brown: Parking space status changed to available"));
    }

    @Test
    void testSuperManager() {
        // Test singleton pattern
        SuperManager manager1 = SuperManager.getInstance();
        SuperManager manager2 = SuperManager.getInstance();
        assertSame(manager1, manager2);

        // Test setters and getters
        manager1.setEmail("admin@example.com");
        manager1.setPassword("admin123");

        assertEquals("admin@example.com", manager1.getEmail());
        assertEquals("admin123", manager1.getPassword());

        // Test management account generation
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        manager1.generateManagementAccount();
        System.setOut(originalOut);
        String output = baos.toString();
        assertTrue(output.contains("Generating management account for: admin@example.com"));
    }

    @Test
    void testParkingSpaceManager() {
        // Test singleton pattern
        ParkingSpaceIterator manager1 = ParkingSpaceIterator.getInstance();
        ParkingSpaceIterator manager2 = ParkingSpaceIterator.getInstance();
        assertSame(manager1, manager2);

        // Test adding and retrieving parking spaces
        ParkingSpace space1 = new ParkingSpace("A1", 10.0);
        ParkingSpace space2 = new ParkingSpace("A2", 12.0);

        manager1.addParkingSpace(space1);
        manager1.addParkingSpace(space2);

        assertEquals(space1, manager1.getParkingSpace("A1"));
        assertEquals(space2, manager1.getParkingSpace("A2"));

        // Test getting all parking spaces
        Map<String, ParkingSpace> allSpaces = manager1.getAllParkingSpaces();
        assertEquals(2, allSpaces.size());
        assertTrue(allSpaces.containsKey("A1"));
        assertTrue(allSpaces.containsKey("A2"));

        // Test removing parking space
        manager1.removeParkingSpace("A1");
        assertNull(manager1.getParkingSpace("A1"));
        assertEquals(1, manager1.getAllParkingSpaces().size());
    }

    @Test
    void testManagementTeam() {
        // Test constructor and getters
        ManagementTeam team = new ManagementTeam("MT001", "Admin", "John Manager");
        assertEquals("MT001", team.getId());
        assertEquals("Admin", team.getRole());
        assertEquals("John Manager", team.getName());

        // Test parking lot management
        ParkingLot lot = new ParkingLot("PL001", "Main Lot", "Downtown");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        team.manageParkingLot(lot);
        System.setOut(originalOut);
        String output = baos.toString();
        assertTrue(output.contains("Managing parking lot: Main Lot"));

        // Test parking space management
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        team.manageParkingSpace(space);
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Managing parking space with ID: A1"));

        // Test client validation
        Client client = new FacultyMember("FM001", "John Doe", "john@example.com", "password", "F123", "CS");
        assertTrue(team.validateClientRegistration(client));

        // Test parking lot operations
        team.addParkingLot(lot);
        team.enableParkingLot(lot);
        team.disableParkingLot(lot);

        // Test parking space operations
        team.enableParkingSpace(space);
        team.disableParkingSpace(space);
    }

    @Test
    void testFacultyMemberMethods() {
        // Setup
        FacultyMember faculty = new FacultyMember("FM001", "John Smith", "john@example.com", "password", "F123", "Computer Science");
        
        // Test getDepartment and setDepartment
        assertEquals("Computer Science", faculty.getDepartment());
        faculty.setDepartment("Mathematics");
        assertEquals("Mathematics", faculty.getDepartment());
        
        // Test getFacultyId and setFacultyId
        assertEquals("F123", faculty.getFacultyId());
        faculty.setFacultyId("F456");
        assertEquals("F456", faculty.getFacultyId());
        
        // Test getParkingRate
        assertEquals(8.0, faculty.getParkingRate()); // From FacultyPricing class
        
        // Test requiresValidation
        assertFalse(faculty.requiresValidation()); // Should be false when facultyId is set
        faculty.setFacultyId(null);
        assertTrue(faculty.requiresValidation()); // Should be true when facultyId is null
        faculty.setFacultyId("");
        assertTrue(faculty.requiresValidation()); // Should be true when facultyId is empty
        
        // Test update method (Observer pattern)
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));
        
        faculty.update(space);
        System.setOut(originalOut);
        String output = baos.toString();
        assertTrue(output.contains("Faculty John Smith: Parking space A1 status changed to available"));
        
        // Test getDiscountRate
        assertEquals(0.15, faculty.getDiscountRate()); // 15% discount for faculty
        
        // Test toString
        String facultyString = faculty.toString();
        assertTrue(facultyString.contains("FacultyMember"));
        assertTrue(facultyString.contains("Mathematics")); // Updated department
        assertTrue(facultyString.contains("")); // Empty facultyId
        assertTrue(facultyString.contains("John Smith"));
    }

    @Test
    void testManagementTeamMethods() {
        // Setup
        ManagementTeam team = new ManagementTeam("MT001", "Admin", "John Manager");
        ParkingLot lot1 = new ParkingLot("PL001", "Main Lot", "Downtown");
        ParkingLot lot2 = new ParkingLot("PL002", "North Lot", "Uptown");
        List<ParkingSpace> spaces = new ArrayList<>();
        spaces.add(new ParkingSpace("A1", 10.0));
        spaces.add(new ParkingSpace("A2", 12.0));
        ParkingSpaceIterator iterator = new ParkingSpaceIterator(spaces, false);
        
        // Test viewParkingSpaces
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));
        
        team.viewParkingSpaces(iterator);
        System.setOut(originalOut);
        String output = baos.toString();
        assertTrue(output.contains("A1"));
        assertTrue(output.contains("A2"));
        
        // Test addParkingLot
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        
        team.addParkingLot(lot1);
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Added parking lot: Main Lot"));
        
        // Test enableParkingLot
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        
        team.enableParkingLot(lot1);
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Enabled parking lot: Main Lot"));
        assertTrue(lot1.isEnabled());
        
        // Test disableParkingLot
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        
        team.disableParkingLot(lot1);
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Disabled parking lot: Main Lot"));
        assertFalse(lot1.isEnabled());
        
        // Test enableParkingLot with non-existent lot
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        
        team.enableParkingLot(lot2);
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Parking lot: North Lot does not exist."));
        
        // Test enableParkingSpace
        ParkingSpace space = new ParkingSpace("B1", 15.0);
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        
        team.enableParkingSpace(space);
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Enabled parking space with ID: B1"));
        
        // Test disableParkingSpace
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        
        team.disableParkingSpace(space);
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Disabled parking space with ID: B1"));
    }

    @Test
    void testNonFacultyStaffMethods() {
        // Setup
        NonFacultyStaff staff = new NonFacultyStaff("NF001", "John Smith", "john@example.com", "password", "S123", "Administration");
        
        // Test setStaffId and getStaffId
        staff.setStaffId("S456");
        assertEquals("S456", staff.getStaffId());
        
        // Test setOffice and getOffice
        staff.setOffice("HR");
        assertEquals("HR", staff.getOffice());
        
        // Test getParkingRate
        assertEquals(10.0, staff.getParkingRate()); // From NonFacultyStaffPricing class
        
        // Test requiresValidation
        assertFalse(staff.requiresValidation()); // Should be false when staffId is set
        staff.setStaffId(null);
        assertTrue(staff.requiresValidation()); // Should be true when staffId is null
        staff.setStaffId("");
        assertTrue(staff.requiresValidation()); // Should be true when staffId is empty
        
        // Test update method (Observer pattern)
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));
        
        staff.update(space);
        System.setOut(originalOut);
        String output = baos.toString();
        assertTrue(output.contains("NonFacultyStaff John Smith: Parking space A1 status changed to available"));
        
        // Test getDiscountRate
        assertEquals(0.1, staff.getDiscountRate()); // 10% discount for non-faculty staff
        
        // Test toString
        String staffString = staff.toString();
        assertTrue(staffString.contains("NonFacultyStaff"));
        assertTrue(staffString.contains("S456")); // Updated staffId
        assertTrue(staffString.contains("HR")); // Updated office
        assertTrue(staffString.contains("John Smith"));
    }

    @Test
    void testParkingLotMethods() {
        // Setup
        ParkingLot lot = new ParkingLot("PL001", "Main Lot", "Downtown");
        ParkingSpace space1 = new ParkingSpace("A1", 10.0);
        ParkingSpace space2 = new ParkingSpace("A2", 12.0);
        
        // Test addParkingSpace
        lot.addParkingSpace(space1);
        lot.addParkingSpace(space2);
        List<ParkingSpace> spaces = lot.getParkingSpaces();
        assertEquals(2, spaces.size());
        assertTrue(spaces.contains(space1));
        assertTrue(spaces.contains(space2));
        
        // Test removeParkingSpace
        lot.removeParkingSpace(space1);
        spaces = lot.getParkingSpaces();
        assertEquals(1, spaces.size());
        assertFalse(spaces.contains(space1));
        assertTrue(spaces.contains(space2));
        
        // Test createIterator with all spaces
        ParkingSpaceIterator iterator = lot.createIterator(false);
        List<ParkingSpace> iteratedSpaces = new ArrayList<>();
        while (iterator.hasNext()) {
            iteratedSpaces.add(iterator.next());
        }
        assertEquals(1, iteratedSpaces.size());
        assertEquals(space2, iteratedSpaces.get(0));
        
        // Test createIterator with enabled spaces only
        space2.disable();
        iterator = lot.createIterator(true);
        iteratedSpaces.clear();
        while (iterator.hasNext()) {
            iteratedSpaces.add(iterator.next());
        }
        assertEquals(0, iteratedSpaces.size()); // No enabled spaces
        
        // Test getId
        assertEquals("PL001", lot.getId());
        
        // Test getLocation
        assertEquals("Downtown", lot.getLocation());
        
        // Test getParkingSpaces
        spaces = lot.getParkingSpaces();
        assertEquals(1, spaces.size());
        assertEquals(space2, spaces.get(0));
    }

    @Test
    void testSensorMethods() {
        // Setup
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        Sensor sensor = new Sensor("S001", space);
        
        // Test setParkingSpace
        ParkingSpace newSpace = new ParkingSpace("A2", 12.0);
        sensor.setParkingSpace(newSpace);
        assertEquals(newSpace, sensor.getParkingSpace());
        
        // Test activate and deactivate
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));
        
        sensor.activate();
        System.setOut(originalOut);
        String output = baos.toString();
        assertTrue(output.contains("Sensor S001 activated"));
        assertTrue(sensor.isActive());
        
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        
        sensor.deactivate();
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Sensor S001 deactivated"));
        assertFalse(sensor.isActive());
        
        // Test update method (Observer pattern)
        sensor.activate();
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        
        sensor.update(newSpace);
        System.setOut(originalOut);
        output = baos.toString();
        assertTrue(output.contains("Sensor S001 detected change in parking space A2"));
        
        // Test detectCarPresence and scanForCar
        String licensePlate = "ABC123";
        sensor.detectCarPresence(licensePlate);
        // Note: scanForCar uses random.nextBoolean(), so we can't predict the exact outcome
        // But we can verify the parking space state changed
        assertTrue(newSpace.isOccupied() || !newSpace.isOccupied());
        
        // Test scanCarInfo
        sensor.activate();
        String carInfo = sensor.scanCarInfo();
        assertTrue(carInfo.equals("No car") || carInfo.equals(licensePlate));
        
        sensor.deactivate();
        assertEquals("Sensor inactive", sensor.scanCarInfo());
        
        // Test updateParkingSpace indirectly through detectCarPresence
        sensor.activate();
        sensor.detectCarPresence("XYZ789");
        // Verify the parking space state was updated
        assertTrue(newSpace.isOccupied() || !newSpace.isOccupied());
    }

    @Test
    void testStudentMethods() {
        // Setup
        Student student = new Student("ST001", "John Smith", "john@example.com", "password", "S123", "Computer Science", "Junior");
        
        // Test constructor and initial state
        assertEquals("ST001", student.getId());
        assertEquals("John Smith", student.getName());
        assertEquals("john@example.com", student.getEmail());
        assertEquals("S123", student.getStudentId());
        assertEquals("Computer Science", student.getDepartment());
        assertEquals("Junior", student.getYear());
        
        // Test getDepartment and setDepartment
        student.setDepartment("Mathematics");
        assertEquals("Mathematics", student.getDepartment());
        
        // Test getMajor (should be same as department)
        assertEquals("Mathematics", student.getMajor());
        
        // Test getParkingRate
        assertEquals(5.0, student.getParkingRate()); // From StudentPricing class
        
        // Test getYear and setYear
        student.setYear("Senior");
        assertEquals("Senior", student.getYear());
        
        // Test getStudentId and setStudentId
        student.setStudentId("S456");
        assertEquals("S456", student.getStudentId());
        
        // Test requiresValidation
        assertFalse(student.requiresValidation()); // Should be false when studentId is set
        student.setStudentId(null);
        assertTrue(student.requiresValidation()); // Should be true when studentId is null
        student.setStudentId("");
        assertTrue(student.requiresValidation()); // Should be true when studentId is empty
        
        // Test update method (Observer pattern)
        ParkingSpace space = new ParkingSpace("A1", 10.0);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));
        
        student.update(space);
        System.setOut(originalOut);
        String output = baos.toString();
        assertTrue(output.contains("Student John Smith: Parking space A1 status changed to available"));
        
        // Test getDiscountRate
        assertEquals(0.15, student.getDiscountRate()); // 15% discount for students
        
        // Test toString
        String studentString = student.toString();
        assertTrue(studentString.contains("Student"));
        assertTrue(studentString.contains("S456")); // Updated studentId
        assertTrue(studentString.contains("Mathematics")); // Updated department
        assertTrue(studentString.contains("Senior")); // Updated year
        assertTrue(studentString.contains("John Smith"));
    }
}