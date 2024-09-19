import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Random;

public class ContaTerminal {
    static InputStreamReader read = new InputStreamReader(System.in);
    static BufferedReader scan = new BufferedReader(read);
    public static void main(String[] args) throws IOException {
        Random rand = new Random();
        String nome = "";
        String agencia = "";
        Map<String, Integer> agencias = Map.of("Região Norte",1234, "Região Sul",4444, "Região Leste",0001, "Região Oeste",9999);
        int agenciaId = 0;
        double saldo;

        System.out.println("Boas vindas! Para dar inicio à criação da sua conta informe seu nome e pressione ENTER:");
        nome = scan.readLine();
        
        System.out.printf("No momento o banco possui 4 agências: %s\nPor favor informe a agência de sua preferência e pressione ENTER:\n", getListaAgencias(agencias));
        agencia = scan.readLine();
        while(!agencias.containsKey(agencia)){
            System.out.printf("Agência inexistente. Favor informar uma de nossas 4 agências: %s\n", getListaAgencias(agencias));
            agencia = scan.readLine();
        }
        agenciaId = agencias.get(agencia);

        System.out.println("Qual valor você deseja depositar na sua nova conta? Por favor informe e pressione ENTER:");
        saldo = tratarValorDeposito();
        
        System.out.printf("Olá %s, nós da filial %s te recebemos de braços abertos! \nSua agência é %04d, conta %s e seu saldo de R$ %.2f já está disponível para uso.\n",
        nome, agencia, agenciaId, (rand.nextInt(1000000)+"-"+rand.nextInt(5)), saldo);
    }

    public static double tratarValorDeposito() throws IOException {
        String input = "";
        Double value = null;

        while(value==null){
            input = scan.readLine();
            
            if(input==null){
                System.out.printf("Valor não detectado. Favor informar um valor a partir de 0\n");
            } try {
                value = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.printf("Valor incompatível. Favor informar um valor a partir de 0\n");
            }
        }
        value = Double.parseDouble(input);
        return value;
    }

    public static String getListaAgencias(Map<String, Integer> agencias){
        String lista = "| ";
        for(String key: agencias.keySet()){
            lista += key+" | ";
        }
        return lista;
    }
}

    // public static void solicitarNome(String nome) throws IOException {
    //     System.out.println("Boas vindas! Para dar inicio à criação da sua conta informe seu nome e pressione ENTER:");
    //     nome = scan.readLine();
    // }

    // public static void solicitarAgencia(Map<String, Integer> agencias, String agencia) throws IOException {
    //     System.out.printf("No momento o banco possui 4 agências: %s\nPor favor informe a agência de sua preferência e pressione ENTER:\n", getListaAgencias(agencias));
    //     agencia = scan.readLine();
    // }

    // public static void solicitarDeposito(int saldo) throws IOException {
    //     System.out.println("Qual valor você deseja depositar na sua nova conta? Por favor informe e pressione ENTER:");
    //     saldo = Integer.parseInt(scan.readLine());
    // }

    // public static void identificarAgencia(Map<String, Integer> agencias, String agencia, int agenciaId) throws IOException {
    //     agencia = scan.readLine();
    //     while(!agencias.containsKey(agencia)){
    //         System.out.printf("Agência inexistente. Favor informar uma de nossas 4 agências: %s\n", getListaAgencias(agencias));
    //         agencia = scan.readLine();
    //     }
    //     agenciaId = agencias.get(agencia);
    // }

    // public static void concluirCadastro(String agencia, int agenciaId, int saldo, Random rand, String nome){
    //     System.out.printf("Olá %s, nós da filial %s te recebemos de braços abertos! \nSua agência é %d, conta %d e seu saldo R$ %d já está disponível para saque.\n",
    //     nome, agencia, agenciaId, rand.nextInt(10000)+"-"+rand.nextInt(5), saldo);
    // }
