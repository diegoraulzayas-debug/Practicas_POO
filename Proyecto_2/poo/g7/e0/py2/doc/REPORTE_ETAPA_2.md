# Reporte Técnico de Avance - Proyecto Etapa 2
**Universidad Nacional Autónoma de México**  
**Facultad de Ingeniería**  
**Asignatura:** Programación Orientada a Objetos  
**Grupo:** 7  
**Proyecto:** Simulador de Sistema Hospitalario  

---

## 1. Justificación de Diseño y Encapsulamiento Estricto (`private`)

En cumplimiento riguroso con los estándares de la Programación Orientada a Objetos y las especificaciones de la Etapa 2:

### 1.1 Adopción de Visibilidad `private` en todas las Clases
Inicialmente, algunos atributos base contaban con visibilidad `protected` para permitir acceso directo desde subclases; sin embargo, para garantizar el máximo nivel de encapsulamiento y desacoplamiento, **todos los atributos en `Paciente`, `Medico`, `Enfermero`, `MedicoGeneral`, `MedicoEspecialista`, `EnfermeroEspecialista`, `JefeEnfermeria`, `PacienteGeneral`, `PacienteEspecialidad` y `Sistema` se han declarado estrictamente como `private`**.

- Las clases derivadas acceden y modifican el estado de la superclase exclusivamente a través de los métodos de acceso (`getters`) y mutadores (`setters`).
- Se previene cualquier efecto colateral o mutación no controlada desde clases hijas o externas.

### 1.2 Políticas de Getters y Setters
- **Atributos Modificables:** Atributos como `nombre`, `especialidad`, `estaEnConsulta`, `estaEnTratamiento`, `tratamiento`, `consultorioAsignado`, `aniosExperiencia`, `subespecialidad`, `certificacionAvanzada`, `turnoSupervision`, etc., disponen de métodos `get` y `set`. Cada uno incluye validaciones internas para impedir inconsistencias (ejemplo: cadenas vacías, valores nulos o rangos numéricos inválidos).
- **Atributos Inmutables (Justificación de Cédula Profesional):** El atributo `cedula` en las jerarquías de `Medico` y `Enfermero` se definió con modificador `final` y **no cuenta con método `setCedula()`**.  
  *Justificación de diseño y legal:* La cédula profesional es una credencial única e inalterable expedida por la Dirección General de Profesiones que identifica al profesional de la salud durante toda su trayectoria en la institución; permitir su modificación durante la ejecución vulneraría la trazabilidad y la integridad de los expedientes clínicos.
- **Protección de Estructuras Internas:** Los arreglos de asignación de pacientes (`pacientesAsignados`, `medicos`, `enfermeros`) no pueden ser reescritos arbitrariamente desde clases externas; las modificaciones se realizan mediante métodos de negocio (`admitirPaciente()`, `registrarMedico()`, `registrarEnfermero()`, `registrarPaciente()`), garantizando el respeto a las capacidades máximas.

---

## 2. Organización en Paquetes y Módulo JAR

El proyecto se estructuró de acuerdo a las especificaciones de la UNAM:

```
Proyecto_2/
├── lib/
│   └── AtencionMedica.jar        (Interfaz empaquetada como biblioteca reutilizable - Puntos Extra)
├── doc/
│   ├── REPORTE_ETAPA_2.md        (Documento técnico, decisiones y evidencias)
│   └── DIAGRAMA_UML.md           (Especificación de diagramas de clases y paquetes)
├── test/
│   └── SistemaHospitalarioTest.java (Suite de 33 pruebas unitarias automatizadas)
├── src/
│   ├── interfaces/
│   │   └── AtencionMedica.java   (Contrato clínico de atención)
│   ├── pacientes/
│   │   ├── Paciente.java         (Clase abstracta, implements Comparable<Paciente>)
│   │   ├── PacienteGeneral.java  (Subclase para consulta primaria)
│   │   └── PacienteEspecialidad.java (Subclase con triaje y prioridad)
│   ├── personal/
│   │   ├── Medico.java           (Clase abstracta base, implements AtencionMedica)
│   │   ├── MedicoGeneral.java    (Subclase de atención primaria)
│   │   ├── MedicoEspecialista.java (Subclase de alta especialidad)
│   │   ├── Enfermero.java        (Clase abstracta base, implements AtencionMedica)
│   │   ├── EnfermeroEspecialista.java (Subclase con certificación clínica)
│   │   └── JefeEnfermeria.java   (Subclase con rol de supervisión)
│   ├── sistema/
│   │   └── Sistema.java          (Gestor hospitalario y asignación polimórfica)
│   └── main/
│       └── Main.java             (Punto de entrada interactivo y menú de usuario)
```

### 2.1 Empaquetado JAR de la Interfaz
La interfaz `AtencionMedica` fue compilada y empaquetada en `lib/AtencionMedica.jar`. Esto permite desacoplar los contratos de atención clínica de las implementaciones específicas y otorga los puntos extra contemplados en los requisitos de la rúbrica.

---

## 3. Jerarquías de Herencia y Especialización

Se desarrollaron tres jerarquías principales que reutilizan código mediante `super` y añaden atributos y comportamientos especializados:

### 3.1 Jerarquía de Pacientes
- **`Paciente` (Clase Abstracta):** Contiene el estado clínico privado (`nombre`, `especialidad`, `estaEnConsulta`, `estaEnTratamiento`, `tratamiento`), implementa `Comparable<Paciente>` para ordenamiento alfabético descendente y declara los métodos abstractos `solicitarConsulta(Sistema sistema)` y `obtenerTipoCondicion()`.
- **`PacienteGeneral`:**
  - *Atributo propio:* `motivoConsulta` (privado).
  - *Comportamiento propio:* `actualizarMotivo(String nuevoMotivo)`.
  - *Sobrescritura:* Implementa `solicitarConsulta()` solicitando atención en consulta externa de medicina general.
- **`PacienteEspecialidad`:**
  - *Atributos propios:* `nivelUrgencia` (escala 1 a 5) y `diagnosticoPrevio` (privados).
  - *Comportamiento propio:* `actualizarTriage(int nuevoNivel, String observacion)` para calibración de urgencia.
  - *Sobrescritura:* Implementa `solicitarConsulta()` solicitando turno con prioridad y derivación hacia la especialidad médica requerida.

### 3.2 Jerarquía de Médicos
- **`Medico` (Clase Abstracta, implementa `AtencionMedica`):**
  - Mantiene cédula inmutable, especialidad y límite estricto de **10 pacientes** (`pacientesAsignados`).
  - Implementa visualización y ordenamiento descendente de pacientes mediante `Collections.sort()` (Z a A).
  - Declara el método abstracto `puedeAtender(Paciente paciente)`.
- **`MedicoGeneral`:**
  - *Atributo propio:* `consultorioAsignado` (privado).
  - *Comportamiento propio:* `derivarAEspecialista(Paciente paciente, String especialidadRequerida)`.
  - *Sobrescritura:* `darConsulta()` realiza evaluación clínica integral de medicina preventiva en su consultorio. Puede atender a cualquier paciente general o con especialidad `"GENERAL"`.
- **`MedicoEspecialista`:**
  - *Atributos propios:* `aniosExperiencia` y `subespecialidad` (privados).
  - *Comportamiento propio:* `emitirDictamenEspecializado(Paciente paciente, String procedimiento)`.
  - *Sobrescritura:* `darConsulta()` ejecuta protocolos diagnósticos avanzados según la especialidad, y `darTratamiento()` prescribe bajo protocolo especializado. Atiende estrictamente a pacientes de su especialidad correspondiente.

### 3.3 Jerarquía de Enfermeros
- **`Enfermero` (Clase Abstracta, implementa `AtencionMedica`):**
  - Mantiene cédula inmutable, especialidad y límite de **3 pacientes** simultáneos.
  - Implementa ordenamiento mediante `Collections.sort()` descendente para pacientes asignados.
- **`EnfermeroEspecialista`:**
  - *Atributo propio:* `certificacionAvanzada` (privado).
  - *Comportamiento propio:* `monitoreoIntensivo(Paciente paciente)`.
  - *Sobrescritura:* `darTratamiento()` enfocado en terapias de infusión y parámetros críticos. Atiende a pacientes de su especialidad correspondiente.
- **`JefeEnfermeria`:**
  - *Atributos propios:* `turnoSupervision` (MATUTINO/VESPERTINO/NOCTURNO) y `pisoAsignado` (privados).
  - *Comportamiento propio y función adicional:* `supervisarGuardia(Enfermero[] enfermeros, int totalEnfermeros)` para auditoría y coordinación de turnos y cargas del equipo de enfermería.

---

## 4. Demostraciones de Polimorfismo

El sistema implementa ambas variantes de polimorfismo:

### 4.1 Polimorfismo Estático (Sobrecarga de Métodos)
- En `Medico` y `Enfermero`:
  - `darTratamiento(Paciente paciente)`: Aplica el tratamiento base registrado en la ficha del paciente.
  - `darTratamiento(Paciente paciente, String indicacion)`: Sobrecarga que permite emitir una prescripción farmacéutica específica o cuidado directo.
- En `Sistema`:
  - `asignarPaciente(Paciente paciente, Medico medico)`: Asignación a personal médico.
  - `asignarPaciente(Paciente paciente, Enfermero enfermero)`: Asignación a personal de enfermería.

### 4.2 Polimorfismo Dinámico (Sobrescritura y Referencias Genéricas)
- **Estructuras Polimórficas:** En `Sistema.java`, los arreglos `Medico[] medicos`, `Enfermero[] enfermeros` y `Paciente[] pacientes` alojan indistintamente instancias de `MedicoGeneral`, `MedicoEspecialista`, `EnfermeroEspecialista`, `JefeEnfermeria`, `PacienteGeneral` y `PacienteEspecialidad`, sin duplicar colecciones.
- **Invocación Polimórfica:** Mediante la interfaz `AtencionMedica`, un bucle puede iterar sobre referencias de tipo `AtencionMedica` e invocar `darConsulta(paciente)`, despachando en tiempo de ejecución la versión correspondiente a la clase real del objeto.

---

## 5. Algoritmos y Mecanismo de Ordenamiento (Merge Sort Nativo $O(n \log n)$)

Para optimizar el rendimiento y evitar la complejidad $O(n^2)$ del algoritmo de burbuja original en su peor caso, así como eliminar cualquier dependencia de bibliotecas externas de colecciones como `java.util.Collections`:

### 5.1 Implementación Nativa de Merge Sort Descendente (Z a A)
En [Medico.java](file:///c:/Users/diegu/Downloads/Practicas_POO/Proyecto_2/src/personal/Medico.java) y [Enfermero.java](file:///c:/Users/diegu/Downloads/Practicas_POO/Proyecto_2/src/personal/Enfermero.java), el método `verListaPacientes()` implementa **Merge Sort** recursivo nativo con paradigma *divide y vencerás*:
- **Complejidad temporal garantizada:** $O(n \log n)$ tanto en el mejor, promedio como en el peor de los casos (muy superior al $O(n^2)$ de Bubble Sort).
- **Cero bibliotecas externas:** Trabaja puramente con arreglos de objetos `Paciente[]`.
- **Criterio de orden:** Alfabético descendente de la Z a la A comparando lexicográficamente los nombres con `compareToIgnoreCase()`.

```java
private void mergeSortDescendente(Paciente[] arreglo, int izquierda, int derecha) {
    if (izquierda < derecha) {
        int medio = izquierda + (derecha - izquierda) / 2;
        mergeSortDescendente(arreglo, izquierda, medio);
        mergeSortDescendente(arreglo, medio + 1, derecha);
        mezclarDescendente(arreglo, izquierda, medio, derecha);
    }
}
```

### 5.2 Pseudocódigo: Asignación Automática Inteligente
```text
Algoritmo AsignarPacienteAutomatico(paciente)
    Si paciente es nulo Entonces
        Retornar
    FinSi

    Para i <- 0 Hasta sistema.noMedicos - 1 Hacer
        medicoActual <- sistema.medicos[i]
        Si medicoActual.puedeAtender(paciente) Y medicoActual.getNoPacientes() < 10 Entonces
            sistema.asignarPaciente(paciente, medicoActual)
            Retornar
        FinSi
    FinPara

    Escribir "No hay médico disponible con cupo para la especialidad requerida."
FinAlgoritmo
```

---

## 6. Resultados de Pruebas Automatizadas
La clase de prueba `test.SistemaHospitalarioTest` valida:
- **Pruebas de Encapsulamiento Estricto:** 5/5 PASADAS.
- **Pruebas de Límites de Cupo (10 por médico, 3 por enfermero):** 16/16 PASADAS.
- **Pruebas de Compatibilidad de Especialidad:** 4/4 PASADAS.
- **Pruebas de Polimorfismo Dinámico y Estático:** 3/3 PASADAS.
- **Pruebas de Jefatura de Enfermería:** 2/2 PASADAS.
- **Pruebas de Ordenamiento con Collections.sort() (Z a A):** 3/3 PASADAS.
- **Resultado Global:** **33/33 (100% de éxito).**
