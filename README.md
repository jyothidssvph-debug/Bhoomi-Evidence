# Bhoomi Evidence — Land Governance Intelligence

A local-first full-stack prototype for:
Policy question → evidence → geography → scenario comparison → decision brief.

## Stack
- Frontend: HTML, CSS, JavaScript
- Backend: Java 17 + Spring Boot 3
- Database: H2 (zero setup) with JPA
- REST API: Spring MVC
- No API keys required

## Run in IntelliJ
1. Open this folder in IntelliJ IDEA.
2. Make sure Java 17+ is installed.
3. Let Maven import dependencies from `pom.xml`.
4. Run `src/main/java/com/bhoomi/evidence/BhoomiEvidenceApplication.java`.
5. Open: http://localhost:8080

## API endpoints
GET /api/evidence
GET /api/districts
POST /api/scenarios/compare
GET /api/health

The frontend is served by Spring Boot from `src/main/resources/static`.

## Demo data
The included evidence and district values are illustrative demo data. Replace them with verified sources before presenting real-world findings.
