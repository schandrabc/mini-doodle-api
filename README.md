# mini-doodle-api (WIP)

Mini meeting scheduling service, built with **Spring Boot 4**, **Java 21**, **Hexagonal Architecture (ports/adapters)**.

 **Current implementation scope:** **DAO / persistence layer only** (JPA entities + repositories + persistence adapters).  
 **Not implemented yet:** domain rules, use cases, REST API endpoints, booking workflows, Swagger/Actuator for real features.

---

## What’s implemented

### Persistence / DAO layer
  - JPA entities (persistence model)
  - Spring Data JPA repositories
  - Persistence adapters

---

## Architecture (Hexagonal)

Structure:

- `domain.model` *(planned)*: domain types (TimeSlot, Meeting, TimeRange, User)
- `application.port.out` *(partially/fully implemented)*: persistence ports
- `application.service` *(planned)*: use case implementations
- `adapter.out.persistence` *(implemented)*: JPA entities/repos + adapters implementing persistence ports
- `adapter.in.web` *(planned)*: REST controllers + DTOs + ProblemDetail error mapping

---

## Planned REST API (not implemented yet)

Once the domain + use cases + web adapter are implemented, endpoints like the following will be added:

- `POST /api/users`
- `POST /api/users/{USER_ID}/slots`
- `POST /api/users/{HOST_USER_ID}/slots/{HOST_SLOT_ID}/meetings`
- `GET /api/meetings/{MEETING_ID}`
- `GET /api/availability/common`

Swagger UI and Actuator endpoints will also be enabled once the web layer is in place.

---

## Next steps

### Domain + Use Cases
- Implement domain model + invariants (`domain.calendar`)
- Implement application services (`application.service`)
- Booking workflow + validations

### Web layer
- REST controllers + DTOs
- Swagger UI (OpenAPI) + Actuator endpoints