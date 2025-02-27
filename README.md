## Criando Um Pequeno Sistema Para Validação de Processo Seletivo

### Cases

Vamos explorar alguns outros cenários com fluxos condicionais, repetições e exceções

<b>Case 1:</b> Vamos imaginara que em um processo seletivo existe o valor base salarial de R$ 2.000,00 e o salario pretendido pelo candidato. Vamos elaborar um controle de fluxo onde:

-   Se o valor salario base for maior que o valor salario pretendido, imprima: "Ligar para o candidato"
-   Senão se o valor salario base for igual ao valor salario pretendido, imprima: "Ligar para o candidato com contra proposta"
-   Senão imprima: "Aguardando resultado demais candidatos"

<b>Case 2:</b> Foi solicitado que nosso sistema garanta que diante das inúmeras candidaturas sejam selecionados apenas no máximo 05 candidatos para entrevista onde o sálario pretendido seja menor ou igual ao sálario base.

```java
// Array com a lista de candidatos
String[] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
```

```java
// Método que simula o valor pretendido
import java.util.concurrent.ThreadLocalRandom;
static double valorPretendido() {
    return ThreadLocalRandom.current().nextDouble(1800, 2200);
}
```

<b>Case 3:</b> Agora é hora de imprimir a lista dos candidatos selecionados para disponibilizar para o RH entrar em contato.

<b>Case 4:</b> O RH deverá realizar uma ligação com no maximo 03 tentativas para cada candidato selecionado e caso o candidato atenda, deve-se imprimir:

-   "Conseguimos contato com [candidato] após [tentativas] tentativa(s)"
-   do contrario imprima: "Não conseguimos contato com [candidato]"
