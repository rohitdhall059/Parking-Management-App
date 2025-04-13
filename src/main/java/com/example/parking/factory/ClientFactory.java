package com.example.parking.factory;

import com.example.parking.model.Client;
import com.example.parking.model.FacultyMember;
import com.example.parking.model.NonFacultyStaff;
import com.example.parking.model.Student;
import com.example.parking.model.Visitor;

/**
 * A factory class for creating different types of clients 
 * based on a string identifier (student, faculty, staff, visitor).
 */
public class ClientFactory {

    /**
     * Creates a Client (or subclass) based on the 'type'.
     *
     * @param type      e.g., "student", "faculty", "staff", "visitor"
     * @param id        unique ID for the client
     * @param name      client's name
     * @param email     client's email
     * @return          a new Client subclass instance
     * @throws IllegalArgumentException if the type is invalid
     */
    public static Client createClient(String type, String id, String name, String email) {
        if (type == null) {
            throw new NullPointerException("Type cannot be null");
        }
        if (id == null || name == null || email == null) {
            throw new NullPointerException("Client parameters cannot be null");
        }
    
        return switch (type.toUpperCase()) {
            case "FM", "FACULTY", "FACULTYMEMBER" -> new FacultyMember(id, name, email, "default1", "default2", "default3");
            case "ST", "STUDENT" -> new Student(id, name, email, "default1", "default2", "default3", "default4");
            case "NF", "NONFACULTY", "NONFACULTYSTAFF" -> new NonFacultyStaff(id, name, email, "default1", "default2", "default3");
            case "VI", "VISITOR" -> new Visitor(id, name, email, "default1", "default2", "default3");
            default -> throw new IllegalArgumentException("Unknown client type: " + type);
        };
    }
}
