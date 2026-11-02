# Hospital Management System

Spring Boot application for managing hospital operations, departments, medical staff, patients, and appointments.

## Technologies
- Java 17 / Java 21
- Spring Boot
- Maven

## Project Structure
The application follows a standard 4-layer architecture:
- `model`: Domain entities (`Hospital`, `Department`, `Room`, `Patient`, `Appointment`, `Doctor`, `Nurse`, `MedicalStaffAppointment`)
- `repository`: In-memory persistence layer using `List`
- `service`: Business logic layer separated per entity
- `controller`: Web layer handling HTTP requests

## Architecture Decisions

### 1. In-Memory Repository with Generic Base Class
- We defined a `HasId` interface and a generic `BaseRepository<T extends HasId>` interface containing standard CRUD operations (`save`, `findAll`, `findById`, `delete`).
- An abstract class `InMemoryRepository<T extends HasId>` implements this interface using a `List<T>` to hold the data in memory.
- Every specific repository (e.g. `PatientRepository`, `DoctorRepository`, `RoomRepository`) extends `InMemoryRepository`, keeping the code clean and avoiding duplicate CRUD implementations (DRY).
- `MedicalStaff` is abstract, while concrete repositories exist for `Doctor` and `Nurse`.

### 2. Service Layer (Single Responsibility)
- We split the business logic into separate services for each main entity (`HospitalService`, `DepartmentService`, `RoomService`, `PatientService`, `DoctorService`, `NurseService`, `AppointmentService`).
- Each service is responsible strictly for its own domain model.
- Controllers never access repositories directly; they only interact with services. Dependencies are injected via constructor.

### 3. Model Extensions
As specified in the project requirements, we extended 3 models with additional fields:
- `Patient`: added `email` (String) and `phoneNumber` (String)
- `Room`: added `floorNumber` (int)
- `Hospital`: added `emergencyHotline` (String)
