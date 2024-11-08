class Song {
    String title;
    String artist;
    int year;
    double duration; 
    String genre;
    Song prev, next;

    public Song(String artist, String title, int year, double duration, String genre) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.genre = genre;
        this.prev = null;
        this.next = null;
    }
}

class Playlist {
    Song head, tail;
    int size;  

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addSong(Song song) {
        if (head == null) {
            head = song;
            tail = song;
        } else {
            tail.next = song;
            song.prev = tail;
            tail = song;
        }
        size++;
    }

    public void bubbleSortByDuration() {
        if (head == null) return;

        boolean swapped;
        do {
            swapped = false;
            Song current = head;
            while (current != null && current.next != null) {
                if (current.duration > current.next.duration) {
                    String tempTitle = current.title;
                    String tempArtist = current.artist;
                    int tempYear = current.year;
                    double tempDuration = current.duration;
                    String tempGenre = current.genre;

                    current.title = current.next.title;
                    current.artist = current.next.artist;
                    current.year = current.next.year;
                    current.duration = current.next.duration;
                    current.genre = current.next.genre;

                    current.next.title = tempTitle;
                    current.next.artist = tempArtist;
                    current.next.year = tempYear;
                    current.next.duration = tempDuration;
                    current.next.genre = tempGenre;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void selectionSortByYear() {
        if (head == null) return;

        Song current = head;
        while (current != null) {
            Song maxNode = current;
            Song check = current.next;
            while (check != null) {
                if (check.year > maxNode.year) {
                    maxNode = check;
                }
                check = check.next;
            }
            if (maxNode != current) {
                String tempTitle = current.title;
                String tempArtist = current.artist;
                int tempYear = current.year;
                double tempDuration = current.duration;
                String tempGenre = current.genre;

                current.title = maxNode.title;
                current.artist = maxNode.artist;
                current.year = maxNode.year;
                current.duration = maxNode.duration;
                current.genre = maxNode.genre;

                maxNode.title = tempTitle;
                maxNode.artist = tempArtist;
                maxNode.year = tempYear;
                maxNode.duration = tempDuration;
                maxNode.genre = tempGenre;
            }
            current = current.next;
        }
    }

    public void display() {
        System.out.println("==========================================================");
        System.out.println("||                       LOL Playlist                   ||");
        System.out.println("==========================================================");

        Song current = head;
        int index = 1;  
        while (current != null) {
            String line1 = index + " | " + current.artist + " - " + current.title + " (" + current.year + ")";
            String line2 = current.duration + "       " + current.genre;

            System.out.println(line1);
            System.out.println(line2);
            System.out.println("==========================================================");

            current = current.next;
            index++;
        }
    }

    public void searchByTitle(String searchTitle) {
        int index = 1;
        Song current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(searchTitle)) {
                System.out.println("==========================================================");
                System.out.printf("Song with title '%s' found at position %d\n", searchTitle, index);
                System.out.println("==========================================================");
                
                String line1 = index + " | " + current.artist + " - " +  current.title + " (" + current.year + ")";
                String line2 = current.duration + "                 " + current.genre;
                System.out.println(line1);
                System.out.println(line2);
                System.out.println("==========================================================");
                return;
            }
            current = current.next;
            index++;
        }
    }
}    

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
    
        playlist.addSong(new Song("Billy Joel", "Piano Man", 1973, 5.39, "Folk"));
        playlist.addSong(new Song("Bruno Mars", "Lady Gaga", 2024, 4.11, "Pop"));
        playlist.addSong(new Song(".Feast", "Nina", 2024, 4.37, "Indonesia Rock"));
        playlist.addSong(new Song("Wave to Earth", "Bad", 2023, 4.23, "Korean Rock, Thai Indie"));
        playlist.addSong(new Song("Why Don't We", "8 Lettes", 1970, 4.03, "Rock"));
        playlist.addSong(new Song("The Smiths", "There Is a Light That Never Goes Out", 1986, 4.4, "Indie"));
        playlist.addSong(new Song("Pamungkas", "To the Bone", 2020, 5.44, "Indonesian Indie"));
        playlist.addSong(new Song("One Ok Rock", "We are", 2017, 4.15, "Pop Rock"));
        playlist.addSong(new Song("Lee Young Ji", "Smart Girl", 2024, 3.9, "R&B"));
        playlist.addSong(new Song("Green Day", "21 Gungs", 2009, 5.21, "Punk Pop"));
        playlist.addSong(new Song("Adele", "Someone Like You", 2011, 4.45, "Pop"));
        playlist.addSong(new Song("Ed Sheeran", "Shape of You", 2017, 4.24, "Pop"));
        playlist.addSong(new Song("Coldplay", "Fix You", 2005, 4.55, "Alternative Rock"));
        playlist.addSong(new Song("Taylor Swift", "Shake It Off", 2014, 3.39, "Pop"));
        playlist.addSong(new Song("Kendrick Lamar", "HUMBLE.", 2017, 2.57, "Hip-Hop"));
        playlist.addSong(new Song("Sia", "Chandelier", 2014, 3.53, "Pop"));
        playlist.addSong(new Song("Maroon 5", "Sugar", 2014, 5.02, "Pop-Rock"));
        playlist.addSong(new Song("Post Malone", "Rockstar", 2017, 3.38, "Hip-Hop"));
        playlist.addSong(new Song("Drake", "God's Plan", 2018, 3.19, "Hip-Hop"));
        playlist.addSong(new Song("The Weeknd", "Blinding Lights", 2020, 3.20, "Pop"));
        playlist.addSong(new Song("Beyoncé", "Halo", 2008, 4.21, "Pop-R&B"));
        playlist.addSong(new Song("Billie Eilish", "Bad Guy", 2019, 3.14, "Pop"));
        playlist.addSong(new Song("Imagine Dragons", "Believer", 2017, 3.24, "Rock"));
        playlist.addSong(new Song("Dua Lipa", "Don't Start Now", 2019, 3.03, "Pop"));
        playlist.addSong(new Song("Drake", "In My Feelings", 2018, 3.37, "Hip-Hop"));
        playlist.addSong(new Song("Shawn Mendes", "Senorita", 2019, 3.11, "Pop"));
        playlist.addSong(new Song("Kanye West", "Stronger", 2007, 5.11, "Hip-Hop"));
        playlist.addSong(new Song("Rihanna", "Diamonds", 2012, 3.45, "Pop"));
        playlist.addSong(new Song("Lana Del Rey", "Summertime Sadness", 2012, 4.25, "Pop"));
        playlist.addSong(new Song("Snoop Dogg", "Drop It Like It's Hot", 2004, 4.30, "Hip-Hop"));
        playlist.addSong(new Song("Lil Nas X", "Old Town Road", 2019, 2.37, "Country-Rap"));
        playlist.addSong(new Song("Travis Scott", "SICKO MODE", 2018, 5.12, "Hip-Hop"));
        playlist.addSong(new Song("Halsey", "Without Me", 2018, 3.21, "Pop"));
        playlist.addSong(new Song("Katy Perry", "Roar", 2013, 3.42, "Pop"));
        playlist.addSong(new Song("The Chainsmokers", "Closer", 2016, 4.05, "Pop"));
        playlist.addSong(new Song("Marshmello", "Happier", 2018, 3.34, "Electronic"));
        playlist.addSong(new Song("Zedd", "Stay", 2017, 3.30, "Electronic"));
        playlist.addSong(new Song("Post Malone", "Circles", 2019, 3.35, "Pop-Rock"));
        playlist.addSong(new Song("Ariana Grande", "No Tears Left to Cry", 2018, 3.25, "Pop"));
        playlist.addSong(new Song("Khalid", "Talk", 2019, 3.17, "R&B"));
        playlist.addSong(new Song("Megan Thee Stallion", "Savage Remix", 2020, 4.03, "Hip-Hop"));
        playlist.addSong(new Song("BTS", "Dynamite", 2020, 3.19, "K-Pop"));
        playlist.addSong(new Song("Drake", "Nonstop", 2018, 3.58, "Hip-Hop"));
        playlist.addSong(new Song("Lizzo", "Truth Hurts", 2017, 2.53, "Pop"));
        playlist.addSong(new Song("Camila Cabello", "Havana", 2017, 3.37, "Pop"));
        playlist.addSong(new Song("Lil Baby", "Drip Too Hard", 2018, 3.04, "Hip-Hop"));
        playlist.addSong(new Song("Maroon 5", "Girls Like You", 2018, 3.30, "Pop-Rock"));
        playlist.addSong(new Song("Charlie Puth", "Attention", 2017, 3.31, "Pop"));
        playlist.addSong(new Song("Shakira", "Hips Don't Lie", 2006, 3.38, "Pop"));
        playlist.addSong(new Song("OneRepublic", "Counting Stars", 2013, 4.17, "Pop-Rock"));
       
        System.out.println("\nTampilan Setelah Lagu Ditambahkan:");
        playlist.display();
    
        long startTimeBubbleSort = System.nanoTime();
        playlist.bubbleSortByDuration(); 
        long endTimeBubbleSort = System.nanoTime();
        System.out.println("\nTampilan Sesudah Lagi Di Urutkan Berdasarkan Menit dan Detik:");
        playlist.display();
        System.out.println("\nBubble Sort memakan waktu: " + (endTimeBubbleSort - startTimeBubbleSort) + " nanodetik.");
    
        long startTimeSelectionSort = System.nanoTime();
        playlist.selectionSortByYear(); 
        long endTimeSelectionSort = System.nanoTime();
        System.out.println("\nTampilan Sesudah Lagu Di Urutkan Berdasarkan Tahun :");
        playlist.display();
        System.out.println("\nSelection Sort memakan waktu: " + (endTimeSelectionSort - startTimeSelectionSort) + " nanodetik.");
    
        String searchTitle = "We Are";  
        System.out.println("\n=================================");
        System.out.println("Judul lagu yang ingin dicari: " + searchTitle); 

        Song current = playlist.head;  
        int index = 1;  
        boolean found = false; 

        while (current != null) {
            if (current.title.equalsIgnoreCase(searchTitle)) {
                found = true;
                System.out.println("Lagu dengan judul '" + searchTitle + "' ditemukan pada posisi ke-" + index);
                System.out.println("=================================");
                String line1 = index + " | " + current.artist + " - " + current.title + " (" + current.year + ")";
                String line2 = current.duration + " menit    " + current.genre;
                System.out.println(line1);
                System.out.println(line2);
                System.out.println("=================================");
                break;  
            }
            current = current.next; 
            index++;
        }
        if (!found) {
            System.out.println("Lagu dengan judul '" + searchTitle + "' tidak ditemukan.");
        }
    }
}