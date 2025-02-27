import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        // Array com a lista de candidatos
        String[] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};

        selecaoCandidatos(candidatos);
    }


    public static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
        } while(continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa(s)");
        } else {
            System.out.println("Não conseguimos contato com " + candidato);
        }
    }


    public static boolean atender() {
        return new Random().nextInt(3)==1;
    }


    public static void imprimirSelecionados(ArrayList<String> candidatos) {
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        for (int indice = 0; indice < candidatos.size(); indice++) {
            System.out.println("O candidato de nº " + (indice+1) + ": " + candidatos.get(indice));
        }
    }


    public static void selecaoCandidatos(String[] candidatos) {
        int quantidadeSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        // String[] candidatosSelecionados = new String[5];
        ArrayList<String> candidatosSelecionados = new ArrayList<>();

        while (quantidadeSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            if (salarioBase >= salarioPretendido) {
                candidatosSelecionados.add(candidato);
                quantidadeSelecionados++;
            }
            candidatosAtual++;
        }

        if (candidatosSelecionados.isEmpty()) {
            System.out.println("Nenhum dos candidatos foram selecionados.");
        }
        else {
            System.out.println("=--==-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            imprimirSelecionados(candidatosSelecionados);
            System.out.println("=--==-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            for (String candidato : candidatosSelecionados) {
                entrandoEmContato(candidato);
            }
            System.out.println("=--==-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
    }


    public static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    
    public static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        } else {
            System.out.println("Aguardando resultado dos demais candidatos");
        }
    }
}
