# Hospital Management System

Spring Boot application for managing a hospital (departments, doctors, nurses, patients, and appointments).

## Technologies
- Java 27
- Spring Boot
- Maven

## Project Structure
The application is split into 4 packages:
- `model`: data classes (Hospital, Department, Room, Patient, Appointment, Doctor, Nurse, MedicalStaffAppointment)
- `repository`: in-memory data storage using lists (`List`)
- `service`: application logic for each entity
- `controller`: web endpoints

## OOP and Design Principles Applied
- **Single Responsibility Principle (SRP):** Each layer and class has one clear task. Repositories only store data, services handle business logic and validation, and controllers handle web endpoints.
- **Don't Repeat Yourself (DRY):** We avoided duplicate CRUD code by writing the logic once in the generic `InMemoryRepository<T extends HasId>`.
- **Dependency Inversion Principle (DIP):** Higher layers depend on abstractions (interfaces like `BaseRepository`) rather than concrete in-memory collections, making it easy to swap storage later.

## Architecture and Decisions
- **Generic Repository:** We created a `BaseRepository` interface and an `InMemoryRepository` abstract class using a list. All entities implement `HasId` so we do not have to rewrite basic CRUD methods (save, findById, delete) in every repository.
- **Service per Entity:** Each main model has its own service (e.g., `PatientService`, `DoctorService`) so that each class has a single responsibility.
- **Added Model Fields:**
  - `Patient`: added `email` and `phoneNumber`
  - `Room`: added `floorNumber`
  - `Hospital`: added `emergencyHotline`
- For `Appointment`, we used `LocalDate` for dates instead of plain Strings.

## How to Run
1. Open the project in IntelliJ IDEA.
2. Run `HospitalApplication.java`.
3. Check in your browser: `http://localhost:8080/hello` (it should return `"Die Anwendung funktioniert!"`).
