package equipes.TF.LP1;

import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Aplicacao {
    
    public Aplicacao(){
        this.equipas = new Equipa[100];        
    }
    
    /*
    Variavies Gerais - Todas as func�es. 
    */    
    Equipa[] equipas;    
    Scanner ler = new Scanner( System.in );
    String pastaFicheiros = "C:\\aplicacao\\";
    
       
    /*
    * CONTROLO DE A��ES
    */
    public void Iniciar(){
        System.out.println(" -<<<< APLICA��O DO MUNDIAL >>>>-");
        this.LerDadosFicheiros();
        this.ApresentarMenuPrincipal();
    }
    
    //Fun��es menu principal    
    public void ApresentarMenuPrincipal(){
        System.out.println("");         
        System.out.println(" ## MENU PRINCIPAL ##");
        System.out.println("(Selecione uma op��o)");
        
        System.out.println("1. Equipas");
        System.out.println("2. Torneio");
        System.out.println("3. Fechar");
        
         switch (this.ler.nextInt()){
            case 1:
                //apresentar menu equipa
                this.ApresentarMenuEquipas();
                break;
            case 2:
                //apresentar menu torneio
                this.ApresentarMenuTorneio();
                break;
            case 3:
            {
                //gravo a informa��o para ficheiros e sai
                this.GravarDadosParaFicheiros();
                break;
            }              
            default:
                System.out.println("Op��o inv�lida.");
                this.ApresentarMenuPrincipal();
        }
        
    }
            
    //Fun��es para gerir as equipas  
    public void ApresentarMenuEquipas(){
        System.out.println("");         
        System.out.println(" ## EQUIPAS ##");
        System.out.println("(Selecione uma op��o)");
        
        System.out.println("1. Listar equipa");    
        System.out.println("2. Adicionar equipa");
        System.out.println("3. Editar equipa");
        System.out.println("4. Eliminar equipa");
        System.out.println("5. Menu Principal");
        
        switch (this.ler.nextInt()){
            case 1:
                this.ListarEquipas();
                break;
            case 2:
                this.AdicionarEquipa();
                break;
            case 3:
            	EditarEquipa();
                this.ApresentarMenuEquipas();
                break;
            case 4:
                this.EliminarEquipa();                
                break;
            case 5:
                this.ApresentarMenuPrincipal();
                break;
            default:
                System.out.println("!!!! Op��o inv�lida !!!");
                this.ApresentarMenuEquipas();
        }
    }
    
    //Fun��es para gerir o torneio
    public void ApresentarMenuTorneio(){                
               
    }
    
    /*
    * GEST�O DE EQUIPAS
    */
    
    public void AdicionarEquipa(){
         // Pe�o os dados ao utilizador
        Equipa nova = new Equipa();
        
        System.out.println("Indique o nome  da equipa:");
        nova.SetnomeEquipa(ler.next());
        
        System.out.println("Indique a federa��o da equipa:");
        nova.SetFederacao(ler.next());
        
        System.out.println("Indique o ano de inaugura��o:");  
        nova.SetInaguracao(ler.nextInt());
        
        System.out.println("Indique o ranking da equipa:");      
        nova.SetRanking(ler.nextInt());
        
        System.out.println("Indique vai ao mundial:");
        String mundial = ler.next();
        
        if (mundial.equals("sim")){
            nova.SetMundial(true);
        }else{
            nova.SetMundial(false);
        }
        // adiciono a equipa na ultima posi��o do array
        this.equipas[this.ContagemEquipas()] = nova;
        
        
        
        // informo que a equipa foi adicionada
        System.out.println("Equipa adicionada com sucesso!"); 
         
        //volta ao menu de equipas
        ApresentarMenuEquipas();
    }
    
    public void EliminarEquipa(){
        
        System.out.println("Indique o nome da equipa que pretende eliminar:");
        String nomeEquipa = ler.next();
        
        // vou correr todo o array para verificar se existe alguma equipa com aquele nome
        Boolean encontrei = false;        
        for (int i = 0; i < this.equipas.length; i++) {
            if (this.equipas[i] != null){
                if (this.equipas[i].GetFederacao().equals(nomeEquipa) || encontrei == true){
                    // encontrei a equipa ent�o vou colocar o proximo elemento na posi��o deste, ou seja, todos as proximos equipas da lista andam uma casa para tr�s
                    this.equipas[i] = this.equipas[i+1];
                    encontrei = true;
                }
            }
        }
        
        if (encontrei == true){            
            System.out.println("Equipa eliminada com sucesso.");
        }else{            
            System.out.println("Equipa n�o encontrada");
        }     
        ApresentarMenuEquipas();
    }
    
    public void ListarEquipas(){
        // se o array est� vazio, ou seja, n�o existem equipas
        if (this.ContagemEquipas() == 0) {
            System.out.println("N�o existem equipas registadas.");            
        } else {
             System.out.println("\n-------------------------\n");  // o barra n d� uma quebra de linha 
            for (int i = 0; i < this.equipas.length; i++) {                  
                // vou correr todas as equipas do array e apresentar informa��o. so apresento a equipa no array se estiver preenchida essa posi��o do array
                if (this.equipas[i] != null){
                    Equipa equipa = this.equipas[i];
                    System.out.println("Equipa "+ (i+1) +
                            "\nNome: " + equipa.GetnomeEquipa() +
                            "\nFedera��o: " + equipa.GetFederacao() +
                            "\nAno Inaugura��o: " + equipa.GetInaguracao() +
                            "\nRanking: " + equipa.GetRanking() +
                            "\nMundial: "+ equipa.GetMundial()
                    );
                    //adiciono uma quebra de linha por cada equipa
                    System.out.println("");
                }
            }
            System.out.println("-------------------------");  
        }
        ApresentarMenuEquipas();        
    }
    
    private void EditarEquipa() {
    	
    	System.out.println("Qual equipa pretende editar?");
    	ListarEquipas();
    	
    	String nomeEquipa = ler.next();
    	
    	for (int i=0;i<equipas.length;i++) {
    		if (equipas[i].GetnomeEquipa()== nomeEquipa) {
    			
    		}	
    	}
    		
    	
    }
    
    private int ContagemEquipas(){
        int contador = 0;
        for (int i = 0; i < this.equipas.length; i++) {                  
            // vou correr todas as equipas do array e apresentar informa��o. so apresento a equipa no array se estiver preenchida essa posi��o do array
            if (this.equipas[i] != null){
                contador++;
            }else{
                break;
            }
        }     
        return contador;
    }
        
    /*
    * GERIR DADOS PARA FICHEIROS TEXTO
    */
        
    public void LerDadosFicheiros(){
        //criar uma pasta --> https://www.guj.com.br/t/criando-arquivos-e-diretorios/42487/2
        File file = new File(this.pastaFicheiros);  
        if (!file.exists()) {
            file.mkdirs();
        }
        //est� dentro de um try porque vai tentar ler o ficheiro, se der erro salta at� o catch mais abaixo
        try
        {
            //1. Ler o ficheiro equipas que est� na pasta
            Scanner scanner = new Scanner(new FileReader(this.pastaFicheiros + "\\equipas.txt")).useDelimiter("\\n");
            int contador = 0;  
            while (scanner.hasNext()) {

                //1.1 Ap�s lido a linha vou dividir o texto pelo separador |
                String[] linhaEquipa = scanner.next().split("\\|");

                //1.2 Crio uma nova equipa com os dados lidos
                Equipa nova = new Equipa();
                nova.SetFederacao(linhaEquipa[0]);
                nova.SetInaguracao(Integer.parseInt(linhaEquipa[1]));
                nova.SetRanking(Integer.parseInt(linhaEquipa[2]));
                nova.SetMundial(Boolean.parseBoolean(linhaEquipa[3]));

                //1.3 Adiciono a equipa no array
                this.equipas[contador] = nova;

                //1.4 Avan�o uma posi��o no array
                contador = contador + 1;
            }
        }catch(Exception ex){}
    }
    
    public void GravarDadosParaFicheiros(){ 
        // aprendido aqui --> https://www.devmedia.com.br/criando-e-gravando-dados-em-txt-com-java/23060
        try
        {
            //1. Este c�digo prepara a escrita de um ficheiro 
            FileWriter ficheiro = new FileWriter(this.pastaFicheiros + "\\equipas.txt");
            PrintWriter escrita = new PrintWriter(ficheiro);

            //2. S� vou adicionar conteeudo no ficheiro se existir equipas
            if (this.ContagemEquipas() > 0){
                for (int i = 0; i < this.ContagemEquipas(); i++) {
                    escrita.printf(this.equipas[i].GetFederacao() + "|" + this.equipas[i].GetInaguracao() + "|" +this.equipas[i].GetRanking() + "|" + this.equipas[i].GetMundial() +"\n");
                }
            }
            ficheiro.close();
        }catch(Exception ex){}
    }
     
}


