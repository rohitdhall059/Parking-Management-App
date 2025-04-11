# Parking Management System

## Overview
The **Parking Management System** is a Java-based application that helps manage parking spaces, client registrations, parking bookings, and payments. It is designed to accommodate various types of clients including **Faculty**, **Non-Faculty Staff**, and **Visitors**. The system provides dynamic pricing strategies and discounts for each client type, while ensuring seamless parking management using the **Observer** design pattern for updates and notifications.

## Features

- **Client Registration**: Supports registration of various client types (Faculty, Non-Faculty Staff, and Visitors).
- **Parking Space Management**: Manages parking space availability, including status updates (e.g., occupied, available).
- **Dynamic Pricing**: Utilizes different pricing strategies tailored for each client type.
- **Discounts**: Provides automatic discounts (10-15%) for clients based on their type.
- **CSV-based Data Persistence**: Stores client data and booking information in CSV files.

## Technologies

- **Java 17**: The core language used for building the system.
- **JUnit 5**: For unit testing the core components of the system.
- **Observer Pattern**: To notify clients about changes in parking space availability.
- **Strategy Pattern**: To implement different pricing strategies for clients.
- **CSV File Handling**: Data is stored in CSV files, ensuring persistence.

## Setup & Installation

### Prerequisites

- **Java 17**: Install Java 17 on your machine. You can check the installation by running:
  ```bash
  java -version
  ```

- **Maven**: The project uses Maven for dependency management and build automation. You can check if Maven is installed by running:
  ```bash
  mvn -v
  ```

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/parking-management-system.git
   cd parking-management-system
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn exec:java -Dexec.mainClass="com.example.parking.Main"
   ```

### Running Tests

1. Run unit tests with Maven:
   ```bash
   mvn test
   ```

## Application Workflow

1. **Client Registration**: Clients can register with necessary details (e.g., email, password, client-specific information like department or visitor details).
2. **Parking Space Management**: Clients can view the status of parking spaces (occupied/available) and make bookings.
3. **Booking Parking**: Clients can book parking spaces for specific time periods, with prices calculated based on the client type and selected pricing strategy.
4. **Payment and Discounts**: Clients receive discounts based on their type (e.g., Faculty get 15%, Non-Faculty Staff and Visitors get 10%).

## Directory Structure

```plaintext
parking-management-system/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── example/
│   │   │   │   │   ├── parking/
│   │   │   │   │   │   ├── model/        # Client models (Client, FacultyMember, etc.)
│   │   │   │   │   │   ├── dao/          # Data Access Object for clients (CSVClientDAO)
│   │   │   │   │   │   ├── service/      # Business logic (e.g., client registration service)
│   │   │   │   │   │   ├── observer/     # Observer pattern related classes
│   │   │   │   │   │   ├── strategy/     # Pricing strategies for clients
│   │   │   │   │   │   └── util/         # Utility classes
│   │   │   │   ├── resources/
│   ├── test/                        # Test classes for unit testing
│   └── target/                       # Compiled output directory
│
├── pom.xml                          # Maven configuration file
├── README.md                        # Project overview and instructions
└── .gitignore                       # Git ignore file to exclude unwanted files
```

## Usage Example

1. **Register a Faculty Member**:
   ```java
   FacultyMember faculty = new FacultyMember("F001", "Dr. Smith", "dr.smith@example.com", "password123", "Computer Science", "F123");
   ```

2. **Book a Parking Space**:
   ```java
   ParkingSpace space = new ParkingSpace("A1", true);
   space.book(client);
   ```

## Contributing

Contributions are welcome! If you'd like to contribute, fork the repository, make your changes, and submit a pull request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
