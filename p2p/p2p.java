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




private static void iniciarServidor(int porta, String apelido) {
        try (ServerSocket serverSocket = new ServerSocket(porta)) {
            System.out.println("Aguardando conexões na porta " + porta + "...");
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado!");

            iniciarChat(socket, apelido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void iniciarChat(Socket socket, String apelido) {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            Thread receiverThread = new Thread(() -> {
                try {
                    String msg;
                    while ((msg = input.readLine()) != null) {
                        System.out.println("Cliente: " + msg);
                    }
                } catch (IOException e) {
                    System.out.println("Conexão encerrada.");
                }
            });
            receiverThread.start();

            String msg;
            while (!(msg = scanner.nextLine()).equalsIgnoreCase("sair")) {
                output.println(apelido + "--> " + msg);
            }
  
