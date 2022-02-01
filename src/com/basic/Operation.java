package com.basic;

public class Operation {

    static String[] data = new String[10];
    /**
     * 1. Menampilkan TodoList
     * 2. Menambah TodoList
     * 3. Menghapus TodoList
     */


    /* Menampilkan TodoList */
    static void showTodo(){
        for (int i = 0; i < data.length; i++){
            if(data[i] != null){
                int no = i+1;
                String todo = data[i];
                System.out.println(no + ". " + todo);
            }
        }
    }

    /* Menambahkan TodoList */
    static void addTodo(String kegiatan){
//        Mengecek apakah Array penuh
            boolean isFull = true;
            for (int i = 0; i < data.length; i++) {
                if (data[i] == null) {
//                Array masih ada yang kosong
                    isFull = false;
                    break;
                }
            }

            if (isFull) {
//            Resize ukuran Array
                String[] temp = data;
                data = new String[data.length * 2];
                for (int i = 0; i < temp.length; i++) {
                    data[i] = temp[i];
                }

                isFull = false;
                if (!isFull) {
                    for (int i = 0; i < data.length; i++) {
                        if (data[i] == null) {
                            data[i] = kegiatan;
                            break;
                        }
                    }
                }

            } else {
//              Menambahkan data
                for (int i = 0; i < data.length; i++) {
                    if (data[i] == null) {
                        data[i] = kegiatan;
                        break;
                    }
                }
            }
    }


    /* Menghapus TodoList */
    static void deleteTodo(int nomor){
        Boolean isValid = true;

        if(nomor -1 >= data.length){
            isValid = false;
            return;
        }else if(data[nomor - 1] == null){
            isValid = false;
            return;
        }else{
            for(int i = (nomor - 1); i < data.length; i++){
                if(i == (data.length - 1)){
                    data[i] = null;
                    isValid = true;
                }else {
                    data[i] = data[i + 1];
                }
            }
        }

        if (isValid) {
            System.out.println("Data dihapus");
        }else{
            System.out.println("Data tidak ditemukan");
        }
    }

    static String[] getData(){
        return data;
    }

}
