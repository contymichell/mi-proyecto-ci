# Proyecto Java con CI y pruebas automatizadas

## Objetivo
Demostrar uso de Git, Maven, JUnit, Cucumber (BDD) y CI/CD con GitHub Actions, incluyendo reportes de cobertura y dashboards accesibles online.

## Pasos realizados
1. Inicialización del repositorio Git (`git init`, `git add`, `git commit`).
2. Configuración de proyecto Maven con dependencias JUnit 5, Cucumber y JaCoCo.
3. Implementación de pruebas unitarias atómicas.
4. Creación de `.gitignore`.
5. Implementación de escenarios BDD con Cucumber.
6. Configuración de pipeline CI en GitHub Actions.
7. Publicación automática de reportes en GitHub Pages.

## Comandos usados
- `git init`, `git add .`, `git commit -m "..."`
- `mvn archetype:generate ...`
- `mvn test`
- `mvn clean test jacoco:report`

## Estructura del proyecto
mi-proyecto-ci/
├── src/
│ ├── main/java/com/ejemplo/Calculadora.java
│ ├── test/java/com/ejemplo/CalculadoraTest.java
│ └── test/java/com/ejemplo/bdd/runner/CucumberRunnerTest.java
│
│── test/resources/features/login.feature
│
├── pom.xml
├── README.md
├── .gitignore
└── .github/workflows/ci.yml

## Pipeline
Cada `push` o `pull request` ejecuta:
- Compilación con Maven
- Ejecución de:
  - Pruebas unitarias (JUnit)  
  - Escenarios BDD (Cucumber)  
- Generación de reportes:
  - Logs de ejecución en `target/surefire-reports/`
  - Cobertura de código en `target/site/jacoco/`
  - Reporte BDD en `target/cucumber-report.html`
- Subida de reportes como artifacts
- Publicación automática en GitHub Pages

## Cobertura de tests (JaCoCo)
Se genera automáticamente al ejecutar:
```bash
mvn clean test jacoco:report
target/site/jacoco/index.html