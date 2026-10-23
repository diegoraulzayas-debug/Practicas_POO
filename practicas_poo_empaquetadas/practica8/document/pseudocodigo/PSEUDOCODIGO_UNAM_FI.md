# PSEUDOCÓDIGOS (ESTÁNDAR UNAM-FI)
#### HuellaCarbono, Auto, Bicicleta, Edificio, Main

---

### 1. Interfaz HuellaCarbono — Contrato Polimórfico

```text
INICIO
    // Declaración formal de la Interfaz
    interfaz HuellaCarbono

    // Método abstracto del contrato de emisiones de CO2
    publico abstracto Real: getHuellaCarbono()
FIN
```

---

### 2. Clase Auto — Atributos, Constructor y Selectores

```text
INICIO
    // Atributos privados
    privado Real: kilometrosRecorridos
    privado Real: rendimientoKmLitro

    // Constructor Auto(kilometrosRecorridos: Real, rendimientoKmLitro: Real)
    this.kilometrosRecorridos = kilometrosRecorridos
    this.rendimientoKmLitro = rendimientoKmLitro

    // Selector getKilometrosRecorridos(): Real
    RETORNAR this.kilometrosRecorridos

    // Selector getRendimientoKmLitro(): Real
    RETORNAR this.rendimientoKmLitro
FIN
```

---

### 3. Clase Auto — calcularLitrosConsumidos y getHuellaCarbono

```text
INICIO
    // Comportamiento exclusivo: calcularLitrosConsumidos(): Real
    RETORNAR this.kilometrosRecorridos / this.rendimientoKmLitro

    // Implementación HuellaCarbono: getHuellaCarbono(): Real
    // Litros consumidos * factor de emisión por litro de gasolina (2.31 kg CO2/L)
    Declarar Real: litrosConsumidos
    litrosConsumidos = calcularLitrosConsumidos()
    RETORNAR litrosConsumidos * 2.31
FIN
```

---

### 4. Clase Bicicleta — Atributos, Constructor y Selectores

```text
INICIO
    // Atributos privados
    privado Real: kilometrosRecorridos
    privado Cadena: materialFabricacion

    // Constructor Bicicleta(kilometrosRecorridos: Real, materialFabricacion: Cadena)
    this.kilometrosRecorridos = kilometrosRecorridos
    this.materialFabricacion = materialFabricacion

    // Selector getKilometrosRecorridos(): Real
    RETORNAR this.kilometrosRecorridos

    // Selector getMaterialFabricacion(): Cadena
    RETORNAR this.materialFabricacion
FIN
```

---

### 5. Clase Bicicleta — ajustarPresionNeumaticos y getHuellaCarbono

```text
INICIO
    // Comportamiento exclusivo: ajustarPresionNeumaticos(): Vacio
    IMPRIMIR "Presión ajustada para uso urbano con cuadro de " + this.materialFabricacion + "."

    // Implementación HuellaCarbono: getHuellaCarbono(): Real
    Declarar Cadena: material
    Declarar Real: factorEmisionPorKm

    material = aMinusculas(this.materialFabricacion)

    SEGUN_CASO (material)
        CASO "fibra de carbono":
            factorEmisionPorKm = 0.015
        CASO "aluminio":
            factorEmisionPorKm = 0.008
        CASO_DEFECTO:
            factorEmisionPorKm = 0.005
    FIN_SEGUN

    RETORNAR this.kilometrosRecorridos * factorEmisionPorKm
FIN
```

---

### 6. Clase Edificio — Atributos, Constructor y Selectores

```text
INICIO
    // Atributos privados
    privado Real: metrosCuadrados
    privado Entero: numeroPisos
    privado Real: consumoKwhPorMetro

    // Constructor Edificio(m2: Real, pisos: Entero, consumoKwh: Real)
    this.metrosCuadrados = m2
    this.numeroPisos = pisos
    this.consumoKwhPorMetro = consumoKwh

    // Selector getMetrosCuadrados(): Real
    RETORNAR this.metrosCuadrados

    // Selector getNumeroPisos(): Entero
    RETORNAR this.numeroPisos

    // Selector getConsumoKwhPorMetro(): Real
    RETORNAR this.consumoKwhPorMetro
FIN
```

---

### 7. Clase Edificio — calcularAreaPromedioPorPiso y getHuellaCarbono

```text
INICIO
    // Comportamiento exclusivo: calcularAreaPromedioPorPiso(): Real
    RETORNAR this.metrosCuadrados / this.numeroPisos

    // Implementación HuellaCarbono: getHuellaCarbono(): Real
    // Consumo total de energía * factor de emisión eléctrica (0.45 kg CO2e/kWh)
    Declarar Real: consumoTotalKwh
    consumoTotalKwh = this.metrosCuadrados * this.consumoKwhPorMetro
    RETORNAR consumoTotalKwh * 0.45
FIN
```

---

### 8. Clase Main — main

```text
INICIO
    // 1. Instanciación directa de objetos con parámetros representativos
    corporativo = NUEVO Edificio(2500.0, 5, 110.0)
    vehiculoUrbano = NUEVO Auto(12000.0, 14.5)
    biciRuta = NUEVO Bicicleta(3200.0, "Aluminio")

    // 2. Almacenamiento polimórfico en colección de tipo HuellaCarbono
    listaHuellaCarbono = NUEVO Lista<HuellaCarbono>()
    listaHuellaCarbono.agregar(corporativo)
    listaHuellaCarbono.agregar(vehiculoUrbano)
    listaHuellaCarbono.agregar(biciRuta)

    // 3. Impresión de encabezado
    IMPRIMIR "--- CÁLCULO POLIMÓRFICO DE HUELLA DE CARBONO ---"
    IMPRIMIR ""

    // 4. Recorrido del ArrayList ejecutando getHuellaCarbono() polimórficamente
    PARA CADA elemento EN listaHuellaCarbono HACER
        // Identificación del objeto mediante toString()
        IMPRIMIR elemento.toString()

        // Invocación polimórfica dinámica en tiempo de ejecución
        IMPRIMIR "Huella de carbono calculada: " + elemento.getHuellaCarbono() + " kg CO2e"
        IMPRIMIR ""
    FIN_PARA
FIN
```

---
