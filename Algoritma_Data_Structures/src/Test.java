import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

        public class Test {
            public static void main(String args[] ){
                Scanner inputManager = new Scanner(System.in);
                kereta kereta = new kereta();
                int repetisi = inputManager.nextInt();
                String[] pilihan;
                inputManager.nextLine();
                for(int index = 0; index<repetisi; index++){
                    pilihan = inputManager.nextLine().split(" ");
                    if(pilihan[0].equalsIgnoreCase("INSERT")){
                        kereta.TambahGerbong(pilihan[1]);
                    }
                    else if(pilihan[0].equalsIgnoreCase("LEPAS")){
                        kereta.HapusGerbongKereta();
                    }
                    else if(pilihan[0].equalsIgnoreCase("SISIP")){
                        int indexKereta = Integer.parseInt(pilihan[1]);
                        kereta.TambahGerbong(indexKereta, pilihan[2]);
                    }
                    else if(pilihan[0].equalsIgnoreCase("CETAK")){
                        kereta.CetakDataKereta();
                    }
                    else{
                        System.out.println("Pilihan tidak ada!");
                    }
                }
            }
        }
        class kereta{
            public LinkedList<String> tipeKereta;
            public HashMap<String,String> dataGerbongKereta;
            public kereta(){
                tipeKereta = new LinkedList<>();
                dataGerbongKereta = new HashMap<>();
                dataGerbongKereta.put("G1", "Eksekutif");
                dataGerbongKereta.put("G2", "Bisnis");
                dataGerbongKereta.put("G3", "Ekonomi");
                dataGerbongKereta.put("GM", "Makanan");
            }
            public void TambahGerbong(String input){
                if(dataGerbongKereta.containsKey(input)){
                    String gerbongKereta = dataGerbongKereta.get(input);
                    tipeKereta.addLast(gerbongKereta);
                    System.out.printf("Gerbong %s berhasil ditambahkan\n", gerbongKereta);
                }
                else{
                    System.out.println("Gerbong Kereta tidak ada!");
                }
            }
            public void TambahGerbong(int index,String input){
                if(dataGerbongKereta.containsKey(input) && index<= tipeKereta.size()-1){
                    String gerbongKereta = dataGerbongKereta.get(input);
                    tipeKereta.add(index, gerbongKereta);
                    System.out.printf("Gerbong %s berhasil ditambahkan pada index ke-%d\n", gerbongKereta, index);
                }
                else{
                    System.out.println("Index melebihi batas");
                }
            }
            public void HapusGerbongKereta() {
                if (tipeKereta.size() == 0) {
                    System.out.println("Jumlah gerbong kosong");
                    return;
                }
                String lastGerbong = tipeKereta.removeLast();
                System.out.printf("Gerbong %s berhasil dilepas\n", lastGerbong);
            }
            public void CetakDataKereta(){
                if(tipeKereta.size()==0){
                    System.out.println("Kereta tidak memiliki gerbong");
                    return;
                }
                System.out.print("Start -");
                for(int index = 0; index<tipeKereta.size();index++){
                    String GerbongKini = tipeKereta.get(index);
                    System.out.printf(" Gerbong %s -",GerbongKini);
                }
                System.out.println(" End");
            }
        }