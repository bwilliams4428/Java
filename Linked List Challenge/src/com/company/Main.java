package com.company;

import java.util.*;

public class Main {

    private static List<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("Strombringer", "Deep Purple");
        album.addSong("Strombringer", 4.6);
        album.addSong("Love don't mean a thing", 4.3);
        album.addSong("Holy Man", 4.4);
        album.addSong("Hold on", 4.5);
        album.addSong("Lady double dealer", 3.6);
        album.addSong("You can't do it right", 7.6);
        album.addSong("High ball shooter", 5.6);
        album.addSong("The gypsy", 2.6);
        album.addSong("Soldier of fortune", 1.6);
        albums.add(album);


        album = new Album("For those who like to rock", "AC/DC");
        album.addSong("T1", 5.65);
        album.addSong("T2", 5.35);
        album.addSong("T3", 5.55);
        album.addSong("T4", 5.85);
        album.addSong("T5", 5.25);
        album.addSong("T6", 5.15);
        album.addSong("T7", 5.45);
        album.addSong("T8", 4.65);
        album.addSong("T9", 2.65);
        album.addSong("T10", 1.65);

        albums.add(album);

        List<Song> playlist = new ArrayList<Song>();
        albums.get(0).addToPlaylst("You can't do it right",playlist);
        albums.get(0).addToPlaylst("Holy Man",playlist);
        albums.get(0).addToPlaylst("Speed King",playlist);

        albums.get(0).addToPlaylist(9,playlist);
        albums.get(1).addToPlaylist(8,playlist);
        albums.get(1).addToPlaylist(3,playlist);
        albums.get(1).addToPlaylist(2,playlist);
        albums.get(1).addToPlaylist(24,playlist); //dne

        play(playlist);

        printMenu();


    }

    private static void play(List<Song> playlist) {

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now Playing " + listIterator.next().toString());
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete ");
                    quit = true;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    }else{
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now Playing " + listIterator.previous().toString());
                    }else{
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replying " + listIterator.previous().toString());
                            forward = false;
                        }else{
                            System.out.println("We are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Now replying " + listIterator.next().toString());
                            forward  = true;
                        }else{
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                   printMenu();
                    break;

                case 6:
                    if(playlist.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous());
                        }

                    }
                    break;
            }
        }
    }


    private static void printMenu(){
        System.out.println("Available actions:\n");
        System.out.println("0 - quit\n" +
                "1 - to play the next song\n"+
                "2 - to play previous song \n"+
                "3 - to replay the current songs\n"+
                "4 - list songs in the playlist\n"+
                "5 - print available actions\n"+
                "6- Delete current song from playlist");
    }
    private static void printList(List<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("========================================================");
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        System.out.println("========================================================");

    }
}