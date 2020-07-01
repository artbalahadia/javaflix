package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MovieList movieList = new MovieList();

    public static void main(String[] args) {
        boolean exit = false;
        int choice = 0;
        System.out.println("Welcome to JavFlix!\n Please choose from the options below:");
        printInstructions();
        while(!exit){
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    movieList.printMovieList();
                    break;
                case 2:
                    addMovie();
                    break;
                case 3:
                    modifyMovie();
                    break;
                case 4:
                    removeMovie();
                    break;
                case 5:
                    searchMovie();
                    break;
                case 6:
                    playMovie();
                    break;
                case 7:
                    movieList.printQueue();
                    break;
                case 8:
                    exit = true;
                    break;
            }
        }
    }

    public static void printInstructions(){
        System.out.println("\nPress:");
        System.out.println("\t 0 - To print the option list.");
        System.out.println("\t 1 - To print the list of movies.");
        System.out.println("\t 2 - To add a movie in the list.");
        System.out.println("\t 3 - To modify a movie in the list.");
        System.out.println("\t 4 - To remove a movie from the list.");
        System.out.println("\t 5 - To search for a movie in the list.");
        System.out.println("\t 6 - To pick a movie to play.");
        System.out.println("\t 7 - To print the current queue.");
        System.out.println("\t 8 - To exit the application.");
    }

    public static void addMovie(){
        System.out.println("Please enter the movie to add: ");
        movieList.addMoveItem(scanner.nextLine());
    }

    public static void modifyMovie(){
        System.out.println("Enter the movie item to modify: ");
        int itemNo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter replacement movie:");
        String newItem = scanner.nextLine();
        movieList.modifyMovieList(itemNo-1, newItem);
    }

    public static void removeMovie(){
        System.out.println("Enter item number to remove: ");
        int itemNo = scanner.nextInt();
        scanner.nextLine();
        movieList.removeMovieItem(itemNo-1);
    }

    public static void searchMovie(){
        System.out.println("Enter movie title to search:");
        String searchItem = scanner.nextLine();
        if(movieList.findItem(searchItem) != null){
            System.out.println("Found " + searchItem + " in the list!");
        } else {
            System.out.println("Sorry, " + searchItem + " is not found");
        }
    }

    public static void playMovie(){
        System.out.println("Enter movie number to play: ");
        int itemNo = scanner.nextInt();
        scanner.nextLine();
        movieList.playMovieItem(itemNo-1);
    }


}
