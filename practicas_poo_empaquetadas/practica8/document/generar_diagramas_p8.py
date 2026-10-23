import os
import xml.etree.ElementTree as ET
import matplotlib
matplotlib.use('Agg')
import matplotlib.pyplot as plt
import matplotlib.patches as patches
from matplotlib.patches import FancyBboxPatch, Polygon

# Directorios de salida
BASE_DIR = r"c:\Users\carma\Downloads\Pra_7\Practicas_POO\practicas_poo_empaquetadas\practica8\document"
DIAGRAMS_DIR = os.path.join(BASE_DIR, "diagrams")
os.makedirs(BASE_DIR, exist_ok=True)
os.makedirs(DIAGRAMS_DIR, exist_ok=True)

# Paleta oficial semántica Draw.io
COLOR_START_FILL = "#d5e8d4"
COLOR_START_STROKE = "#82b366"
COLOR_PROC_FILL = "#dae8fc"
COLOR_PROC_STROKE = "#6c8ebf"
COLOR_DEC_FILL = "#fff2cc"
COLOR_DEC_STROKE = "#d6b656"
COLOR_MERGE_FILL = "#e1d5e7"
COLOR_MERGE_STROKE = "#9673a6"
COLOR_END_FILL = "#f8cecc"
COLOR_END_STROKE = "#b85450"

# -------------------------------------------------------------
# 1. GENERACIÓN DE ARCHIVOS DRAW.IO (.DRAWIO)
# -------------------------------------------------------------

def build_drawio_xml_suite():
    diagrams = {}

    # 1. Diagrama de Clases UML
    diagrams["01_diagrama_clases_uml"] = ("Diagrama de Clases UML", """
    <mxGraphModel dx="1600" dy="1200" grid="1" gridSize="10" guides="1" tooltips="1" connect="1" arrows="1" fold="1" page="1" pageScale="1" pageWidth="1800" pageHeight="1400" background="#ffffff" math="0" shadow="0">
      <root>
        <mxCell id="0" />
        <mxCell id="1" parent="0" />

        <!-- Interfaz HuellaCarbono -->
        <mxCell id="cls_interfaz" value="&amp;laquo;interface&amp;raquo;&lt;br/&gt;&lt;b&gt;HuellaCarbono&lt;/b&gt;&lt;hr/&gt;&lt;div align=&quot;left&quot;&gt;&lt;i&gt;&amp;lt;sin atributos&amp;gt;&lt;/i&gt;&lt;/div&gt;&lt;hr/&gt;&lt;div align=&quot;left&quot;&gt;+ getHuellaCarbono(): double&lt;/div&gt;" style="shape=rect;fillColor=#ffffff;strokeColor=#000000;strokeWidth=1.8;rounded=0;html=1;whiteSpace=wrap;verticalAlign=top;spacing=8;fontColor=#000000;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="720" y="60" width="360" height="130" as="geometry" />
        </mxCell>

        <!-- Clase Auto -->
        <mxCell id="cls_auto" value="&lt;b&gt;Auto&lt;/b&gt;&lt;hr/&gt;&lt;div align=&quot;left&quot;&gt;- kilometrosRecorridos: double&lt;br/&gt;- rendimientoKmLitro: double&lt;/div&gt;&lt;hr/&gt;&lt;div align=&quot;left&quot;&gt;+ Auto(kilometrosRecorridos: double, rendimientoKmLitro: double)&lt;br/&gt;+ getKilometrosRecorridos(): double&lt;br/&gt;+ getRendimientoKmLitro(): double&lt;br/&gt;+ calcularLitrosConsumidos(): double&lt;br/&gt;+ getHuellaCarbono(): double&lt;br/&gt;+ toString(): String&lt;/div&gt;" style="shape=rect;fillColor=#ffffff;strokeColor=#000000;strokeWidth=1.8;rounded=0;html=1;whiteSpace=wrap;verticalAlign=top;spacing=8;fontColor=#000000;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="80" y="300" width="460" height="230" as="geometry" />
        </mxCell>

        <!-- Clase Bicicleta -->
        <mxCell id="cls_bici" value="&lt;b&gt;Bicicleta&lt;/b&gt;&lt;hr/&gt;&lt;div align=&quot;left&quot;&gt;- kilometrosRecorridos: double&lt;br/&gt;- materialFabricacion: String&lt;/div&gt;&lt;hr/&gt;&lt;div align=&quot;left&quot;&gt;+ Bicicleta(kilometrosRecorridos: double, materialFabricacion: String)&lt;br/&gt;+ getKilometrosRecorridos(): double&lt;br/&gt;+ getMaterialFabricacion(): String&lt;br/&gt;+ ajustarPresionNeumaticos(): void&lt;br/&gt;+ getHuellaCarbono(): double&lt;br/&gt;+ toString(): String&lt;/div&gt;" style="shape=rect;fillColor=#ffffff;strokeColor=#000000;strokeWidth=1.8;rounded=0;html=1;whiteSpace=wrap;verticalAlign=top;spacing=8;fontColor=#000000;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="670" y="300" width="460" height="230" as="geometry" />
        </mxCell>

        <!-- Clase Edificio -->
        <mxCell id="cls_edificio" value="&lt;b&gt;Edificio&lt;/b&gt;&lt;hr/&gt;&lt;div align=&quot;left&quot;&gt;- metrosCuadrados: double&lt;br/&gt;- numeroPisos: int&lt;br/&gt;- consumoKwhPorMetro: double&lt;/div&gt;&lt;hr/&gt;&lt;div align=&quot;left&quot;&gt;+ Edificio(metrosCuadrados: double, numeroPisos: int, consumoKwhPorMetro: double)&lt;br/&gt;+ getMetrosCuadrados(): double&lt;br/&gt;+ getNumeroPisos(): int&lt;br/&gt;+ getConsumoKwhPorMetro(): double&lt;br/&gt;+ calcularAreaPromedioPorPiso(): double&lt;br/&gt;+ getHuellaCarbono(): double&lt;br/&gt;+ toString(): String&lt;/div&gt;" style="shape=rect;fillColor=#ffffff;strokeColor=#000000;strokeWidth=1.8;rounded=0;html=1;whiteSpace=wrap;verticalAlign=top;spacing=8;fontColor=#000000;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="1260" y="300" width="480" height="245" as="geometry" />
        </mxCell>

        <!-- Herencia / Implementación Auto -> HuellaCarbono (Línea continua ──▷) -->
        <mxCell id="rel_impl_auto" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=0.5;exitY=0;exitDx=0;exitDy=0;entryX=0.15;entryY=1;entryDx=0;entryDy=0;endArrow=block;endSize=14;endFill=0;strokeColor=#000000;strokeWidth=1.8;" edge="1" parent="1" source="cls_auto" target="cls_interfaz">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>

        <!-- Herencia / Implementación Bicicleta -> HuellaCarbono (Línea continua ──▷) -->
        <mxCell id="rel_impl_bici" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=0.5;exitY=0;exitDx=0;exitDy=0;entryX=0.5;entryY=1;entryDx=0;entryDy=0;endArrow=block;endSize=14;endFill=0;strokeColor=#000000;strokeWidth=1.8;" edge="1" parent="1" source="cls_bici" target="cls_interfaz">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>

        <!-- Herencia / Implementación Edificio -> HuellaCarbono (Línea continua ──▷) -->
        <mxCell id="rel_impl_edificio" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=0.5;exitY=0;exitDx=0;exitDy=0;entryX=0.85;entryY=1;entryDx=0;entryDy=0;endArrow=block;endSize=14;endFill=0;strokeColor=#000000;strokeWidth=1.8;" edge="1" parent="1" source="cls_edificio" target="cls_interfaz">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>

        <!-- Clase Main -->
        <mxCell id="cls_main" value="&lt;b&gt;Main&lt;/b&gt;&lt;hr/&gt;&lt;div align=&quot;left&quot;&gt;&lt;i&gt;&amp;lt;sin atributos&amp;gt;&lt;/i&gt;&lt;/div&gt;&lt;hr/&gt;&lt;div align=&quot;left&quot;&gt;+ Main()&lt;br/&gt;+ &lt;u&gt;main(args: String[]): void&lt;/u&gt;&lt;/div&gt;" style="shape=rect;fillColor=#ffffff;strokeColor=#000000;strokeWidth=1.8;rounded=0;html=1;whiteSpace=wrap;verticalAlign=top;spacing=8;fontColor=#000000;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="740" y="660" width="320" height="135" as="geometry" />
        </mxCell>

        <!-- Dependencias de Main hacia Clases -->
        <mxCell id="rel_dep_main_auto" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=0;exitY=0.5;exitDx=0;exitDy=0;entryX=0.5;entryY=1;entryDx=0;entryDy=0;dashed=1;endArrow=open;endSize=10;strokeColor=#000000;strokeWidth=1.5;" edge="1" parent="1" source="cls_main" target="cls_auto">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="rel_dep_main_bici" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=0.5;exitY=0;exitDx=0;exitDy=0;entryX=0.5;entryY=1;entryDx=0;entryDy=0;dashed=1;endArrow=open;endSize=10;strokeColor=#000000;strokeWidth=1.5;" edge="1" parent="1" source="cls_main" target="cls_bici">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
        <mxCell id="rel_dep_main_edif" style="edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;exitX=1;exitY=0.5;exitDx=0;exitDy=0;entryX=0.5;entryY=1;entryDx=0;entryDy=0;dashed=1;endArrow=open;endSize=10;strokeColor=#000000;strokeWidth=1.5;" edge="1" parent="1" source="cls_main" target="cls_edificio">
          <mxGeometry relative="1" as="geometry" />
        </mxCell>
      </root>
    </mxGraphModel>
    """)

    # 2. Auto.calcularLitrosConsumidos()
    diagrams["02_flujo_auto_calcularLitrosConsumidos"] = ("Auto.calcularLitrosConsumidos()", """
    <mxGraphModel dx="1000" dy="800" grid="1" gridSize="10" guides="1" tooltips="1" connect="1" arrows="1" fold="1" page="1" pageScale="1" pageWidth="800" pageHeight="600" background="#ffffff" math="0" shadow="0">
      <root>
        <mxCell id="0" />
        <mxCell id="1" parent="0" />
        <mxCell id="node_start" value="● Inicio" style="shape=ellipse;fillColor=#d5e8d4;strokeColor=#82b366;fontColor=#000000;strokeWidth=2;html=1;align=center;verticalAlign=middle;fontStyle=1;fontSize=13;" vertex="1" parent="1">
          <mxGeometry x="340" y="40" width="120" height="45" as="geometry" />
        </mxCell>
        <mxCell id="node_calc" value="litros = kilometrosRecorridos / rendimientoKmLitro" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="150" y="130" width="500" height="55" as="geometry" />
        </mxCell>
        <mxCell id="node_merge" value="" style="rhombus;fillColor=#e1d5e7;strokeColor=#9673a6;strokeWidth=1.5;html=1;" vertex="1" parent="1">
          <mxGeometry x="375" y="230" width="50" height="40" as="geometry" />
        </mxCell>
        <mxCell id="node_ret" value="return litros" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="325" y="310" width="150" height="45" as="geometry" />
        </mxCell>
        <mxCell id="node_end" value="◉ Fin" style="shape=ellipse;fillColor=#f8cecc;strokeColor=#b85450;fontColor=#000000;strokeWidth=2.5;html=1;align=center;verticalAlign=middle;fontStyle=1;fontSize=13;" vertex="1" parent="1">
          <mxGeometry x="340" y="400" width="120" height="45" as="geometry" />
        </mxCell>
        <mxCell id="e0" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_start" target="node_calc" />
        <mxCell id="e1" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_calc" target="node_merge" />
        <mxCell id="e2" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_merge" target="node_ret" />
        <mxCell id="e3" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_ret" target="node_end" />
      </root>
    </mxGraphModel>
    """)

    # 3. Auto.getHuellaCarbono()
    diagrams["03_flujo_auto_getHuellaCarbono"] = ("Auto.getHuellaCarbono()", """
    <mxGraphModel dx="1000" dy="800" grid="1" gridSize="10" guides="1" tooltips="1" connect="1" arrows="1" fold="1" page="1" pageScale="1" pageWidth="800" pageHeight="650" background="#ffffff" math="0" shadow="0">
      <root>
        <mxCell id="0" />
        <mxCell id="1" parent="0" />
        <mxCell id="node_start" value="● Inicio" style="shape=ellipse;fillColor=#d5e8d4;strokeColor=#82b366;fontColor=#000000;strokeWidth=2;html=1;align=center;verticalAlign=middle;fontStyle=1;fontSize=13;" vertex="1" parent="1">
          <mxGeometry x="340" y="40" width="120" height="45" as="geometry" />
        </mxCell>
        <mxCell id="node_call" value="litrosConsumidos = calcularLitrosConsumidos()" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="170" y="130" width="460" height="55" as="geometry" />
        </mxCell>
        <mxCell id="node_mult" value="emisiones = litrosConsumidos * 2.31&#xa;(Factor estándar gasolina: 2.31 kg CO2/L)" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="170" y="225" width="460" height="60" as="geometry" />
        </mxCell>
        <mxCell id="node_merge" value="" style="rhombus;fillColor=#e1d5e7;strokeColor=#9673a6;strokeWidth=1.5;html=1;" vertex="1" parent="1">
          <mxGeometry x="375" y="325" width="50" height="40" as="geometry" />
        </mxCell>
        <mxCell id="node_ret" value="return emisiones" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="325" y="405" width="150" height="45" as="geometry" />
        </mxCell>
        <mxCell id="node_end" value="◉ Fin" style="shape=ellipse;fillColor=#f8cecc;strokeColor=#b85450;fontColor=#000000;strokeWidth=2.5;html=1;align=center;verticalAlign=middle;fontStyle=1;fontSize=13;" vertex="1" parent="1">
          <mxGeometry x="340" y="495" width="120" height="45" as="geometry" />
        </mxCell>
        <mxCell id="e0" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_start" target="node_call" />
        <mxCell id="e1" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_call" target="node_mult" />
        <mxCell id="e2" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_mult" target="node_merge" />
        <mxCell id="e3" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_merge" target="node_ret" />
        <mxCell id="e4" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_ret" target="node_end" />
      </root>
    </mxGraphModel>
    """)

    # 4. Bicicleta.ajustarPresionNeumaticos()
    diagrams["04_flujo_bicicleta_ajustarPresionNeumaticos"] = ("Bicicleta.ajustarPresionNeumaticos()", """
    <mxGraphModel dx="1000" dy="800" grid="1" gridSize="10" guides="1" tooltips="1" connect="1" arrows="1" fold="1" page="1" pageScale="1" pageWidth="800" pageHeight="550" background="#ffffff" math="0" shadow="0">
      <root>
        <mxCell id="0" />
        <mxCell id="1" parent="0" />
        <mxCell id="node_start" value="● Inicio" style="shape=ellipse;fillColor=#d5e8d4;strokeColor=#82b366;fontColor=#000000;strokeWidth=2;html=1;align=center;verticalAlign=middle;fontStyle=1;fontSize=13;" vertex="1" parent="1">
          <mxGeometry x="340" y="40" width="120" height="45" as="geometry" />
        </mxCell>
        <mxCell id="node_msg" value="mensaje = &quot;Presión ajustada para uso urbano con cuadro de &quot; + materialFabricacion + &quot;.&quot;" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="130" y="130" width="540" height="60" as="geometry" />
        </mxCell>
        <mxCell id="node_print" value="System.out.println(mensaje)" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="260" y="230" width="280" height="50" as="geometry" />
        </mxCell>
        <mxCell id="node_merge" value="" style="rhombus;fillColor=#e1d5e7;strokeColor=#9673a6;strokeWidth=1.5;html=1;" vertex="1" parent="1">
          <mxGeometry x="375" y="320" width="50" height="40" as="geometry" />
        </mxCell>
        <mxCell id="node_end" value="◉ Fin" style="shape=ellipse;fillColor=#f8cecc;strokeColor=#b85450;fontColor=#000000;strokeWidth=2.5;html=1;align=center;verticalAlign=middle;fontStyle=1;fontSize=13;" vertex="1" parent="1">
          <mxGeometry x="340" y="400" width="120" height="45" as="geometry" />
        </mxCell>
        <mxCell id="e0" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_start" target="node_msg" />
        <mxCell id="e1" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_msg" target="node_print" />
        <mxCell id="e2" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_print" target="node_merge" />
        <mxCell id="e3" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_merge" target="node_end" />
      </root>
    </mxGraphModel>
    """)

    # 5. Bicicleta.getHuellaCarbono() (Switch-case)
    diagrams["05_flujo_bicicleta_getHuellaCarbono"] = ("Bicicleta.getHuellaCarbono()", """
    <mxGraphModel dx="1200" dy="1000" grid="1" gridSize="10" guides="1" tooltips="1" connect="1" arrows="1" fold="1" page="1" pageScale="1" pageWidth="1000" pageHeight="800" background="#ffffff" math="0" shadow="0">
      <root>
        <mxCell id="0" />
        <mxCell id="1" parent="0" />
        <mxCell id="node_start" value="● Inicio" style="shape=ellipse;fillColor=#d5e8d4;strokeColor=#82b366;fontColor=#000000;strokeWidth=2;html=1;align=center;verticalAlign=middle;fontStyle=1;fontSize=13;" vertex="1" parent="1">
          <mxGeometry x="440" y="30" width="120" height="45" as="geometry" />
        </mxCell>
        <mxCell id="node_norm" value="mat = materialFabricacion.toLowerCase()" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="310" y="110" width="380" height="50" as="geometry" />
        </mxCell>
        <mxCell id="node_dec1" value="¿mat == &quot;fibra de carbono&quot;?" style="rhombus;fillColor=#fff2cc;strokeColor=#d6b656;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="360" y="200" width="280" height="70" as="geometry" />
        </mxCell>
        <mxCell id="node_act_fibra" value="factorEmisionPorKm = 0.015" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="670" y="210" width="240" height="50" as="geometry" />
        </mxCell>
        <mxCell id="node_dec2" value="¿mat == &quot;aluminio&quot;?" style="rhombus;fillColor=#fff2cc;strokeColor=#d6b656;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="380" y="315" width="240" height="70" as="geometry" />
        </mxCell>
        <mxCell id="node_act_alum" value="factorEmisionPorKm = 0.008" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="670" y="325" width="240" height="50" as="geometry" />
        </mxCell>
        <mxCell id="node_act_default" value="factorEmisionPorKm = 0.005&#xa;(case &quot;acero&quot; / default)" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="355" y="430" width="290" height="55" as="geometry" />
        </mxCell>
        <mxCell id="node_merge_switch" value="" style="rhombus;fillColor=#e1d5e7;strokeColor=#9673a6;strokeWidth=1.5;html=1;" vertex="1" parent="1">
          <mxGeometry x="470" y="525" width="60" height="45" as="geometry" />
        </mxCell>
        <mxCell id="node_calc_final" value="huella = kilometrosRecorridos * factorEmisionPorKm" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="250" y="605" width="500" height="55" as="geometry" />
        </mxCell>
        <mxCell id="node_merge_final" value="" style="rhombus;fillColor=#e1d5e7;strokeColor=#9673a6;strokeWidth=1.5;html=1;" vertex="1" parent="1">
          <mxGeometry x="475" y="690" width="50" height="40" as="geometry" />
        </mxCell>
        <mxCell id="node_ret" value="return huella" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="430" y="755" width="140" height="40" as="geometry" />
        </mxCell>
        <mxCell id="node_end" value="◉ Fin" style="shape=ellipse;fillColor=#f8cecc;strokeColor=#b85450;fontColor=#000000;strokeWidth=2.5;html=1;align=center;verticalAlign=middle;fontStyle=1;fontSize=13;" vertex="1" parent="1">
          <mxGeometry x="440" y="830" width="120" height="45" as="geometry" />
        </mxCell>

        <mxCell id="e0" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_start" target="node_norm" />
        <mxCell id="e1" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_norm" target="node_dec1" />
        <mxCell id="e2_si" value="[sí]" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;fontColor=#000000;" edge="1" parent="1" source="node_dec1" target="node_act_fibra" />
        <mxCell id="e2_no" value="[no]" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;fontColor=#000000;" edge="1" parent="1" source="node_dec1" target="node_dec2" />
        <mxCell id="e3_si" value="[sí]" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;fontColor=#000000;" edge="1" parent="1" source="node_dec2" target="node_act_alum" />
        <mxCell id="e3_no" value="[no]" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;fontColor=#000000;" edge="1" parent="1" source="node_dec2" target="node_act_default" />
        
        <mxCell id="e4_fibra" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_act_fibra" target="node_merge_switch">
          <mxGeometry relative="1" as="geometry">
            <Array as="points"><mxPoint x="790" y="548" /></Array>
          </mxGeometry>
        </mxCell>
        <mxCell id="e4_alum" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_act_alum" target="node_merge_switch">
          <mxGeometry relative="1" as="geometry">
            <Array as="points"><mxPoint x="790" y="548" /></Array>
          </mxGeometry>
        </mxCell>
        <mxCell id="e4_def" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_act_default" target="node_merge_switch" />
        
        <mxCell id="e5" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_merge_switch" target="node_calc_final" />
        <mxCell id="e6" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_calc_final" target="node_merge_final" />
        <mxCell id="e7" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_merge_final" target="node_ret" />
        <mxCell id="e8" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_ret" target="node_end" />
      </root>
    </mxGraphModel>
    """)

    # 6. Edificio.calcularAreaPromedioPorPiso()
    diagrams["06_flujo_edificio_calcularAreaPromedioPorPiso"] = ("Edificio.calcularAreaPromedioPorPiso()", """
    <mxGraphModel dx="1000" dy="800" grid="1" gridSize="10" guides="1" tooltips="1" connect="1" arrows="1" fold="1" page="1" pageScale="1" pageWidth="800" pageHeight="600" background="#ffffff" math="0" shadow="0">
      <root>
        <mxCell id="0" />
        <mxCell id="1" parent="0" />
        <mxCell id="node_start" value="● Inicio" style="shape=ellipse;fillColor=#d5e8d4;strokeColor=#82b366;fontColor=#000000;strokeWidth=2;html=1;align=center;verticalAlign=middle;fontStyle=1;fontSize=13;" vertex="1" parent="1">
          <mxGeometry x="340" y="40" width="120" height="45" as="geometry" />
        </mxCell>
        <mxCell id="node_calc" value="areaPromedio = metrosCuadrados / numeroPisos" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="140" y="130" width="520" height="55" as="geometry" />
        </mxCell>
        <mxCell id="node_merge" value="" style="rhombus;fillColor=#e1d5e7;strokeColor=#9673a6;strokeWidth=1.5;html=1;" vertex="1" parent="1">
          <mxGeometry x="375" y="230" width="50" height="40" as="geometry" />
        </mxCell>
        <mxCell id="node_ret" value="return areaPromedio" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="315" y="310" width="170" height="45" as="geometry" />
        </mxCell>
        <mxCell id="node_end" value="◉ Fin" style="shape=ellipse;fillColor=#f8cecc;strokeColor=#b85450;fontColor=#000000;strokeWidth=2.5;html=1;align=center;verticalAlign=middle;fontStyle=1;fontSize=13;" vertex="1" parent="1">
          <mxGeometry x="340" y="400" width="120" height="45" as="geometry" />
        </mxCell>
        <mxCell id="e0" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_start" target="node_calc" />
        <mxCell id="e1" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_calc" target="node_merge" />
        <mxCell id="e2" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_merge" target="node_ret" />
        <mxCell id="e3" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_ret" target="node_end" />
      </root>
    </mxGraphModel>
    """)

    # 7. Edificio.getHuellaCarbono()
    diagrams["07_flujo_edificio_getHuellaCarbono"] = ("Edificio.getHuellaCarbono()", """
    <mxGraphModel dx="1000" dy="800" grid="1" gridSize="10" guides="1" tooltips="1" connect="1" arrows="1" fold="1" page="1" pageScale="1" pageWidth="800" pageHeight="650" background="#ffffff" math="0" shadow="0">
      <root>
        <mxCell id="0" />
        <mxCell id="1" parent="0" />
        <mxCell id="node_start" value="● Inicio" style="shape=ellipse;fillColor=#d5e8d4;strokeColor=#82b366;fontColor=#000000;strokeWidth=2;html=1;align=center;verticalAlign=middle;fontStyle=1;fontSize=13;" vertex="1" parent="1">
          <mxGeometry x="340" y="40" width="120" height="45" as="geometry" />
        </mxCell>
        <mxCell id="node_kwh" value="consumoTotalKwh = metrosCuadrados * consumoKwhPorMetro" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="120" y="130" width="560" height="55" as="geometry" />
        </mxCell>
        <mxCell id="node_factor" value="emisiones = consumoTotalKwh * 0.45&#xa;(Factor promedio eléctrico: 0.45 kg CO2e/kWh)" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="140" y="225" width="520" height="60" as="geometry" />
        </mxCell>
        <mxCell id="node_merge" value="" style="rhombus;fillColor=#e1d5e7;strokeColor=#9673a6;strokeWidth=1.5;html=1;" vertex="1" parent="1">
          <mxGeometry x="375" y="325" width="50" height="40" as="geometry" />
        </mxCell>
        <mxCell id="node_ret" value="return emisiones" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="325" y="405" width="150" height="45" as="geometry" />
        </mxCell>
        <mxCell id="node_end" value="◉ Fin" style="shape=ellipse;fillColor=#f8cecc;strokeColor=#b85450;fontColor=#000000;strokeWidth=2.5;html=1;align=center;verticalAlign=middle;fontStyle=1;fontSize=13;" vertex="1" parent="1">
          <mxGeometry x="340" y="495" width="120" height="45" as="geometry" />
        </mxCell>
        <mxCell id="e0" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_start" target="node_kwh" />
        <mxCell id="e1" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_kwh" target="node_factor" />
        <mxCell id="e2" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_factor" target="node_merge" />
        <mxCell id="e3" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_merge" target="node_ret" />
        <mxCell id="e4" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_ret" target="node_end" />
      </root>
    </mxGraphModel>
    """)

    # 8. Main.main(String[] args)
    diagrams["08_flujo_main_main"] = ("Main.main(String[] args)", """
    <mxGraphModel dx="1200" dy="1000" grid="1" gridSize="10" guides="1" tooltips="1" connect="1" arrows="1" fold="1" page="1" pageScale="1" pageWidth="1000" pageHeight="1100" background="#ffffff" math="0" shadow="0">
      <root>
        <mxCell id="0" />
        <mxCell id="1" parent="0" />
        <mxCell id="node_start" value="● Inicio" style="shape=ellipse;fillColor=#d5e8d4;strokeColor=#82b366;fontColor=#000000;strokeWidth=2;html=1;align=center;verticalAlign=middle;fontStyle=1;fontSize=13;" vertex="1" parent="1">
          <mxGeometry x="440" y="30" width="120" height="45" as="geometry" />
        </mxCell>
        <mxCell id="node_inst" value="corporativo = new Edificio(2500.0, 5, 110.0)&#xa;vehiculoUrbano = new Auto(12000.0, 14.5)&#xa;biciRuta = new Bicicleta(3200.0, &quot;Aluminio&quot;)" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="270" y="110" width="460" height="75" as="geometry" />
        </mxCell>
        <mxCell id="node_col" value="listaHuellaCarbono = new ArrayList&lt;HuellaCarbono&gt;()&#xa;listaHuellaCarbono.add(corporativo)&#xa;listaHuellaCarbono.add(vehiculoUrbano)&#xa;listaHuellaCarbono.add(biciRuta)" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="270" y="215" width="460" height="85" as="geometry" />
        </mxCell>
        <mxCell id="node_banner" value="System.out.println(&quot;--- CÁLCULO POLIMÓRFICO DE HUELLA DE CARBONO ---&quot;)" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="220" y="330" width="560" height="45" as="geometry" />
        </mxCell>
        <mxCell id="node_iter_init" value="iter = listaHuellaCarbono.iterator()" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="350" y="405" width="300" height="45" as="geometry" />
        </mxCell>
        <mxCell id="node_merge_loop" value="" style="rhombus;fillColor=#e1d5e7;strokeColor=#9673a6;strokeWidth=1.5;html=1;" vertex="1" parent="1">
          <mxGeometry x="475" y="480" width="50" height="40" as="geometry" />
        </mxCell>
        <mxCell id="node_dec_loop" value="¿iter.hasNext()?" style="rhombus;fillColor=#fff2cc;strokeColor=#d6b656;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="425" y="550" width="150" height="65" as="geometry" />
        </mxCell>
        <mxCell id="node_body_next" value="elemento = iter.next()" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="630" y="560" width="220" height="45" as="geometry" />
        </mxCell>
        <mxCell id="node_body_print" value="System.out.println(elemento.toString())" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="585" y="635" width="310" height="45" as="geometry" />
        </mxCell>
        <mxCell id="node_body_poli" value="huella = elemento.getHuellaCarbono()&#xa;(Invocación polimórfica dinámica)" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="585" y="715" width="310" height="50" as="geometry" />
        </mxCell>
        <mxCell id="node_body_printf" value="System.out.printf(&quot;Huella: %,.2f kg CO2e%n&quot;, huella)" style="rounded=1;arcSize=10;fillColor=#dae8fc;strokeColor=#6c8ebf;fontColor=#000000;strokeWidth=1.5;html=1;whiteSpace=wrap;align=center;verticalAlign=middle;fontSize=12;" vertex="1" parent="1">
          <mxGeometry x="550" y="795" width="380" height="45" as="geometry" />
        </mxCell>
        <mxCell id="node_merge_exit" value="" style="rhombus;fillColor=#e1d5e7;strokeColor=#9673a6;strokeWidth=1.5;html=1;" vertex="1" parent="1">
          <mxGeometry x="475" y="880" width="50" height="40" as="geometry" />
        </mxCell>
        <mxCell id="node_end" value="◉ Fin" style="shape=ellipse;fillColor=#f8cecc;strokeColor=#b85450;fontColor=#000000;strokeWidth=2.5;html=1;align=center;verticalAlign=middle;fontStyle=1;fontSize=13;" vertex="1" parent="1">
          <mxGeometry x="440" y="955" width="120" height="45" as="geometry" />
        </mxCell>

        <mxCell id="e0" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_start" target="node_inst" />
        <mxCell id="e1" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_inst" target="node_col" />
        <mxCell id="e2" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_col" target="node_banner" />
        <mxCell id="e3" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_banner" target="node_iter_init" />
        <mxCell id="e4" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_iter_init" target="node_merge_loop" />
        <mxCell id="e5" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_merge_loop" target="node_dec_loop" />
        
        <mxCell id="e6_si" value="[sí]" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;fontColor=#000000;" edge="1" parent="1" source="node_dec_loop" target="node_body_next" />
        <mxCell id="e6_no" value="[no]" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;fontColor=#000000;" edge="1" parent="1" source="node_dec_loop" target="node_merge_exit" />
        
        <mxCell id="e7" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_body_next" target="node_body_print" />
        <mxCell id="e8" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_body_print" target="node_body_poli" />
        <mxCell id="e9" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_body_poli" target="node_body_printf" />
        
        <!-- Retroalimentación del ciclo -->
        <mxCell id="e10_loop" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_body_printf" target="node_merge_loop">
          <mxGeometry relative="1" as="geometry">
            <Array as="points">
              <mxPoint x="960" y="818" />
              <mxPoint x="960" y="500" />
            </Array>
          </mxGeometry>
        </mxCell>
        
        <mxCell id="e11" style="edgeStyle=orthogonalEdgeStyle;rounded=1;strokeColor=#000000;strokeWidth=1.5;endArrow=block;endFill=1;" edge="1" parent="1" source="node_merge_exit" target="node_end" />
      </root>
    </mxGraphModel>
    """)

    # Guardar archivos Draw.io individuales
    for key, (name, content) in diagrams.items():
        file_xml = f"""<?xml version="1.0" encoding="UTF-8"?>
<mxfile host="app.diagrams.net" modified="2026-10-23T12:00:00.000Z" agent="Antigravity Senior SE" version="24.0.0" type="device">
  <diagram id="{key}" name="{name}">
    {content}
  </diagram>
</mxfile>"""
        for folder in [BASE_DIR, DIAGRAMS_DIR]:
            p = os.path.join(folder, f"{key}.drawio")
            with open(p, "w", encoding="utf-8") as f:
                f.write(file_xml.strip())

    # Guardar archivo unificado con pestañas
    unified_xml = """<?xml version="1.0" encoding="UTF-8"?>
<mxfile host="app.diagrams.net" modified="2026-10-23T12:00:00.000Z" agent="Antigravity Senior SE" version="24.0.0" type="device">
"""
    for key, (name, content) in diagrams.items():
        unified_xml += f"""  <diagram id="{key}" name="{name}">
    {content}
  </diagram>
"""
    unified_xml += "</mxfile>"
    for folder in [BASE_DIR, DIAGRAMS_DIR]:
        p = os.path.join(folder, "diagramas_pra8.drawio")
        with open(p, "w", encoding="utf-8") as f:
            f.write(unified_xml.strip())
    print("[OK] Archivos .drawio generados exitosamente.")

# -------------------------------------------------------------
# 2. RENDERIZADO DE IMÁGENES PNG EN ALTA DEFINICIÓN (2X / 300 DPI)
# -------------------------------------------------------------

def draw_uml_class(ax, x, y, w, h, title, attributes, methods, is_interface=False):
    """Dibuja una caja UML de 3 compartimentos con borde negro sólido y fondo blanco."""
    rect = FancyBboxPatch((x, y), w, h, boxstyle="square,pad=0",
                          facecolor='#ffffff', edgecolor='#000000', linewidth=1.8, zorder=2)
    ax.add_patch(rect)
    
    h_header = 40 if is_interface else 30
    h_attr = max(24, len(attributes) * 18 + 12)
    
    # Línea divisoria cabecera-atributos
    y_line1 = y + h - h_header
    ax.plot([x, x + w], [y_line1, y_line1], color='#000000', linewidth=1.5, zorder=3)
    
    # Línea divisoria atributos-métodos
    y_line2 = y_line1 - h_attr
    ax.plot([x, x + w], [y_line2, y_line2], color='#000000', linewidth=1.5, zorder=3)
    
    # Texto Cabecera
    if is_interface:
        ax.text(x + w/2, y + h - 14, "«interface»", ha='center', va='center', fontsize=10, fontstyle='italic', color='#000000', zorder=4)
        ax.text(x + w/2, y + h - 28, title, ha='center', va='center', fontsize=13, fontweight='bold', color='#000000', zorder=4)
    else:
        ax.text(x + w/2, y + h - 15, title, ha='center', va='center', fontsize=13, fontweight='bold', color='#000000', zorder=4)
        
    # Texto Atributos
    curr_y = y_line1 - 14
    for attr in attributes:
        ax.text(x + 12, curr_y, attr, ha='left', va='center', fontsize=10, color='#000000', zorder=4)
        curr_y -= 18
        
    # Texto Métodos
    curr_y = y_line2 - 14
    for m in methods:
        is_static = m.startswith("<u>") and m.endswith("</u>")
        clean_m = m.replace("<u>", "").replace("</u>", "")
        txt = ax.text(x + 12, curr_y, clean_m, ha='left', va='center', fontsize=10, color='#000000', zorder=4)
        if is_static:
            txt_width = len(clean_m) * 5.8
            ax.plot([x + 12, x + 12 + txt_width], [curr_y - 6, curr_y - 6], color='#000000', linewidth=1.2, zorder=5)
        curr_y -= 18

def draw_interface_impl_arrow(ax, x_start, y_start, x_end, y_end):
    """Flecha de herencia / realización UML: línea continua con triángulo hueco (──▷)."""
    ax.plot([x_start, x_end], [y_start, y_end], color='#000000', linewidth=1.8, linestyle='-', zorder=2)
    dx = x_end - x_start
    dy = y_end - y_start
    length = (dx**2 + dy**2)**0.5
    if length == 0: return
    ux = dx / length
    uy = dy / length
    px = -uy
    py = ux
    arrow_size = 14
    arrow_width = 8
    p1 = (x_end, y_end)
    p2 = (x_end - ux * arrow_size + px * arrow_width, y_end - uy * arrow_size + py * arrow_width)
    p3 = (x_end - ux * arrow_size - px * arrow_width, y_end - uy * arrow_size - py * arrow_width)
    triangle = Polygon([p1, p2, p3], closed=True, edgecolor='#000000', facecolor='#ffffff', linewidth=1.8, zorder=5)
    ax.add_patch(triangle)

def draw_dependency_arrow(ax, x_start, y_start, x_end, y_end):
    """Flecha de dependencia UML: línea discontinua con flecha abierta."""
    ax.plot([x_start, x_end], [y_start, y_end], color='#000000', linewidth=1.6, linestyle='--', zorder=2)
    dx = x_end - x_start
    dy = y_end - y_start
    length = (dx**2 + dy**2)**0.5
    if length == 0: return
    ux = dx / length
    uy = dy / length
    px = -uy
    py = ux
    arrow_size = 12
    arrow_width = 6
    p_tip = (x_end, y_end)
    p_left = (x_end - ux * arrow_size + px * arrow_width, y_end - uy * arrow_size + py * arrow_width)
    p_right = (x_end - ux * arrow_size - px * arrow_width, y_end - uy * arrow_size - py * arrow_width)
    ax.plot([p_left[0], p_tip[0], p_right[0]], [p_left[1], p_tip[1], p_right[1]], color='#000000', linewidth=1.6, zorder=3)

def render_png_class_diagram():
    fig, ax = plt.subplots(figsize=(18, 13), dpi=300)
    ax.set_facecolor('#ffffff')
    fig.patch.set_facecolor('#ffffff')
    ax.set_xlim(0, 1800)
    ax.set_ylim(0, 1300)
    ax.axis('off')

    ax.text(900, 1250, "DIAGRAMA DE CLASES UML - MODELO DE HUELLA DE CARBONO", ha='center', va='center', fontsize=20, fontweight='bold', color='#000000')
    ax.text(900, 1215, "Práctica 8 • Polimorfismo e Interfaces en Java • UNAM-FI", ha='center', va='center', fontsize=12, color='#444444')

    # 1. Interfaz HuellaCarbono
    draw_uml_class(ax, 720, 980, 360, 130, "HuellaCarbono",
                   ["<sin atributos>"],
                   ["+ getHuellaCarbono(): double"],
                   is_interface=True)

    # 2. Clase Auto
    draw_uml_class(ax, 60, 550, 480, 230, "Auto",
                   ["- kilometrosRecorridos: double", "- rendimientoKmLitro: double"],
                   ["+ Auto(kmRecorridos: double, rendKmLitro: double)",
                    "+ getKilometrosRecorridos(): double",
                    "+ getRendimientoKmLitro(): double",
                    "+ calcularLitrosConsumidos(): double",
                    "+ getHuellaCarbono(): double",
                    "+ toString(): String"])

    # 3. Clase Bicicleta
    draw_uml_class(ax, 660, 550, 480, 230, "Bicicleta",
                   ["- kilometrosRecorridos: double", "- materialFabricacion: String"],
                   ["+ Bicicleta(kmRecorridos: double, material: String)",
                    "+ getKilometrosRecorridos(): double",
                    "+ getMaterialFabricacion(): String",
                    "+ ajustarPresionNeumaticos(): void",
                    "+ getHuellaCarbono(): double",
                    "+ toString(): String"])

    # 4. Clase Edificio
    draw_uml_class(ax, 1260, 550, 480, 245, "Edificio",
                   ["- metrosCuadrados: double", "- numeroPisos: int", "- consumoKwhPorMetro: double"],
                   ["+ Edificio(m2: double, pisos: int, consumoKwh: double)",
                    "+ getMetrosCuadrados(): double",
                    "+ getNumeroPisos(): int",
                    "+ getConsumoKwhPorMetro(): double",
                    "+ calcularAreaPromedioPorPiso(): double",
                    "+ getHuellaCarbono(): double",
                    "+ toString(): String"])

    # Flechas continuas de herencia (──▷)
    draw_interface_impl_arrow(ax, 300, 780, 750, 980)    # Auto -> HuellaCarbono
    draw_interface_impl_arrow(ax, 900, 780, 900, 980)    # Bicicleta -> HuellaCarbono
    draw_interface_impl_arrow(ax, 1500, 795, 1050, 980)  # Edificio -> HuellaCarbono

    # 5. Clase Main
    draw_uml_class(ax, 720, 140, 360, 135, "Main",
                   ["<sin atributos>"],
                   ["+ Main()", "<u>+ main(args: String[]): void</u>"])

    # Flechas de Dependencia (- - ->)
    draw_dependency_arrow(ax, 720, 230, 400, 550)   # Main -> Auto
    draw_dependency_arrow(ax, 900, 275, 900, 550)   # Main -> Bicicleta
    draw_dependency_arrow(ax, 1080, 230, 1400, 550) # Main -> Edificio

    plt.tight_layout()
    for folder in [BASE_DIR, DIAGRAMS_DIR]:
        output_png = os.path.join(folder, "01_diagrama_clases_uml.png")
        plt.savefig(output_png, dpi=300, bbox_inches='tight', facecolor='#ffffff')
    plt.close()
    print("[OK] Diagrama de clases renderizado en PNG 2x.")

# -------------------------------------------------------------
# FUNCIONES AUXILIARES PARA DIAGRAMAS DE ACTIVIDADES
# -------------------------------------------------------------

def draw_flow_start(ax, x, y, w=150, h=45, label="● Inicio"):
    p = FancyBboxPatch((x - w/2, y - h/2), w, h, boxstyle="round,pad=3,rounding_size=20",
                       facecolor=COLOR_START_FILL, edgecolor=COLOR_START_STROKE, linewidth=2, zorder=3)
    ax.add_patch(p)
    ax.text(x, y, label, ha='center', va='center', fontsize=11, fontweight='bold', color='#000000', zorder=4)

def draw_flow_process(ax, x, y, w, h, label, base_fontsize=10.0):
    """Dibuja un proceso garantizando que el texto quede 100% dentro de los límites del rectángulo."""
    lines = label.split("\n")
    max_len = max(len(line) for line in lines)
    
    # Obtener la escala real de puntos tipográficos a coordenadas del gráfico
    fig = ax.figure
    fig_w_in, fig_h_in = fig.get_size_inches()
    x_min, x_max = ax.get_xlim()
    data_units_per_pt = (x_max - x_min) / (fig_w_in * 72.0)
    
    # Margen de seguridad interno en coordenadas del gráfico (al menos 34 unidades de colchón horizontal)
    avail_w = w - 34.0
    avail_h = h - 14.0
    
    # Ancho promedio de caracter en sans-serif (~0.80 pt/char para caracteres anchos)
    max_fs_w = avail_w / (max_len * 0.80 * data_units_per_pt)
    max_fs_h = avail_h / (max(1, len(lines) * 1.5) * data_units_per_pt)
    
    actual_fontsize = min(base_fontsize, max_fs_w, max_fs_h)
    actual_fontsize = max(7.0, actual_fontsize)
    
    p = FancyBboxPatch((x - w/2, y - h/2), w, h, boxstyle="round,pad=2,rounding_size=6",
                       facecolor=COLOR_PROC_FILL, edgecolor=COLOR_PROC_STROKE, linewidth=1.8, zorder=3)
    ax.add_patch(p)
    
    line_spacing = actual_fontsize * 1.5
    if len(lines) == 1:
        ax.text(x, y, label, ha='center', va='center', fontsize=actual_fontsize, color='#000000', zorder=4)
    else:
        curr_y = y + (len(lines) - 1) * (line_spacing / 2.0)
        for line in lines:
            ax.text(x, curr_y, line, ha='center', va='center', fontsize=actual_fontsize, color='#000000', zorder=4)
            curr_y -= line_spacing

def draw_flow_decision(ax, x, y, w, h, label, base_fontsize=9.5):
    """Dibuja un rombo de decisión garantizando que el texto quede centrado y protegido."""
    pts = [[x, y + h/2], [x + w/2, y], [x, y - h/2], [x - w/2, y]]
    poly = Polygon(pts, closed=True, edgecolor=COLOR_DEC_STROKE, facecolor=COLOR_DEC_FILL, linewidth=1.8, zorder=3)
    ax.add_patch(poly)
    
    fig = ax.figure
    fig_w_in, _ = fig.get_size_inches()
    x_min, x_max = ax.get_xlim()
    data_units_per_pt = (x_max - x_min) / (fig_w_in * 72.0)
    
    avail_w = w * 0.65
    max_fs = avail_w / (len(label) * 0.85 * data_units_per_pt)
    actual_fontsize = min(base_fontsize, max_fs)
    actual_fontsize = max(7.5, actual_fontsize)
    
    ax.text(x, y, label, ha='center', va='center', fontsize=actual_fontsize, fontweight='bold', color='#000000', zorder=4)

def draw_flow_merge(ax, x, y, w=50, h=35):
    pts = [[x, y + h/2], [x + w/2, y], [x, y - h/2], [x - w/2, y]]
    poly = Polygon(pts, closed=True, edgecolor=COLOR_MERGE_STROKE, facecolor=COLOR_MERGE_FILL, linewidth=1.6, zorder=3)
    ax.add_patch(poly)

def draw_flow_end(ax, x, y, w=150, h=45, label="◉ Fin"):
    p = FancyBboxPatch((x - w/2, y - h/2), w, h, boxstyle="round,pad=3,rounding_size=20",
                       facecolor=COLOR_END_FILL, edgecolor=COLOR_END_STROKE, linewidth=2.5, zorder=3)
    ax.add_patch(p)
    ax.text(x, y, label, ha='center', va='center', fontsize=11, fontweight='bold', color='#000000', zorder=4)

def draw_arrow(ax, points, label=None, label_offset=(0, 0)):
    xs = [pt[0] for pt in points]
    ys = [pt[1] for pt in points]
    ax.plot(xs, ys, color='#000000', linewidth=1.6, zorder=2)
    x_last, y_last = points[-1]
    x_prev, y_prev = points[-2]
    dx = x_last - x_prev
    dy = y_last - y_prev
    length = (dx**2 + dy**2)**0.5
    if length > 0:
        ux = dx / length
        uy = dy / length
        px = -uy
        py = ux
        p1 = (x_last, y_last)
        p2 = (x_last - ux * 10 + px * 5, y_last - uy * 10 + py * 5)
        p3 = (x_last - ux * 10 - px * 5, y_last - uy * 10 - py * 5)
        tri = Polygon([p1, p2, p3], closed=True, edgecolor='#000000', facecolor='#000000', zorder=3)
        ax.add_patch(tri)
    if label:
        lx = points[0][0] + (points[1][0] - points[0][0]) * 0.5 + label_offset[0]
        ly = points[0][1] + (points[1][1] - points[0][1]) * 0.5 + label_offset[1]
        ax.text(lx, ly, label, fontsize=10, fontweight='bold', color='#000000',
                bbox=dict(boxstyle='square,pad=0.2', facecolor='#ffffff', edgecolor='none'), zorder=4)

# -------------------------------------------------------------
# RENDERIZADO DE CADA MÉTODO INDIVIDUAL
# -------------------------------------------------------------

def render_png_auto_calcularLitros():
    fig, ax = plt.subplots(figsize=(8, 7), dpi=300)
    ax.set_facecolor('#ffffff')
    fig.patch.set_facecolor('#ffffff')
    ax.set_xlim(0, 800)
    ax.set_ylim(0, 600)
    ax.axis('off')

    ax.text(400, 565, "DIAGRAMA DE ACTIVIDADES: Auto.calcularLitrosConsumidos()", ha='center', va='center', fontsize=13, fontweight='bold')
    ax.text(400, 545, "Práctica 8 • Programación Orientada a Objetos • UNAM-FI", ha='center', va='center', fontsize=9.5, color='#555555')

    draw_flow_start(ax, 400, 490, 140, 45)
    draw_flow_process(ax, 400, 390, 520, 55, "litros = kilometrosRecorridos / rendimientoKmLitro")
    draw_flow_merge(ax, 400, 290, 50, 35)
    draw_flow_process(ax, 400, 200, 180, 45, "return litros")
    draw_flow_end(ax, 400, 100, 140, 45)

    draw_arrow(ax, [(400, 467), (400, 417)])
    draw_arrow(ax, [(400, 362), (400, 307)])
    draw_arrow(ax, [(400, 272), (400, 222)])
    draw_arrow(ax, [(400, 177), (400, 122)])

    plt.tight_layout()
    for folder in [BASE_DIR, DIAGRAMS_DIR]:
        plt.savefig(os.path.join(folder, "02_flujo_auto_calcularLitrosConsumidos.png"), dpi=300, bbox_inches='tight', facecolor='#ffffff')
    plt.close()
    print("[OK] 02_flujo_auto_calcularLitrosConsumidos.png generado.")

def render_png_auto_getHuella():
    fig, ax = plt.subplots(figsize=(8, 8), dpi=300)
    ax.set_facecolor('#ffffff')
    fig.patch.set_facecolor('#ffffff')
    ax.set_xlim(0, 800)
    ax.set_ylim(0, 700)
    ax.axis('off')

    ax.text(400, 665, "DIAGRAMA DE ACTIVIDADES: Auto.getHuellaCarbono()", ha='center', va='center', fontsize=13, fontweight='bold')
    ax.text(400, 645, "Práctica 8 • Programación Orientada a Objetos • UNAM-FI", ha='center', va='center', fontsize=9.5, color='#555555')

    draw_flow_start(ax, 400, 590, 140, 45)
    draw_flow_process(ax, 400, 495, 480, 55, "litrosConsumidos = calcularLitrosConsumidos()")
    draw_flow_process(ax, 400, 395, 480, 60, "emisiones = litrosConsumidos * 2.31\n(Factor estándar gasolina: 2.31 kg CO2/L)")
    draw_flow_merge(ax, 400, 295, 50, 35)
    draw_flow_process(ax, 400, 205, 180, 45, "return emisiones")
    draw_flow_end(ax, 400, 105, 140, 45)

    draw_arrow(ax, [(400, 567), (400, 522)])
    draw_arrow(ax, [(400, 467), (400, 425)])
    draw_arrow(ax, [(400, 365), (400, 312)])
    draw_arrow(ax, [(400, 277), (400, 227)])
    draw_arrow(ax, [(400, 182), (400, 127)])

    plt.tight_layout()
    for folder in [BASE_DIR, DIAGRAMS_DIR]:
        plt.savefig(os.path.join(folder, "03_flujo_auto_getHuellaCarbono.png"), dpi=300, bbox_inches='tight', facecolor='#ffffff')
    plt.close()
    print("[OK] 03_flujo_auto_getHuellaCarbono.png generado.")

def render_png_bici_ajustarPresion():
    fig, ax = plt.subplots(figsize=(8, 7), dpi=300)
    ax.set_facecolor('#ffffff')
    fig.patch.set_facecolor('#ffffff')
    ax.set_xlim(0, 800)
    ax.set_ylim(0, 600)
    ax.axis('off')

    ax.text(400, 565, "DIAGRAMA DE ACTIVIDADES: Bicicleta.ajustarPresionNeumaticos()", ha='center', va='center', fontsize=13, fontweight='bold')
    ax.text(400, 545, "Práctica 8 • Programación Orientada a Objetos • UNAM-FI", ha='center', va='center', fontsize=9.5, color='#555555')

    draw_flow_start(ax, 400, 490, 140, 45)
    draw_flow_process(ax, 400, 395, 540, 60, "mensaje = \"Presión ajustada para uso urbano \"\n+ \"con cuadro de \" + materialFabricacion + \".\"")
    draw_flow_process(ax, 400, 295, 280, 45, "System.out.println(mensaje)")
    draw_flow_merge(ax, 400, 205, 50, 35)
    draw_flow_end(ax, 400, 105, 140, 45)

    draw_arrow(ax, [(400, 467), (400, 425)])
    draw_arrow(ax, [(400, 365), (400, 317)])
    draw_arrow(ax, [(400, 272), (400, 222)])
    draw_arrow(ax, [(400, 187), (400, 127)])

    plt.tight_layout()
    for folder in [BASE_DIR, DIAGRAMS_DIR]:
        plt.savefig(os.path.join(folder, "04_flujo_bicicleta_ajustarPresionNeumaticos.png"), dpi=300, bbox_inches='tight', facecolor='#ffffff')
    plt.close()
    print("[OK] 04_flujo_bicicleta_ajustarPresionNeumaticos.png generado.")

def render_png_bici_getHuella():
    fig, ax = plt.subplots(figsize=(11, 10), dpi=300)
    ax.set_facecolor('#ffffff')
    fig.patch.set_facecolor('#ffffff')
    ax.set_xlim(0, 1000)
    ax.set_ylim(0, 950)
    ax.axis('off')

    ax.text(500, 915, "DIAGRAMA DE ACTIVIDADES: Bicicleta.getHuellaCarbono()", ha='center', va='center', fontsize=14, fontweight='bold')
    ax.text(500, 895, "Práctica 8 • Programación Orientada a Objetos • UNAM-FI", ha='center', va='center', fontsize=10, color='#555555')

    draw_flow_start(ax, 500, 840, 140, 45)
    draw_flow_process(ax, 500, 755, 400, 45, "mat = materialFabricacion.toLowerCase()")
    draw_flow_decision(ax, 500, 650, 290, 72, "¿mat == \"fibra de carbono\"?")
    draw_flow_process(ax, 830, 650, 260, 45, "factorEmisionPorKm = 0.015")

    draw_flow_decision(ax, 500, 520, 240, 70, "¿mat == \"aluminio\"?")
    draw_flow_process(ax, 830, 520, 260, 45, "factorEmisionPorKm = 0.008")

    draw_flow_process(ax, 500, 395, 300, 55, "factorEmisionPorKm = 0.005\n(case \"acero\" / default)")
    draw_flow_merge(ax, 500, 290, 60, 40)
    draw_flow_process(ax, 500, 205, 520, 48, "huella = kilometrosRecorridos * factorEmisionPorKm")
    draw_flow_merge(ax, 500, 130, 45, 30)
    draw_flow_end(ax, 500, 50, 140, 45)

    # Conexiones
    draw_arrow(ax, [(500, 817), (500, 777)])
    draw_arrow(ax, [(500, 732), (500, 686)])
    draw_arrow(ax, [(645, 650), (700, 650)], label="[sí]", label_offset=(0, 12))
    draw_arrow(ax, [(500, 614), (500, 555)], label="[no]", label_offset=(-18, 0))
    draw_arrow(ax, [(620, 520), (700, 520)], label="[sí]", label_offset=(0, 12))
    draw_arrow(ax, [(500, 485), (500, 422)], label="[no]", label_offset=(-18, 0))

    # Convergencia de ramas switch a merge
    draw_arrow(ax, [(830, 627), (830, 290), (530, 290)])
    draw_arrow(ax, [(830, 497), (830, 290)])
    draw_arrow(ax, [(500, 367), (500, 310)])

    draw_arrow(ax, [(500, 270), (500, 229)])
    draw_arrow(ax, [(500, 181), (500, 145)])
    draw_arrow(ax, [(500, 115), (500, 72)], label="return huella", label_offset=(50, 0))

    plt.tight_layout()
    for folder in [BASE_DIR, DIAGRAMS_DIR]:
        plt.savefig(os.path.join(folder, "05_flujo_bicicleta_getHuellaCarbono.png"), dpi=300, bbox_inches='tight', facecolor='#ffffff')
    plt.close()
    print("[OK] 05_flujo_bicicleta_getHuellaCarbono.png generado.")

def render_png_edificio_calcularArea():
    fig, ax = plt.subplots(figsize=(8, 7), dpi=300)
    ax.set_facecolor('#ffffff')
    fig.patch.set_facecolor('#ffffff')
    ax.set_xlim(0, 800)
    ax.set_ylim(0, 600)
    ax.axis('off')

    ax.text(400, 565, "DIAGRAMA DE ACTIVIDADES: Edificio.calcularAreaPromedioPorPiso()", ha='center', va='center', fontsize=13, fontweight='bold')
    ax.text(400, 545, "Práctica 8 • Programación Orientada a Objetos • UNAM-FI", ha='center', va='center', fontsize=9.5, color='#555555')

    draw_flow_start(ax, 400, 490, 140, 45)
    draw_flow_process(ax, 400, 390, 520, 55, "areaPromedio = metrosCuadrados / numeroPisos")
    draw_flow_merge(ax, 400, 290, 50, 35)
    draw_flow_process(ax, 400, 200, 180, 45, "return areaPromedio")
    draw_flow_end(ax, 400, 100, 140, 45)

    draw_arrow(ax, [(400, 467), (400, 417)])
    draw_arrow(ax, [(400, 362), (400, 307)])
    draw_arrow(ax, [(400, 272), (400, 222)])
    draw_arrow(ax, [(400, 177), (400, 122)])

    plt.tight_layout()
    for folder in [BASE_DIR, DIAGRAMS_DIR]:
        plt.savefig(os.path.join(folder, "06_flujo_edificio_calcularAreaPromedioPorPiso.png"), dpi=300, bbox_inches='tight', facecolor='#ffffff')
    plt.close()
    print("[OK] 06_flujo_edificio_calcularAreaPromedioPorPiso.png generado.")

def render_png_edificio_getHuella():
    fig, ax = plt.subplots(figsize=(8, 8), dpi=300)
    ax.set_facecolor('#ffffff')
    fig.patch.set_facecolor('#ffffff')
    ax.set_xlim(0, 800)
    ax.set_ylim(0, 700)
    ax.axis('off')

    ax.text(400, 665, "DIAGRAMA DE ACTIVIDADES: Edificio.getHuellaCarbono()", ha='center', va='center', fontsize=13, fontweight='bold')
    ax.text(400, 645, "Práctica 8 • Programación Orientada a Objetos • UNAM-FI", ha='center', va='center', fontsize=9.5, color='#555555')

    draw_flow_start(ax, 400, 590, 140, 45)
    draw_flow_process(ax, 400, 495, 560, 55, "consumoTotalKwh = metrosCuadrados * consumoKwhPorMetro")
    draw_flow_process(ax, 400, 395, 520, 60, "emisiones = consumoTotalKwh * 0.45\n(Factor promedio eléctrico: 0.45 kg CO2e/kWh)")
    draw_flow_merge(ax, 400, 295, 50, 35)
    draw_flow_process(ax, 400, 205, 180, 45, "return emisiones")
    draw_flow_end(ax, 400, 105, 140, 45)

    draw_arrow(ax, [(400, 567), (400, 522)])
    draw_arrow(ax, [(400, 467), (400, 425)])
    draw_arrow(ax, [(400, 365), (400, 312)])
    draw_arrow(ax, [(400, 277), (400, 227)])
    draw_arrow(ax, [(400, 182), (400, 127)])

    plt.tight_layout()
    for folder in [BASE_DIR, DIAGRAMS_DIR]:
        plt.savefig(os.path.join(folder, "07_flujo_edificio_getHuellaCarbono.png"), dpi=300, bbox_inches='tight', facecolor='#ffffff')
    plt.close()
    print("[OK] 07_flujo_edificio_getHuellaCarbono.png generado.")

def render_png_main_main():
    fig, ax = plt.subplots(figsize=(11.5, 13), dpi=300)
    ax.set_facecolor('#ffffff')
    fig.patch.set_facecolor('#ffffff')
    ax.set_xlim(0, 1050)
    ax.set_ylim(0, 1200)
    ax.axis('off')

    ax.text(525, 1165, "DIAGRAMA DE ACTIVIDADES: Main.main(args: String[])", ha='center', va='center', fontsize=14, fontweight='bold')
    ax.text(525, 1140, "Práctica 8 • Ejecución Polimórfica e Iteración • UNAM-FI", ha='center', va='center', fontsize=10, color='#555555')

    draw_flow_start(ax, 480, 1085, 140, 45)
    draw_flow_process(ax, 480, 990, 480, 75, "corporativo = new Edificio(2500.0, 5, 110.0)\nvehiculoUrbano = new Auto(12000.0, 14.5)\nbiciRuta = new Bicicleta(3200.0, \"Aluminio\")")
    draw_flow_process(ax, 480, 875, 480, 85, "listaHuellaCarbono = new ArrayList<HuellaCarbono>()\nlistaHuellaCarbono.add(corporativo)\nlistaHuellaCarbono.add(vehiculoUrbano)\nlistaHuellaCarbono.add(biciRuta)")
    draw_flow_process(ax, 480, 775, 580, 48, "System.out.println(\"--- CÁLCULO POLIMÓRFICO DE HUELLA DE CARBONO ---\")")
    draw_flow_process(ax, 480, 695, 340, 45, "iter = listaHuellaCarbono.iterator()")
    
    draw_flow_merge(ax, 480, 615, 50, 35)
    draw_flow_decision(ax, 480, 520, 190, 65, "¿iter.hasNext()?")
    
    draw_flow_process(ax, 770, 520, 240, 45, "elemento = iter.next()")
    draw_flow_process(ax, 770, 430, 320, 45, "System.out.println(elemento.toString())")
    draw_flow_process(ax, 770, 335, 320, 55, "huella = elemento.getHuellaCarbono()\n[Despacho Dinámico Polimórfico]")
    draw_flow_process(ax, 770, 240, 400, 48, "System.out.printf(\"Huella: %,.2f kg CO2e%n\", huella)")

    draw_flow_merge(ax, 480, 340, 50, 35)
    draw_flow_end(ax, 480, 210, 140, 45)

    # Conexiones
    draw_arrow(ax, [(480, 1062), (480, 1027)])
    draw_arrow(ax, [(480, 952), (480, 917)])
    draw_arrow(ax, [(480, 832), (480, 799)])
    draw_arrow(ax, [(480, 751), (480, 717)])
    draw_arrow(ax, [(480, 672), (480, 632)])
    draw_arrow(ax, [(480, 597), (480, 552)])

    draw_arrow(ax, [(575, 520), (650, 520)], label="[sí]", label_offset=(0, 12))
    draw_arrow(ax, [(480, 487), (480, 357)], label="[no]", label_offset=(-18, 0))

    draw_arrow(ax, [(770, 497), (770, 452)])
    draw_arrow(ax, [(770, 407), (770, 362)])
    draw_arrow(ax, [(770, 307), (770, 264)])

    # Bucle hacia merge
    draw_arrow(ax, [(770, 216), (770, 145), (1000, 145), (1000, 615), (505, 615)])
    draw_arrow(ax, [(480, 322), (480, 232)])

    plt.tight_layout()
    for folder in [BASE_DIR, DIAGRAMS_DIR]:
        plt.savefig(os.path.join(folder, "08_flujo_main_main.png"), dpi=300, bbox_inches='tight', facecolor='#ffffff')
    plt.close()
    print("[OK] 08_flujo_main_main.png generado.")

if __name__ == "__main__":
    print("Iniciando generación de suite completa de diagramas para Práctica 8...")
    build_drawio_xml_suite()
    render_png_class_diagram()
    render_png_auto_calcularLitros()
    render_png_auto_getHuella()
    render_png_bici_ajustarPresion()
    render_png_bici_getHuella()
    render_png_edificio_calcularArea()
    render_png_edificio_getHuella()
    render_png_main_main()
    print("¡Suite completada con éxito!")
