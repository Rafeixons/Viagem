
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Viagem {
    
    
    
    ArrayList<Viagem> v = new ArrayList<>();

    String nome;
    String dias;
    String valor = "0";

    LocalDate data;
    LocalDate hoje = LocalDate.now();
    
    long diasFalta = 0;
    long valorI ;

    
    
    
    public Viagem(String nome, LocalDate data, String dias, String valor, long diasFalta) {
                    this.nome = nome;
                    this.data = data;
                    this.dias = dias;
                    this.valor = valor;
                    this.diasFalta = diasFalta;
            }


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
                // colocar looping pra data incorreta
            } while (data == null);
            if (data.isBefore(hoje)) {
                    JOptionPane.showMessageDialog(null, "A viagem já passou");
                } else if (data.isEqual(hoje)) {
                    JOptionPane.showMessageDialog(null, "A viagem é hoje!!");
                } else {
                    diasFalta = ChronoUnit.DAYS.between(hoje, data);
                    JOptionPane.showMessageDialog(null, "Faltam " + diasFalta + " para sua viageeem!");
                }
            do {
                dias = JOptionPane.showInputDialog(null, "Planeja ficar quantos dias em viagem?");
            } while (dias == null);
            do {
                valor = JOptionPane.showInputDialog(null, "Qual o valor gasto por dia?");
                valorI = Long.parseLong(valor);
                
            } while (valor == null);

            JOptionPane.showMessageDialog(null, "Viagem cadastrada, obrigada por utilizar o nosso sistema!");

            imprimir();
        } else if (escolha == 1) {
            JOptionPane.showMessageDialog(null, "Obrigada por utilizar o nosso sistema!");
        }
        
        Viagem novaViagem = new Viagem(nome, data, dias, valor, diasFalta);
        v.add(novaViagem);
    }
    
    

    public void imprimir() {
        
        if(v.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhuma viagem cadastrada.");
        }
        long total = (valorI*diasFalta);
        
        String[] opcoes = new String [v.size()];
        
        for(int i = 0; i < v.size(); i++){
            
            Viagem viagens = v.get(i);
            
        }
        
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
        
        String [] escolha = JOptionPane.showInputDialog(null, desejo, nome, desejo, icon, opcoes, diasFalta);

        if (desejo == 0) {
            for (Viagem viagem : v){
              if ((viagem.nome+"-"+viagem.data).equals(escolha));
              
              JOptionPane.showMessageDialog(null, viagem.nome + " sua viagem será dia " + viagem.data);
            JOptionPane.showMessageDialog(null, "Dias de viagem: " + viagem.dias);
            JOptionPane.showMessageDialog(null, "Valor gasto em cada dia: " + viagem.valor);
            JOptionPane.showMessageDialog(null, "Valor total da viajem: " + total);
                
            }

        } else if (desejo == 1) {
            menu();
        }
    }
}
