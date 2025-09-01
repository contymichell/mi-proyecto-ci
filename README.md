# Proyecto Java con CI y pruebas automatizadas

## Objetivo
Demostrar uso de Git, Maven, JUnit y CI.

## Pasos realizados
1. Inicialización del repositorio Git (`git init`, `git add`, `git commit`).
2. Configuración de proyecto Maven con dependencias JUnit.
3. Implementación de dos pruebas unitarias atómicas.
4. Creación de .gitignore.
5. Configuración de pipeline CI en GitHub Actions.

## Comandos usados
- `git init`, `git add .`, `git commit -m "..."`
- `mvn archetype:generate ...`
- `mvn test`

## Estructura del proyecto
mi-proyecto-ci/
 ├── src/
 │   ├── main/java/com/ejemplo/Calculadora.java
 │   └── test/java/com/ejemplo/CalculadoraTest.java
 ├── pom.xml
 ├── README.md
 ├── .gitignore
 └── .github/workflows/ci.yml

## Pipeline
Cada `push` o `pull request` ejecuta:
- Compilación con Maven
- Ejecución de tests
- Generación de reportes en `target/surefire-reports/` (logs de tests)
- Generación de cobertura de código en `target/site/jacoco/`
- Subida del reporte JaCoCo como artifact descargable desde GitHub Actions

## Cobertura de tests (JaCoCo)
Se genera automáticamente al ejecutar:
```bash
mvn clean test jacoco:report
target/site/jacoco/index.html