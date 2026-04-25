
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Viagem {   
    ArrayList<Viagem> v = new ArrayList<>();

    String nome;
    String dias;
    String valor;

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

    public Viagem() {
    }
      


    public void menu() {
        
        Viagem novaViagem = new Viagem();

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
                novaViagem.nome = JOptionPane.showInputDialog(null, "Qual o nome do viajante?");
            } while (novaViagem.nome == null);
            do {
                String entrada = JOptionPane.showInputDialog(null, "Qual a data da viagem? (dd/MM/yyyy)");
                try {
                    novaViagem.data = LocalDate.parse(entrada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data incorreta");
                }                
                // colocar looping pra data incorreta
            } while (novaViagem.data == null);
            if (novaViagem.data.isBefore(novaViagem.hoje)) {
                    JOptionPane.showMessageDialog(null, "A viagem já passou");
                } else if (novaViagem.data.isEqual(novaViagem.hoje)) {
                    JOptionPane.showMessageDialog(null, "A viagem é hoje!!");
                } else {
                    novaViagem.diasFalta = ChronoUnit.DAYS.between(novaViagem.hoje, novaViagem.data);
                    JOptionPane.showMessageDialog(null, "Faltam " + novaViagem.diasFalta + " para sua viageeem!");
                }
            do {
                novaViagem.dias = JOptionPane.showInputDialog(null, "Planeja ficar quantos dias em viagem?");
            } while (novaViagem.dias == null);
            do {
                novaViagem.valor = JOptionPane.showInputDialog(null, "Qual o valor gasto por dia?");
                novaViagem.valorI = Long.parseLong(novaViagem.valor);
                
            } while (novaViagem.valor == null);

            JOptionPane.showMessageDialog(null, "Viagem cadastrada.");
                v.add(novaViagem);
            imprimir();
        } else if (escolha == 1) {
            JOptionPane.showMessageDialog(null, "Obrigada por utilizar o nosso sistema!");
        }   
        
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
       
        if (desejo == 0) {
            String escolha = (String) JOptionPane.showInputDialog(null,"Escolha uma viagem cadastrada:","Viagens cadastradas",JOptionPane.QUESTION_MESSAGE,null,opcoes,opcoes[0]);
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
