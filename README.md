# CIDevopsProject

Learning the functionality of Jenkins

## Project structure ✅

```
CILabProject/

├── src/
│   ├── main/
│   │   ├── java/com/muj/ci/Calculator.java
│   │   └── resources/
│   └── test/
│       └── java/com/muj/ci/CalculatorTest.java
├── pom.xml
├── Jenkinsfile
├── docker/
│   └── Dockerfile
├── scripts/
│   ├── build.sh
│   └── deploy.sh
└── README.md
```

## Quick start 🔧

- Build & test locally: `mvn -B test`
- Build and run (script): `./scripts/build.sh` then `./scripts/deploy.sh`
- Jenkins: `Jenkinsfile` includes stages for build, test and Docker build

## Notes 💡

- `Calculator` is a tiny example class to demonstrate CI and unit tests (JUnit 5).
- Dockerfile is a multi-stage image that packages the Maven-built JAR into a runtime image.
