package org.codedifferently;

import java.util.Scanner;

public class UI {

    private BandGigManager bgm = new BandGigManager();
    private Scanner sc = new Scanner(System.in);
    Gig gig = new Gig();

    public void startProgram() {
        boolean running = true;

        while (running) {
            System.out.println("\n============= OPENING BAND GIG MANAGER =============");
            System.out.println("1. Gig Scheduling ");
            System.out.println("2. Song and Setlist Maintenance");
            System.out.println("3. Band lineup");
            System.out.println("4. Calculate Total Earnings");
            System.out.println("5. Exit");
            System.out.println("====================================================");
            System.out.print("Select option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clears leftover newline

            switch (choice) {
                case 1:
                    showGigMenu();
                    break;

                case 2:
                    showSongMenu();
                    break;


                case 3:
                    adjustGigLineup();
                    break;
                case 4:
                    System.out.println("Total earnings: $" + bgm.calculateTotalEarnings());
                    break;

                case 5:
                    running = false;
                    System.out.println("Closing Band Gig Manager...");
                    break;

                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }



    private void viewVenueInformation() {
        System.out.print("Enter gig number to view venue information: ");
        int gigIndex = sc.nextInt();
        sc.nextLine();

        Gig gig = bgm.findGigByIndex(gigIndex - 1);

        if (gig != null) {
            System.out.println(gig.getVenue());
        } else {
            System.out.println("Invalid gig selection.");
        }
    }

    private void markGigComplete() {
        System.out.print("Enter gig number to mark as completed: ");
        int gigIndex = sc.nextInt();
        sc.nextLine();

        Gig gig = bgm.findGigByIndex(gigIndex - 1);

        if (gig != null) {
            gig.markCompleted();
            System.out.println("Gig marked as completed.");
        } else {
            System.out.println("Invalid gig selection.");
        }
    }

    private void viewSongCatalog() {
        if (bgm.getSongCatalog().isEmpty()) {
            System.out.println("Song catalog is empty.");
        } else {
            System.out.println("Song Catalog:");
            for (int i = 0; i < bgm.getSongCatalog().size(); i++) {
                System.out.println((i + 1) + ". " + bgm.getSongCatalog().get(i));
            }
            System.out.println("");
        }
    }

    private void generateSetlist() {
        if (bgm.getGigs().isEmpty()) {
            System.out.println("No gigs available.");
            return;
        }

        if (bgm.getSongCatalog().isEmpty()) {
            System.out.println("Song catalog is empty.");
            return;
        }

        System.out.println("Select a gig to generate a setlist for:");
        bgm.viewAllGigs();

        System.out.print("Enter gig number: ");
        int gigIndex = sc.nextInt();
        sc.nextLine();

        Gig gig = bgm.findGigByIndex(gigIndex - 1);

        if (gig == null) {
            System.out.println("Invalid gig selection.");
            return;
        }

        if (gig.isCompleted()) {
            System.out.println("Cannot generate a setlist for a completed gig.");
            return;
        }

        System.out.print("How many songs should be in the setlist? ");
        int numberOfSongs = sc.nextInt();
        sc.nextLine();

        bgm.generateSetlistForGig(gig, numberOfSongs);

        System.out.println("Setlist generated for this gig.");
        System.out.println("Setlist: " + gig.getSetlist());
    }



    private void viewGigSetlist() {
        if (bgm.getGigs().isEmpty()) {
            System.out.println("No gigs available.");
            return;
        }

        System.out.println("Select a gig to view its setlist:");
        bgm.viewAllGigs();

        System.out.print("Enter gig number: ");
        int gigIndex = sc.nextInt();
        sc.nextLine();

        Gig gig = bgm.findGigByIndex(gigIndex - 1);

        if (gig == null) {
            System.out.println("Invalid gig selection.");
            return;
        }

        if (gig.getSetlist().isEmpty()) {
            System.out.println("This gig does not have a setlist yet.");
            return;
        }

        System.out.println("\nSetlist for " + gig.getDate() + " at " + gig.getVenue().getName() + ":");
        for (int i = 0; i < gig.getSetlist().size(); i++) {
            System.out.println((i + 1) + ". " + gig.getSetlist().get(i));
        }
    }

    private void addSongToGigSetlist() {
        if (bgm.getGigs().isEmpty()) {
            System.out.println("No gigs available.");
            return;
        }

        System.out.println("Select a gig to add a song to:");
        bgm.viewAllGigs();

        System.out.print("Enter gig number: ");
        int gigIndex = sc.nextInt();
        sc.nextLine();

        Gig gig = bgm.findGigByIndex(gigIndex - 1);

        if (gig == null) {
            System.out.println("Invalid gig selection.");
            return;
        }

        if (gig.isCompleted()) {
            System.out.println("Cannot modify the setlist of a completed gig.");
            return;
        }

        System.out.print("Enter song name to add to this gig's setlist: ");
        String song = sc.nextLine();

        gig.addSong(song);
        System.out.println("Song added to this gig's setlist.");
    }

    private void removeSongFromGigSetlist() {
        if (bgm.getGigs().isEmpty()) {
            System.out.println("No gigs available.");
            return;
        }

        System.out.println("Select a gig to remove a song from:");
        bgm.viewAllGigs();

        System.out.print("Enter gig number: ");
        int gigIndex = sc.nextInt();
        sc.nextLine();

        Gig gig = bgm.findGigByIndex(gigIndex - 1);

        if (gig == null) {
            System.out.println("Invalid gig selection.");
            return;
        }

        if (gig.isCompleted()) {
            System.out.println("Cannot modify the setlist of a completed gig.");
            return;
        }

        if (gig.getSetlist().isEmpty()) {
            System.out.println("This gig does not have a setlist yet.");
            return;
        }

        System.out.println("Current setlist:");
        for (int i = 0; i < gig.getSetlist().size(); i++) {
            System.out.println((i + 1) + ". " + gig.getSetlist().get(i));
        }

        System.out.print("Enter the number of the song to remove: ");
        int songIndex = sc.nextInt();
        sc.nextLine();

        if (songIndex < 1 || songIndex > gig.getSetlist().size()) {
            System.out.println("Invalid song selection.");
            return;
        }

        String removedSong = gig.getSetlist().remove(songIndex - 1);
        System.out.println("Removed song: " + removedSong);
    }

    private void showGigMenu() {

        boolean running = true;
        do {
            System.out.println("1. Create New Gigs");
            System.out.println("2. View Upcoming Gigs");
            System.out.println("3. View Completed Gigs");
            System.out.println("4. View All Gigs");
            System.out.println("5. Mark Gig Completed");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); //clear token
            {
                switch (choice) {
                    case 1:
                        bgm.addNewGig();
                        break;
                    case 2:
                        bgm.viewUpcomingGigs();
                        break;
                    case 3:
                        bgm.viewCompletedGigs();
                        break;
                    case 4:
                        bgm.viewAllGigs();
                        break;
                    case 5:
                        markGigComplete();
                        break;
                     case 0:
                    running=false;
            }

        }
    }while (running) ;
}

    private void showSongMenu() {
        boolean running = true;

        do {
            System.out.println("\n========== SONG / LINEUP MENU ==========");
            System.out.println("1. Add Song To Catalog");
            System.out.println("2. View Song Catalog");
            System.out.println("3. Generate Setlist For A Gig");
            System.out.println("4. View Setlist For A Gig");
            System.out.println("5. Add Song Manually To A Gig Setlist");
            System.out.println("6. Remove Song From A Gig Setlist");
            System.out.println("0. Exit");
            System.out.print("Select option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name of song to add to catalog: ");
                    String song = sc.nextLine();
                    bgm.addSongToCatalog(song);
                    System.out.println("Song added to catalog.");
                    break;

                case 2:
                    viewSongCatalog();
                    break;

                case 3:
                    generateSetlist();
                    break;

                case 4:
                    viewGigSetlist();
                    break;

                case 5:
                    addSongToGigSetlist();
                    break;
                case 6:
                    removeSongFromGigSetlist();
                    break;
                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid selection. Please try again.");
            }

        } while (running);
    }

    private void adjustGigLineup() {

        if (bgm.getGigs().isEmpty()) {
            System.out.println("No gigs available.");
            return;
        }

        System.out.println("Select a gig to adjust lineup for:");
        bgm.viewAllGigs();

        System.out.print("Enter gig number: ");
        int gigIndex = sc.nextInt();
        sc.nextLine();

        Gig gig = bgm.findGigByIndex(gigIndex - 1);

        if (gig == null) {
            System.out.println("Invalid gig selection.");
            return;
        }

        if (gig.isCompleted()) {
            System.out.println("Cannot adjust lineup for a completed gig.");
            return;
        }

        boolean editing = true;

        while (editing) {
            System.out.println("\n===== LINEUP MENU =====");
            System.out.println("Gig: " + gig.getDate() + " at " + gig.getVenue().getName());
            System.out.println("Current Lineup: " + gig.getLineup());
            System.out.println("1. Apply Default Lineup");
            System.out.println("2. Add Band Member");
            System.out.println("3. Remove Band Member");
            System.out.println("4. Swap Band Member");
            System.out.println("5. Return to Main Menu");
            System.out.print("Select option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    bgm.applyDefaultLineup(gig);
                    System.out.println("Default lineup applied to this gig.");
                    break;

                case 2:
                    System.out.print("Enter member to add: ");
                    String memberToAdd = sc.nextLine();
                    gig.addBandMember(memberToAdd);
                    System.out.println("Band member added to this gig.");
                    break;

                case 3:
                    System.out.print("Enter member to remove: ");
                    String memberToRemove = sc.nextLine();
                    gig.removeBandMember(memberToRemove);
                    System.out.println("Band member removed from this gig.");
                    break;

                case 4:
                    System.out.print("Enter member to replace: ");
                    String oldMember = sc.nextLine();

                    System.out.print("Enter new member: ");
                    String newMember = sc.nextLine();

                    gig.swapBandMember(oldMember, newMember);
                    System.out.println("Band member swapped for this gig.");
                    break;

                case 5:
                    editing = false;
                    break;

                default:
                    System.out.println("Invalid selection.");
            }
        }
    }
    }