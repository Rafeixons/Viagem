
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

public class Viagem {

    String nome;
    String dias;
    String valor;

    LocalDate data;
    LocalDate hoje;

    public void menu() {

        String[] opcoes = {"Planejar Viagem", "Sair"};
        int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha uma opção",
                "Planejador de Viagem",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);

        if (escolha == 0) {
            do {
                nome = JOptionPane.showInputDialog(null, "Qual o nome do viajante?");
            } while (nome == null);
            do {
                String entrada = JOptionPane.showInputDialog(null, "Qual a data da viagem? (dd/MM/yyyy)");

                try {
                    data = LocalDate.parse(entrada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data incorreta");
                }

                if (data.isBefore(hoje)) {
                    JOptionPane.showMessageDialog(null, "A viagem já passou");
                } else if (data.isEqual(hoje)) {
                    JOptionPane.showMessageDialog(null, "A viagem é hoje!!");
                } else {
                    long diasFalta = ChronoUnit.DAYS.between(hoje, data);
                    JOptionPane.showMessageDialog(null, "Faltam " + diasFalta + "Para sua viageeem!");
                }
                // colocar looping pra data incorreta
            } while (data == null);
            do {
                dias = JOptionPane.showInputDialog(null, "Planeja ficar quantos dias em viagem?");
            } while (dias == null);
            do {
                valor = JOptionPane.showInputDialog(null, "Qual o valor gasto por dia?");
            } while (valor == null);

            JOptionPane.showMessageDialog(null, "Viagem cadastrada, obrigada por utilizar o nosso sistema!");


            double valorI = Double.parseDouble(valor);

            imprimir();
        } else if (escolha == 1) {
            JOptionPane.showMessageDialog(null, "Obrigada por utilizar o nosso sistema!");
        }
    }

    public void imprimir() {
        String[] imprimir = {"Imprimir", "Planejar Viagem"};
        int desejo = JOptionPane.showOptionDialog(
                null,
                "Deseja listar suas viagens cadastradas?",
                "Planejador de Viagem",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                imprimir,
                imprimir[0]);

        if (desejo == 0) {
            JOptionPane.showMessageDialog(null, nome + "sua viagem será dia" + data);
            JOptionPane.showMessageDialog(null, "Dias de viagem: " + dias);
            JOptionPane.showMessageDialog(null, "Valor gasto em cada dia: " + valor);

        } else if (desejo == 1) {
            menu();
        }
    }
}
