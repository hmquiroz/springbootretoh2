# springbootretoh2
Simulador de Compras Reto 1 - Deadline 26/02/2021
<BR>Autor: Humberto Muguerza <BR>
<B><br>Componentes usados:<BR></B>
-Springboot <BR>
-H2 (in-memory Database) <BR>
-Springboot JPA<BR>
-Log4J<BR>
-Apache Commons Lang (Utilitarios)<BR>
-Maven (Utilitarios)<BR>

<B><br>API Rest Metodos:<BR></B>

* [GET]  method listar  | Endpoint: /listar <BR>
* [POST] method simular | Endpoint: /simular <BR>
DNIs Validos","42498387 , 41768286 , 17822694"

<B><br>Forma de Calculo Simulacion:<BR></B>
Calculo de la Cuota:
- TEM = ((1+TEA) exp 30/360) - 1
- FRC = (TEM * ((1+TEM) exp N)) / (((1+TEM) exp N) - 1)
- CUOTA =  MP * FRC
- IMPORTE A PAGAR = CUOTA + ITF
  <BR><BR>
    Donde:<BR>
    ITF : 0.005%<BR>
    TEA : Tasa Efectiva Mensual<BR>
    TEM : Tasa Efectiva Mensual<BR>
    N   : Numero de Cuotas<BR>
    MP  : Monto a Pagar