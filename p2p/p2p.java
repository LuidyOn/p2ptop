public class p2p {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Qual é seu apelido? ");
        String apelido = scanner.nextLine();

        System.out.print("Qual é sua porta? ");
        int minhaPorta = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Qual é o IP? ");
        String ip = scanner.nextLine();

        System.out.print("Qual é a porta do outro cliente? ");
        int portaOutro = scanner.nextInt();
        scanner.nextLine();
    
    } 
}
  
