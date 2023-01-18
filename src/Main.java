import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album album1=new Album("Shreyas's Album","ShreyaGhosal");
        album1.addSongToAlbum("Rabne",3.56);
        album1.addSongToAlbum("Munbe vaa",5.6);
        album1.addSongToAlbum("Pal",4.5);
        album1.addSongToAlbum("Sunn raha hai",5.34);

        Album album2=new Album("A.R.Rahman album","Rahman");

        album2.addSongToAlbum("Pachainirame",4.56);
        album2.addSongToAlbum("Mallipoo",4.3);
        album2.addSongToAlbum("New york",5.2);
        album2.addSongToAlbum("Anbe Anbe",5.4);

        System.out.println( album1.findSong("Rane"));
        LinkedList<Song> myplaylist=new LinkedList<>();

        album1.addToPlaylistFromAlbum("Rabne",myplaylist);
        album1.addToPlaylistFromAlbum("Pal",myplaylist);
        album2.addToPlaylistFromAlbum("Mallipoo",myplaylist);
        album2.addToPlaylistFromAlbum("New york",myplaylist);
       // Song sample=new Song("Uyire",2.6);
//        System.out.println(sample);
       play(myplaylist);
    }
    public static void play(LinkedList<Song> playlist){
        ListIterator<Song> itr=playlist.listIterator();
        Scanner sc=new Scanner(System.in);
        boolean isForward=false;
        if(playlist.size()>0){
            System.out.println("Your currently playing");
            System.out.println(itr.next());
            isForward=true;
        }
        else{
            System.out.println("Playlist is Empty");
        }
        System.out.println("Enter your choice");
        printMenu();

        boolean quit=false;
        while(!quit){
            int choice =sc.nextInt();
            switch(choice){
                case 1:
                    if(isForward==false){
                        itr.next();
                        isForward=true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    else{
                        System.out.println("No more songs in playlist");
                        isForward=false;
                    }
                    break;
                case 2:
                    if(isForward==true){
                        itr.previous();
                        isForward=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }
                    else{
                        System.out.println("You are at the start of playlist");
                        isForward=true;
                    }
                    break;
                case 3:
                    if(isForward==true){
                        if(itr.hasPrevious()) {
                            System.out.println(itr.previous());
                            isForward=false;
                        }
                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isForward=true;
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    break;
                case 6:
                    printSongs(playlist);
                    break;
                case 7:
                    quit=true;
                    break;
            }
        }
    }
    public static void printSongs(LinkedList<Song> playlist){
        for(Song song:playlist){
            System.out.println(song);
        }
        return;
    }
    public static void printMenu(){
        System.out.println("1 - Play next song");
        System.out.println("2 - play previous song");
        System.out.println("3 - Repeat current song");
        System.out.println("4 - show menu again");
        System.out.println("5 - delete current song");
        System.out.println("6 - Print all songs in playlist");
        System.out.println("7 - Exit");
    }
}